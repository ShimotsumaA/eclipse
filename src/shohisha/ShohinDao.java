package shohisha;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShohinBean;
import sogo.DBAccess;

public class ShohinDao extends DBAccess {

	//商品テーブル全件検索
	public ArrayList<ShohinBean> selectAll(){
		ArrayList<ShohinBean>list=new ArrayList<ShohinBean>();

		String sql="SELECT * FROM shohin";

		try {
			connect();
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				ShohinBean bean = new ShohinBean();

				bean.setShohinId(rs.getString("shohinId"));
				bean.setShohinName(rs.getString("shohinName"));
				bean.setKijiId(rs.getString("kijiId"));
				bean.setCategoryId(rs.getString("categoryId"));
				bean.setValue(rs.getBigDecimal("value"));
				list.add(bean);
			}
		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			disconnect();
		}
		return list;
	}

	//商品IDをもとに商品テーブルを検索
	public ArrayList<ShohinBean> joken(String shohinId) {
		ShohinBean bean =new ShohinBean();
		ArrayList<ShohinBean>list=new ArrayList<ShohinBean>();

		String sql="SELECT shohinId, shohinName, kijiId, categoryId,value FROM shohin where shohinId=?";

		try {
			connect();
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, shohinId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				bean.setShohinId(rs.getString("shohinId"));
				bean.setShohinName(rs.getString("shohinName"));
				bean.setKijiId(rs.getString("kijiId"));
				bean.setCategoryId(rs.getString("categoryId"));
				bean.setValue(rs.getBigDecimal("value"));
				list.add(bean);
			}


		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;

		}


	//新規登録メソッド
		public int insert(String shohinId,String shohinName, String kijiId, String categoryId,BigDecimal value){

			String sql = "INSERT into shohisha(shohinId,shohinName,kijiId,categoryId,value)"
					+ "values(?,?,?,?,?)";

			int rs=0;

			try {
				connect();

				PreparedStatement ps=getConnection().prepareStatement(sql);
				ps.setString(1, shohinId);
				ps.setString(2, shohinName);
				ps.setString(3, kijiId);
				ps.setString(4, categoryId);
				ps.setBigDecimal(5,value);


				rs=ps.executeUpdate();



	    	}catch(Exception e) {
	    		e.printStackTrace();

	    	}finally {
	    		disconnect();
	    	}
			return rs;
		}

	//商品IDをもとに情報更新メソッド
		public int update(String shohinId,String shohinName, String kijiId, String categoryId,BigDecimal value) {

				String sql = "UPDATE shohin SET shohinName=?, kijiId=?,categoryId=?,value=? where shohinId=?";

				int rs=0;

				try {
					connect();
					PreparedStatement ps=getConnection().prepareStatement(sql);

					ps.setString(1, shohinName);
					ps.setString(2, kijiId);
					ps.setString(3, categoryId);
					ps.setBigDecimal(4, value);
					ps.setString(5,shohinId);


					rs=ps.executeUpdate();



		    	}catch(Exception e) {
		    		e.printStackTrace();

		    	}finally {
		    		disconnect();
		    	}
				return rs;
		}

	//削除メソッド
		public int delete(String shohinId) {

			String sql="DELETE FROM shohin where shohinId=?";
			int rs=0;

			try {
				connect();
				PreparedStatement ps=getConnection().prepareStatement(sql);

				ps.setString(1, shohinId);

				rs=ps.executeUpdate();

			}catch(Exception e) {
	    		e.printStackTrace();

	    	}finally {
	    		disconnect();
	    	}
			return rs;
		}
}
