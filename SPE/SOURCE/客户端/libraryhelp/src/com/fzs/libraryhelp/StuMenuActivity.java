package com.fzs.libraryhelp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class StuMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stumenu);
	}
	
	/*
	 * 插入学生按钮监听
	 */
	public void menuload1(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, InsertStuActivity.class);
		startActivity(intent);
	}

	/*
	 * 删除学生按钮监听
	 */
	public void menuload2(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, DeleteStuActivity.class);
		startActivity(intent);
	}

	/*
	 * 修改学生按钮监听
	 */
	public void menuload3(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, UpdateStuActivity.class);
		startActivity(intent);
	}

	/*
	 * 查找学生按钮监听
	 */
	public void menuload4(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, SelectStuActivity.class);
		startActivity(intent);
	}

}
