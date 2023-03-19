package bs.student_manage.view;

import java.util.Scanner;

import bs.student_manage.controller.StudentController;
import bs.student_manage.dto.StudentDto;

// 사용자에게 화면을 출력하는 클래스
public class MainView {
	Scanner sc = new Scanner(System.in);
	StudentController controller = new StudentController();
	
	// 프로그램 시작 안내
	public void startMenu() {
		System.out.println("학생관리 프로그램을 실행시키겠습니까?(Y/N)");
		char isEnter = sc.next().charAt(0);
		
		while(true) {
			if(isEnter == 'Y' || isEnter == '네') {
				mainMenu();
				return;
			} else if(isEnter == 'N') {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.println("Y/N으로 다시 입력해주세요 : ");
				isEnter = sc.next().charAt(0);
			}
		}
	}
	
	// 메인 메뉴화면 구현 
	public void mainMenu() {
		/* 1. 학생관리 프로그램 시작화면을 구현한다.
		 * 2. 사용자가 학생관리 프로그램 메뉴에서 숫자를 입력하고 사용자가 입력한 값에 맞는 기능을 구현한다.
		 */
		
		// 1. 학생관리 프로그램 시작화면 구현
		while(true) {
			System.out.println("===== 학생관리 프로그램 =====");
			// 3. 학생등록 구현
			System.out.println("1. 학생등록");
			// 6. 학생수정 구현
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			// 4. 전체조회 구현
			System.out.println("4. 전체조회");
			// 5. 이름조회 구현
			System.out.println("5. 학생이름 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요 : ");
			int menuChoice = sc.nextInt();
			
			// 2. 사용자가 학생관리 프로그램 메뉴에서 숫자를 입력한다.
			switch(menuChoice) {
				case 1 : 
					controller.insertStudent(); ; break;
				case 2 : 
					controller.updateStudent(); break;
				case 3 : 
					System.out.println("아직 기능구현하지 못했습니다."); break;
				case 4 : 
					controller.infoStudentAll(); break;
				case 5 : 
					controller.searchStudent(); break;
				case 0 : 
					System.out.println("프로그램을 종료합니다."); return;
				default : 
					System.out.println("메뉴에 있는 번호를 출력해주세요."); break;
			}
		}
	}
	
	// 학생등록 값 입력받기
	public StudentDto insertStudentView() {
		System.out.println("===== 학생등록 =====");
		System.out.print("학번 : ");
		String student_ID = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("전공 : ");
		String major = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		StudentDto result = new StudentDto(student_ID, name, grade, gender, major, address);
		
		return result;
	}
	
	// 저장 성공여부 화면출력
	public void isEmptyPrint(String msg) {
		System.out.println("===== 저장중... =====");
		System.out.println(msg);
	}
	
	// 등록된 학생정보 전체줄력
	public void studentAllPrint(String infoAll) {
		if(infoAll.equals("")) {
			System.out.println("저장된 학생이 없습니다.");
		} else {
			System.out.println("===== 전체 학생 =====\n");
			System.out.println(infoAll);
		}
	}
	
	// 학생이름 검색받기
	public String searchName() {
		System.out.print("학생이름을 입력해주세요 : ");
		String name = sc.nextLine();
		return name;
	}
	
	// 검색한 학생정보 출력
	public void studentPrint(String infoStudent) {
		if(infoStudent.equals("")) {
			System.out.println("저장된 학생이 없습니다.");
		} else {
			System.out.println("===== 학생 정보 =====\n");
			System.out.println(infoStudent);
		}
	}
	
	// 수정할 학생정보 입력
	public StudentDto updateStudnet() {
		StudentDto student = new StudentDto();
		System.out.println("===== 학생정보 수정 =====");
		System.out.print("수정할 학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 전공 : ");
		String major = sc.nextLine();
		System.out.print("수정할 주소 : ");
		String address = sc.nextLine();
		
		student.setGrade(grade);
		student.setMajor(major);
		student.setAddress(address);
		
		return student;
	}
}
