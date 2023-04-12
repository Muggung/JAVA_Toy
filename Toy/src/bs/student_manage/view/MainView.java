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
				case 2 : control.updateStudent(); break;
				case 3 : control.deleteStudent(); break;    // 다시 만들것...
				case 4 : control.printAllStudent(); break;
				case 5 : control.printStudent(); break;
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
	public String checkStudentID() {
		System.out.print("학번을 입력해주세요 : ");
		String student_ID = sc.next();
		
		return student_ID;
	}
	
	// 학생 정보 수정 화면
	public Student updateStudent() {
		Student s = new Student();
		boolean isOver = true;
		
		while(isOver) {
			System.out.println("===== 학생 정보 수정 =====");
			System.out.println("😀수정할 정보를 선택해주세요.😀");
			System.out.println("1. 나이 / 2. 전공 / 3. 학년 / 4. 주소 / 0. 수정 종료");
			System.out.print("입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : 
					System.out.print("수정할 나이 : ");
					int age = sc.nextInt();
					s.setAge(age);
					break;
				case 2 : 
					System.out.print("수정할 전공 : ");
					sc.nextLine();
					String major = sc.nextLine();
					s.setMajor(major);
					break;
				case 3 : 
					System.out.print("수정할 학년 : ");
					int grade = sc.nextInt();
					s.setGrade(grade);
					break;
				case 4 : 
					System.out.print("수정할 주소 : ");
					sc.nextLine();
					String address = sc.nextLine();
					s.setAddress(address);
					break;
				case 0 :
					isOver = false;
					break;
				default :
					System.out.println("잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
			}
		}
		return s;
	}
	
	// 시스템 메세지 출력
	public void systemMsg(String msg) {
		System.out.println("=====***** 시스템 메세지 *****=====");
		System.out.println(msg);
	}
	
	// 학생 조회 화면
	public void printAllStudent(HashMap<String, Student> hm) {
		System.out.println("=====***** 학생 조회 *****=====");
		if(hm.isEmpty()) {
			System.out.println("저장된 학생이 없어요...😅😅😅😅😅😅");
		} else {
			hm.forEach((s, v) -> System.out.println("학번 : " + s + v));	
		}
	}
	
	// 학생 이름 조회 화면
	public String printStudent() {
		System.out.println("=====***** 학생 검색 *****=====");
		System.out.println("찾으실 학생 이름을 입력해주세요!");
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		return name;
	}
}