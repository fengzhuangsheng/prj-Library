package com.fzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.fzs.entity.User;
import com.fzs.dao.UserDao;
import com.fzs.util.DBUtil;

/**
 * 
 * @author fzs 数据库操作DAO实现类
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 通过用户名称和密码登录，登录成功返回User对象，登录失败返回null
	 */
	public User login(String username, String password) {

		String sql = " select username,password from Userinfo where username=? and password=? ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		System.out.println("数据库连接成功！");
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setPassword(password);
				u.setUsername(username);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}
	
	/**
	 * 用户注册，注册成功返回true，注册失败返回false
	 */
	
	public boolean register(User user) {

		boolean f = false;
		String sql = " insert into Userinfo values (?,?,?,?)";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		System.out.print("数据库连接成功！");
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setLong(3, user.getAge());
			pstmt.setString(4, user.getSex());

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				f = true;
			} else {
				f = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return f;
	}
	
	/**
	 * 验证用户是否存在，存在返回true，不存在返回false
	 */
	
	public boolean check(String username) {
		boolean b = false;
		String sql = "select * from Userinfo where username=?";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		System.out.print("数据库连接成功！");
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			rs = ps.executeQuery();
			if (rs.next()) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			util.closeConn(conn);
		}
		return b;
	}

}
