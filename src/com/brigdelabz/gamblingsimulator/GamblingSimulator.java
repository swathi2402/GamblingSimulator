package com.brigdelabz.gamblingsimulator;

public class GamblingSimulator {
	public static final int START_STAKE = 100;
	public static final int BET_ON_GAME = 1;
	public static int stake = 0;
	public static int win = 0;
	public static int loose = 0;
	
	public static void play() {
		if (Math.random() > 0.5) {
			System.out.println("You won the $1");
			stake++;
			win++;
		}
		else {
			System.out.println("You lost the $1");
			stake--;
			loose++;
		}
	}
	
	public static void resignGame() {
		int halfOfStake = START_STAKE /2;
		while(stake != halfOfStake) {
			play();
		}
		if (stake == halfOfStake) {
			System.out.println("Winning count: " + win + " Loosing count: " + loose);;
			System.out.println("Player resigning the game");
		}
	}
	
	public static void main(String[] args) {
		resignGame();
	}
}
