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
					bean.setKijiId(rs.getString("kijiId"));
					bean.setKijiName(rs.getString("KijiName"));
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
