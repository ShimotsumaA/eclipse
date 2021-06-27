package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.OrderBean;
import bean.PostCodeBean;
import sogo.DBAccess;

public class PostCodeDAO extends DBAccess{
	public ArrayList<PostCodeBean> joken(String zip) {
		ArrayList<PostCodeBean> list = new ArrayList<>();

		// joken method
		String sql = "SELECT*FROM  ad_address where zip=?";

		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, zip);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PostCodeBean bean = new PostCodeBean();
				bean.setZip(rs.getInt("zip"));
				bean.setKenId(rs.getInt("ken_id"));


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
