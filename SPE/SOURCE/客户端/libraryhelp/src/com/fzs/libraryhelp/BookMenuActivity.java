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
	 * ����ͼ�鰴ť����
	 */
	public void menuload1(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, InsertBookActivity.class);
		startActivity(intent);
	}

	/*
	 * ɾ��ͼ�鰴ť����
	 */
	public void menuload2(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, DeleteBookActivity.class);
		startActivity(intent);
	}

	/*
	 * �޸�ͼ�鰴ť����
	 */
	public void menuload3(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, UpdateBookActivity.class);
		startActivity(intent);
	}

	/*
	 * ����ͼ�鰴ť����
	 */
	public void menuload4(View v) {
		Intent intent = new Intent();
		intent.setClass(BookMenuActivity.this, SelectBookActivity.class);
		startActivity(intent);
	}
}
