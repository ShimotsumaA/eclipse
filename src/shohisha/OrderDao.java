package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.OrderBean;
import bean.ShohishaBean;
import sogo.DBAccess;

public class OrderDao extends DBAccess {

	public ArrayList<OrderBean> selectAll() {
		ArrayList<OrderBean> list = new ArrayList<>();

		// selectAll method
		String sql = "SELECT * FROM  TYUMON";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setDate(rs.getString("DATE"));
				bean.setSId(rs.getString("S_ID"));
				bean.setStatusId(rs.getInt("STATUS_ID"));
				bean.setODetailId(rs.getString("O_DETAIL_ID"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}

	public ArrayList<OrderBean> joken(String orderId) {
		ArrayList<OrderBean> list = new ArrayList<>();

		// joken method
		String sql = "SELECT*FROM  TYUMON where ORDER_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, orderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setDate(rs.getString("DATE"));
				bean.setSId(rs.getString("S_ID"));
				bean.setStatusId(rs.getInt("STATUS_ID"));
				bean.setODetailId(rs.getString("O_DETAIL_ID"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}

	public ArrayList<OrderBean> joukenDate(String date) {
		ArrayList<OrderBean> list = new ArrayList<>();

		// joukenDatel method
		String sql = "SELECT*FROM  TYUMON where DATE=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setDate(rs.getString("DATE"));
				bean.setSId(rs.getString("S_ID"));
				bean.setStatusId(rs.getInt("STATUS_ID"));
				bean.setODetailId(rs.getString("O_DETAIL_ID"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}

	public ArrayList<OrderBean> joukenShohisha(String sId) {
		ArrayList<OrderBean> list = new ArrayList<>();

		// joukenShohisha method
		String sql = "SELECT*FROM  TYUMON where S_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, sId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setDate(rs.getString("DATE"));
				bean.setSId(rs.getString("S_ID"));
				bean.setStatusId(rs.getInt("STATUS_ID"));
				bean.setODetailId(rs.getString("O_DETAIL_ID"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}

	public ArrayList<OrderBean> jokenStatus(int statusId) {
		ArrayList<OrderBean> list = new ArrayList<>();

		// joukenStatus method
		String sql = "SELECT*FROM  TYUMON where STATUS_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setDate(rs.getString("DATE"));
				bean.setSId(rs.getString("S_ID"));
				bean.setStatusId(rs.getInt("STATUS_ID"));
				bean.setODetailId(rs.getString("O_DETAIL_ID"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}

	public int delete(String orderId) {
		//delete method
		String sql = "delete from tyumon where ORDER_ID=?";

		int kensu=0;

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, orderId);

			kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}

	public int insert(String orderId,String date,String sId,int statusId,String oDetailID) {

		String sql = "insert tyumon into values(?,?,?,?,?)";

		//
		int kensu = 0;

		try {
			connect();
			//
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1,orderId);
				ps.setString(2, date);
				ps.setString(3, sId);
				ps.setInt(4, statusId);
				ps.setString(5, oDetailID);

				//
				kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}


	public int update(String orderId,int statusId){

		int count=0;

		String sql = "update tyumon set STATUS_ID=? where ORDER_ID=?";

		try {
			connect();
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(2, orderId);
			ps.setInt(1, statusId);


			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}

	public int updateCyumon(String orderId){

		int count=0;

		String sql = "update tyumon set STATUS_ID=1 where ORDER_ID=? ";

		try {
			connect();
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, orderId);


			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}

	public ArrayList<OrderBean> jokenSIdStatus(String sId, int statusId) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<OrderBean> list = new ArrayList<>();

		// joukenStatus method
		String sql = "SELECT*FROM  TYUMON where STATUS_ID=? AND S_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, statusId);
			ps.setString(2, sId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setDate(rs.getString("DATE"));
				bean.setSId(rs.getString("S_ID"));
				bean.setStatusId(rs.getInt("STATUS_ID"));
				bean.setODetailId(rs.getString("O_DETAIL_ID"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}







}