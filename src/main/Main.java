package main;

import java.util.Scanner;

public class Main {
	private static final String QUIT = "dolan pls sthap";
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
			
			if (line.equals(QUIT)) {
				input.close();
				print("Bye!\n");
				System.exit(0);
			} else if (line.equals(UP)) {
				g.moveUp();
			} else if (line.equals(DOWN)) {
				g.moveDown();
			} else if (line.equals(LEFT)) {
				g.moveLeft();
			} else if (line.equals(RIGHT)) {
				g.moveRight();
			}
			
			g.addRandom();
			print(g);
		}
	}

	private static void print(Object obj) {
		System.out.print(obj);
	}
}
