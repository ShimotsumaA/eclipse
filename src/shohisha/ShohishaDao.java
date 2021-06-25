package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShohishaBean;
import sogo.DBAccess;

public class ShohishaDao extends DBAccess {

	//消費者テーブル全件検索
	public ArrayList<ShohishaBean> selectAll(){
		ArrayList<ShohishaBean>list=new ArrayList<ShohishaBean>();

		String sql="SELECT * FROM shohisha";

		try {
			connect();
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				ShohishaBean bean = new ShohishaBean();

				bean.setId(rs.getString("s_id"));
				bean.setName(rs.getString("s_name"));
				bean.setBirth(rs.getString("date_birth"));
				bean.setPost(rs.getString("postcode"));
				bean.setAdress(rs.getString("address"));
				bean.setTel(rs.getString("tel"));
				bean.setMail(rs.getString("mailaddress"));
				bean.setPass(rs.getString("s_pass"));
				list.add(bean);
			}
		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			disconnect();
		}
		return list;
	}


	//IDをもとに消費者テーブルを検索
	public ArrayList<ShohishaBean> joken(String sId) {
		ShohishaBean bean =new ShohishaBean();
		ArrayList<ShohishaBean>list=new ArrayList<ShohishaBean>();

		String sql="SELECT s_id, s_name, date_birth, postcode, address, tel, mailadress, s_pass FROM shohisha where s_id=?";

		try {
			connect();
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, sId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				bean.setId(rs.getString("s_id"));
				bean.setName(rs.getString("s_name"));
				bean.setBirth(rs.getString("date_birth"));
				bean.setPost(rs.getString("postcode"));
				bean.setAdress(rs.getString("address"));
				bean.setTel(rs.getString("tel"));
				bean.setMail(rs.getString("mailaddress"));
				bean.setPass(rs.getString("s_pass"));
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
		public int insert(String sId, String sName, String dateBirth, String postCode, String adress,
				String tel, String mailAdress, String sPass) {

			String sql = "INSERT into shohisha(s_id, s_name, date_birth, postcode, address, tel, mailadress, s_pass)"
					+ "values(?,?,?,?,?,?,?,?)";

			int rs=0;

			try {
				connect();

				PreparedStatement ps=getConnection().prepareStatement(sql);
				ps.setString(1, sId);
				ps.setString(2, sName);
				ps.setString(3, dateBirth);
				ps.setString(4, postCode);
				ps.setString(5,adress);
				ps.setString(6,tel);
				ps.setString(7,mailAdress);
				ps.setString(8,sPass);

				rs=ps.executeUpdate();



	    	}catch(Exception e) {
	    		e.printStackTrace();

	    	}finally {
	    		disconnect();
	    	}
			return rs;
		}

	//情報更新メソッド
		public int update(String sId, String sName, String dateBirth, String postCode, String adress,
					String tel, String mailAdress, String sPass) {

				String sql = "UPDATE shohisha SET s_name=?, date_birth=?,postcode=?,address=?,tel=?"
						+ "mailaddress=?,s_pass=? where s_id=?";

				int rs=0;

				try {
					connect();
					PreparedStatement ps=getConnection().prepareStatement(sql);

					ps.setString(1, sName);
					ps.setString(2, dateBirth);
					ps.setString(3, postCode);
					ps.setString(4, adress);
					ps.setString(5,tel);
					ps.setString(6,mailAdress);
					ps.setString(7,sPass);
					ps.setString(8,sId);

					rs=ps.executeUpdate();



		    	}catch(Exception e) {
		    		e.printStackTrace();

		    	}finally {
		    		disconnect();
		    	}
				return rs;
		}

	//削除メソッド
		public int delete(String sId) {

			String sql="DELETE FROM shohisha where s_id=?";
			int rs=0;

			try {
				connect();
				PreparedStatement ps=getConnection().prepareStatement(sql);

				ps.setString(1, sId);

				rs=ps.executeUpdate();

			}catch(Exception e) {
	    		e.printStackTrace();

	    	}finally {
	    		disconnect();
	    	}
			return rs;
		}

}
