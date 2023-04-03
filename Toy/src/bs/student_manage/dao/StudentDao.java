package bs.student_manage.dao;

import java.util.HashMap;

import bs.student_manage.dto.Student;

// 학생 관리 프로그램 데이터 저장 및 반환
public class StudentDao {
	private HashMap<String, Student> studentMap = new HashMap<String, Student>();
	
	// 학생 등록 값 저장
	public boolean insertStudent(Student s) {
		if(studentMap.containsKey(s.getStudent_ID())) {
			return false;
		} else {
			studentMap.put(s.getStudent_ID(), s);
			return true;
		}
	}
	
	// 학생 조회
	public HashMap<String, Student> printAllStudent() {
		return studentMap;
	}
}