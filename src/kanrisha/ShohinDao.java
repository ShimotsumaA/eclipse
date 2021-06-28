package kanrisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ShohinBean;
import sogo.DBAccess;

public class ShohinDao extends DBAccess {
	//荳�隕ｧ陦ｨ遉ｺ縺ｮ繝｡繧ｽ繝�繝�
	public ArrayList<ShohinBean> selectAll(){
		ArrayList<ShohinBean> list=new ArrayList<ShohinBean>();
		String sql="select*from shohin";
		try {
				connect();
				//繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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
	//謚ｽ蜃ｺ繝｡繧ｽ繝�繝�
	public ArrayList<ShohinBean> joken(String shohinId) {
			ArrayList<ShohinBean> list = new ArrayList<ShohinBean>();
		    String sql="select*from shohin where shohin_Id=?";

		    try {
		    	connect();
		    	//繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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
	    	//繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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
	    	//繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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


	//逋ｻ骭ｲ繝｡繧ｽ繝�繝�
	public int insert(String shohin_Id,String shohin_Name,String kiji_Id,
				String category_Id,java.math.BigDecimal value) {


	int count=0;

	String sql="insert into shohin(shohin_Id, shohin_Name ,kiji_Id, , value,category_Id) values(?,?,?,?,?)";
	try {
		connect();
		// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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

	//蝠�蜩∝炎髯､繝｡繧ｽ繝�繝�
	public  int delete(String shohin_Id) {

		int count=0;

		String sql = "delete from shohin where shohin_Id=? ";

		try {
			connect();
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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

	public int update(String shohin_Id,String shohin_Name,String kiji_Id,
			String category_Id,java.math.BigDecimal value) {

		int count=0;

		String sql = "update shohin set shohin_Name=?,kiji_Id=?,category_Id=?,value=? where shohin_Id=?";

		try {
			connect();
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, shohin_Id);
			ps.setString(2, shohin_Name);
			ps.setString(3, kiji_Id);
			ps.setString(4, category_Id);
			ps.setBigDecimal(5, value);


			count =ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;


	}


	//蝨ｨ蠎ｫ繧貞､画峩縺吶ｋ繝｡繧ｽ繝�繝�
	public int zaikoUpdate(String shohin_Id ,int zaiko) {

		int count=0;

		String sql = "update shohin set zaiko=? where shohin_Id=?";

		try {
			connect();
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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


	//繝�繝ｼ繝悶Ν縺ｫ蛟､繧定ｿｽ蜉�縺吶ｋ繝｡繧ｽ繝�繝�
	public  int zaikoInsert(String shohin_Id ,int zaiko) {

		int count=0;

		String sql = "insert into shohin(shohin_Id,zaiko) values (?,?)";

		try {
			connect();
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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
			// 繧ｹ繝�繝ｼ繝医Γ繝ｳ繝医�ｮ菴懈��
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
