package shohisha;

public class SoryoKeisan {
	//引数に消費者id,商品合計を持つメソッド
	public int soryo(String sId,int sum) {
		ShohishaDao dao = new ShohishaDao();
		// 郵便番号取得
		int zip = Integer.parseInt(dao.joken(sId).get(0).getPost());

		PostCodeDAO dao2 = new PostCodeDAO();
		int kenId = dao2.joken(zip).get(0).getKenId();

		if(sum>=5000) {
			return 0;
		}else if(kenId == 1 || kenId == 47) {
			return 1920;
		} else if (kenId == 2 || kenId == 3 || kenId == 5) {
			return 1480;
		} else if (kenId == 4 || kenId == 6 || kenId == 7) {
			return 1370;
		} else if ((kenId >= 8 && kenId <= 15) || (kenId >= 40 && kenId <= 46) || kenId == 19 || kenId == 20) {
			return 1260;
		} else {
			return 1150;
		}
	}

}
