package bs.student_manage.view;

import java.util.HashMap;
import java.util.Scanner;

import bs.student_manage.controller.StudentController;
import bs.student_manage.dto.Student;

public class MainView {
	private static MainView mv = new MainView();
	private MainView() {};
	public static MainView getMainView() {
		return mv;
	}
	
	Scanner sc = new Scanner(System.in);
	StudentController control = new StudentController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("===== 학생 관리 프로그램 =====");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 학생 조회");
			System.out.println("5. 학생 이름 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : control.insertStudent(); break;
				case 2 : 
				case 3 :
				case 4 : control.printAllStudent(); break;
				case 5 :
				case 0 : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("===== 잘못 입력하셨습니다. 다시 입력해주세요. ====="); break;
			}
		}
	}
	
	// 학생 등록 화면
	public Student insertView() {
		System.out.println("===== 학생 등록 화면 =====");
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("전공 : ");
		String major = sc.nextLine();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		return new Student(name, age, gender, major, grade, address);
	}
	
	// 학생 학번 확인 화면
	public void checkStudentID() {
		
	}
	
	// 학생 정보 수정 화면
	
	// 시스템 메세지 출력
	public void systemMsg(String msg) {
		System.out.println(msg);
	}
	
	// 학생 조회 화면
	public void printAllStudent(HashMap<String, Student> hm) {
		hm.forEach((s, v) -> System.out.println("학번 : " + s + v));
	}
}