package bs.student_manage.dto;

public class StudentDto {
	// 사용자가 입력한 정보를 저장하는 클래스
	
	private String student_ID;
	private String studentName;
	private int studentGrade;
	private char studentGender;
	private String studentMajor;
	private String address;
	
	{
		student_ID =  "2-22" + (int) (Math.random() * 100) + 1;
	}
	
	public StudentDto() {}
	
	public StudentDto(String pName, int pGrade, char pGender, String pMajor, String pAddress) {
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
		return this.studentName + " " + this.studentGrade + "학년 " + this.studentGender
				+ "자 " + this.studentMajor + " " + this.address + "\n";
	}
	
}