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
		String sql = "SELECT*FROM  TYUMON_DETAIL where O_DETAIL_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, oDetailId);
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

	public ArrayList<OrderDetailBean> joukenShohin(String oDetailId,String shohinId) {
		ArrayList<OrderDetailBean> list = new ArrayList<>();

		// jouken method
		String sql = "SELECT*FROM  TYUMON_DETAIL where O_DETAIL_ID=? AND SHOHIN_ID";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, oDetailId);
			ps.setString(2, shohinId);
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




	public int delete(String oDetailId) {
		//delete method
		String sql = "delete from tyumon_detail where O_DETAIL_ID=?";

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

	public int deleteShohin(String oDetailId,String shohinId) {
		//delete method
		String sql = "delete from tyumon_detail where O_DETAIL_ID=? and where shohin_id=?";

		int kensu=0;

		try {connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, oDetailId);
			ps.setString(2, shohinId);

			kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}

	public int insert(String oDetailId,String shohinId,int kazuKonyu) {

		String sql = "insert tyumon_detail into values(?,?,?)";

		//
		int kensu = 0;

		try {
			connect();
			//
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1,oDetailId);
				ps.setString(2,shohinId);
				ps.setInt(3,kazuKonyu );

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

		String sql = "update tyumon_detail set KAZU_KONYU=? where O_DETAIL_ID=? AND SHOHIN_ID=?";
		int kazu=joukenShohin(oDetailId,shohinId).get(0).getKazuKonyu()+kazuKonyu;


		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(2, oDetailId);
			ps.setInt(1, kazu);
			ps.setString(3, shohinId);



			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}



}
