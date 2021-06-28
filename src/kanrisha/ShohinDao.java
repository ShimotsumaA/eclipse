package kanrisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShohinBean;
import sogo.DBAccess;

public class ShohinDao extends DBAccess {

	//商品を取得する
	public ArrayList<ShohinBean> selectAll(){
		ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();
		String sql="select*from shohin";
		try {
				connect();

				PreparedStatement ps =getConnection().prepareStatement(sql);
				ResultSet rs=ps.executeQuery();

				while(rs.next()) {
					ShohinBean bean=new ShohinBean();
					bean.setShohinId(rs.getString("shohin_id"));
					bean.setShohinName(rs.getString("shohin_name"));
					bean.setKijiId(rs.getString("kiji_id"));
					bean.setCategoryId(rs.getString("category_id"));
					bean.setZaiko(rs.getInt("zaiko"));
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
	//商品IDから商品の情報を取得する
	public ArrayList<ShohinBean> joken(String shohinId) {
			ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		    String sql="select*from shohin where shohin_Id=?";

		    try {
		    	connect();

		    	PreparedStatement ps=getConnection().prepareStatement(sql);
		    	ps.setString(1, shohinId);

		    	ResultSet rs=ps.executeQuery();

		    	while(rs.next()) {
		    		ShohinBean bean=new ShohinBean();
		    		bean.setShohinId(rs.getString("shohin_id"));
		    		bean.setShohinName(rs.getString("shohin_name"));
					bean.setKijiId(rs.getString("kiji_id"));
					bean.setCategoryId(rs.getString("category_id"));
					bean.setValue(rs.getBigDecimal("value"));
					bean.setZaiko(rs.getInt("zaiko"));

					list.add(bean);
		    	}
		    } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return list;
		    }

	public ArrayList<ShohinBean> kijijoken(String kijiId) {
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
	    String sql="select*from shohin where kiji_Id=?";

	    try {
	    	connect();

	    	PreparedStatement ps=getConnection().prepareStatement(sql);
	    	ps.setString(1, kijiId);

	    	ResultSet rs=ps.executeQuery();

	    	while(rs.next()) {
	    		ShohinBean bean=new ShohinBean();
	    		bean.setShohinId(rs.getString("shohin_id"));
	    		bean.setShohinName(rs.getString("shohin_name"));
				bean.setKijiId(rs.getString("kiji_id"));
				bean.setCategoryId(rs.getString("category_id"));
				bean.setValue(rs.getBigDecimal("value"));
				bean.setZaiko(rs.getInt("zaiko"));

				list.add(bean);
	    	}
	    } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	    }

	public ArrayList<ShohinBean> categoryjoken(String categoryId) {
		ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
	    String sql="select*from shohin where category_Id=?";

	    try {
	    	connect();

	    	PreparedStatement ps=getConnection().prepareStatement(sql);
	    	ps.setString(1, categoryId);

	    	ResultSet rs=ps.executeQuery();

	    	while(rs.next()) {
	    		ShohinBean bean=new ShohinBean();
	    		bean.setShohinId(rs.getString("shohin_id"));
	    		bean.setShohinName(rs.getString("shohin_name"));
				bean.setKijiId(rs.getString("kiji_id"));
				bean.setCategoryId(rs.getString("category_id"));
				bean.setValue(rs.getBigDecimal("value"));
				bean.setZaiko(rs.getInt("zaiko"));

				list.add(bean);
	    	}
	    } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	    }


	//新しい商品を登録する
	public int insert(String shohin_Id,String shohin_Name,String kiji_Id,
				String category_Id,java.math.BigDecimal value) {


	int count=0;

	String sql="insert into shohin(shohin_Id, shohin_Name ,kiji_Id, , value,category_Id) values(?,?,?,?,?)";
	try {
		connect();

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, shohin_Id);
		ps.setString(2, shohin_Name);
		ps.setString(3, kiji_Id);
		ps.setBigDecimal(4, value);
		ps.setString(5, category_Id);

		count=ps.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	return count;

	}

	//削除する
	public  int delete(String shohin_Id) {

		int count=0;

		String sql = "delete from shohin where shohin_Id=? ";

		try {
			connect();

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohin_Id);

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;

	}

	//変更する
	public int update(String shohin_Id,String shohin_Name,String kiji_Id,
			String category_Id, java.math.BigDecimal value) {

		int count=0;

		String sql = "update shohin set shohin_Name=?,kiji_Id=?,category_Id=?,value=? where shohin_Id=?";

		try {
			connect();

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(5, shohin_Id);
			ps.setString(1, shohin_Name);
			ps.setString(2, kiji_Id);
			ps.setString(3, category_Id);
			ps.setBigDecimal(4, value);


			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}


	//在庫情報を変更する
	public int zaikoUpdate(String shohin_Id ,int zaiko) {

		int count=0;

		String sql = "update shohin set zaiko=? where shohin_Id=?";

		try {
			connect();

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohin_Id);
			ps.setInt(2, zaiko);

			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;

	}


	//在庫情報を加える
	public  int zaikoInsert(String shohin_Id ,int zaiko) {

		int count=0;

		String sql = "insert into shohin(shohin_Id,zaiko) values (?,?)";

		try {
			connect();

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohin_Id);
			ps.setInt(2,zaiko);

			count=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}

	//nyukoUpdate
	public int nyukoUpdate(String shohin_Id,int nyuko) {
		int count=0;

		int zaiko=joken(shohin_Id).get(0).getZaiko()+nyuko;



		String sql = "update shohin set zaiko=? where shohin_Id=?";

		try {
			connect();

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohin_Id);
			ps.setInt(2, zaiko);

			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;
	}
}
