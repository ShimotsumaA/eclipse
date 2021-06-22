package kanrisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.KanrishaBean;
import sogo.DBAccess;

public class PostIdDao extends DBAccess{

	//一覧を表示するメソッド
		public  ArrayList<KanrishaBean> selectAll() {

			ArrayList<KanrishaBean> list = new ArrayList<KanrishaBean>();

			String sql = "select * from staff";

			try {
				connect();
				// ステートメントの作成
				PreparedStatement ps = getConnection().prepareStatement(sql);

				 ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					KanrishaBean bean = new KanrishaBean();
					bean.setPostId(rs.getString("postId"));
					bean.setPostName(rs.getString("postName"));
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
