package sogo;

import kanrisha.KanrishaIdDao;
import kanrisha.ShohinDao;
import shohisha.OrderDao;
import shohisha.OrderDetailDAO;
import shohisha.ShohishaDao;

public class ErrCheck {

	// DAO�Ɋւ���G���[�`�F�b�N

	// �����ID�G���[�`�F�b�N
	public boolean existSId(String sId) {
		ShohishaDao dao = new ShohishaDao();

		if (dao.joken(sId).size() != 0) {
			return true; // ID�����݂���Ƃ�true��Ԃ�
		} else {
			return false;
		}

	}


	// ����ID�G���[�`�F�b�N
	public boolean existOrderId(String orderId) {
		OrderDao dao = new OrderDao();

		if (dao.joken(orderId).size() != 0) {
			return true; // ID�����݂���Ƃ�true��Ԃ�
		} else {
			return false;
		}

	}

	// �����ڍ�ID�G���[�`�F�b�N
	public boolean existODetailShohinId(String oDetail, String shohinId) {
		OrderDetailDAO dao = new OrderDetailDAO();

		if (dao.joukenShohin(oDetail, shohinId).size() != 0) {
			return true; // ID�����݂���Ƃ�true��Ԃ�
		} else {
			return false;
		}

	}

	// �Ǘ���ID�G���[�`�F�b�N
	public boolean existkId(String kId) {
		KanrishaIdDao dao = new KanrishaIdDao();

		if (dao.jouken(kId).size() != 0) {
			return true; // ID�����݂���Ƃ�true��Ԃ�
		} else {
			return false;
		}

	}

	// ���iID�G���[�`�F�b�N

	public boolean existShohinId(String shohinId) {
		ShohinDao dao = new ShohinDao();

		if (dao.joken(shohinId).size() != 0) {
			return true; // ID�����݂���Ƃ�true��Ԃ�
		} else {
			return false;
		}

	}

	// ���͗��̃G���[�`�F�b�N(ID�����E���p�S�p�`�F�b�N)
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

	//�p�X���[�h���̓`�F�b�N
	public boolean checkPass(String kPass1) {

		// 4�����ȏ�15�����ȓ���
		if ((kPass1.length() >= 4) && (kPass1.length() <= 15)) {
			// ���p���ǂ���
			if (kPass1.matches("^[A-Za-z0-9]+$")) {
				// �����Ɖp�ꂪ�܂܂�Ă��邩
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
	//�p�X���[�h��v�`�F�b�N
	public boolean checkPassMaches(String kPass1,String kPass2) {
		if(kPass1.equals(kPass2)){
			return true;
		}else {
			return false;
		}

	}
}
