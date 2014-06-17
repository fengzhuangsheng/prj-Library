package com.fzs.database;


import com.fzs.util.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StuDao {
	private DBHelper helper;

	public StuDao(Context context) {
		this.helper = new DBHelper(context);
	}

	public void insert(Stu stu) {
		System.out.println("≤Â»Î ˝æ›...");
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(
				"insert into tab_stu values(?,?,?,?,?,?,?,?)",
				new Object[] { stu.getId(), stu.getName(), stu.getGender(),
						stu.getIdcard(), stu.getPassword(), stu.getAcademy(),
						stu.getProfession(), stu.getGrade() });
		db.close();
	}

	public void delete(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from tab_stu where stu_id = ?", new Object[] { id });
		db.close();
	}

	public void update(Stu stu) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(
				"update tab_stu set stu_name=?,stu_gender=?,stu_idcard=?,stu_password=?,stu_academy=?,stu_profession=?,stu_grade=? where stu_id=?",
				new Object[] { stu.getName(), stu.getGender(), stu.getIdcard(),
						stu.getPassword(), stu.getAcademy(),
						stu.getProfession(), stu.getGrade(), stu.getId() });
		db.close();
	}

	public Stu select(int id) {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from tab_stu where stu_id=?",
				new String[] { id + "" });

		Stu stu = null;
		if (c.moveToNext()) {
			String name = c.getString(c.getColumnIndex("stu_name"));
			String password = c.getString(c.getColumnIndex("stu_password"));
			String idcard = c.getString(c.getColumnIndex("stu_idcard"));
			String gender = c.getString(c.getColumnIndex("stu_gender"));
			String academy = c.getString(c.getColumnIndex("stu_academy"));
			String profession = c.getString(c.getColumnIndex("stu_profession"));
			Integer grade = c.getInt(c.getColumnIndex("stu_grade"));

			stu = new Stu(id, name, password, idcard, gender, academy,
					profession, grade);
		}
		c.close();
		db.close();
		return stu;
	}
}
