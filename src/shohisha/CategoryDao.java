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

					bean.setCategoryId(rs.getString("CATEGORY_ID"));
					bean.setCategoryName(rs.getString("CATEGORY_NAME"));
					list.add(bean);
				}
			}catch(SQLException e) {
				e.printStackTrace();

			}finally {
				disconnect();
			}
			return list;
		}

		public ArrayList<CategoryBean> joken(String categoryId){
			ArrayList<CategoryBean>list=new ArrayList<CategoryBean>();

			String sql="SELECT * FROM category where categoryId=?";

			try {
				connect();

				PreparedStatement ps=getConnection().prepareStatement(sql);
				ps.setString(1, categoryId);
				ResultSet rs=ps.executeQuery();

				while(rs.next()) {
					CategoryBean bean = new CategoryBean();

					bean.setCategoryId(rs.getString("CATEGORY_ID"));
					bean.setCategoryName(rs.getString("CATEGORY_NAME"));
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
