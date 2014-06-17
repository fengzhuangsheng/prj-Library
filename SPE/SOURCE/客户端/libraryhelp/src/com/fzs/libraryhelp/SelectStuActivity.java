package com.fzs.libraryhelp;

import com.fzs.database.Stu;
import com.fzs.database.StuDao;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SelectStuActivity extends Activity {

	/*
	 * ����EditText
	 */
	private EditText stuselectET;
	/*
	 * ����TextView
	 */
	private TextView stuselectTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stuinfoselect);
		/*
		 * ��ʼ��EditText
		 */
		stuselectET = (EditText) findViewById(R.id.stuselectET);
		// ��ʼ��TextView
		stuselectTV = (TextView) findViewById(R.id.stuselectTV3);
	}

	/*
	 * ��ѯ��ť����
	 */
	public void stuSelectLoad(View v) {
		/*
		 * ��ȡEditText�е�ֵ
		 */
		String str_id = stuselectET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// ����StuDao��ѯ�������в�ѯ
		StuDao dao = new StuDao(this);
		Stu stu = dao.select(id);

		// ��ʾ����ѯ���
		stuselectTV.setText("ѧ��ID��" + stu.getId() + "\n" + "ѧ��������"
				+ stu.getName() + "\n" + "ѧ�����룺" + stu.getPassword() + "\n"
				+ "ѧ�����֤�ţ�" + stu.getIdcard() + "\n" + "ѧ���Ա�"
				+ stu.getGender() + "\n" + "ѧ��ѧԺ��" + stu.getAcademy() + "\n"
				+ "ѧ��רҵ��" + stu.getProfession() + "\n" + "ѧ���꼶��"
				+ stu.getGrade());

	}

}
