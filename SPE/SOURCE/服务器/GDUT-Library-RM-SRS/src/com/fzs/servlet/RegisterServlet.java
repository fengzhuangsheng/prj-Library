package com.fzs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fzs.dao.UserDao;
import com.fzs.dao.impl.UserDaoImpl;
import com.fzs.entity.User;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 获得客户端请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		User user = new User(username, password, age, sex);

		UserDao dao = new UserDaoImpl();
		// UserDaoImpl userDaoImpl = new UserDaoImpl();
		boolean b = dao.register(user);
		if (b) {
			out.write("true");
		} else {
			out.write("false");
		}
		out.flush();
		out.close();

	}
}
