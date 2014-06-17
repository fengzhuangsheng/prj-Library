package com.fzs.libraryhelp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
	}
	/*
	 * 圖書信息按钮监听
	 */
	public void menuload1(View v) {
		Intent intent = new Intent();
		intent.setClass(MainMenuActivity.this, BookMenuActivity.class);
		startActivity(intent);
	}

	/*
	 * 學生信息按钮监听
	 */
	public void menuload2(View v) {
		Intent intent = new Intent();
		intent.setClass(MainMenuActivity.this, StuMenuActivity.class);
		startActivity(intent);
	}

	/*
	 * 修改学生按钮监听
	 */
	public void menuload3(View v) {
		Intent intent = new Intent();
		intent.setClass(MainMenuActivity.this, UpdateStuActivity.class);
		startActivity(intent);
	}

	/*
	 * 查找学生按钮监听
	 */
	public void menuload4(View v) {
		Intent intent = new Intent();
		intent.setClass(MainMenuActivity.this, SelectStuActivity.class);
		startActivity(intent);
	}

}
