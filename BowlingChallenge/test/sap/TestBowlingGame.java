package sap;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestBowlingGame {
	
	// These variables are useful for simulating user inputs. In our tests they represent cases of 12, 20 or 21 tosses,
	// and they represent an input stream of enter (return) input
	static String twentyTosses = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r";
	static String twentyOneTosses = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r";
	static String twelveTosses = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r";
	
	@Test
	public void testPerfectGame() {
		HashMap<Integer, ArrayList<Integer>> roundTossMap = new HashMap<Integer, ArrayList<Integer>>();
		Game game = new Game();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add(10);
		for (int i = 1; i<= 9; i++) {
			roundTossMap.put(i, list);
		}
		list2.add(10);
		list2.add(10);
		list2.add(10);
		roundTossMap.put(10, list2);
		game.setRoundTossMap(roundTossMap);
		ByteArrayInputStream in = new ByteArrayInputStream(twelveTosses.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals(300, BowlingGame.playBowling(game, scanner, "Test Player"));
		scanner.close();
	}
	
	@Test
	public void testZeroScore() {
		HashMap<Integer, ArrayList<Integer>> roundTossMap = new HashMap<Integer, ArrayList<Integer>>();
		Game game = new Game();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(0);
		for (int i = 1; i<= 10; i++) {
			roundTossMap.put(i, list);
		}
		game.setRoundTossMap(roundTossMap);
		ByteArrayInputStream in = new ByteArrayInputStream(twentyTosses.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals(0, BowlingGame.playBowling(game, scanner, "Test Player"));
		scanner.close();
	}
	
	@Test
	public void testAllSpareWith9and1() {
		HashMap<Integer, ArrayList<Integer>> roundTossMap = new HashMap<Integer, ArrayList<Integer>>();
		Game game = new Game();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add(9);
		list.add(1);
		for (int i = 1; i<= 9; i++) {
			roundTossMap.put(i, list);
		}
		list2.add(9);
		list2.add(1);
		list2.add(10);
		roundTossMap.put(10, list2);
		game.setRoundTossMap(roundTossMap);
		ByteArrayInputStream in = new ByteArrayInputStream(twentyOneTosses.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals(191, BowlingGame.playBowling(game, scanner, "Test Player"));
		scanner.close();
	}
	
	@Test
	public void testAllSpareWith1and9() {
		HashMap<Integer, ArrayList<Integer>> roundTossMap = new HashMap<Integer, ArrayList<Integer>>();
		Game game = new Game();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add(1);
		list.add(9);
		for (int i = 1; i<= 9; i++) {
			roundTossMap.put(i, list);
		}
		list2.add(1);
		list2.add(9);
		list2.add(10);
		roundTossMap.put(10, list2);
		game.setRoundTossMap(roundTossMap);
		ByteArrayInputStream in = new ByteArrayInputStream(twentyOneTosses.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals(119, BowlingGame.playBowling(game, scanner, "Test Player"));
		scanner.close();
	}
	
	@Test
	public void testAllSpareWith5and5() {
		HashMap<Integer, ArrayList<Integer>> roundTossMap = new HashMap<Integer, ArrayList<Integer>>();
		Game game = new Game();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add(5);
		list.add(5);
		for (int i = 1; i<= 9; i++) {
			roundTossMap.put(i, list);
		}
		list2.add(5);
		list2.add(5);
		list2.add(10);
		roundTossMap.put(10, list2);
		game.setRoundTossMap(roundTossMap);
		ByteArrayInputStream in = new ByteArrayInputStream(twentyOneTosses.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals(155, BowlingGame.playBowling(game, scanner, "Test Player"));
		scanner.close();
	}
	
	@Test
	public void testAllSpareWith5and5ExceptLast() {
		HashMap<Integer, ArrayList<Integer>> roundTossMap = new HashMap<Integer, ArrayList<Integer>>();
		Game game = new Game();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.add(5);
		list.add(5);
		for (int i = 1; i<= 9; i++) {
			roundTossMap.put(i, list);
		}
		list2.add(5);
		list2.add(0);
		roundTossMap.put(10, list2);
		game.setRoundTossMap(roundTossMap);
		ByteArrayInputStream in = new ByteArrayInputStream(twentyTosses.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals(140, BowlingGame.playBowling(game, scanner, "Test Player"));
		scanner.close();
	}
	
	@Test
	public void test5strikes5SparesWith21stAsStrike() {
		HashMap<Integer, ArrayList<Integer>> roundTossMap = new HashMap<Integer, ArrayList<Integer>>();
		Game game = new Game();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list.add(10);
		for (int i = 1; i<= 5; i++) {
			roundTossMap.put(i, list);
		}
		list2.add(5);
		list2.add(5);
		for (int i = 6; i<= 9; i++) {
			roundTossMap.put(i, list2);
		}
		list3.add(5);
		list3.add(5);
		list3.add(10);
		roundTossMap.put(10, list3);
		game.setRoundTossMap(roundTossMap);
		ByteArrayInputStream in = new ByteArrayInputStream(twentyTosses.getBytes());
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		assertEquals(215, BowlingGame.playBowling(game, scanner, "Test Player"));
		scanner.close();
	}
	
	// Test that proves that the random generating function works correctly.
	// If the randomly generated game has exactly 10 rounds and generated value
	// for each toss of each round lies in the range [0,10]
	@Test
	public void testGameValid() {
		Game game = BowlingGame.generateRandomGame();
		int flag = 0;
		// The program should not result in an empty game,
		// neither should it be of less or more than 10 rounds
		if (game.getRoundTossMap().isEmpty() || game.getRoundTossMap().size()!= 10) {
			flag = 1;
		} else {
			for (int i = 1; i <= 10; i++) {
				// A round should at least have one toss and at most 3 tosses
				if (game.getRoundTossMap().get(i).isEmpty() || game.getRoundTossMap().get(i).size() > 3) {
					flag = 1;
					break;
				}
				// A round which is not the last round can only have at most 2 tosses
				if (i < 10 && game.getRoundTossMap().get(i).size() > 2) {
					flag = 1;
					break;
				}
				// A round which is not the last round can only have 1 and only 1 toss if the first toss resulted in a 10
				if (i < 10 && game.getRoundTossMap().get(i).get(0) == 10 && game.getRoundTossMap().get(i).size() > 1) {
					flag = 1;
					break;
				}
				// The minimum value of any toss of any of the 10 rounds should be 0 and maximum should be 10
				for (int j = 0; j < game.getRoundTossMap().get(i).size(); j++) {
					if (game.getRoundTossMap().get(i).get(j) < 0 || game.getRoundTossMap().get(i).get(j) > 10) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					break;
				}
				// If the first toss scores less than 10, there must be at least one more toss for that round
				if (game.getRoundTossMap().get(i).get(0) < 10 && game.getRoundTossMap().get(i).size() < 2) {
					flag = 1;
					break;
				}
				// If the first toss scores less than 10, the second toss should score at most 10 minus the score in first toss
				if (game.getRoundTossMap().get(i).get(0) < 10 && game.getRoundTossMap().get(i).get(1) > (10 - game.getRoundTossMap().get(i).get(0))) {
					flag = 1;
					break;
				}
				// In the last round, if either the first toss or the sum of the first two tosses results in a 10,
				// there must be 3 and exactly 3 tosses in total for the round
				if (i == 10 && (game.getRoundTossMap().get(i).get(0) == 10 || (game.getRoundTossMap().get(i).get(0) + game.getRoundTossMap().get(i).get(1) == 10)) && game.getRoundTossMap().get(i).size() != 3) {
					flag = 1;
					break;
				}
			}
		}
		assertEquals(0, flag);
	}
}
