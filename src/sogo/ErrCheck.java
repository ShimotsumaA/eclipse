package sogo;

import kanrisha.KanrishaIdDao;
import kanrisha.ShohinDao;
import shohisha.OrderDao;
import shohisha.OrderDetailDAO;
import shohisha.ShohishaDao;

public class ErrCheck {

	// DAOに関するエラーチェック

	// 消費者IDエラーチェック
	public boolean existSId(String sId) {
		ShohishaDao dao = new ShohishaDao();

		if (dao.joken(sId).size() != 0) {
			return true; // IDが存在するときtrueを返す
		} else {
			return false;
		}

	}


	// 注文IDエラーチェック
	public boolean existOrderId(String orderId) {
		OrderDao dao = new OrderDao();

		if (dao.joken(orderId).size() != 0) {
			return true; // IDが存在するときtrueを返す
		} else {
			return false;
		}

	}

	// 注文詳細IDエラーチェック
	public boolean existODetailShohinId(String oDetail, String shohinId) {
		OrderDetailDAO dao = new OrderDetailDAO();

		if (dao.joukenShohin(oDetail, shohinId).size() != 0) {
			return true; // IDが存在するときtrueを返す
		} else {
			return false;
		}

	}

	// 管理者IDエラーチェック
	public boolean existkId(String kId) {
		KanrishaIdDao dao = new KanrishaIdDao();

		if (dao.jouken(kId).size() != 0) {
			return true; // IDが存在するときtrueを返す
		} else {
			return false;
		}

	}

	// 商品IDエラーチェック

	public boolean existShohinId(String shohinId) {
		ShohinDao dao = new ShohinDao();

		if (dao.joken(shohinId).size() != 0) {
			return true; // IDが存在するときtrueを返す
		} else {
			return false;
		}

	}

	// 入力欄のエラーチェック(ID長さ・半角全角チェック)
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

	//パスワード入力チェック
	public boolean checkPass(String kPass1) {

		// 4文字以上15文字以内か
		if ((kPass1.length() >= 4) && (kPass1.length() <= 15)) {
			// 半角かどうか
			if (kPass1.matches("^[A-Za-z0-9]+$")) {
				// 数字と英語が含まれているか
				if (kPass1.matches("/[0-9]/") && kPass1.matches("/[A-Za-z]")) {
					return true;
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
	//パスワード一致チェック
	public boolean checkPassMaches(String kPass1,String kPass2) {
		if(kPass1.equals(kPass2)){
			return true;
		}else {
			return false;
		}

	}
}
