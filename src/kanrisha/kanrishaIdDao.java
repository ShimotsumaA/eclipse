package kanrisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.kanrishaBean;
import sogo.DBAccess;

public class kanrishaIdDao extends DBAccess{

	//すべての社員情報を得る
	public ArrayList<kanrishaBean> selectAll(){
		ArrayList<kanrishaBean> list = new ArrayList<kanrishaBean>();

		String sql = "select * from  staff";

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);

			//SQLを発行する
		 	ResultSet rs = ps.executeQuery();


		 	//ResultSetからbeanにユーザ情報を設定する
		 	while(rs.next()){
		 		kanrishaBean bean = new kanrishaBean();

		 		bean.setId(rs.getString("kId"));
		 		bean.setName(rs.getString("kName"));
		 		bean.setName(rs.getString("postId"));
		 		bean.setPass(rs.getString("kPass"));

		 		list.add(bean);
		 	}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}


	//IDからある社員の情報を選択する
	public ArrayList<kanrishaBean> jouken(String kId){
		ArrayList<kanrishaBean> list = new ArrayList<kanrishaBean>();

		String sql = "select k_Name, k_Pass from staff where k_Id = ?";

		try {
			connect();

			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, kId);

			//SQLを発行する
		 	ResultSet rs = ps.executeQuery();

		 	//ResultSetからbeanにユーザ情報を設定する
		 	while(rs.next()){
		 		kanrishaBean bean = new kanrishaBean();

		 		bean.setId("kId");
		 		bean.setName(rs.getString("kName"));
		 		bean.setName(rs.getString("postId"));
		 		bean.setPass(rs.getString("kPass"));

		 		list.add(bean);
		 	}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;

	}


	//新しい社員情報を登録する
	public int insert(String kId, String kName, String postId, String kPass) {

		String sql = "insert into staff values(?,?,?,?)";

		int kensu = 0;

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1, kId);
				ps.setString(2, kName);
				ps.setString(3, postId);
				ps.setString(4, kPass);

				//SQLを発行し、件数に代入する
				kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}


	//前のID(oldKId)をもとに社員情報を選択し、新しい情報に登録しなおす。
	public int update(String oldKId, String newKId, String kName, String postId, String kPass) {
		String sql = "update staff set k_Id=?, k_Name=?, post_Id=?, k_Pass=? where k_Id=?";
		int kensu = 0;

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1, newKId);
				ps.setString(2, kName);
				ps.setString(3, kPass);
				ps.setString(4, postId);
				ps.setString(5, oldKId);

				//SQLを発行し、件数に代入する
				kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}

	public int delete(String kId) {
		String sql = "delete from staff where k_Id=?";
		int kensu = 0;

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1, kId);

				kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}

}
