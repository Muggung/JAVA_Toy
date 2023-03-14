package bs.student_manage.view;

import java.util.Scanner;

import bs.student_manage.controller.StudentController;
import bs.student_manage.dto.StudentDto;

// 사용자에게 화면을 출력하는 클래스
public class MainView {
	Scanner sc = new Scanner(System.in);
	// 3-. StudentController 클래스의 메소드를 사용하기 위해 new 연산자 사용
	// 3-. StudentController 클래스의 주소값을 controller에 담아 주소값 다름 방지
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
			// 3-1. 학생등록 구현
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			System.out.println("4. 전체조회");
			System.out.println("5. 학생이름 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요 : ");
			int menuChoice = sc.nextInt();
			
			// 2. 사용자가 학생관리 프로그램 메뉴에서 숫자를 입력한다.
			switch(menuChoice) {
				// 
				case 1 : 
					controller.insertStudent(); ; break;
				case 2 : 
					System.out.println("아직 기능구현하지 못했습니다."); break;
				case 3 : 
					System.out.println("아직 기능구현하지 못했습니다."); break;
				case 4 : 
					System.out.println("아직 기능구현하지 못했습니다."); break;
				case 5 : 
					System.out.println("아직 기능구현하지 못했습니다."); break;
				case 0 : 
					System.out.println("프로그램을 종료합니다."); return;
				default : 
					System.out.println("메뉴에 있는 번호를 출력해주세요."); break;
			}
		}
	}
	
	// 3-2. 학생등록 값 입력받기
	public StudentDto insertStudentView() {
		System.out.println("===== 학생등록 =====");
		System.out.print("학번 : ");
		String student_ID = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();				// 버퍼 지우기
		System.out.print("성별(남/여) : ");
		char gender = sc.next().charAt(0);
		sc.nextLine();				// 버퍼 지우기
		System.out.print("전공 : ");
		String major = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		// 3-3-3. 입력받은 정보를 정보를 저장하는 StudentDto 클래스에 매개변수로 할당 (값 전달)
		StudentDto result = new StudentDto(student_ID, name, grade, gender, major, address);
		// 3-4. 입력받은 정보를 StudentDto 자료형으로 return
		return result;
	}
	
}
