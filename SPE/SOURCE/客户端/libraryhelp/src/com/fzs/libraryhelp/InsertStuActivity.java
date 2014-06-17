package com.fzs.libraryhelp;

import com.fzs.database.Stu;
import com.fzs.database.StuDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class InsertStuActivity extends Activity {

	/*
	 * ����EditText
	 */
	private EditText stuinsertET1;
	private EditText stuinsertET2;
	private EditText stuinsertET3;
	private EditText stuinsertET4;
	private EditText stuinsertET5;
	private EditText stuinsertET6;
	private EditText stuinsertET7;
	private EditText stuinsertET8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stuinfoinsert);
		/*
		 * ��ʼ��EditText
		 */
		stuinsertET1 = (EditText) findViewById(R.id.stuinsertET1);
		stuinsertET2 = (EditText) findViewById(R.id.stuinsertET2);
		stuinsertET3 = (EditText) findViewById(R.id.stuinsertET3);
		stuinsertET4 = (EditText) findViewById(R.id.stuinsertET4);
		stuinsertET5 = (EditText) findViewById(R.id.stuinsertET5);
		stuinsertET6 = (EditText) findViewById(R.id.stuinsertET6);
		stuinsertET7 = (EditText) findViewById(R.id.stuinsertET7);
		stuinsertET8 = (EditText) findViewById(R.id.stuinsertET8);
	}
	/*
	 * �ύ��ť����
	 */
	public void stuInsertLoad(View v) {
		/*
		 * ��ȡÿ��EditText�е�ֵ
		 */
		String str_id = stuinsertET1.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		String name = stuinsertET2.getText().toString().trim();
		String password = stuinsertET3.getText().toString().trim();
		String idcard = stuinsertET4.getText().toString().trim();
		String gender = stuinsertET5.getText().toString().trim();
		String academy = stuinsertET6.getText().toString().trim();
		String profession = stuinsertET7.getText().toString().trim();
		String str_grade = stuinsertET8.getText().toString().trim();
		Integer grade = 0;
		if (!str_grade.equals("")) {
			grade = Integer.parseInt(str_grade);
		}
		// ��װ��ѧ������
		Stu stu = new Stu(id, name, password, idcard, gender, academy,
				profession, grade);

		// ����StuDao���뷽�����в���
		StuDao dao = new StuDao(this);
		dao.insert(stu);

		/*
		 * �����Ի�����ʾ����ɹ�
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ʾ");
		builder.setMessage("�ɹ�����ѧ����Ϣ��");
		builder.setPositiveButton("ȷ��", null);
		builder.create();
		builder.show();
	}

}
