/**
 * 
 */
package fa.training.entities;

/**
 * @author Van Thinh
 *
 */
public abstract class Students {
	private String fullName;
	private String birthday;
	private String sex;
	private String phoneNumber;
	private String universityName;
	private String gradeLevel;

	public Students() {

	}

	public Students(String fullName, String birthday, String sex, String phoneNumber, String universityName,
			String gradeLevel) {
		super();
		this.fullName = fullName;
		this.birthday = birthday;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.universityName = universityName;
		this.gradeLevel = gradeLevel;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public abstract void showMyInfo();
	/**
	 * 
	 * @author: ThinhNV30
	 * @birthday: 03/03/1993
	 * @param:Hien thi thong tin
	 * @return:
	 */
	public void showMe() {
		System.out.println("fullName: " + fullName);
		System.out.println("birthday: " + birthday);
		System.out.println("sex: " + sex);
		System.out.println("phoneNumber: " + phoneNumber);
		System.out.println("universityName: " + universityName);
		System.out.println("gradeLevel: " + gradeLevel);
	}

}
