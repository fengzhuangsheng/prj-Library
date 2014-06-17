package com.fzs.database;

import com.fzs.util.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BookDao {
	private DBHelper helper;

	public BookDao(Context context) {
		this.helper = new DBHelper(context);
	}

	public void insert(Book book) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("insert into tab_book values(?,?,?,?,?,?)", new Object[] {
				book.getId(), book.getName(), book.getAuthor(),
				book.getPress(), book.getType(), book.getState() });
		db.close();
	}

	public void delete(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from tab_book where book_id=?", new Object[] { id });
		db.close();
	}

	public void update(Book book) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(
				"update tab_book set book_name=?,book_author=?,book_press=?, book_type=?, book_state=? where book_id=?",
				new Object[] { book.getName(), book.getAuthor(),
						book.getPress(), book.getType(), book.getState(),
						book.getId() });
		db.close();
	}

	public Book select(int id) {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from tab_book where book_id=?",
				new String[] { id + "" });

		Book book = null;

		if (c.moveToNext()) {
			String name = c.getString(c.getColumnIndex("book_name"));
			String author = c.getString(c.getColumnIndex("book_author"));
			String press = c.getString(c.getColumnIndex("book_press"));
			String type = c.getString(c.getColumnIndex("book_type"));
			Integer state = c.getInt(c.getColumnIndex("book_state"));
			book = new Book(id, name, author, press, type, state);
		}
		c.close();
		db.close();
		return book;
	}
}
