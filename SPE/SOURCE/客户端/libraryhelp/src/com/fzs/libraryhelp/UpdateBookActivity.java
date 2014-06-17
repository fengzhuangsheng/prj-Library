package com.fzs.libraryhelp;

import com.fzs.database.Book;
import com.fzs.database.BookDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class UpdateBookActivity extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText bookupdateET1;
	private EditText bookupdateET2;
	private EditText bookupdateET3;
	private EditText bookupdateET4;
	private EditText bookupdateET5;
	private EditText bookupdateET6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookupdate);

		/*
		 * 初始化EditText
		 */
		bookupdateET1 = (EditText) findViewById(R.id.bookupdateET1);
		bookupdateET2 = (EditText) findViewById(R.id.bookupdateET2);
		bookupdateET3 = (EditText) findViewById(R.id.bookupdateET3);
		bookupdateET4 = (EditText) findViewById(R.id.bookupdateET4);
		bookupdateET5 = (EditText) findViewById(R.id.bookupdateET5);
		bookupdateET6 = (EditText) findViewById(R.id.bookupdateET6);

	}

	/*
	 * 更新按钮监听
	 */
	public void bookUpdateLoad(View v) {
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = bookupdateET1.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		String name = bookupdateET2.getText().toString().trim();
		String author = bookupdateET3.getText().toString().trim();
		String press = bookupdateET4.getText().toString().trim();
		String type = bookupdateET5.getText().toString().trim();
		String str_state = bookupdateET6.getText().toString().trim();
		Integer state = 0;
		if (!str_state.equals("")) {
			state = Integer.parseInt(str_state);
		}
		// 封装成图书对象
		Book book = new Book(id, name, author, press, type, state);

		// 调用BookDao更新方法进行更新
		BookDao dao = new BookDao(this);
		dao.update(book);

		/*
		 * 弹出对话框提示更新成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功更新图书信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}
