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
	 * ����EditText
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
		 * ��ʼ��EditText
		 */
		bookinsertET1 = (EditText) findViewById(R.id.bookinsertET1);
		bookinsertET2 = (EditText) findViewById(R.id.bookinsertET2);
		bookinsertET3 = (EditText) findViewById(R.id.bookinsertET3);
		bookinsertET4 = (EditText) findViewById(R.id.bookinsertET4);
		bookinsertET5 = (EditText) findViewById(R.id.bookinsertET5);
		bookinsertET6 = (EditText) findViewById(R.id.bookinsertET6);

	}

	/*
	 * �ύ��ť����
	 */
	public void bookInsertLoad(View v) {
		/*
		 * ��ȡÿ��EditText�е�ֵ
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
		// ��װ��ͼ�����
		Book book = new Book(id, name, author, press, type, state);

		// ����BookDao���뷽�����в���
		BookDao dao = new BookDao(this);
		dao.insert(book);

		/*
		 * �����Ի�����ʾ����ɹ�
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ʾ");
		builder.setMessage("�ɹ�����ͼ����Ϣ��");
		builder.setPositiveButton("ȷ��", null);
		builder.create();
		builder.show();
	}

}
