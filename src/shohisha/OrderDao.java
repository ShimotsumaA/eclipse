package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sogo.DBAccess;
import bean.CategoryBean;
import bean.OrderBean;

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
				bean.setData(rs.getString("DATE"));
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

	public ArrayList<OrderBean> jouken(String orderId) {
		ArrayList<OrderBean> list = new ArrayList<>();

		// jouken method
		String sql = "SELECT*FROM  TYUMON where ORDER_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setData(rs.getString("DATE"));
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
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setData(rs.getString("DATE"));
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
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setData(rs.getString("DATE"));
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

	public ArrayList<OrderBean> jokenStatus(String orderId) {
		ArrayList<OrderBean> list = new ArrayList<>();

		// joukenStatus method
		String sql = "SELECT*FROM  TYUMON where STATUS_ID=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setData(rs.getString("DATE"));
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

	public int insert(String kId, String kName, String postId, String kPass) {

		String sql = "insert into STAFF values(?,?,?,?)";

		//邂｡逅�閠�諠�蝣ｱ繧定ｿｽ蜉�縺励◆莉ｶ謨ｰ
		int kensu = 0;

		try {
			connect();
			//繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医ｒ菴懈�舌☆繧�
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1, kId);
				ps.setString(2, kName);
				ps.setString(3, postId);
				ps.setString(4, kPass);

				//SQL繧堤匱陦後＠縲∽ｻｶ謨ｰ縺ｫ莉｣蜈･縺吶ｋ
				kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}






}