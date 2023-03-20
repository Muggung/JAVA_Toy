package bs.student_manage.dao;

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
	public String searchStudentName(String name) {
		String result = "";
		
		for(StudentDto s : students) {
			if(s != null && s.getName().equals(name)) {
				result += s.infoResult();
			}
		}
		
		return result;
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
}
