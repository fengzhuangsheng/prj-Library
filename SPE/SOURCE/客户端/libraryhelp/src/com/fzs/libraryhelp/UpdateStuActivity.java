package com.fzs.libraryhelp;


import com.fzs.database.Stu;
import com.fzs.database.StuDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class UpdateStuActivity extends Activity {

	/*
	 * ����EditText
	 */
	private EditText stuupdateET1;
	private EditText stuupdateET2;
	private EditText stuupdateET3;
	private EditText stuupdateET4;
	private EditText stuupdateET5;
	private EditText stuupdateET6;
	private EditText stuupdateET7;
	private EditText stuupdateET8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stuinfoupdate);
		/*
		 * ��ʼ��EditText
		 */
		stuupdateET1 = (EditText) findViewById(R.id.stuupdateET1);
		stuupdateET2 = (EditText) findViewById(R.id.stuupdateET2);
		stuupdateET3 = (EditText) findViewById(R.id.stuupdateET3);
		stuupdateET4 = (EditText) findViewById(R.id.stuupdateET4);
		stuupdateET5 = (EditText) findViewById(R.id.stuupdateET5);
		stuupdateET6 = (EditText) findViewById(R.id.stuupdateET6);
		stuupdateET7 = (EditText) findViewById(R.id.stuupdateET7);
		stuupdateET8 = (EditText) findViewById(R.id.stuupdateET8);

	}

	/*
	 * ���°�ť����
	 */
	public void stuUpdateLoad(View v) {
		/*
		 * ��ȡÿ��EditText�е�ֵ
		 */
		String str_id = stuupdateET1.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		String name = stuupdateET2.getText().toString().trim();
		String password = stuupdateET3.getText().toString().trim();
		String idcard = stuupdateET4.getText().toString().trim();
		String gender = stuupdateET5.getText().toString().trim();
		String academy = stuupdateET6.getText().toString().trim();
		String profession = stuupdateET7.getText().toString().trim();
		String str_grade = stuupdateET8.getText().toString().trim();
		Integer grade = 0;
		if (!str_grade.equals("")) {
			grade = Integer.parseInt(str_grade);
		}
		// ��װ��ѧ������
		Stu stu = new Stu(id, name, password, idcard, gender, academy,
				profession, grade);

		// ����StuDao���·������и���
		StuDao dao = new StuDao(this);
		dao.update(stu);

		/*
		 * �����Ի�����ʾ���³ɹ�
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ʾ");
		builder.setMessage("�ɹ�����ID��Ϊ��" + id + "��ѧ����Ϣ��");
		builder.setPositiveButton("ȷ��", null);
		builder.create();
		builder.show();
	}
}
