/**
 * 
 */
package fa.training.entities;

/**
 * @author Van Thinh
 *
 */
public class TrungBinh extends Students {

	private int englishScore;
	private double entryTestScore;

	public TrungBinh() {
		super();
	}

	public TrungBinh(String fullName, String birthday, String sex, String phoneNumber, String universityName,
			String gradeLevel, int englishScore, double entryTestScore) {
		super(fullName, birthday, sex, phoneNumber, universityName, gradeLevel);
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public double getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(double entryTestScore) {
		this.entryTestScore = entryTestScore;
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
		System.out.println("englishScore: " + englishScore);
		System.out.println("entryTestScore: " + entryTestScore);

	}
}
