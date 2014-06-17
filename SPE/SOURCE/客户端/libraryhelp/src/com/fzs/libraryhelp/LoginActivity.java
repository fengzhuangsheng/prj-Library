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
		// ϵͳ��Ϊ��Ҫ������activityѰ���뵱ǰactivity��ͬ��task;
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// �ж���֤
				if (validate()) {

					// �ж��Ƿ��¼�ɹ�
					if (login()) {
						startActivity(intent);
						// ������Activity
						finish();

					} else {
						showDialog("�û����ƺ�����������������룡");
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

	// �����û���¼����
	private boolean login() {
		String name = username.getText().toString();
		String pwd = password.getText().toString();
		JSONObject jsonObj;
		try {
			jsonObj = query(name, pwd);
			// ���username��Ϊ��
			if (jsonObj.getString("username")!=null) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			showDialog("��������Ӧ�쳣�����Ժ�����");
			e.printStackTrace();
		}

		return false;

	}

	// ����validate�������������û�����������зǿ���֤
	private boolean validate() {
		String name = username.getText().toString().trim();
		if (name.equals("")) {
			showDialog("�û������Ǳ����");
			return false;
		}
		String pass = password.getText().toString().trim();
		if (pass.equals("")) {
			showDialog("�û������Ǳ����");
			return false;
		}
		return true;
	}

	// ����һ����ʾ��ʾ��Ϣ�ĶԻ���
	private void showDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	// ����һ����ѯ����ͨ���û�����������в�ѯ������POST���󣬻����Ӧ���
	private JSONObject query(String username, String password) throws Exception {
		// ʹ��Map��װ�������
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		// ���巢�������URL
		String url = HttpUtil.BASE_URL + "servlet/LoginServlet";
		return new JSONObject(HttpUtil.postRequest(url, map));
	}
}
