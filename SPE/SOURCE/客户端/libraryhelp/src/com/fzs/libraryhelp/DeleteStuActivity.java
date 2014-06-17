package com.fzs.libraryhelp;


import com.fzs.database.StuDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class DeleteStuActivity extends Activity {
	/*
	 * ����EditText
	 */
	private EditText studeleteET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stuinfodelete);
		/*
		 * ��ʼ��EditText
		 */
		studeleteET = (EditText) findViewById(R.id.studeleteET);

	}

	/*
	 * ɾ����ť����
	 */
	public void stuDeleteLoad(View v) {
		/*
		 * ��ȡEditText�е�ֵ
		 */
		String str_id = studeleteET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// ����StuDaoɾ����������ɾ��
		StuDao dao = new StuDao(this);
		dao.delete(id);

		/*
		 * �����Ի�����ʾɾ���ɹ�
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ʾ");
		builder.setMessage("�ɹ�ɾ��ID��Ϊ��" + id + "��ѧ����Ϣ��");
		builder.setPositiveButton("ȷ��", null);
		builder.create();
		builder.show();
	}

}
