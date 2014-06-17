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
	 * 定义EditText
	 */
	private EditText stuselectET;
	/*
	 * 定义TextView
	 */
	private TextView stuselectTV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stuinfoselect);
		/*
		 * 初始化EditText
		 */
		stuselectET = (EditText) findViewById(R.id.stuselectET);
		// 初始化TextView
		stuselectTV = (TextView) findViewById(R.id.stuselectTV3);
	}

	/*
	 * 查询按钮监听
	 */
	public void stuSelectLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = stuselectET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// 调用StuDao查询方法进行查询
		StuDao dao = new StuDao(this);
		Stu stu = dao.select(id);

		// 显示出查询结果
		stuselectTV.setText("学生ID：" + stu.getId() + "\n" + "学生姓名："
				+ stu.getName() + "\n" + "学生密码：" + stu.getPassword() + "\n"
				+ "学生身份证号：" + stu.getIdcard() + "\n" + "学生性别："
				+ stu.getGender() + "\n" + "学生学院：" + stu.getAcademy() + "\n"
				+ "学生专业：" + stu.getProfession() + "\n" + "学生年级："
				+ stu.getGrade());

	}

}
