package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CategoryBean;
import sogo.DBAccess;

	public class CategoryDao extends DBAccess{

	//カテゴリテーブル全件検索
		public ArrayList<CategoryBean> selectAll(){
			ArrayList<CategoryBean>list=new ArrayList<CategoryBean>();

			String sql="SELECT * FROM category";

			try {
				connect();
				PreparedStatement ps=getConnection().prepareStatement(sql);
				ResultSet rs=ps.executeQuery();

				while(rs.next()) {
					CategoryBean bean = new CategoryBean();

					bean.setCategoryId(rs.getString("categoryId"));
					bean.setCategoryName(rs.getString("categoryName"));
					list.add(bean);
				}
			}catch(SQLException e) {
				e.printStackTrace();

			}finally {
				disconnect();
			}
			return list;
		}

}
