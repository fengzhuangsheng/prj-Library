package com.fzs.libraryhelp;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.fzs.util.HttpUtil;

public class LoginActivity extends Activity {
	EditText username;
	EditText password;
	Button login, register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		findViews();
	}

	private void findViews() {
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.login);
		register = (Button) findViewById(R.id.register);
		final Intent intent = new Intent(LoginActivity.this,
				MainMenuActivity.class);
		// 系统会为需要启动的activity寻找与当前activity不同的task;
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 判断验证
				if (validate()) {

					// 判断是否登录成功
					if (login()) {
						startActivity(intent);
						// 结束该Activity
						finish();

					} else {
						showDialog("用户名称和密码错误，请重新输入！");
					}
				}
			}
		});
		register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,
						RegisterActivity.class);
				startActivity(intent);
			}
		});
	}

	// 处理用户登录请求
	private boolean login() {
		String name = username.getText().toString();
		String pwd = password.getText().toString();
		JSONObject jsonObj;
		try {
			jsonObj = query(name, pwd);
			// 如果username不为空
			if (jsonObj.getString("username")!=null) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			showDialog("服务器响应异常，请稍后再试");
			e.printStackTrace();
		}

		return false;

	}

	// 定义validate（）方法，对用户名和密码进行非空验证
	private boolean validate() {
		String name = username.getText().toString().trim();
		if (name.equals("")) {
			showDialog("用户名称是必填项！");
			return false;
		}
		String pass = password.getText().toString().trim();
		if (pass.equals("")) {
			showDialog("用户密码是必填项！");
			return false;
		}
		return true;
	}

	// 定义一个显示提示信息的对话框
	private void showDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	// 定义一个查询请求，通过用户名和密码进行查询，发送POST请求，获得响应结果
	private JSONObject query(String username, String password) throws Exception {
		// 使用Map封装请求参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		// 定义发送请求的URL
		String url = HttpUtil.BASE_URL + "servlet/LoginServlet";
		return new JSONObject(HttpUtil.postRequest(url, map));
	}
}
