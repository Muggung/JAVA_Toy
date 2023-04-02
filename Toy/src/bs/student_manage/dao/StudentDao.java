package bs.student_manage.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import bs.student_manage.dto.StudentDto;

public class StudentDao {
	private Map<String, StudentDto> students = new HashMap<String, StudentDto>();
	
	// 학생정보 등록
	public boolean isEmpty(StudentDto student) {
		String id = student.getID();
		
		if(students.containsKey(id)) {
			return false;
		} else {
			students.put(id, student);
			return true;
		}
	}
	
	// 학생정보 전체출력
	public String infoStudentResult() {
		String total = "";
		
		for(Map.Entry<String, StudentDto> entry : students.entrySet()) {
			total += entry.getKey() + " " + entry.getValue().infoResult() + "\n";
		}
		return total;
	}
	
	// 학생이름 검색
	public String searchStudentName(String name) {
		String result = "";
		
		Set<String> keys = students.keySet();
		for(String k : keys) {
			if(students.get(k).getName().contains(name)) {
				result += students.get(k).infoResult();
			}
		}
		return result;
	}

	// 학생정보 수정
	public boolean updateStudent(String id, StudentDto student) {
		Set<String> keys = students.keySet();
		for(String k : keys) {
			if(k.equals(id)) {
				students.get(k).setGrade(student.getGrade());
				students.get(k).setMajor(student.getMajor());
				students.get(k).setAddress(student.getAddress());
				return true;
			}
		}
		return false;
	}
	
	// 학생정보 삭제
	public boolean deleteStudent(String student_ID) {
		Set<String> keys = students.keySet();
		for(String k : keys) {
			if(students.get(k) != null && students.get(k).getID().equals(student_ID)) {
				students.remove(k);
				return true;
			}
		}
		return false;
	}
}