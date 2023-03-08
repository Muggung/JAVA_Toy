package RockScissorsPaper.com.controller;

import java.util.Scanner;

public class RockScissorsPaper {
	public void rockScissoersPaper() {
		Scanner sc = new Scanner(System.in);
		/*
		 * 가위 바위 보 게임 구현
		 * 1. 사용자가 가위, 바위, 보 중 하나를 입력한다.(숫자로 입력)
		 * 2. 컴퓨터가 랜덤 값을 생성하고 변수에 할당한다.
		 * 3. 컴퓨터의 값과 사용자의 값을 비교하여 다음처럼 결과 출력
		 * 3-1. 컴퓨터의 값 == 사용자의 값 : "비겼습니다." 출력 (출력 후 다시 사용자와 컴퓨터의 값을 비교할 수 있도록 로직구성)
		 * 3-2. 컴퓨터의 값 승리 : "컴퓨터가 이겼습니다." 출력
		 * 3-3. 사용자의 값 승리 : "사용자가 이겼습니다." 출력
		 * 4. 컴퓨터의 승리 횟수와 사용자의 승리 횟수 출력
		 */
		char isOver = 'N';
		int userCount = 0;
		int comCount = 0;
		do {
			System.out.println("=====가위 바위 보=====");
			System.out.println("컴퓨터 : ....고민중....");
			
			int randomNum = (int) (Math.random()*3) + 1;
			
			System.out.println("번호를 입력해주세요 : \n1. 가위\t2. 바위\t3. 보");
			int userChoice = sc.nextInt();
			
			switch(userChoice) {
				case 1 :
					if(randomNum == 1) {
						System.out.println("사용자 : 가위\n컴퓨터 : 가위\n비겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					} else if(randomNum == 2) {
						comCount+=1;
						System.out.println("사용자 : 가위\n컴퓨터 : 주먹\n컴퓨터가 이겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					} else {
						userCount+=1;
						System.out.println("사용자 : 가위\n컴퓨터 : 보\n사용자가 이겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					}
					break;
				case 2 :
					if(randomNum == 1) {
						userCount+=1;
						System.out.println("사용자 : 바위\n컴퓨터 : 가위\n사용자가 이겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					} else if(randomNum == 2) {
						System.out.println("사용자 : 바위\n컴퓨터 : 바위\n비겼습니다..");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					} else {
						comCount+=1;
						System.out.println("사용자 : 바위\n컴퓨터 : 보\n컴퓨터가 이겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					}
					break;
				case 3 :
					if(randomNum == 1) {
						comCount+=1;
						System.out.println("사용자 : 보\n컴퓨터 : 가위\n컴퓨터가 이겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					} else if(randomNum == 2) {
						userCount+=1;
						System.out.println("사용자 : 보\n컴퓨터 : 바위\n사용자가 이겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					} else {
						System.out.println("사용자 : 보\n컴퓨터 : 보\n비겼습니다.");
						System.out.print("이어서 하시겠습니까??(Y/N) ");
						isOver = sc.next().charAt(0);
					}
					break;
			}
		} while(isOver == 'Y');
		System.out.printf("컴퓨터 승 : %d번, 사용자 승 : %d번 ", comCount, userCount);
		System.out.println("프로그램 종료되었습니다.");
	}

}
