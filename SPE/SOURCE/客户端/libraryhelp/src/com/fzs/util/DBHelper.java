package com.fzs.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context) {
		super(context, "hdu.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * 创建学生表tab_stu
		 */
		String createTableStu = "create table tab_stu (stu_id int , stu_name varchar(10), "
				+ "stu_gender varchar(10), stu_idcard varchar(18),"
				+ " stu_password varchar(10), stu_academy varchar(20), "
				+ "stu_profession varchar(20), stu_grade int,primary key('stu_id')) ";

		db.execSQL(createTableStu);

		/*
		 * 创建图书表tab_book
		 */
		String createTabBook = "create table tab_book (book_id int, book_name varchar(10) ,"
				+ "book_author varchar(10) , book_press varchar(20) ,"
				+ "book_type varchar(20) , book_state int, primary key('book_id') )";
		
		db.execSQL(createTabBook);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
