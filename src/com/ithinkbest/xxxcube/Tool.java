package com.ithinkbest.xxxcube;

public class Tool {
	public static final String[] ROTATE_NAME = {
		//
			"X11",
			"X12",
			"X13",
			"X21",
			"X22",
			"X23",
			"X31",
			"X32",
			"X33",
			"Y11",
			"Y12",
			"Y13",
			"Y21",
			"Y22",
			"Y23",
			"Y31",
			"Y32",
			"Y33",
			"Z11",
			"Z12",
			"Z13",
			"Z21",
			"Z22",
			"Z23",
			"Z31",
			"Z32",
			"Z33",
		
		
	};
			
	
	public static final int[] ROTATE_CORNER = {
			//
			0, 1, 2, // X(1)
			6, 7, 8, // X(-1)
			9, 10, 11, // Y(1)
			15, 16, 17, // Y(-1)
			18, 19, 20, // Z(1)
			24, 25, 26 };// Z(-1)
	public static final int[] ROTATE_EDGE = {
			//
			3, 4, 5, // X(0)
			12, 13, 14, // Y(0)
			21, 22, 23, // Z(0)
	};
	public static final int[] DEGREE, RING, FACE;
	// public static final int[][][] XYZ;
	public static final int[][] CORNER_SET = {
			// cnt=6
			{ 0, 6, 24, 18 }, // X-1
			{ 2, 8, 26, 20 }, // X+1
			{ 0, 18, 20, 2 }, // Y-1
			{ 6, 24, 26, 8 }, // Y+1
			{ 0, 2, 6, 8 }, // Z-1
			{ 18, 20, 26, 24 }, // Z+1

	};

	public static final boolean[][] VISIBLE_FACE;

	static {
		VISIBLE_FACE = new boolean[27][6];
		int[] x = { -1, 0, 1 };
		int[] y = { -1, 0, 1 };
		int[] z = { -1, 0, 1 };

		int k = 0;
		for (int c : z) {
			for (int b : y) {
				for (int a : x) {
					// System.out.printf("%2d % d,% d,% d \n",k++, a,b,c);

					if (a == 1) {
						VISIBLE_FACE[k][0] = true;
					} else if (a == -1) {
						VISIBLE_FACE[k][3] = true;
					}
					if (b == 1) {
						VISIBLE_FACE[k][1] = true;
					} else if (b == -1) {
						VISIBLE_FACE[k][4] = true;
					}
					if (c == 1) {
						VISIBLE_FACE[k][2] = true;
					} else if (c == -1) {
						VISIBLE_FACE[k][5] = true;
					}
					k++;
				}
			}
		}

	}

	// // lower ring
	// { 3, 4, 5 }, // 0
	// { 4, 5 }, // 1
	// { 0, 4, 5 }, // 2
	// { 3, 5 }, // 3
	// { 5 }, // 4
	// { 0, 5 }, // 5
	// { 3, 1, 5 }, // 6
	// { 1, 5 }, // 7
	// { 1, 2, 5 }, // 8
	// // "abc", "bc", "xbc",
	// // "ac", "c", "xc",
	// // "ayc", "yc", "xyc",
	//
	// { 3, 4 }, // 9
	// { 4 }, // 10
	// { 0, 4 }, // 11
	// { 3 }, // 12
	// {}, // 13
	// { 4 }, // 14
	// { 3, 1 }, // 15
	// { 4 }, // 16
	// { 0, 1 }, // 17
	//
	// // "ab", "b", "xb",
	// // "a", "", "x",
	// // "ay", "y", "xy",
	// //
	//
	// { 3, 4, 2 }, // 18
	// { 4, 2 }, // 19
	// { 0, 4, 2 }, // 20
	// { 3, 2 }, // 21
	// { 2 }, // 22
	// { 0, 2 }, // 23
	// { 3, 1, 2 }, // 24
	// { 1, 2 }, // 25
	// { 0,1, 2 },// 26
	// //
	//
	// // "abz", "bz", "xbz",
	// // "az", "z", "xz",
	// // "ayz", "yz", "xyz"
	// };

	// static final String[] visibleArray = {
	// // lower ring
	// "abc", "bc", "xbc", "ac", "c", "xc", "ayc", "yc", "xyc",
	//
	// // middle ring 9-17
	// "ab", "b", "xb", "a", "", "x", "ay", "y", "xy",
	//
	// // upper ring
	// "abz", "bz", "xbz", "az", "z", "xz", "ayz", "yz", "xyz"
	//
	// };

	static {
		//
		DEGREE = new int[27];
		RING = new int[27];
		FACE = new int[27];

		//
		int cnt = 0;
		for (int c = 0; c <= 2; c++) {
			for (int b = 0; b <= 2; b++) {
				for (int a = 0; a <= 2; a++) {
					DEGREE[cnt] = a;
					RING[cnt] = b;
					FACE[cnt] = c;
					cnt++;
				}
			}

		}

	}
	

	public static boolean is8CornerReady(int [] faceCnts){
		for (int c:faceCnts){
			if (c!=5){
				return false;
			}
		}
		return true;
	}
	
	
	public static String getStr(int [] colors){
		StringBuilder sb=new StringBuilder();
		for (int c:colors){
			sb.append(c);
		}
		return sb.toString();
	}

	public static String getStrWithSpace(int [] colors, int cnt){
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<cnt;i++){
			sb.append(colors[i]+" ");
		}
		return sb.toString();
	}
	
	public static String getRotateName(int [] colors, int cnt){
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<cnt;i++){
			sb.append(ROTATE_NAME[ colors[i]]+" ");
		}
		return sb.toString();
	}
	
	
	
	public static String getFaceColorStr(int [] colors){
		StringBuilder sb=new StringBuilder();
		for (int c:colors){
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String getRotateName(int k) {
		int face = FACE[k]; // 0:X, 1:Y, 2:Z
		int ring = RING[k] - 1; // 0:-1, 1:0, 2:1
		int degree = (DEGREE[k] + 1) * 90;// 0: 90, 1:180, 2:270
		char charX = 'X';
		// String cmd="cmd:"+(charX+face);
		// System.out.printf("rotate:%c(% d) %3d° ",(charX+face),ring, degree);
		return String.format("%c(% d) %3d° ", (charX + face), ring, degree);

	}

}
