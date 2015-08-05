package com.ithinkbest.xxxcube;

public class Cube333 {
	static

	Cube[] cubes;
	static final String[] visibleArray = {
			// lower ring
			"abc", "bc", "xbc", "ac", "c", "xc", "ayc", "yc", "xyc",

			// middle ring 9-17
			"ab", "b", "xb", "a", "", "x", "ay", "y", "xy",

			// upper ring
			"abz", "bz", "xbz", "az", "z", "xz", "ayz", "yz", "xyz"

	};

	// int[] x1={-1,26,23,20,17,14,11,8,5,2};
	// int[] x2={-1,25,22,19,16,13,10,7,4,1};
	// int[] x3={-1,24,21,18,15,12,9,6,3,0};
	//
	// final int [][]xi={{-1},
	// {-1,26,23,20,17,14,11,8,5,2},
	// {-1,25,22,19,16,13,10,7,4,1},
	// {-1,24,21,18,15,12,9,6,3,0} };

	// to keep format
	// final int [][][]xyz={{},
	// {{-1},
	// {-1,26,23,20,17,14,11,8,5,2},
	// {-1,25,22,19,16,13,10,7,4,1},
	// {-1,24,21,18,15,12,9,6,3,0}},
	// {{-2},
	// {-2,24,25,26,15,16,17,6,7,8},
	// {-2,21,22,23,12,13,14,3,4,5},
	// {-2,18,19,20,9,10,11,0,1,2}},
	// {{-3},
	// {-3,18,19,20,21,22,23,24,25,26},
	// {-3,9,10,11,12,13,14,15,16,17},
	// {-3,0,1,2,3,4,5,6,7,8}}
	// };
	//
	final int[][][] xyz = { {},
			{ { -1 }, { -1, 26, 23, 20, 17, 14, 11, 8, 5, 2 }, { -1, 25, 22, 19, 16, 13, 10, 7, 4, 1 },
					{ -1, 24, 21, 18, 15, 12, 9, 6, 3, 0 } },
			{ { -2 }, { -2, 24, 25, 26, 15, 16, 17, 6, 7, 8 }, { -2, 21, 22, 23, 12, 13, 14, 3, 4, 5 },
					{ -2, 18, 19, 20, 9, 10, 11, 0, 1, 2 } },
			{ { -3 }, { -3, 18, 19, 20, 21, 22, 23, 24, 25, 26 }, { -3, 9, 10, 11, 12, 13, 14, 15, 16, 17 },
					{ -3, 0, 1, 2, 3, 4, 5, 6, 7, 8 } } };

	public Cube333() {
		reset();
	}

	public void reset() {
		cubes = new Cube[27];
		for (int i = 0; i < 27; i++) {
			cubes[i] = new Cube();
			cubes[i].setVisible(visibleArray[i]);
			// System.out.printf("%2d %s \n", i, cubes[i].toString());
		}
	}

	public void set(String colorStr) {
		// 6x9
	}

	public void rotateByCommand(String cmd) {
		String[] moves = cmd.split(" ");
		int face, ring, clock;
		face = 0;
		int temp;
		for (String move : moves) {

			if (move.startsWith("X")) {
				face = 1;
			} else if (move.startsWith("Y")) {
				face = 2;
			} else if (move.startsWith("Z")) {
				face = 3;
			}
			temp = Integer.parseInt(move.substring(1));
			ring = temp / 10;
			clock = temp - ring * 10;
			// System.out.println(move+" "+face+" "+ring+" "+clock);
			rotate(face, ring, clock);
			// System.out.print(move + " " + face + " " + ring + " " + clock + "
			// ");
			// showColor();

		}
	}

	public void rotate(int k) {
		int face = 1+Tool.FACE[k];
		int ring = 1+Tool.RING[k];
		int degree = 1+Tool.DEGREE[k];
//		System.out.printf("rotate(%d) face=%d, ring=%d, degree=%d \n",k,face,ring,degree);
		rotate(face, ring, degree);

	}

