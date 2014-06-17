package com.fzs.libraryhelp;


import com.fzs.database.StuDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class DeleteStuActivity extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText studeleteET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stuinfodelete);
		/*
		 * 初始化EditText
		 */
		studeleteET = (EditText) findViewById(R.id.studeleteET);

	}

	/*
	 * 删除按钮监听
	 */
	public void stuDeleteLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = studeleteET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// 调用StuDao删除方法进行删除
		StuDao dao = new StuDao(this);
		dao.delete(id);

		/*
		 * 弹出对话框提示删除成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功删除ID号为：" + id + "的学生信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}

}
