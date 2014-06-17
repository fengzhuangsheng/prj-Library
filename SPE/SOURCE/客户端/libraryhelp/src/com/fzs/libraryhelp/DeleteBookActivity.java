package com.fzs.libraryhelp;

import com.fzs.database.BookDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class DeleteBookActivity extends Activity {
	/*
	 * ����EditText
	 */
	private EditText bookdeleteET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookdelete);

		/*
		 * ��ʼ��EditText
		 */
		bookdeleteET = (EditText) findViewById(R.id.bookdeleteET);

	}

	/*
	 * ɾ����ť����
	 */
	public void bookDeleteLoad(View v) {
		/*
		 * ��ȡEditText�е�ֵ
		 */
		String str_id = bookdeleteET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// ����BookDaoɾ����������ɾ��
		BookDao dao = new BookDao(this);
		dao.delete(id);

		/*
		 * �����Ի�����ʾɾ���ɹ�
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ʾ");
		builder.setMessage("�ɹ�ɾ��ID��Ϊ��" + id + "��ͼ����Ϣ��");
		builder.setPositiveButton("ȷ��", null);
		builder.create();
		builder.show();
	}
}
