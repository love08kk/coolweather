package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CoolweatherOpenHelper extends SQLiteOpenHelper {
	
	String TAG = "CoolweatherOpenHelper";
	
	public CoolweatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Province表建表语句
	 */
	public static final String CREATE_PROVINCE = "create table Province ("+" id integer primary key autoincrement ," +
			"province_name text," +
			"province_code text,)";
	/**
	 * City表建表语句
	 */
	public static final String CREATE_CITY = "create table City = ("+" id integer primary key autoincrement," +
			"city_name text," +
			"city_code text" +
			"province_id integer,)";
	/**
	 * County表建表语句
	 */
	public static final String CREATE_COUNTY = "create table County = ("+"id integer primary key autoincrement," +
			"county_name text" +
			"county_code text" +
			"city_id integer,)";
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PROVINCE);
		Log.i(TAG, "province created");
		db.execSQL(CREATE_CITY);
		Log.i(TAG, "city created");
		db.execSQL(CREATE_COUNTY);
		Log.i(TAG, "county created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
