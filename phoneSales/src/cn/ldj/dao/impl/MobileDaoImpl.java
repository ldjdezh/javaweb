package cn.ldj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.ldj.dao.MobileDao;
import cn.ldj.domain.MobileClassify;
import cn.ldj.domain.MobileForm;
import cn.ldj.utils.JdbcUtils;

public class MobileDaoImpl implements MobileDao {

	/**
	 * 返回所有手机类别
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<MobileClassify> getMobileClassify() throws Exception {
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
			String sql = "SELECT * FROM mobileclassify";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			List<MobileClassify> list = new ArrayList<MobileClassify>();

			while (rs.next()) {
				MobileClassify mc = new MobileClassify();
				int mid = rs.getInt("mid");
				String name = rs.getString("name");
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
	 * 根据手机版本号返回手机信息
	 * 
	 * @param version
	 * @return
	 * @throws Exception
	 */
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
			String sql = "select * mobileform where mobile_version = ?";
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

	/**
	 * 得到所有手机列表
	 */
	@Override
	public List<MobileForm> getMobileFormList(int begin, int end) throws Exception {
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

	/**
	 * 根据分类得到手机列表
	 */
	@Override
	public List<MobileForm> getMobileFormListByClassify(int mid, int begin, int end) throws Exception {
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
			String sql = "select * from mobileform where mid=? limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			List<MobileForm> list = new ArrayList<MobileForm>();

			while (rs.next()) {
				String version = rs.getString(1);
				String name = rs.getString(2);
				String made = rs.getString(3);
				double price = rs.getDouble(4);
				String mess = rs.getString(5);
				String pic = rs.getString(6);
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

	/**
	 * 根据版本号得到手机列表
	 */
	@Override
	public List<MobileForm> getMobileFormListByVersion(String version, int begin, int end) throws Exception {
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
			String sql = "select * from mobileform where mobile_version like %?% limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, version);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			List<MobileForm> list = new ArrayList<MobileForm>();

			while (rs.next()) {
				String version2 = rs.getString(1);
				String name = rs.getString(2);
				String made = rs.getString(3);
				double price = rs.getDouble(4);
				String mess = rs.getString(5);
				String pic = rs.getString(6);
				int mid = rs.getInt(7);
				MobileClassify mc = getMobileClassify(mid);

				MobileForm mf = new MobileForm();
				mf.setMobile_version(version2);
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

	/**
	 * 根据手机名得到手机列表
	 */
	@Override
	public List<MobileForm> getMobileFormListByName(String name, int begin, int end) throws Exception {
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
			String sql = "select * from mobileform where mobile_name like %?% limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			List<MobileForm> list = new ArrayList<MobileForm>();

			while (rs.next()) {
				String version = rs.getString(1);
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

	/**
	 * 根据价格区间得到手机列表
	 */
	@Override
	public List<MobileForm> getMobileFormListByPrice(int low, int high, int begin, int end) throws Exception {
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
			String sql = "select * from mobileform where mobile_price between ? and ? limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, low);
			pstmt.setInt(2, high);
			pstmt.setInt(3, begin);
			pstmt.setInt(4, end);

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
	public int getTotal() throws Exception{
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
			String sql = "select count(*) from mobileform";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
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
}
