package sogo;

import java.util.ArrayList;

import bean.ShohishaBean;
import kanrisha.KanrishaIdDao;
import kanrisha.ShohinDao;
import shohisha.OrderDao;
import shohisha.OrderDetailDAO;
import shohisha.ShohishaDao;

public class ErrCheck {

	// DAO

	// 消費者IDが存在するか。
	public boolean existSId(String sId) {
		ShohishaDao dao = new ShohishaDao();

		if (dao.joken(sId).size() != 0) {
			return true; // IDが存在する。
		} else {
			return false;
		}

	}

	//消費者IDとパスワードが一致するか。
		public boolean sPassCollect(String sId, String sPass) {
			ShohishaDao dao = new ShohishaDao();
			ArrayList <ShohishaBean> list  = dao.joken(sId);
			String pass = list.get(0).getPass();

			if (list.size() != 0 && pass.equals(sPass)) {
					return true; // 一致する。
				} else {
				return false;
			}
		}


	// 注文番号が存在するか。
	public boolean existOrderId(String orderId) {
		OrderDao dao = new OrderDao();

		if (dao.joken(orderId).size() != 0) {
			return true; // 注文番号が存在する。
		} else {
			return false;
		}

	}

	//消費者idとステータスidが一致する商品が
	public boolean existOrderIdStatusId(String sId,int statusId) {
		OrderDao dao = new OrderDao();

		if (dao.jokenSIdStatus(sId,statusId).size() != 0) {
			return true; // 注文番号が存在する。
		} else {
			return false;
		}

	}


	//注文詳細番号が存在するか。
	public boolean existODetailShohinId(String oDetail, String shohinId) {
		OrderDetailDAO dao = new OrderDetailDAO();

		if (dao.joukenShohin(oDetail, shohinId).size() != 0) {
			return true; //注文詳細番号が存在する。
		} else {
			return false;
		}

	}



	//管理者IDが存在するか。
	public boolean existkId(String kId) {
		KanrishaIdDao dao = new KanrishaIdDao();

		if (dao.jouken(kId).size() != 0) {
			return true; // 管理者IDが存在する。
		} else {
			return false;
		}

	}

	//管理者IDとパスワードが一致するか。
	public boolean kPassCollect(String kId,String kPass) {
		KanrishaIdDao dao = new KanrishaIdDao();

		if (dao.passCollect(kId,kPass).size() != 0) {
			return true; // 一致する。
		} else {
			return false;
		}

	}

	//商品IDが存在するか。

	public boolean existShohinId(String shohinId) {
		ShohinDao dao = new ShohinDao();

		if (dao.joken(shohinId).size() != 0) {
			return true; // IDが存在する。
		} else {
			return false;
		}

	}

	//管理者ID、消費者IDが英数字かつ10文字以内であるか。
	public boolean checkId(String id) {
		if (id.matches("^[A-Za-z0-9]+$")) {
			if ((id.length() > 0) && (id.length() <= 10)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}
	}

	//管理者パスワード、消費者パスワードがルールに沿っているか。
	public boolean checkPass(String kPass1) {

		//4文字以上15文字以内か。
		if ((kPass1.length() >= 4) && (kPass1.length() <= 15)) {
			//英数字だけで構成されているか。
			if (kPass1.matches("^[A-Za-z0-9]+$")) {
				//英数字どちらも使用しているか。
				if (kPass1.matches("/[0-9]/") && kPass1.matches("/[A-Za-z]")) {
					return true; //パスワードがルールに従っている。
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}


	//２回入力したパスワードが一致するか。
	public boolean checkPassMaches(String kPass1,String kPass2) {
		if(kPass1.equals(kPass2)){
			return true;
		}else {
			return false;
		}

	}

}
