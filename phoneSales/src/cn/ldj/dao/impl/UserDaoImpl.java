package cn.ldj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.ldj.dao.UserDao;
import cn.ldj.domain.User;
import cn.ldj.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) throws Exception {
		Connection con = null;// 定义引用
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			/*
			 * 一、得到连接
			 */
			con = JdbcUtils.getConnection();

			/*
			 * 二、创建PreparedStatement
			 */
			String sql = "INSERT INTO user VALUES(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setString(2, user.getLogname());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getRealname());

			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	@Override
	public User getUser(String logname) throws Exception {
		Connection con = null;// 定义引用
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			/*
			 * 一、得到连接
			 */
			con = JdbcUtils.getConnection();

			/*
			 * 二、创建PreparedStatement
			 */

			String sql = "SELECT * FROM user WHERE logname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, logname);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int uid = rs.getInt("uid");
			String rPassword = rs.getString("password");
			String rPhone = rs.getString("phone");
			String rAddress = rs.getString("address");
			String rRealname = rs.getString("realname");

			User user = new User();
			user.setUid(uid);
			user.setLogname(logname);
			user.setPassword(rPassword);
			user.setAddress(rAddress);
			user.setPhone(rPhone);
			user.setRealname(rRealname);

			return user;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}

	}

	@Override
	public void updateUser(User user) throws Exception {
		Connection con = null;// 定义引用
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			/*
			 * 一、得到连接
			 */
			con = JdbcUtils.getConnection();

			/*
			 * 二、创建PreparedStatement
			 */
			String sql = "UPDATE user set password=?,phone=?,address=?,realname=? where uid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getPhone());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getRealname());
			pstmt.setInt(5, user.getUid());

			pstmt.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	@Override
	public User getUid(int uid) throws Exception {
		Connection con = null;// 定义引用
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			/*
			 * 一、得到连接
			 */
			con = JdbcUtils.getConnection();

			/*
			 * 二、创建PreparedStatement
			 */

			String sql = "SELECT * FROM user WHERE uid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String logname = rs.getString("logname");
			String rPassword = rs.getString("password");
			String rPhone = rs.getString("phone");
			String rAddress = rs.getString("address");
			String rRealname = rs.getString("realname");

			User user = new User();
			user.setUid(uid);
			user.setLogname(logname);
			user.setPassword(rPassword);
			user.setAddress(rAddress);
			user.setPhone(rPhone);
			user.setRealname(rRealname);

			return user;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

}
