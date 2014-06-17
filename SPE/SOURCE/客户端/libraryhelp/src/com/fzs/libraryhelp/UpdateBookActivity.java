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
	 * ����EditText
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
		 * ��ʼ��EditText
		 */
		bookupdateET1 = (EditText) findViewById(R.id.bookupdateET1);
		bookupdateET2 = (EditText) findViewById(R.id.bookupdateET2);
		bookupdateET3 = (EditText) findViewById(R.id.bookupdateET3);
		bookupdateET4 = (EditText) findViewById(R.id.bookupdateET4);
		bookupdateET5 = (EditText) findViewById(R.id.bookupdateET5);
		bookupdateET6 = (EditText) findViewById(R.id.bookupdateET6);

	}

	/*
	 * ���°�ť����
	 */
	public void bookUpdateLoad(View v) {
		/*
		 * ��ȡÿ��EditText�е�ֵ
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
		// ��װ��ͼ�����
		Book book = new Book(id, name, author, press, type, state);

		// ����BookDao���·������и���
		BookDao dao = new BookDao(this);
		dao.update(book);

		/*
		 * �����Ի�����ʾ���³ɹ�
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ʾ");
		builder.setMessage("�ɹ�����ͼ����Ϣ��");
		builder.setPositiveButton("ȷ��", null);
		builder.create();
		builder.show();
	}
}
