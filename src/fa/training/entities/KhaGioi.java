/**
 * 
 */
package fa.training.entities;

/**
 * @author Van Thinh
 *
 */
public class KhaGioi extends Students {

	private double diemTB;
	private String bestRewardName;

	public KhaGioi() {
		super();
	}

	public KhaGioi(String fullName, String birthday, String sex, String phoneNumber, String universityName,
			String gradeLevel, double diemTB, String bestRewardName) {
		super(fullName, birthday, sex, phoneNumber, universityName, gradeLevel);
		this.diemTB = diemTB;
		this.bestRewardName = bestRewardName;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}

	@Override
	/**
	 * 
	 * @author: ThinhNV30
	 * @birthday: 03/03/1993
	 * @param:Hien thi thong tin
	 * @return:
	 */
	public void showMyInfo() {
		super.showMe();
		System.out.println("diemTB: " + diemTB);
		System.out.println("bestRewardName: " + bestRewardName);

	}

}
