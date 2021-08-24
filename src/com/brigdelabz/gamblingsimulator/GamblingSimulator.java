package com.brigdelabz.gamblingsimulator;

public class GamblingSimulator {
	public static final int START_STAKE = 100;
	public static final int BET_ON_GAME = 1;
	public static final int DAYS_OF_PLAYING = 20;
	public static int stake = 0;
	public static int win = 0;
	public static int loose = 0;
	
	public static void play() {
		if (Math.random() > 0.5) {
			System.out.println("You won the $1");
			stake++;
		}
		else {
			System.out.println("You lost the $1");
			stake--;
		}
	}
	
	public static int resignGame() {
		win = (int) Math.round(START_STAKE + (START_STAKE * 0.5));
		loose = (int) Math.round(START_STAKE * 0.5);
		System.out.println("Winning amount: " + win);
		System.out.println("Loosing amount: " + loose);
		
		boolean resign = true;
		stake = START_STAKE;
		while(resign == true) {
			play();
			if(stake == win) {
				resign = false;
			}
			if(stake == loose) {
				resign = false;
			}
		}
		return stake;
	}
	
	public static void main(String[] args) {
		int stackeValue = resignGame();
		if(stackeValue == win) {
			System.out.println("Player retires game as he wins enough");
		}
		if(stackeValue == loose) {
			System.out.println("Player retires game as he looses enough");
		}
	}
}
