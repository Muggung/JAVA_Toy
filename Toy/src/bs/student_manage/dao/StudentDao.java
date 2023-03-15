package bs.student_manage.dao;

import bs.student_manage.dto.StudentDto;

public class StudentDao {
	// 사용자가 입력했던 정보를 인스턴스해주는 클래스
	
	/* 3-6. StudentController의 insertStudent메소드에 저장된 학생정보를 비어있는 학생 맴버변수에 할당
	 * (만약 비어있는 맴버변수에 할당하지않으면 insertStudent메소드의 student에 계속 덮어씌어질테니??)
	 * 
	 * > 왜 StudentDto로 맴버변수를 만들었을까??
	 * < 3-6-1에서 isEmpty(student)에서 student 자료형이 StudentDto이기에 student(학생정보)를 맴버변수에 넣을려면 같은 자료형이여야한다.
	 */
	private StudentDto student1;
	private StudentDto student2;
	private StudentDto student3;
	private StudentDto student4;
	private StudentDto student5;
	
	// 3-6-1. 저장할 맴버변수 공간이 비어있는지 확인하고, 비어있으면 insertStudent의 student(학생정보)를 할당
	public boolean isEmpty(StudentDto student) {
		// >> 왜 boolean형으로 만든걸까? (학생정보 등록 성공/실패 출력때문??)
		// << 없어도 된다.(나중에 전체출력하면 알 수 있기에)
		// < 다만 사용자의 편의를 위해 학생등록 성공 여부를 알려주면 좋기에 boolean형으로 반환값을 만든 것 
		
		// 3-6-2. student1,2,3,4,5에 입력값이 없으면 student(학생정보) 할당해 저장
		if(student1 == null) {
			this.student1 = student;
		} else if(student2 == null) {
			this.student2 = student;
		} else if(student3 == null) {
			this.student3 = student;
		} else if(student4 == null) {
			this.student4 = student;
		} else if(student5 == null) {
			this.student5 = student;
		} else {
			return false;
		} return true;
	}
	
	// 4-3. student안에 학생정보가 있으면 result에 student정보 넣기
	public String infoStudentResult() {
		String result = "";
		
		if(student1 != null) {
			result += student1.infoResult();
		}
		if(student2 != null) {
			result += student2.infoResult();
		}
		if(student3 != null) {
			result += student3.infoResult();
		}
		if(student4 != null) {
			result += student4.infoResult();
		}
		if(student5 != null) {
			result += student5.infoResult();
		}
		return result;
	}
	
	// 5-4. 매개변수로 받은 이름이 student에 있는지 확인
	public String searchStudentName(String name) {
		String result = "";
		
		if(student1 != null && student1.getName().equals(name)) {
			result += student1.infoResult();
		}
		if(student2 != null && student2.getName().equals(name)) {
			result += student2.infoResult();
		}
		if(student3 != null && student3.getName().equals(name)) {
			result += student3.infoResult();
		}
		if(student4 != null && student4.getName().equals(name)) {
			result += student4.infoResult();
		}
		if(student5 != null && student5.getName().equals(name)) {
			result += student5.infoResult();
		}
		return result;
	}
}
