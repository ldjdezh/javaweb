package cn.ldj.dao.admin.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.ldj.dao.MobileDao;
import cn.ldj.dao.UserDao;
import cn.ldj.dao.admin.AdminDao;
import cn.ldj.dao.impl.MobileDaoImpl;
import cn.ldj.dao.impl.UserDaoImpl;
import cn.ldj.domain.Manager;
import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.domain.OrderForm;
import cn.ldj.domain.User;
import cn.ldj.utils.JdbcUtils;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void deleteMade(int mid) throws Exception {
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
			String sql = "delete from mobileclassify where mid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);

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

	/**
	 * 添加分类
	 */
	@Override
	public void addMade(String made) throws Exception {
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
			String sql = "insert into mobileclassify values(null,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, made);

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

	/**
	 * 获得分类
	 */
	@Override
	public List<MobileClassify> getAllMobileClassify() throws Exception {
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
			String sql = "select * from mobileclassify";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			List<MobileClassify> list = new ArrayList<MobileClassify>();

			while (rs.next()) {
				int mid = rs.getInt(1);
				String name = rs.getString(2);
				MobileClassify mc = new MobileClassify();
				mc.setMid(mid);
				mc.setName(name);
				list.add(mc);
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

	/**
	 * 根据名字返回管理员
	 */
	@Override
	public Manager getManager(String name) throws Exception {
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
			String sql = "select * from manager where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int mid = rs.getInt(1);
			String password = rs.getString(3);
			Manager manager = new Manager();
			manager.setMid(mid);
			manager.setName(name);
			manager.setPassword(password);

			return manager;

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
	public void addPhone(MobileForm mf) throws Exception {
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
			String sql = "insert into mobileform values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mf.getMobile_version());
			pstmt.setString(2, mf.getMobile_name());
			pstmt.setString(3, mf.getMobile_made());
			pstmt.setDouble(4, mf.getMobile_price());
			pstmt.setString(5, mf.getMobile_mess());
			pstmt.setString(6, mf.getMobile_pic());
			pstmt.setInt(7, mf.getMobile_classify().getMid());

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
	public void updatePhone(MobileForm mf) throws Exception {
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
			String sql = "update mobileform set mobile_name=?,mobile_made=?"
					+ ", mobile_price=?,mobile_mess=?,mobile_pic=?,mid=? " + " where mobile_version=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, mf.getMobile_name());
			pstmt.setString(2, mf.getMobile_made());
			pstmt.setDouble(3, mf.getMobile_price());
			pstmt.setString(4, mf.getMobile_mess());
			pstmt.setString(5, mf.getMobile_pic());
			pstmt.setInt(6, mf.getMobile_classify().getMid());
			pstmt.setString(7, mf.getMobile_version());

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
	public void deletePhone(MobileForm mf) throws Exception {
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
			String sql = "delete from mobileform where mobile_version=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mf.getMobile_version());
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
	public List<MobileForm> findPhoneList(int begin, int end) throws Exception {
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
			String sql = "select * from mobileform limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();
			List<MobileForm> list = new ArrayList<MobileForm>();

			while (rs.next()) {
				String version = rs.getString(1);
				String name = rs.getString(2);
				String made = rs.getString(3);
				double price = rs.getDouble(4);
				String mess = rs.getString(5);
				String pic = rs.getString(6);
				int mid = rs.getInt(7);
				MobileClassify mc = getMobileClassify(mid);

				MobileForm mf = new MobileForm();
				mf.setMobile_version(version);
				mf.setMobile_name(name);
				mf.setMobile_made(made);
				mf.setMobile_price(price);
				mf.setMobile_mess(mess);
				mf.setMobile_pic(pic);
				mf.setMobile_classify(mc);
				list.add(mf);
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

	@Override
	public MobileForm getMobileForm(String version) throws Exception {
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
			String sql = "select * from mobileform where mobile_version = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, version);

			rs = pstmt.executeQuery();

			if (!rs.next()) {
				throw new Exception("没有这个手机版本号");
			}

			String name = rs.getString(2);
			String made = rs.getString(3);
			double price = rs.getDouble(4);
			String mess = rs.getString(5);
			String pic = rs.getString(6);
			int mid = rs.getInt(7);
			MobileClassify mc = getMobileClassify(mid);

			MobileForm mf = new MobileForm();
			mf.setMobile_version(version);
			mf.setMobile_name(name);
			mf.setMobile_made(made);
			mf.setMobile_price(price);
			mf.setMobile_mess(mess);
			mf.setMobile_pic(pic);
			mf.setMobile_classify(mc);

			return mf;

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

	/**
	 * 根据手机类别id获得mobileclassify对象
	 */
	@Override
	public MobileClassify getMobileClassify(int mid) throws Exception {
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
			String sql = "select * from mobileclassify where mid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);

			rs = pstmt.executeQuery();
			if (!rs.next()) {
				throw new Exception("没有这个手机类别");
			}

			String name = rs.getString("name");

			MobileClassify mc = new MobileClassify();
			mc.setMid(mid);
			mc.setName(name);

			return mc;

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
			String sql = "select count(*) as num from mobileform";
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
	public int getTotalByOrder() throws Exception {
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
			String sql = "select count(*) as num from orderform";
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
