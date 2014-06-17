package com.fzs.libraryhelp;

import com.fzs.database.Book;
import com.fzs.database.BookDao;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SelectBookActivity extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText bookselectET;
	/*
	 * 定义TextView
	 */
	private TextView bookselectTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookselect);
		/*
		 * 初始化
		 */
		bookselectET = (EditText) findViewById(R.id.bookselectET);
		bookselectTV = (TextView) findViewById(R.id.bookselectTV3);
	}

	/*
	 * 查询按钮监听
	 */
	public void bookSelectLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = bookselectET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// 调用BookDao查询方法进行查询
		BookDao dao = new BookDao(this);
		Book book = dao.select(id);

		// 显示出查询结果
		bookselectTV.setText("图书号：" + book.getId() + "\n" + "图书名："
				+ book.getName() + "\n" + "图书作者：" + book.getAuthor() + "\n"
				+ "出版社：" + book.getPress() + "\n" + "类别：" + book.getType()
				+ "\n" + "在借状态：" + book.getState());
	}
}
