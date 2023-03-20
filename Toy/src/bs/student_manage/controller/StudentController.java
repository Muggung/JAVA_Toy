package bs.student_manage.controller;

import bs.student_manage.dao.StudentDao;
import bs.student_manage.dto.StudentDto;
import bs.student_manage.view.MainView;

public class StudentController {
	StudentDao dao = new StudentDao();
	/* 학생관리 프로그램의 기능을 모아놓은 클래스
	 * 0. 프로그램 시작 구현
	 * 1. 학생등록 구현
	 * 2. 전체조회 구현
	 * 3. 이름조회 구현
	 * 4. 학생수정 구현
	 * 5. 학생삭제 구현
	 */
	
	// 0. 프로그램 시작 구현
	public void startProgram() {
		new MainView().startMenu();
	}
	
	// 1. 학생등록 구현
	public void insertStudent() {
		StudentDto student = new MainView().insertStudentView();
		
		String successMsg = dao.isEmpty(student) ? "===== 학생등록 성공!! =====" : "===== 학생등록 실패... =====";
		
		new MainView().isEmptyPrint(successMsg);
	}
	
	// 2. 전체조회 구현
	public void infoStudentAll() {
		String result = dao.infoStudentResult();
		
		new MainView().studentAllPrint(result);
	}
	
	// 3. 이름조회 구현
	public void searchStudent() {
		String studentName = new MainView().searchName();
		
		String search = dao.searchStudentName(studentName);
		
		new MainView().studentPrint(search);
	}
	
	// 4. 학생수정 구현
	public void updateStudent() {
		String msg = "";
		
		String studentName = new MainView().searchName();
		
		StudentDto student = new MainView().updateStudent();
		
		student.setName(studentName);
		
		msg = dao.updateStudent(student) ? "===== 수정 성공! ====" : "===== 수정 실패:( 학생정보가 있는지 확인해주세요. =====";
		
		new MainView().isEmptyPrint(msg);
	}
	
	// 5. 학생삭제 구현
	public void deleteStudent() {
		String msg = "";
		
		String student_ID = new MainView().deleteStudent();
		
		msg = dao.deleteStudent(student_ID) ? "===== 삭제 성공! =====" : "===== 삭제 실패:( 학생정보가 맞는지 확인해주세요.";
		
		new MainView().isEmptyPrint(msg);
	}
}
