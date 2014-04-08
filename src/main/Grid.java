package main;

import java.awt.Point;

/**
 * To jest model. Ma metody do ustawiania wartosci przez kontroler, sam inicjalizuje sie zerami.
 * Poczytać o modelu i kontrolerze i odpowiednio podzielic miedzy nie odpowiednie operacje 
 * wykonywane na gridzie
 *
 */
public class Grid {
	private int[][] array = new int[4][4];
	
	public Grid() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = 0;
			}
		}
	}
	
	private void setValue(int row, int column, int value) {
		array[row][column] = value;
	}

	
	
	public void addRandom() {

	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("====\n");
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sb.append(array[i][j]);
			}
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	/* --------- LEFT -------- */
	public void moveLeft() {
		for (int i = 0; i < 4; i++) {
			moveRowElementsLeft(array[i]);
			sumRowElementsLeft(array[i]);
			moveRowElementsLeft(array[i]);
		}
	}
	
	private void moveRowElementsLeft(int row[]) {
		for (int i = 1; i < 4; i++) {
			int k = i;
			int z = i - 1;
			while (z > -1) {
				if (row[z] == 0) {
					row[z] = row[k];
					row[k] = 0;
					
					k--;
				}
				z--;
			}
		}
	}
	
	private void sumRowElementsLeft(int row[]) {
		for (int i = 1; i < 4; i++) {
			if (row[i-1] == row[i] ) {
				row[i-1] = row[i-1] + row[i];
				row[i] = 0;
			}
		}
	}
	
	/* --------- RIGHT -------- */
	public void moveRight() {
		for (int i = 0; i < 4; i++) {
			moveRowElementsRight(array[i]);
			sumRowElementsRight(array[i]);
			moveRowElementsRight(array[i]);
		}
	}
	
	private void moveRowElementsRight(int row[]) {
		for (int i = 2; i > -1; i--) {
			int k = i;
			int z = i + 1;
			while (z < 4) {
				if (row[z] == 0) {
					row[z] = row[k];
					row[k] = 0;
					
					k++;
				}
				z++;
			}
		}
	}
	
	private void sumRowElementsRight(int row[]) {
		for (int i = 3; i > 0; i--) {
			if (row[i-1] == row[i] ) {
				row[i-1] = row[i-1] + row[i];
				row[i] = 0;
			}
		}
	}
	
	/* --------- DOWN -------- */
	public void moveDown() {
		moveColumnElementsDown();
		sumColumnElementsDown();
		moveColumnElementsDown();
	}
	
	private void moveColumnElementsDown() {
		for (int h = 0; h < 4; h++) {
			for (int i = 2; i > -1; i--) {
				int k = i;
				int z = i + 1;
				while (z < 4) {
					if (array[z][h] == 0) {
						array[z][h] = array[k][h];
						array[k][h] = 0;
						
						k++;
					}
					z++;
				}
			}
		}
	}
	
	private void sumColumnElementsDown() {
		for (int h = 0; h < 4; h++) {
			for (int i = 3; i > 0; i--) {
				if (array[i-1][h] == array[i][h] ) {
					array[i-1][h] = array[i-1][h] + array[i][h];
					array[i][h] = 0;
				}
			}
		}
	}
	
	
	
	/* --------- UP -------- */
	public void moveUp() {
		moveColumnElementsUp();
		sumColumnElementsUp();
		moveColumnElementsUp();
	}
	
	private void moveColumnElementsUp() {
		for (int h = 0; h < 4; h++) {
			for (int i = 1; i < 4; i++) {
				int k = i;
				int z = i - 1;
				while (z > -1) {
					if (array[z][h] == 0) {
						array[z][h] = array[k][h];
						array[k][h] = 0;
						
						k--;
					}
					z--;
				}
			}
		}
	}
	
	private void sumColumnElementsUp() {
		for (int h = 0; h < 4; h++) {
			for (int i = 1; i < 4; i++) {
				if (array[i-1][h] == array[i][h] ) {
					array[i-1][h] = array[i-1][h] + array[i][h];
					array[i][h] = 0;
				}
			}
		}
	}
}
