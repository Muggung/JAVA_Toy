package bs.student_manage.dao;

import java.util.HashMap;
import java.util.Set;

import bs.student_manage.dto.Student;

// 학생 관리 프로그램 데이터 저장 및 반환
public class StudentDao{
	private HashMap<String, Student> students = new HashMap<String, Student>();
	
	// 학생 등록 값 저장
	public boolean insertStudent(Student s) {
		if(students.containsKey(s.getStudent_ID())) {
			return false;
		} else {
			students.put(s.getStudent_ID(), s);
			return true;
		}
	}
	
	// 학생 학번 데이터 조회
	public boolean checkStudentID(String id) {
		if(students.containsKey(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	// 학생 정보 수정
	public boolean updateStudent(String id, Student s) {
		if(!students.containsKey(id)) {
			return false;
		}
		if(s.getAge() != 0) {
			students.get(id).setAge(s.getAge());
		}
		if(s.getMajor() != null) {
			students.get(id).setMajor(s.getMajor());
		}
		if(s.getGrade() != 0) {
			students.get(id).setGrade(s.getGrade());
		}
		if(s.getAddress() != null) {
			students.get(id).setAddress(s.getAddress());
		}
		return true;
	}
	
	// 학생 정보 삭제 (다시 만들 것)
	public boolean deleteStudent(String id) {
		if(students.containsKey(id)) {
			students.remove(id);
			return true;
		} else {
			return false;
		}
	}
	
	// 등록된 학생 정보 반환
	public HashMap<String, Student> printAllStudent() {
		return students;
	}
	
	// 검색된 학생 정보 반환
	public HashMap<String, Student> printStudent(String name) {
		HashMap<String, Student> copyMap = new HashMap<String, Student>();
		
		Set keys = students.keySet();
		
		for(Object k : keys) {
			if(students.get(k).getName().equals(name)) {
				copyMap = students;
			}
		} return copyMap;
	}
}