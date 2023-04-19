package com.employee_manage.view;

import java.util.List;
import java.util.Scanner;

import com.employee_manage.controller.Controller;
import com.employee_manage.model.common.Employee_Controller;
import com.employee_manage.model.dto.Employee;

public class MainView {
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		Employee_Controller controller = new Controller();
		
		while(true) {
			System.out.println("----- 사원관리 프로그램 -----");
			System.out.println("1. 전체 사원 조회");
			System.out.println("2. 사원 조회");
			System.out.println("3. 사원 등록");
			System.out.println("4. 사원 수정");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서 관리");
			System.out.println("7. 직책 관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 입력 : ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1 : controller.printAllEmployee(); break;
				case 2 : // 사원 조회
				case 3 : // 사원 등록
				case 4 : // 사원 수정
				case 5 : // 사원 삭제
				case 6 : // 부서 관리
				case 7 : // 직책 관리
				case 0 : System.out.println("----- 프로그램을 종료합니다. -----"); return;
			}
		}
	}
	
	public void printAllEmployee(List<Employee> employee) {
		System.out.println("===== 전체 사원 조회 =====");
		employee.forEach(e -> System.out.println(e));
	}
}
