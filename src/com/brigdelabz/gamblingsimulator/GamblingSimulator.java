package com.brigdelabz.gamblingsimulator;

public class GamblingSimulator {
	public static final int START_STAKE = 100;
	public static final int BET_ON_GAME = 1;
	public static final int DAYS_OF_PLAYING = 30;
	public static final int MONTH_PER_YEAR = 12;
	public static int stake = 0;
	public static int win = 0;
	public static int loose = 0;

	public static void play() {
		if (Math.random() > 0.5) {
			stake++;
		} else {
			stake--;
		}
	}

	public static int resignGame() {
		win = (int) Math.round(START_STAKE + (START_STAKE * 0.5));
		loose = (int) Math.round(START_STAKE * 0.5);

		boolean resign = true;
		stake = START_STAKE;
		while (resign == true) {
			play();
			if (stake == win) {
				resign = false;
			}
			if (stake == loose) {
				resign = false;
			}
		}
		return stake;
	}

	public static void main(String[] args) {
		int totalAmount = 0;
		int winCount = 0;
		int looseCount = 0;
		int luckyMonth = 0;
		int unluckyMonth = DAYS_OF_PLAYING * START_STAKE;
		for (int months = 1; months <= MONTH_PER_YEAR; months++) {
			winCount = 0;
			looseCount = 0;
			totalAmount = 0;
			for (int index = 1; index <= DAYS_OF_PLAYING; index++) {
				int stackeValue = resignGame();
				totalAmount += stackeValue;
				if (stackeValue == win) {
					winCount++;
				}
				if (stackeValue == loose) {
					looseCount++;
				}
			}
			System.out.println("Month " + months + ": ");
			System.out.println("Total number of days won the bet: " + winCount);
			System.out.println("Total number of days lost the bet: " + looseCount);
			System.out.println("Total amount at the end of month is: " + totalAmount);
			
			if(luckyMonth < totalAmount) {
				luckyMonth = totalAmount;
			}
			if(unluckyMonth > totalAmount) {
				unluckyMonth = totalAmount;
			}
		}
		System.out.println("Total amount in a lucky month: " + luckyMonth);
		System.out.println("Total amount in an unlucky month: " + unluckyMonth);
	}
}
