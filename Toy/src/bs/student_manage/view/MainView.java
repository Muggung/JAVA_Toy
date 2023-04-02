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
			if(isEnter == 'Y' || isEnter == 'y') {
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
		while(true) {
			System.out.println("===== 학생관리 프로그램 =====");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			System.out.println("4. 전체조회");
			System.out.println("5. 학생이름 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요 : ");
			int menuChoice = sc.nextInt();
			
			switch(menuChoice) {
				case 1 : 
					controller.insertStudent(); ; break;
				case 2 : 
					controller.updateStudent(); break;
				case 3 : 
					controller.deleteStudent(); break;
				case 4 : 
					controller.infoStudentAll(); break;
				case 5 : 
					controller.searchByName(); break;
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
		
		StudentDto result = new StudentDto(name, grade, gender, major, address);
		
		return result;
	}
	
	// 저장 성공여부 화면출력
	public void isEmptyPrint(String msg) {
		System.out.println("===== 저장중... =====");
		System.out.println(msg);
	}
	
	// 등록된 학생정보 전체줄력
	public void studentAllPrint(String infoAll) {
		if(infoAll.length() < 1) {
			System.out.println("저장된 학생이 없습니다.");
		} else {
			System.out.println("===== 학생 정보 =====\n");
			System.out.println(infoAll);
		}
	}
	
	// 학생이름 검색받기
	public String searchStudentName() {
		System.out.print("학생 이름 : ");
		String name = sc.nextLine();
		return name;
	}
	
	// 검색한 학생정보 출력
	public void studentPrint(String infoStudent) {
		if(infoStudent.length() < 1) {
			System.out.println("저장된 학생이 없습니다.");
		} else {
			System.out.println("===== 검색하신 학생 =====\n");
			System.out.println(infoStudent);
		}
	}
	
	// 수정할 학생 학번
	public String searchStudentID() {
		System.out.print("학번 : ");
		String id = sc.nextLine();
		return id;
	}
	
	// 수정할 학생정보 입력
	public StudentDto updateStudent() {
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
	
	// 삭제할 학생정보 입력
	public String deleteStudent() {
		System.out.println("===== 학생정보 삭제 =====");
		System.out.print("삭제할 학생 학번 : ");
		String student_ID = sc.nextLine();
		return student_ID;
	}
	
	// 항목별 조회 출력
	public int studentType() {
		System.out.println("===== 조회할 항목 =====");
		System.out.println("1. 학년");
		System.out.println("2. 전공");
		System.out.println("3. 주소");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		
		return choice;
	}
	
	public Object insertType(String type) {
		System.out.println("조회할 " + type + "을(를) 입력해주세요.");
		System.out.print("입력 : ");
		return type.equals("학년") ? sc.nextInt() : sc.next();
	}
}