package kanrisha;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import bean.OrderBean;
import bean.OrderDetailBean;
import bean.ShohinBean;
import shohisha.OrderDao;
import shohisha.OrderDetailDAO;

public class Uriage {

	public Map<String, Integer> MapDate(String date) {
		OrderDao dao = new OrderDao();
		OrderDetailDAO dao2 = new OrderDetailDAO();
		ShohinDao dao3 = new ShohinDao();

		ArrayList<OrderBean> orderList;
		ArrayList<OrderDetailBean> oDetailList;
		ArrayList<ShohinBean> shohinList;

		Map<String, Integer> shohinMap = new LinkedHashMap<>();

		// 日づけごとのオーダーリストを抽出
		orderList = dao.joukenDate(date);

		String oDetailId = null;
		String shohinId = null;
		int kazuKonyu = 0;
		BigDecimal value = BigDecimal.valueOf(0); // 単価
		BigDecimal gokei = BigDecimal.valueOf(0); // 合計

		for (int i = 1; i <= orderList.size(); i++) {
			// 日付ごとのorderリストから注文詳細番号を取得する。
			oDetailId = orderList.get(i - 1).getODetailId();
			// 注文詳細番号から商品ID 購入個数を選択；
			oDetailList = dao2.jouken(oDetailId);

			for (int j = 1; j <= oDetailList.size(); j++) {
				shohinId = oDetailList.get(j - 1).getShohinId();
				kazuKonyu = oDetailList.get(j - 1).getKazuKonyu();

				if (shohinMap.containsKey(String.valueOf(shohinId))) {
					int kazu = shohinMap.get(String.valueOf(shohinId)) + kazuKonyu;
					shohinMap.put(String.valueOf(shohinId), kazu);
				} else {
					shohinMap.put(String.valueOf(shohinId), kazuKonyu);
				}

			}

		}

		return shohinMap;



	}

}
