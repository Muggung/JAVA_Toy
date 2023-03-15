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
	 */
	
	// 0. 프로그램 시작 구현
	public void startProgram() {
		new MainView().startMenu();
	}
	
	// 1. 학생등록 구현
	public void insertStudent() {
		// 3-5. MainView의 insertStudentView 메소드의 studentDto에 저장된 리턴 값을 변수에 저장
		// student 변수에 저장된 값(학생정보)으로 객체(학생)을 생성하려면 학생 객체를 만들어야하니 StudentDao에서 생성
		StudentDto student = new MainView().insertStudentView();
		
		// 3-6-3. 학생등록 성공여부 할당(isEmpty메소드 활용)
		String successMsg = dao.isEmpty(student) ? "===== 학생등록 성공!! =====" : "===== 학생등록 실패... =====";
		
		// 3-6-4. MainView에서 화면출력을 담당하기에 String인 successMsg를 매개변수로 화면출력해주는 isEmptyPrint() 메소드 생성
		new MainView().isEmptyPrint(successMsg);
	}
	
	// 2. 전체조회 구현
	public void infoStudentAll() {
		// 4-2. StudentDao에 저장된 student 중 null이 아닌 student를 찾는 메소드 생성
		// 생성 후 String으로 값 받아오기
		String result = dao.infoStudentResult();
		
		// 4-4. result를 매개변수로 값을 전달하여 MainView에 화면출력
		new MainView().studentAllPrint(result);
	}
	
	// 3. 이름조회 구현
	public void searchStudent() {
		// 5-2. 학생 이름 검색받기
		String searachStudentName = new MainView().searchName();
		
		// 5-3. 받은 이름으로 Dao에서 메소드를 만들어 받은 이름과 student의 이름이 일치한지 확인
		String search = dao.searchStudentName(searachStudentName);
		
		// 5-4. MainView에 학생 출력하기
		new MainView().studentPrint(search);
	}
}
