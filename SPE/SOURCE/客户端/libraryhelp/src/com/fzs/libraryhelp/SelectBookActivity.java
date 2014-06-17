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
	 * ����EditText
	 */
	private EditText bookselectET;
	/*
	 * ����TextView
	 */
	private TextView bookselectTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookselect);
		/*
		 * ��ʼ��
		 */
		bookselectET = (EditText) findViewById(R.id.bookselectET);
		bookselectTV = (TextView) findViewById(R.id.bookselectTV3);
	}

	/*
	 * ��ѯ��ť����
	 */
	public void bookSelectLoad(View v) {
		/*
		 * ��ȡEditText�е�ֵ
		 */
		String str_id = bookselectET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// ����BookDao��ѯ�������в�ѯ
		BookDao dao = new BookDao(this);
		Book book = dao.select(id);

		// ��ʾ����ѯ���
		bookselectTV.setText("ͼ��ţ�" + book.getId() + "\n" + "ͼ������"
				+ book.getName() + "\n" + "ͼ�����ߣ�" + book.getAuthor() + "\n"
				+ "�����磺" + book.getPress() + "\n" + "���" + book.getType()
				+ "\n" + "�ڽ�״̬��" + book.getState());
	}
}
