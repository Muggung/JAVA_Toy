package bs.student_manage.controller;

import bs.student_manage.dao.StudentDao;
import bs.student_manage.dto.StudentDto;
import bs.student_manage.view.MainView;

public class StudentController {
	StudentDao dao = new StudentDao();
	
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
		new MainView().studentAllPrint(dao.infoStudentResult());
	}
	
	// 3. 이름조회 구현
	public void searchByName() {
		String studentSearch = new MainView().searchStudentName();
		
		String result = dao.searchStudentName(studentSearch);
		
		new MainView().studentPrint(result);
	}
	
	// 4. 학생수정 구현
	public void updateStudent() {
		String msg = "";
		
		String student_ID = new MainView().searchStudentID();
		
		StudentDto student = new MainView().updateStudent();
		
		msg = dao.updateStudent(student_ID, student) ? "===== 수정 성공! ====" : "===== 수정 실패:( 학생정보가 있는지 확인해주세요. =====";
		
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