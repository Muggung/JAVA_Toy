package bs.student_manage.controller;

import bs.student_manage.dto.StudentDto;
import bs.student_manage.view.MainView;

public class StudentController {
	/* 학생관리 프로그램의 기능을 모아놓은 클래스
	 * 0. 프로그램 시작 구현
	 * 1. 학생등록 구현
	 */
	
	// 0. 프로그램 시작 구현
	public void startProgram() {
		new MainView().startMenu();
	}
	
	// 1. 학생등록 구현
	public void insertStudent() {
		// 3-5. MainView의 insertStudentView 메소드의 studentDto에 저장된 리턴 값을 변수에 저장
		StudentDto student = new MainView().insertStudentView();
	}
}
