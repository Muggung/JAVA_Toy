package bs.student_manage.dao;

import java.util.Arrays;

import bs.student_manage.StudentInterface;
import bs.student_manage.dto.StudentDto;

public class StudentDao {
	// 사용자가 입력했던 정보를 인스턴스해주는 클래스
	private StudentDto[] students = new StudentDto[SIZE];
	private static final int SIZE = 5;
	
	// 학생정보 등록
	public boolean isEmpty(StudentDto student) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				return true;
			}
		}
		return false;
	}
	
	// 학생정보 전체출력
	public String infoStudentResult() {
		String result = "";
		for(StudentDto s : students) {
			if(s != null) {
				result += s.infoResult();
			}
		}
		
		return result;
	}
	
	// 학생이름 검색
	public StudentDto[] searchStudent(Object o) {
		StudentDto[] searchArr = new StudentDto[students.length];
		
		searchArr = studentCondition(students, o, (s, obj) -> s.getName().equals(o) || s.getAddress().equals(o) || s.getMajor().equals(obj) || s.getID().equals(obj));;
		
		StudentDto[] resultArr = Arrays.copyOf(searchArr, searchArr.length);
		
		return resultArr;
	}

	// 학생정보 수정
	public boolean updateStudent(StudentDto student) {
		for(int i=0; i<students.length; i++) {
			if(students[i] != null && students[i].getName().equals(student.getName())) {
				students[i].setGrade(student.getGrade());
				students[i].setMajor(student.getMajor());
				students[i].setAddress(student.getAddress());
				return true;
			}
		}
		return false;
	}
	
	// 학생정보 삭제
	public boolean deleteStudent(String student_ID) {
		for(int i=0; i<students.length; i++) {
			if(students[i] != null && students[i].getID().equals(student_ID)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// 인터페이스
	public static StudentDto[] studentCondition(StudentDto[] s, Object data, StudentInterface si) {
		StudentDto[] studentArr = new StudentDto[s.length];
		int index = 0;
		for(int i=0; i<s.length; i++) {
			if(s[i] != null) {
				if(si.check(s[i], data)) {
					studentArr[index++] = s[i];
				}
			}
		}
		StudentDto[] copyArr = Arrays.copyOf(studentArr, studentArr.length);
		return copyArr;
	}
}
