package kanrisha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KanrishaBean;
import sogo.DBAccess;

public class KanrishaIdDao extends DBAccess{

	//管理者情報をすべて選択する
	public ArrayList<KanrishaBean> selectAll(){
		ArrayList<KanrishaBean> list = new ArrayList<KanrishaBean>();

		String sql = "select * from  staff";

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);

			//SQLを発行する
		 	ResultSet rs = ps.executeQuery();


		 	//ResultSetからbeanにユーザ情報を設定する
		 	while(rs.next()){
		 		KanrishaBean bean = new KanrishaBean();

		 		bean.setId(rs.getString("K_ID"));
		 		bean.setName(rs.getString("k_Name"));
		 		bean.setPostId(rs.getString("post_Id"));
		 		bean.setPass(rs.getString("k_Pass"));

		 		list.add(bean);
		 	}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}


	//管理者IDをもとに特定の管理者情報を選択する
	public ArrayList<KanrishaBean> joken(String kId){

		ArrayList<KanrishaBean> list = new ArrayList<KanrishaBean>();

		String sql = "select K_NAME, POST_ID, K_PASS  from STAFF where K_ID = ?";

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, kId);

			//SQLを発行する
		 	ResultSet rs = ps.executeQuery();

		 	//ResultSetからbeanにユーザ情報を設定する
		 	while(rs.next()){
		 		KanrishaBean bean = new KanrishaBean();

		 		bean.setId(kId);
		 		bean.setName(rs.getString("k_Name"));
		 		bean.setPostId(rs.getString("post_Id"));
		 		bean.setPass(rs.getString("k_Pass"));

		 		list.add(bean);
		 	}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;

	}

	//IDとパスワードを用いて情報を取得する
	public ArrayList<KanrishaBean> passCollect(String kId,String kPass){

		ArrayList<KanrishaBean> list = new ArrayList<KanrishaBean>();

		String sql = "select K_NAME, POST_ID, K_PASS  from STAFF where K_ID = ? AND K_PASS=?";

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, kId);
			ps.setString(2, kPass);

			//SQLを発行する
		 	ResultSet rs = ps.executeQuery();

		 	//ResultSetからbeanにユーザ情報を設定する
		 	while(rs.next()){
		 		KanrishaBean bean = new KanrishaBean();

		 		bean.setId(kId);
		 		bean.setName(rs.getString("k_Name"));
		 		bean.setPostId(rs.getString("post_Id"));
		 		bean.setPass(rs.getString("k_Pass"));

		 		list.add(bean);
		 	}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;

	}


	//新しい管理者情報を登録する
	public int insert(String kId, String kName, String postId, String kPass) {

		String sql = "insert into STAFF values(?,?,?,?)";

		//管理者情報を追加した件数
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


	//管理者IDをもとに管理者情報を選択し、新たな情報に上書きする
	public int update(String oldKId, String newKId, String kName, String postId, String kPass) {
		String sql = "update  set K_ID=?, K_NAME=?, POST_ID=?, K_PASS=? where K_ID=?";
		int kensu = 0;

		try {
			connect();
			//ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);

				ps.setString(1, newKId);
				ps.setString(2, kName);
				ps.setString(3, postId);
				ps.setString(4, kPass);
				ps.setString(5, oldKId);

				//SQLを発行する
				kensu = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return kensu;
	}


	//管理者IDをもとに特定の管理者情報を削除する
	public int delete(String kId) {
		String sql = "delete from STAFF where K_ID=?";

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


