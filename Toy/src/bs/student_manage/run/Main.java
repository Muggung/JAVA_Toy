package bs.student_manage.run;

import bs.student_manage.controller.StudentController;

public class Main {
	public static void main(String[] args) {
		// 학생관리 프로그램 시작하는 메인 클래스
		StudentController scr = new StudentController();
		scr.startProgram();
	}
}
