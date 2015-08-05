package com.ithinkbest.cube;

import java.util.Arrays;

public class Rubik {
	private Cube[] cubes = new Cube[27];
	private final static int[][] RING = {
			//
			{ 24, 21, 18, 15, 12, 9, 6, 3, 0 }, // 0, X(-1)
			{ 25, 22, 19, 16, 13, 10, 7, 4, 1 }, // 1, X(0)
			{ 26, 23, 20, 17, 14, 11, 8, 5, 2 }, // 2, X(1)
			{ 18, 19, 20, 9, 10, 11, 0, 1, 2 }, // 3, Y(-1)
			{ 21, 22, 23, 12, 13, 14, 3, 4, 5 }, // 4, Y(0)
			{ 24, 25, 26, 15, 16, 17, 6, 7, 8 }, // 5, Y(1)
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8 }, // 6, Z(-1)
			{ 9, 10, 11, 12, 13, 14, 15, 16, 17 }, // 7, Z(0)
			{ 18, 19, 20, 21, 22, 23, 24, 25, 26 } // 8, Z(1)
	};

	private final static int[][] FACE_COLOR = {
			//
			{ 26, 23, 20, 17, 14, 11, 8, 5, 2 }, // 2, X(1)
			{ 24, 25, 26, 15, 16, 17, 6, 7, 8 }, // 5, Y(1)
			{ 18, 19, 20, 21, 22, 23, 24, 25, 26 }, // 8, Z(1)
			{ 18, 21, 24, 9, 12, 15, 0, 3, 6 }, // 0, X(-1) left-right flip
			{ 20, 19, 18, 11, 10, 9, 2, 1, 0 }, // 3, Y(-1) left-right flip
			{ 6, 7, 8, 3, 4, 5, 0, 1, 2 } // 6, Z(-1) top-down flip

	};

	private static final boolean[][] FACE;

	static {
		FACE = new boolean[27][6];
		int k = 0;
		for (int z = -1; z <= 1; z++) {
			for (int y = -1; y <= 1; y++) {
				for (int x = -1; x <= 1; x++) {
					System.out.printf("%2d(% d,% d,% d) \n", k, x, y, z);

					if (x == 1) {
						FACE[k][0] = true;
					}
					if (y == 1) {
						FACE[k][1] = true;
					}
					if (z == 1) {
						FACE[k][2] = true;
					}
					if (x == -1) {
						FACE[k][3] = true;
					}
					if (y == -1) {
						FACE[k][4] = true;
					}
					if (z == -1) {
						FACE[k][5] = true;
					}
					k++;
				}
			}
		}
	}

	public Rubik() {
		for (int i = 0; i < 27; i++) {
			cubes[i] = new Cube();
			cubes[i].setIsFace(FACE[i]);
			System.out.println(cubes[i]);

		}
	}

	/*
	 * 0: X(1)
	 */
	public int[] getFaceColor(int k){
		int [] result=new int[9];
		for (int i=0;i<9;i++){
			
			result[i]=cubes[FACE_COLOR[k][i]].getFaceColor(k); 
		}
		
		
		return result;
	}
	
	public String getFaceColor(){
		StringBuilder sb=new StringBuilder();
		
		for (int k=0;k<6;k++){
			for (int i=0;i<9;i++){
				
				sb.append(cubes[FACE_COLOR[k][i]].getFaceColor(k)); 
			}
				
		}
			
		return sb.toString();
	}
	
	public String getFaceColorTextImg(){
		StringBuilder sb=new StringBuilder();
		
		for (int k=0;k<6;k++){
			for (int i=0;i<3;i++){				
				sb.append(cubes[FACE_COLOR[k][i]].getFaceColor(k))
				.append(' ');
				
			}
			sb.append("  ");
		}
		sb.append("\n");
		for (int k=0;k<6;k++){
			for (int i=3;i<6;i++){				
				sb.append(cubes[FACE_COLOR[k][i]].getFaceColor(k)).append(' ');
			}
			sb.append("  ");
		}
		sb.append("\n");
		for (int k=0;k<6;k++){
			for (int i=6;i<9;i++){				
				sb.append(cubes[FACE_COLOR[k][i]].getFaceColor(k)).append(' ');
			}
			sb.append("  ");
		}
		sb.append("\n");
		
		
		
			
		return sb.toString();
	}
	
	public String getFaceColorTextImg(String str){
		StringBuilder sb=new StringBuilder();
		int temp;
		for (int k=0;k<6;k++){
			for (int i=0;i<3;i++){				
				temp=cubes[FACE_COLOR[k][i]].getFaceColor(k);
				sb.append(str.substring(temp,1+temp))
				.append(' ');
				
			}
			sb.append("  ");
		}
		sb.append("\n");
		for (int k=0;k<6;k++){
			for (int i=3;i<6;i++){				
				temp=cubes[FACE_COLOR[k][i]].getFaceColor(k);
				sb.append(str.substring(temp,1+temp))
				.append(' ');
			}
			sb.append("  ");
		}
		sb.append("\n");
		for (int k=0;k<6;k++){
			for (int i=6;i<9;i++){				
				temp=cubes[FACE_COLOR[k][i]].getFaceColor(k);
				sb.append(str.substring(temp,1+temp))
				.append(' ');
			}
			sb.append("  ");
		}
		sb.append("\n");
		
		
		
			
		return sb.toString();
	}
	
	

	@Override
	public String toString() {
		return "Rubik [cubes=" + Arrays.toString(cubes) + "]";
	}

	/**
	 * 
	 * @param k
	 *            0 : X(-1) 90° 1 : X(-1) 180° 2 : X(-1) 270°
	 * 
	 * 
	 */
	public void rotate(int k) {
		int r = k / 3;
		int clock = k - 3 * r;
		int[] temp;
		// move

		// rotation
		switch (clock) {
		case 0: // 90 degree
			temp = cubes[RING[r][0]].getColor();
			cubes[RING[r][0]].setColor(cubes[RING[r][6]].getColor());
			cubes[RING[r][6]].setColor(cubes[RING[r][8]].getColor());
			cubes[RING[r][8]].setColor(cubes[RING[r][2]].getColor());
			cubes[RING[r][2]].setColor(temp);

			temp = cubes[RING[r][1]].getColor();
			cubes[RING[r][1]].setColor(cubes[RING[r][3]].getColor());
			cubes[RING[r][3]].setColor(cubes[RING[r][7]].getColor());
			cubes[RING[r][7]].setColor(cubes[RING[r][5]].getColor());
			cubes[RING[r][5]].setColor(temp);
//			System.out.printf("%d <-%d< %d<-%d\n",RING[r][0],RING[r][6],RING[r][8],RING[r][2]);
			break;
		case 1: // 180 degree
			temp = cubes[RING[r][0]].getColor();
			cubes[RING[r][0]].setColor(cubes[RING[r][8]].getColor());
			cubes[RING[r][8]].setColor(temp);

			temp = cubes[RING[r][2]].getColor();
			cubes[RING[r][2]].setColor(cubes[RING[r][6]].getColor());
			cubes[RING[r][6]].setColor(temp);
			temp = cubes[RING[r][1]].getColor();
			cubes[RING[r][1]].setColor(cubes[RING[r][7]].getColor());
			cubes[RING[r][7]].setColor(temp);

			temp = cubes[RING[r][5]].getColor();
			cubes[RING[r][5]].setColor(cubes[RING[r][3]].getColor());
			cubes[RING[r][3]].setColor(temp);
			break;
		case 2: // 270 degree
			temp = cubes[RING[r][0]].getColor();
			cubes[RING[r][0]].setColor(cubes[RING[r][2]].getColor());
			cubes[RING[r][2]].setColor(cubes[RING[r][8]].getColor());
			cubes[RING[r][8]].setColor(cubes[RING[r][6]].getColor());
			cubes[RING[r][6]].setColor(temp);

			temp = cubes[RING[r][1]].getColor();
			cubes[RING[r][1]].setColor(cubes[RING[r][5]].getColor());
			cubes[RING[r][5]].setColor(cubes[RING[r][7]].getColor());
			cubes[RING[r][7]].setColor(cubes[RING[r][3]].getColor());
			cubes[RING[r][3]].setColor(temp);
			break;

		}

		for (int i = 0; i < 9; i++) {
			cubes[RING[r][i]].rotate(clock);
		}

	}

}
