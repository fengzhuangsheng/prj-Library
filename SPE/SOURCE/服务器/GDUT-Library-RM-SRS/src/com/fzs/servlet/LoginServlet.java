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
 * @author fzs 响应 Android客户端发来的请求
 */

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		UserDao dao = new UserDaoImpl();
		// 获得客户端请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = dao.login(username, password);
		if (u != null) {
			// 响应客户端内容，登录成功
			request.getSession(true).setAttribute("username", username);
			try {

				// 把验证的userId封装成JSONObject
				JSONObject jsonObj = new JSONObject().put("username", username);
				// 输出响应
				response.getWriter().println(jsonObj.toString());

			} catch (JSONException ex) {
				ex.printStackTrace();
			}
		} else {
			// 响应客户端内容，登录失败
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
