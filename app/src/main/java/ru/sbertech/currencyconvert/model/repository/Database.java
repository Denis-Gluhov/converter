package ru.sbertech.currencyconvert.model.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ru.sbertech.currencyconvert.App;
import ru.sbertech.currencyconvert.model.Currency;

public class Database extends SQLiteOpenHelper implements ContractRepository.Database {

    private static final String DATABASE_NAME = "currency";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE = "table_currency";
    private static final String ID = "_id";
    private static final String NUM_CODE = "num_code";
    private static final String CHAR_CODE = "char_code";
    private static final String NOMINAL = "nominal";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE + "(" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NUM_CODE + " TEXT, " +
            CHAR_CODE + " TEXT, " +
            NOMINAL + " INTEGER, " +
            NAME + " TEXT, " +
            VALUE + " REAL)";
    private static final String INSERT = "INSERT INTO " + TABLE + " (" +
            NUM_CODE + ", " + CHAR_CODE+ ", " + NOMINAL+ ", " + NAME +", " + VALUE + ")" +
            " VALUES ('%s', '%s', %s, '%s', %s)";
    private static final String DELETE = "DELETE FROM " + TABLE;

    private SQLiteDatabase liteDatabase;

    public Database() {
        super(App.APP_CONTEXT, DATABASE_NAME, null, DATABASE_VERSION);
        liteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    @Override
    public void add(List<Currency> data) {
        for (Currency currency : data){
            String query = String.format(INSERT, currency.getNumCode(), currency.getCharCode(),
                    currency.getNominal(), currency.getName(), currency.getValue());
            liteDatabase.execSQL(query);
        }
    }

    @Override
    public void clear() {
        liteDatabase.execSQL(DELETE);
    }

    @Override
    public List<Currency> getAll() {
        String query = "SELECT * FROM " + TABLE;
        List<Currency> currencies = new ArrayList<>();
        Cursor cursor = liteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()){
            Currency currency = new Currency();
            currency.setNumCode(cursor.getString(cursor.getColumnIndex(NUM_CODE)));
            currency.setCharCode(cursor.getString(cursor.getColumnIndex(CHAR_CODE)));
            currency.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            currency.setNominal(cursor.getInt(cursor.getColumnIndex(NOMINAL)));
            currency.setValue(cursor.getDouble(cursor.getColumnIndex(VALUE)));
            currencies.add(currency);
        }
        cursor.close();
        return currencies;
    }
}