	public void rotate(int face, int ring, int degree) {
		Cube temp;
		// if (face==1){
		// temp =cubes[xi[ring][1]];
		// cubes[xi[ring][1]]=cubes[xi[ring][7]];
		// cubes[xi[ring][7]]=cubes[xi[ring][9]];
		// cubes[xi[ring][9]]=cubes[xi[ring][3]];
		// cubes[xi[ring][3]]=temp;
		//
		// temp =cubes[xi[ring][2]];
		// cubes[xi[ring][2]]=cubes[xi[ring][4]];
		// cubes[xi[ring][4]]=cubes[xi[ring][8]];
		// cubes[xi[ring][8]]=cubes[xi[ring][6]];
		// cubes[xi[ring][6]]=temp;
		//
		// for (int k=1;k<=9;k++){
		// cubes[xi[ring][k]].rotate(face, clock);
		// }
		// }
		if (degree == 1) {
			temp = cubes[xyz[face][ring][1]];
			cubes[xyz[face][ring][1]] = cubes[xyz[face][ring][7]];
			cubes[xyz[face][ring][7]] = cubes[xyz[face][ring][9]];
			cubes[xyz[face][ring][9]] = cubes[xyz[face][ring][3]];
			cubes[xyz[face][ring][3]] = temp;

			temp = cubes[xyz[face][ring][2]];
			cubes[xyz[face][ring][2]] = cubes[xyz[face][ring][4]];
			cubes[xyz[face][ring][4]] = cubes[xyz[face][ring][8]];
			cubes[xyz[face][ring][8]] = cubes[xyz[face][ring][6]];
			cubes[xyz[face][ring][6]] = temp;

			for (int k = 1; k <= 9; k++) {
				cubes[xyz[face][ring][k]].rotate(face, degree);
			}
		}
		if (degree == 2) {
			temp = cubes[xyz[face][ring][1]];
			cubes[xyz[face][ring][1]] = cubes[xyz[face][ring][9]];
			cubes[xyz[face][ring][9]] = temp;

			temp = cubes[xyz[face][ring][2]];
			cubes[xyz[face][ring][2]] = cubes[xyz[face][ring][8]];
			cubes[xyz[face][ring][8]] = temp;

			temp = cubes[xyz[face][ring][3]];
			cubes[xyz[face][ring][3]] = cubes[xyz[face][ring][7]];
			cubes[xyz[face][ring][7]] = temp;

			temp = cubes[xyz[face][ring][4]];
			cubes[xyz[face][ring][4]] = cubes[xyz[face][ring][6]];
			cubes[xyz[face][ring][6]] = temp;

			for (int k = 1; k <= 9; k++) {
				cubes[xyz[face][ring][k]].rotate(face, degree);
			}
		}
		if (degree == 3) {
			temp = cubes[xyz[face][ring][1]];
			cubes[xyz[face][ring][1]] = cubes[xyz[face][ring][3]];
			cubes[xyz[face][ring][3]] = cubes[xyz[face][ring][9]];
			cubes[xyz[face][ring][9]] = cubes[xyz[face][ring][7]];
			cubes[xyz[face][ring][7]] = temp;

			temp = cubes[xyz[face][ring][2]];
			cubes[xyz[face][ring][2]] = cubes[xyz[face][ring][6]];
			cubes[xyz[face][ring][6]] = cubes[xyz[face][ring][8]];
			cubes[xyz[face][ring][8]] = cubes[xyz[face][ring][4]];
			cubes[xyz[face][ring][4]] = temp;

			for (int k = 1; k <= 9; k++) {
				cubes[xyz[face][ring][k]].rotate(face, degree);
			}
		}

	}

	public int[][] getColor() {
		int[][] color = new int[7][10];

		for (int k = 1; k <= 9; k++) {
			color[1][k] = cubes[xyz[1][1][k]].getX();
			color[2][k] = cubes[xyz[2][1][k]].getY();
			color[3][k] = cubes[xyz[3][1][k]].getZ();
			color[4][k] = cubes[xyz[1][3][k]].getA();
			color[5][k] = cubes[xyz[2][3][k]].getB();
			color[6][k] = cubes[xyz[3][3][k]].getC();
		}

		return color;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int[][] color = getColor();
		for (int face = 1; face <= 6; face++) {
			for (int unit = 1; unit <= 9; unit++) {
				sb.append(color[face][unit]);
			}
		}
		return sb.toString();
	}
	//
	// private String getMaskedColor(String input, String maskStr){
	// if (maskStr.length()==0) return "";
	//
	// StringBuilder sb=new StringBuilder();
	// boolean[] isShown=new boolean[6];
	//
	// char[] maskChar=maskStr.toCharArray();
	//
	// for (int i=0;i<maskChar.length;i++){
	// if (maskChar[i]=='x'){
	// isShown[0]=true;
	// continue;
	// }
	// if (maskChar[i]=='y'){
	// isShown[1]=true;
	// continue;
	// }
	// if (maskChar[i]=='z'){
	// isShown[2]=true;
	// continue;
	// }
	// if (maskChar[i]=='a'){
	// isShown[3]=true;
	// continue;
	// }
	// if (maskChar[i]=='b'){
	// isShown[4]=true;
	// continue;
	// }
	// if (maskChar[i]=='c'){
	// isShown[5]=true;
	// continue;
	// }
	// }
	//
	// char[] inputChar=input.toCharArray();
	//
	// for (int i=0;i<6;i++){
	// if (isShown[i]){
	// sb.append(inputChar[i]);
	// }else{
	// sb.append('.');
	// }
	// }
	//
	// return sb.toString();
	// }

