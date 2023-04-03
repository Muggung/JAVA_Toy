package bs.student_manage.controller;

import bs.student_manage.dao.StudentDao;
import bs.student_manage.dto.Student;
import bs.student_manage.view.MainView;

// 학생 관리 프로그램의 기능
public class StudentController {
	StudentDao dao = new StudentDao();
	
	// 프로그램 시작
	public void startProgram() {
		MainView.getMainView().mainMenu();
	}
	
	// 학생 정보 저장
	public void insertStudent() {
		Student s = MainView.getMainView().insertView();
		
		String msg = dao.insertStudent(s) ? "학생 등록 성공 :)" : "학생 등록 실패 :(";
		
		MainView.getMainView().systemMsg(msg);
	}
	
	// 학생 정보 수정
	public void updateStudent() {
		String checkID = MainView.getMainView().checkStudentID();
		
		Student s = MainView.getMainView().updateStudent();
		
		String msg = dao.updateStudent(checkID, s) ? "수정 성공 :)" : "수정 실패 :(";
		
		MainView.getMainView().systemMsg(msg);
	}
	
	// 학생 조회
	public void printAllStudent() {
		MainView.getMainView().printAllStudent(dao.printAllStudent());
	}
}