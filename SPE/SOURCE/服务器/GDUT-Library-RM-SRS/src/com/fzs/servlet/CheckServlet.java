package com.fzs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fzs.dao.UserDao;
import com.fzs.dao.impl.UserDaoImpl;

public class CheckServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		UserDao userDaoImpl = new UserDaoImpl();
		boolean b = userDaoImpl.check(username);
		if (b) // �û�������
		{
			out.write("t");
		} else // �û���������
		{
			out.write("f");
		}
		out.flush();
		out.close();
	}

}
