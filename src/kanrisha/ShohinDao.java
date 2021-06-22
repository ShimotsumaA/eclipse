package kanrisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShohinBean;
import sogo.DBAccess;

public class ShohinDao extends DBAccess {
	//一覧表示のメソッド
	public ArrayList<ShohinBean> selectAll(){
		ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();
		String sql="select*from shohin";
		try {
				connect();
				//ステートメントの作成
				PreparedStatement ps =getConnection().prepareStatement(sql);
				ResultSet rs=ps.executeQuery();

				while(rs.next()) {
					ShohinBean bean=new ShohinBean();
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
	//抽出メソッド
	public ArrayList<ShohinBean> joken(String shohinId) {
			ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		    String sql="select*from shohin where shohinId=?";

		    try {
		    	connect();
		    	//ステートメントの作成
		    	PreparedStatement ps=getConnection().prepareStatement(sql);
		    	ps.setString(1, shohinId);

		    	ResultSet rs=ps.executeQuery();

		    	while(rs.next()) {
		    		ShohinBean bean=new ShohinBean();
		    		bean.setShohinId(rs.getString("shohinId"));
		    		bean.setShohinName(rs.getString("shohinName"));
					bean.setKijiId(rs.getString("kijiId"));
					bean.setCategoryId(rs.getString("categoryId"));
					bean.setValue(rs.getBigDecimal("value"));
					list.add(bean);
		    	}
		    } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return list;
		    }
	//登録メソッド
	public int insert(String shohinId,String shohinName,String kijiId,
				String categoryId,java.math.BigDecimal value) {


	int count=0;

	String sql="insert into shohin(shohinId, shohinName ,kijiId, categoryId, value) values(?,?,?,?,?)";
	try {
		connect();
		// ステートメントの作成
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, shohinId);
		ps.setString(2, shohinName);
		ps.setString(3, kijiId);
		ps.setString(4, categoryId);
		ps.setBigDecimal(5, value);
		count=ps.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disconnect();
	}
	return count;

	}

	//商品削除メソッド
	public  int delete(String shohinId) {

		int count=0;

		String sql = "delete from shohin where shohinId=? ";

		try {
			connect();
			// ステートメントの作成
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohinId);

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;

	}

	public int update(String shohinId,String shohinName,String kijiId,
			String categoryId,java.math.BigDecimal value) {

		int count=0;

		String sql = "update shohin set shohinName=?,kijiId=?,categoryId=?,value=? where shohinId=?";

		try {
			connect();
			// ステートメントの作成
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohinId);
			ps.setString(2, shohinName);
			ps.setString(3, kijiId);
			ps.setString(4, categoryId);
			ps.setBigDecimal(5, value);


			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}


	//在庫を変更するメソッド
	public int zaikoUpdate(String shohinId ,int zaiko) {

		int count=0;

		String sql = "update shohin set zaiko=? where shohinId=?";

		try {
			connect();
			// ステートメントの作成
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohinId);
			ps.setInt(2, zaiko);

			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;

	}


	//テーブルに値を追加するメソッド
	public  int zaikoInsert(String shohinId ,int nyuko) {

		int count=0;

		String sql = "insert into shohin(shohinId,nyuko) values (?,?)";

		try {
			connect();
			// ステートメントの作成
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohinId);
			ps.setInt(2,nyuko );

			count=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}
}
