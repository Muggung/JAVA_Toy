package bs.student_manage.dto;

import java.util.Objects;

// 학생 정보
public class Student {
	private String student_ID;
	private String name;
	private int age;
	private char gender;
	private String major;
	private int grade;
	private String address;
	
	public Student() {}

	public Student(String name, int age, char gender, String major, int grade, String address) {
		super();
		this.student_ID = "2-22" + (int) (Math.random() * 100) + 1;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.major = major;
		this.grade = grade;
		this.address = address;
	}

	public String getStudent_ID() {
		return student_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return " " + name + " " + age + "살 " + gender + "자 " + grade + "학년 " + major + " 전공 "
				+ address + "에 거주";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, gender, grade, major, name, student_ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && gender == other.gender
				&& Objects.equals(grade, other.grade) && Objects.equals(major, other.major)
				&& Objects.equals(name, other.name) && Objects.equals(student_ID, other.student_ID);
	}
	
}