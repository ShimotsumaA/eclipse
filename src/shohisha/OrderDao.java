package shohisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sogo.DBAccess;
import bean.CategoryBean;
import bean.OrderBean;

public class OrderDao extends DBAccess{

	public ArrayList<OrderBean> selectAll(){
		ArrayList<OrderBean> list=new ArrayList<>();

		String sql="SELECT * FROM  TYUMON";

		try {
			connect();
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setOrderId(rs.getString("ORDER_ID"));
				bean.setData(rs.getString("DATE"));
				bean.setSId(rs.getString("S_ID"));
				bean.setSatusId(rs.getInt("STATUS_ID"));

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

