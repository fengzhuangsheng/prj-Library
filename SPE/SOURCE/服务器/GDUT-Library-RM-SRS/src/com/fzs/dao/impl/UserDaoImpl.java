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
 * @author fzs ���ݿ����DAOʵ����
 */
public class UserDaoImpl implements UserDao {

	/**
	 * ͨ���û����ƺ������¼����¼�ɹ�����User���󣬵�¼ʧ�ܷ���null
	 */
	public User login(String username, String password) {

		String sql = " select username,password from Userinfo where username=? and password=? ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		System.out.println("���ݿ����ӳɹ���");
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
	 * �û�ע�ᣬע��ɹ�����true��ע��ʧ�ܷ���false
	 */
	
	public boolean register(User user) {

		boolean f = false;
		String sql = " insert into Userinfo values (?,?,?,?)";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		System.out.print("���ݿ����ӳɹ���");
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
	 * ��֤�û��Ƿ���ڣ����ڷ���true�������ڷ���false
	 */
	
	public boolean check(String username) {
		boolean b = false;
		String sql = "select * from Userinfo where username=?";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		System.out.print("���ݿ����ӳɹ���");
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
