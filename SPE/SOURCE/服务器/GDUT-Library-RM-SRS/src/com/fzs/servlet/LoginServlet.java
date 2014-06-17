package com.fzs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fzs.dao.UserDao;
import com.fzs.dao.impl.UserDaoImpl;
import com.fzs.entity.User;

/**
 * 
 * @author fzs ��Ӧ Android�ͻ��˷���������
 */

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		UserDao dao = new UserDaoImpl();
		// ��ÿͻ����������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = dao.login(username, password);
		if (u != null) {
			// ��Ӧ�ͻ������ݣ���¼�ɹ�
			request.getSession(true).setAttribute("username", username);
			try {

				// ����֤��userId��װ��JSONObject
				JSONObject jsonObj = new JSONObject().put("username", username);
				// �����Ӧ
				response.getWriter().println(jsonObj.toString());

			} catch (JSONException ex) {
				ex.printStackTrace();
			}
		} else {
			// ��Ӧ�ͻ������ݣ���¼ʧ��
			response.getWriter().println(0);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}
