package BaseBall.com.controller;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBallGame {
	public void baseBallPlay() {
		Scanner sc = new Scanner(System.in);
		/*
		 * 1. 랜덤으로 세개의 수를 각 자리수에 저장한다.
		 * 2. 사용자가 세개의 수를 입력한다.
		 * 3. 사용자가 입력한 숫자가 정답과 자리수와 숫자가 일치하면 -> 스트라이크,
		 * 3-1. 사용자가 입력한 숫자가 정답과 일치하고 자리수가 맞지 않으면 -> 볼,
		 * 3-2. 사용자가 입력한 숫자가 일치한게 하나도 없으면 -> 파울으로 처리
		 * 4. 게임에서 승리(스트라이크 3번)할 때 까지 반복
		 * 5.정답을 맞추면 게임을 더 할지 확인후 계속진행은 위 로직 반복 그만하면 프로그램종료
		 */
		boolean gameOver = false;
		char restart = ' ';
		int strike = 0;
		int ball = 0;

		int[] randomBall = new int[3];
		int[] userBall = new int[3];
		System.out.println("======야구게임=====");

		while (!gameOver) {
			strike = 0;
			ball = 0;
			// 2. 사용자가 세개의 수를 입력한다.
			for (int i = 0; i < userBall.length; i++) {
				System.out.print(i + 1 + "번째 숫자를 입력해주세요 : ");
				userBall[i] = sc.nextInt();
				if(userBall[0] >= 10 || userBall[1] >= 10 || userBall[2] >= 10) {
					System.out.println("1 ~ 9 사이의 숫자를 입력해주세요.\n다시 입력해주세요 : ");
					userBall[i] = sc.nextInt();
				}
			}

			// 1. 랜덤으로 세개의 수를 각 자리수에 저장한다.
			for (int i = 0; i < randomBall.length; i++) {
				randomBall[i] = (int) (Math.random() * 9) + 1;
			}

			for (int i = 0; i < randomBall.length; i++) {
				for (int j = 0; j < userBall.length; j++) {
					if (randomBall[i] == userBall[i]) {
						if(i==j) {
							// 3. 사용자가 입력한 숫자가 정답과 자리수와 숫자가 일치하면 -> 스트라이크
							strike++;
						}
					} else if (randomBall[i] == userBall[j]) {
						if (!(i == j)) {
							// 3-1. 사용자가 입력한 숫자가 정답과 일치하고 자리수가 맞지 않으면 -> 볼,
							ball++;
						}
					}
				}
			}

			// 3-2. 사용자가 입력한 숫자가 일치한게 하나도 없으면 -> 파울으로 처리
			if (strike == 0 && ball == 0) {
				System.out.println("=====파울====");
			}
			System.out.println(Arrays.toString(randomBall));
			System.out.println("스트라이크 : " + strike + "개");
			System.out.println("  볼 : " + ball + "개\n");
			
			// 4. 게임에서 승리(스트라이크 3번)할 때 까지 반복
			if(strike == 3) {
				System.out.println("=====승리=====");
				// 5.정답을 맞추면 게임을 더 할지 확인후 계속진행은 위 로직 반복 그만하면 프로그램종료
				System.out.println("한판 더??(Y/N)");
				restart = sc.next().charAt(0);
				if(restart == 'Y') {
					gameOver = false;
				} else if (restart == 'N') {
					gameOver = true;
				}
			}
		}
		System.out.println("======게임종료======");
	}
}
