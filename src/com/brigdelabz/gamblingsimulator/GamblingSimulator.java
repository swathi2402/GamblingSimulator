package com.brigdelabz.gamblingsimulator;

public class GamblingSimulator {
	public static final int START_STAKE = 100;
	public static final int BET_ON_GAME = 1;
	
	public static void play() {
		int stake = 0;
		if (Math.random() > 0.5) {
			System.out.println("You won the $1");
			stake++;
		}
		else {
			System.out.println("You lost the $1");
			stake--;
		}
	}
	
	public static void main(String[] args) {
		play();
	}
}