	private String getMaskedColorShort(String input, String maskStr) {
		if (maskStr.length() == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		boolean[] isShown = new boolean[6];

		char[] maskChar = maskStr.toCharArray();

		for (int i = 0; i < maskChar.length; i++) {
			if (maskChar[i] == 'x') {
				isShown[0] = true;
				continue;
			}
			if (maskChar[i] == 'y') {
				isShown[1] = true;
				continue;
			}
			if (maskChar[i] == 'z') {
				isShown[2] = true;
				continue;
			}
			if (maskChar[i] == 'a') {
				isShown[3] = true;
				continue;
			}
			if (maskChar[i] == 'b') {
				isShown[4] = true;
				continue;
			}
			if (maskChar[i] == 'c') {
				isShown[5] = true;
				continue;
			}
		}

		char[] inputChar = input.toCharArray();

		for (int i = 0; i < 6; i++) {
			if (isShown[i]) {
				sb.append(inputChar[i]);
			}
			// else{
			// sb.append('.');
			// }
		}

		return sb.toString();
	}

	public String toDescription() {
		StringBuilder sb = new StringBuilder();
		// int[][] color = getColor();
		String a, b, c, d, e, f, g, h, i;
		for (int k = 0; k < 27; k++) {
			a = cubes[k].toString();
			b = visibleArray[k];
			// c=this.getMaskedColor(a, b);
			c = "";
			// d=this.getMaskedColorShort(a, b);
			d = "";
			e = cubes[k].getVisible();
			f = cubes[k].getVisibleVal();
			g = cubes[k].getVisibleBaseVal();
			i = cubes[k].getVisibleDiffVal();

			// System.out.printf("%2d %s %3s %s\n",k,a,b,c);
			if (i.contains("X")) {
				System.out.printf("%2d %3s %3s %3s \n", k, a, g, i);
			}

		}
		return sb.toString();
	}

	public void showSample(int k) {
		reset();
		System.out.println("inital:");
		System.out.println("   " + toString());
		// cube #11 and #17, self rotate
		String cmd = "Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21 X12";
		this.rotateByCommand(cmd);
		System.out.println("cmd:");
		System.out.println("   " + cmd);
		System.out.println("done:");
		System.out.println("   " + toString());
		System.out.println("description:");
		System.out.println("   " + toDescription());

	}

	public void showColor() {
		int[][] color = getColor();
		String[] colorName = { " ", "藍", "橘", "黃", "綠", "紅", "白" };
		for (int face = 1; face <= 6; face++) {
			System.out.print("[");
			// for (int face = 1; face <= 6; face++) {
			for (int unit = 1; unit <= 9; unit++) {
				System.out.print(colorName[color[face][unit]]);
				if (unit == 3 || unit == 6) {
					System.out.print("-");

				}
			}
			System.out.print("] ");
		}
		// System.out.println();
	}

	public int[] getCompleteCornerCnt() {
		int cnt = 0;
		int[] val=new int[6];
		
		int[] index = new int[4];
		Cube[] corners = new Cube[4];
		for (int i = 0; i < Tool.CORNER_SET.length; i++) {
//			System.out.printf(" --- corner set = %d  ---\n", i);
			index[0] = Tool.CORNER_SET[i][0];
			index[1] = Tool.CORNER_SET[i][1];
			index[2] = Tool.CORNER_SET[i][2];
			index[3] = Tool.CORNER_SET[i][3];

			corners[0] = cubes[index[0]];
			corners[1] = cubes[index[1]];
			corners[2] = cubes[index[2]];
			corners[3] = cubes[index[3]];

			int faceOkCnt = 0;

			for (int face = 0; face < 6; face++) {
//				System.out.printf(" face=%d \n", face);

		
				int sameColorCnt = 0;
				int visibleFaceCnt = 0;
				int tempColor = -1;
				for (int item = 0; item < 4; item++) {
//					System.out.printf(" #%d=>%d %b", item, index[item], Tool.VISIBLE_FACE[index[item]][face]);

					if (Tool.VISIBLE_FACE[index[item]][face]) {
//						System.out.printf(" ...to check, color=%d", corners[item].getFaceColors()[face]);
						
						visibleFaceCnt++;
						if (visibleFaceCnt == 1) {
							tempColor = corners[item].getFaceColors()[face];
							sameColorCnt++;
						} else {
							if (corners[item].getFaceColors()[face] == tempColor) {
								sameColorCnt++;
								
							}else{
								break;
							}
						}

//						System.out.printf(" ...visibleFaceCnt=%d, sameColorCnt=%d, tempColor=%d, \n",visibleFaceCnt,sameColorCnt, corners[item].getFaceColors()[face]);
					} else {
//						System.out.printf(" \n");

					}

				}
				if (sameColorCnt == visibleFaceCnt) {
					faceOkCnt++;
				}

//				System.out.printf("--------- faceOkCnt=%d\n", faceOkCnt);

			}

			// System.out.printf("\n---------\n");
//			System.out.printf(" /// corner set = %d  faceOkCnt=%d ///\n", i,faceOkCnt);
			val[i]=faceOkCnt-1;
		}

		return val;
	}

	public int getCompleteFaceCnt() {
		int[][] color = getColor();
		// String[] colorName = { " ", "藍", "橘", "黃", "綠", "紅", "白" };
		int cnt = 0;
		int temp = 0;
		for (int face = 1; face <= 6; face++) {
			temp = 0;
			for (int unit = 1; unit <= 9; unit++) {
				if (color[face][5] == color[face][unit]) {
					temp++;
				}

			}
			if (temp == 9) {
				cnt++;
			}
		}
		return cnt;
	}
}
