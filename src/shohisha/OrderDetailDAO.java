package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.OrderDetailBean;
import sogo.DBAccess;

public class OrderDetailDAO extends DBAccess{

	public ArrayList<OrderDetailBean> selectAll() {
		ArrayList<OrderDetailBean> list = new ArrayList<>();

		// selectAll method
		String sql = "SELECT * FROM  TYUMON_DETAIL";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderDetailBean bean = new OrderDetailBean();

				bean.setODetailId(rs.getString("O_DETAIL_ID"));
				bean.setShohinId(rs.getString("SHOHIN_ID"));
				bean.setKazuKonyu(rs.getInt("KAZU_KONYU"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}

	public ArrayList<OrderDetailBean> jouken(String oDetailId) {
		ArrayList<OrderDetailBean> list = new ArrayList<>();

		// jouken method
		String sql = "SELECT*FROM  TYUMON_ID where O_DETAIL_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderDetailBean bean = new OrderDetailBean();

				bean.setODetailId(rs.getString("ORDER_ID"));
				bean.setShohinId(rs.getString("SHOHIN_ID"));
				bean.setKazuKonyu(rs.getInt("KAZU_KONYU"));
	
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disconnect();
		}
		return list;
	}


	public int delete(String oDetailId) {
		//delete method
		String sql = "delete from tyumon where O_DETAIL_ID=?";

		int kensu=0;

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, oDetailId);

			kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}

	public int insert(String oDetailId,String shohinId,int kazuKonyu) {

		String sql = "insert tyumon into values(?,?,?)";

		//
		int kensu = 0;

		try {
			connect();
			//
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1,oDetailId);
				ps.setString(2,shohinId);
				ps.setInt(4,kazuKonyu );

				//
				kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}


	public int update(String oDetailId,String shohinId,int kazuKonyu){

		int count=0;

		String sql = "update tyumon set STATUS_ID=? where ORDER_ID=?";

		try {
			connect();
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(2, orderId);
			ps.setInt(1, StatusId);


			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}



}
