package com.fzs.libraryhelp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class BookMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookmenu);
	}

	/*
	 * 插入图书按钮监听
	 */
	public void menuload1(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, InsertBookActivity.class);
		startActivity(intent);
	}

	/*
	 * 删除图书按钮监听
	 */
	public void menuload2(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, DeleteBookActivity.class);
		startActivity(intent);
	}

	/*
	 * 修改图书按钮监听
	 */
	public void menuload3(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, UpdateBookActivity.class);
		startActivity(intent);
	}

	/*
	 * 查找图书按钮监听
	 */
	public void menuload4(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, SelectBookActivity.class);
		startActivity(intent);
	}
}
