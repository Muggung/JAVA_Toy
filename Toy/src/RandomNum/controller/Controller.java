package RandomNum.controller;

import java.util.Scanner;

public class Controller {
	public void upAndDown() {
		Scanner sc = new Scanner(System.in);
		/*
		 * 1. 랜덤으로 1 ~ 50까지의 수를 한개 저장
		 * 2. 사용자에게 값을 입력받아 랜덤값과 비교하고 랜덤값이 크면 UP출력
		 * 3. 작으면 Down! 맞추면 정답! 출력
		 * 4. 정답을 맞출 때까지 진행
		 */
		double randomNum[] = new double[1];
		boolean gameOver = false;
		
		
		
		randomNum[0] = (int) (Math.random() * 50) + 1;
		
		System.out.print("수를 입력 : ");
		int userNum = sc.nextInt();
		
		while(!gameOver) {
			System.out.print("번호가 틀렸습니다. 다시 입력해주세요 : ");
			userNum = sc.nextInt();
			
			if(randomNum[0] < userNum) {
				System.out.println("Down!");
			} else if(randomNum[0] > userNum) {
				System.out.println("Up!");
			} else if(userNum < 1 || userNum > 50){
				System.out.println("1 ~ 50 사이 숫자를 입력해주세요.");
			} else if(randomNum[0] == userNum){
				System.out.println("게임 승리!!! 프로그램을 종료합니다.");
				gameOver = true;
			}
		}
		System.out.println("랜덤 번호 : " + randomNum[0]);
		System.out.println("유저 번호 : " + userNum);
	}
}
