package main;

import java.util.Scanner;

public class Main {
	private static final String EMPTY = "";
	private static final String UP = "w";
	private static final String DOWN = "s";
	private static final String LEFT = "a";
	private static final String RIGHT = "d";
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String line;
		
		Grid g = new Grid();
		print(g);
		
		while (input.hasNext()) {
			line = input.nextLine();
			
			if (line.equals(EMPTY)) {
				input.close();
				print("Bye!\n");
			} else if (line.equals(UP)) {
				g.moveUp();
				print(g);
			} else if (line.equals(DOWN)) {
				g.moveDown();
				print(g);
			} else if (line.equals(LEFT)) {
				g.moveLeft();
				print(g);
			} else if (line.equals(RIGHT)) {
				g.moveRight();
				print(g);
			}
		}
	}

	private static void print(Object obj) {
		System.out.print(obj);
	}
}
