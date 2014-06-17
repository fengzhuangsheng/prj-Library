package com.fzs.libraryhelp;

import com.fzs.database.Book;
import com.fzs.database.BookDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class InsertBookActivity extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText bookinsertET1;
	private EditText bookinsertET2;
	private EditText bookinsertET3;
	private EditText bookinsertET4;
	private EditText bookinsertET5;
	private EditText bookinsertET6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookinsert);
		/*
		 * 初始化EditText
		 */
		bookinsertET1 = (EditText) findViewById(R.id.bookinsertET1);
		bookinsertET2 = (EditText) findViewById(R.id.bookinsertET2);
		bookinsertET3 = (EditText) findViewById(R.id.bookinsertET3);
		bookinsertET4 = (EditText) findViewById(R.id.bookinsertET4);
		bookinsertET5 = (EditText) findViewById(R.id.bookinsertET5);
		bookinsertET6 = (EditText) findViewById(R.id.bookinsertET6);

	}

	/*
	 * 提交按钮监听
	 */
	public void bookInsertLoad(View v) {
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = bookinsertET1.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		String name = bookinsertET2.getText().toString().trim();
		String author = bookinsertET3.getText().toString().trim();
		String press = bookinsertET4.getText().toString().trim();
		String type = bookinsertET5.getText().toString().trim();
		String str_state = bookinsertET6.getText().toString().trim();
		Integer state = 0;
		if (!str_state.equals("")) {
			state = Integer.parseInt(str_state);
		}
		// 封装成图书对象
		Book book = new Book(id, name, author, press, type, state);

		// 调用BookDao插入方法进行插入
		BookDao dao = new BookDao(this);
		dao.insert(book);

		/*
		 * 弹出对话框提示插入成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功插入图书信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}

}
