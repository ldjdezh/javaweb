package cn.ldj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.ldj.dao.MobileDao;
import cn.ldj.dao.OrderDao;
import cn.ldj.dao.UserDao;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.OrderForm;
import cn.ldj.domain.User;
import cn.ldj.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrder(OrderForm orderForm) throws Exception {
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
			String sql = "insert into orderform values(null,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderForm.getUser().getUid());
			pstmt.setString(2, orderForm.getMobileForm().getMobile_version());
			pstmt.setString(3, orderForm.getMess());
			pstmt.setInt(4, orderForm.getNum());
			pstmt.setDouble(5, orderForm.getSum());
			pstmt.setInt(6, orderForm.getStatus());

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
	public int getTotal() throws Exception {
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
			String sql = "select count(*) from orderform";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int total = rs.getInt(1);

			return total;

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
	public List<OrderForm> getOrderFormList(int begin, int end) throws Exception {
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
			String sql = "select * from orderform limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();
			List<OrderForm> list = new ArrayList<OrderForm>();

			UserDao userDao = new UserDaoImpl();
			MobileDao mobileDao = new MobileDaoImpl();
			while (rs.next()) {
				int oid = rs.getInt(1);
				int uid = rs.getInt(2);
				String mobile_version = rs.getString(3);
				String mess = rs.getString(4);
				int num = rs.getInt(5);
				double price = rs.getDouble(6);
				int status = rs.getInt(7);

				User user = userDao.getUid(uid);
				MobileForm mf = mobileDao.getMobileForm(mobile_version);

				OrderForm of = new OrderForm();

				of.setOid(oid);
				of.setUser(user);
				of.setMobileForm(mf);
				of.setMess(mess);
				of.setNum(num);
				of.setStatus(status);
				of.setSum(price);

				list.add(of);
			}

			return list;

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
