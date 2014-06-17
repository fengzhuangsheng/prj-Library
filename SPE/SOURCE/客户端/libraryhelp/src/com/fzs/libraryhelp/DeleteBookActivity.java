package com.fzs.libraryhelp;

import com.fzs.database.BookDao;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class DeleteBookActivity extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText bookdeleteET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookdelete);

		/*
		 * 初始化EditText
		 */
		bookdeleteET = (EditText) findViewById(R.id.bookdeleteET);

	}

	/*
	 * 删除按钮监听
	 */
	public void bookDeleteLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = bookdeleteET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// 调用BookDao删除方法进行删除
		BookDao dao = new BookDao(this);
		dao.delete(id);

		/*
		 * 弹出对话框提示删除成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功删除ID号为：" + id + "的图书信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}
