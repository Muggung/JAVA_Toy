package bs.student_manage.dto;

public class StudentDto {
	// 사용자가 입력한 정보를 저장하는 클래스
	
	// 3-3. MainView에서 입력받은 정보를 저장(정보 저장은 은닉되어야한다. 따라서 맴버변수로 선언 후 getter와 setter로 접근하기)
	private String student_ID;
	private String studentName;
	private int studentGrade;
	private char studentGender;
	private String studentMajor;
	private String address;
	
	public StudentDto() {}		// 기본 생성자 : 기본값을 입력(지금은 없는듯...)
	
	public StudentDto(String p_ID, String pName, int pGrade, char pGender, String pMajor, String pAddress) {
		// 3-3-1. MainView 클래스의 insertStudentView(매개변수) 값 받아오기
		// 3-3-2. StudentDto 필드를 매개변수로 받아온 값을 할당
		this.student_ID = p_ID;
		this.studentName = pName;
		this.studentGrade = pGrade;
		this.studentGender = pGender;
		this.studentMajor = pMajor;
		this.address = pAddress;
	}
	
	public String getID() {
		return this.student_ID;
	}
	
	public void setID(String p_ID) {
		this.student_ID = p_ID;
	}
	
	public String getName() {
		return this.studentName;
	}
	
	public void setName(String pName) {
		this.studentName = pName;
	}
	
	public int getGrade() {
		return this.studentGrade;
	}
	
	public void setGrade(int pGrade) {
		this.studentGrade = pGrade;
	}
	
	public char getGender() {
		return this.studentGender;
	}
	
	public void setGender(char pGender) {
		this.studentGender = pGender;
	}
	
	public String getMajor() {
		return this.studentMajor;
	}
	
	public void setMajor(String pMajor) {
		this.studentMajor = pMajor;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String pAddress) {
		this.address = pAddress;
	}
	
	public String infoResult() {
		return this.student_ID + " " + this.studentName + " " + this.studentGrade + " " + this.studentGender
				+ " " + this.studentMajor + " " + this.address;
	}
}
