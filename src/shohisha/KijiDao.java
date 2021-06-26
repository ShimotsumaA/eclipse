package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.KijiBean;
import sogo.DBAccess;

public class KijiDao extends DBAccess{

	//一覧を表示するメソッド
		public  ArrayList<KijiBean> selectAll() {

			ArrayList<KijiBean> list = new ArrayList<KijiBean>();

			String sql = "select * from kiji";

			try {
				connect();
				// ステートメントの作成
				PreparedStatement ps = getConnection().prepareStatement(sql);

				 ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					KijiBean bean = new KijiBean();
					bean.setKijiId(rs.getString("kiji_id"));
					bean.setKijisyurui(rs.getString("syurui"));
					bean.setKijiColour(rs.getString("colour"));

					list.add(bean);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return list;


		}

		public  ArrayList<KijiBean> joken(String kijiId) {

			ArrayList<KijiBean> list = new ArrayList<KijiBean>();

			String sql = "select * from kiji where kiji_id=?";

			try {
				connect();
				// ステートメントの作成
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, kijiId);

				 ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					KijiBean bean = new KijiBean();
					bean.setKijiId(rs.getString("kiji_id"));
					bean.setKijisyurui(rs.getString("syurui"));
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
