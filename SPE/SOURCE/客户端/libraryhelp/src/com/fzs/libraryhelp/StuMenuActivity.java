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
	 * ����ѧ����ť����
	 */
	public void menuload1(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, InsertStuActivity.class);
		startActivity(intent);
	}

	/*
	 * ɾ��ѧ����ť����
	 */
	public void menuload2(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, DeleteStuActivity.class);
		startActivity(intent);
	}

	/*
	 * �޸�ѧ����ť����
	 */
	public void menuload3(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, UpdateStuActivity.class);
		startActivity(intent);
	}

	/*
	 * ����ѧ����ť����
	 */
	public void menuload4(View v) {
		Intent intent = new Intent();
		intent.setClass(StuMenuActivity.this, SelectStuActivity.class);
		startActivity(intent);
	}

}
