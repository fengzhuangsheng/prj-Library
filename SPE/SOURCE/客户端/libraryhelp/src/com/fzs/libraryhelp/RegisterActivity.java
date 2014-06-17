package com.fzs.libraryhelp;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.fzs.util.HttpUtil;

public class RegisterActivity extends Activity {
	EditText username;
	EditText password;
	EditText age;
	RadioGroup sex;
	Button register;
	Button reset;
	String str;
	String jsonString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		findViews();
	}

	private void findViews() {
		username = (EditText) findViewById(R.id.usernameRegister);
		password = (EditText) findViewById(R.id.passwordRegister);
		age = (EditText) findViewById(R.id.ageRegister);
		sex = (RadioGroup) findViewById(R.id.sexRegister);
		register = (Button) findViewById(R.id.Register);
		reset = (Button) findViewById(R.id.Reset);
		username.setOnFocusChangeListener(new EtusernameOnFocusChange());
		reset.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 重置界面的输入值
				username.setText("");
				password.setText("");
				age.setText("");
			}

		});
		register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 获得界面的输入值
				String name = username.getText().toString().trim();
				String pass = password.getText().toString().trim();
				String agestr = (age.getText().toString().trim());
				String sexstr = ((RadioButton) RegisterActivity.this
						.findViewById(sex.getCheckedRadioButtonId())).getText()
						.toString();
				// 使用Map封装请求参数
				Map<String, String> map = new HashMap<String, String>();
				map.put("username", name);
				map.put("password", pass);
				map.put("age", agestr);
				map.put("sex", sexstr);
				// 定义发送请求的URL
				String url = HttpUtil.BASE_URL + "servlet/RegisterServlet";
				String result = null;
				try {
					result = HttpUtil.postRequest(url, map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Message msg = new Message();
				System.out.println("result---->" + result);
				msg.obj = result;
				handler1.sendMessage(msg);

			}
		});

	}

	Handler handler1 = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			String msgobj = msg.obj.toString();
			if (msgobj.equals("true")) {
				Toast.makeText(RegisterActivity.this, "注册成功", 0).show();
				Intent intent = new Intent();
				intent.setClass(RegisterActivity.this, LoginActivity.class);
				startActivity(intent);
			} else {
				Toast.makeText(RegisterActivity.this, "注册失败", 0).show();
			}
			super.handleMessage(msg);
		}
	};