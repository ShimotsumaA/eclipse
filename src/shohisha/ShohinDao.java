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

				bean.setShohinId(rs.getString("shohin_id"));
				bean.setShohinName(rs.getString("shohin_name"));
				bean.setKijiId(rs.getString("kiji_id"));
				bean.setValue(rs.getBigDecimal("value"));
				bean.setZaiko(rs.getInt("zaiko"));
				bean.setCategoryId(rs.getString("category_id"));


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

		String sql="SELECT shohin_d, shohin_name, kiji_id,value,zaiko,category_id, FROM shohin where shohinId=?";

		try {
			connect();
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, shohinId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				bean.setShohinId(rs.getString("shohin_id"));
				bean.setShohinName(rs.getString("shohin_name"));
				bean.setKijiId(rs.getString("kiji_id"));
				bean.setValue(rs.getBigDecimal("value"));
				bean.setZaiko(rs.getInt("zaiko"));
				bean.setCategoryId(rs.getString("category_id"));

			}


		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;

		}


	//新規登録メソッド
		public int insert(String shohinId,String shohinName, String kijiId, BigDecimal value,int zaiko, String categoryId){

			String sql = "INSERT into shohisha(shohin_id,shohin_name,kiji_id, value, zaiko,category_id)"
					+ "values(?,?,?,?,?,?)";

			int rs=0;

			try {
				connect();

				PreparedStatement ps=getConnection().prepareStatement(sql);
				ps.setString(1, shohinId);
				ps.setString(2, shohinName);
				ps.setString(3, kijiId);
				ps.setBigDecimal(4,value);
				ps.setInt(5,zaiko);
				ps.setString(6, categoryId);

				rs=ps.executeUpdate();

	    	}catch(Exception e) {
	    		e.printStackTrace();

	    	}finally {
	    		disconnect();
	    	}
			return rs;
		}

	//商品IDをもとにテーブル情報更新メソッド
		public int update(String shohinId,String shohinName, String kijiId, BigDecimal value,int zaiko, String categoryId) {

				String sql = "UPDATE shohin SET shohin_name=?, kiji_id=?,value=?, zaiko=?,category_id=? where shohin_id=?";

				int rs=0;

				try {
					connect();
					PreparedStatement ps=getConnection().prepareStatement(sql);

					ps.setString(1, shohinName);
					ps.setString(2, kijiId);
					ps.setBigDecimal(3, value);
					ps.setInt(3, zaiko);
					ps.setString(4, categoryId);
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

			String sql="DELETE FROM shohin where shohin_id=?";
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

	//zaikoUpdate(shohinIdをもとに入庫数を更新)
		public int zaikoUpdate(String shohinId,int nyuko) {
			String sql ="UPDATE shohin SET nyuko=? WHERE shohin_id=?";
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
	//nyukoUpdate(shohinIdをもとに在庫数を更新)
		public int nyukoUpdate(String shohinId,int zaiko) {
			String sql ="UPDATE shohin SET zaiko=? WHERE shohin_id=?";
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
	//zaikoInsert(shohinIdをもとに入庫数を新規登録)
		public int zaikoInsert(String shohinId,int nyuko) {
			String sql ="INSERT INTO shohin SET (shohin_id,nyuko)VALUES(?,?)";
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
