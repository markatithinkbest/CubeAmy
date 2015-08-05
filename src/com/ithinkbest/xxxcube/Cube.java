package com.ithinkbest.xxxcube;

import java.util.Arrays;

public class Cube {
	// private int x;
	// private int y;
	// private int z;
	// private int a;
	// private int b;
	// private int c;

	private boolean[] isVisible;
	private int[] baseVal = { 1, 2, 3, 4, 5, 6 };
	private int[] val = { 1, 2, 3, 4, 5, 6 };

	private int faceCnt;
	private int[] initialFaceColor = new int[3];
	private int[] currentFaceColor = new int[3];

	public Cube() {
		reset();
	}
	public int[] getFaceColors(){
		return val;
	}
	public String getVisible() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			if (isVisible[i]) {
				sb.append('#');
			} else {
				sb.append('.');
			}
		}
		return sb.toString();
	}

	public void updateCurrentFaceColor() {
		int k = 0;
		for (int i = 0; i < 6; i++) {
			if (isVisible[i]) {
				currentFaceColor[k] = baseVal[i];
				k++;
			}
		}
	}

	public String getVisibleVal() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			if (isVisible[i]) {
				sb.append(val[i]);
			}
		}
		return sb.toString();
	}

	public String getVisibleBaseVal() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			if (isVisible[i]) {
				sb.append(baseVal[i]);
			}
		}
		return sb.toString();

		// StringBuilder sb = new StringBuilder();
		// for (int i = 0; i < faceCnt; i++) {
		//
		// sb.append(initialFaceColor[i]);
		//
		// }
		// return sb.toString();

	}

	public String getVisibleDiffVal() {
		StringBuilder sb = new StringBuilder();
		int xCnt = 0;
		int k = 0;
		for (int i = 0; i < 6; i++) {
			if (isVisible[i]) {
				currentFaceColor[k++] = val[i];
				if (baseVal[i] == val[i]) {
					sb.append('.');
				} else {
					sb.append('X');
					xCnt++;
				}
			}
		}

		if (xCnt == 2) {
			// System.out.printf("%d %d %d %d \n", currentFaceColor[0],
			// currentFaceColor[1], initialFaceColor[0],
			// initialFaceColor[1]);
			if (faceCnt == 2) {
				if (currentFaceColor[1] == initialFaceColor[0] && currentFaceColor[0] == initialFaceColor[1]) {
					sb.append(" correct cube, wrong color location");
				}
			}
		}

		return sb.toString();

	}

	public void setVisible(String visible) {
		char[] maskChar = visible.toCharArray();
		faceCnt = 0;
		for (int i = 0; i < maskChar.length; i++) {
			if (maskChar[i] == 'x') {
				initialFaceColor[faceCnt] = baseVal[0];
				faceCnt++;
				isVisible[0] = true;
				continue;
			}
			if (maskChar[i] == 'y') {
				initialFaceColor[faceCnt] = baseVal[1];
				faceCnt++;
				isVisible[1] = true;
				continue;
			}
			if (maskChar[i] == 'z') {
				initialFaceColor[faceCnt] = baseVal[2];
				faceCnt++;
				isVisible[2] = true;
				continue;
			}
			if (maskChar[i] == 'a') {
				initialFaceColor[faceCnt] = baseVal[3];
				faceCnt++;
				isVisible[3] = true;
				continue;
			}
			if (maskChar[i] == 'b') {
				initialFaceColor[faceCnt] = baseVal[4];
				faceCnt++;
				isVisible[4] = true;
				continue;
			}
			if (maskChar[i] == 'c') {
				initialFaceColor[faceCnt] = baseVal[5];
				faceCnt++;
				isVisible[5] = true;
				continue;
			}
		}
		// System.out.printf("faceCnt=%d visible=%s \n",faceCnt, visible);
	}

	public void reset() {
		isVisible = new boolean[6];
		val = baseVal.clone();
		//
		// x = 1;
		// y = 2;
		// z = 3;
		// a = 4;
		// b = 5;
		// c = 6;
	}

	public void setX(int x) {
		// this.x = x;
		val[0] = x;
	}

	public void setY(int y) {
		// this.y = y;
		val[1] = y;
	}

	public void setZ(int z) {
		// this.z = z;
		val[2] = z;
	}

	public void setA(int a) {
		// this.a = a;
		val[3] = a;
	}

	public void setB(int b) {
		// this.b = b;
		val[4] = b;

	}

	public void setC(int c) {
		// this.c = c;
		val[5] = c;

	}

	public int getX() {
		// return x;
		return val[0];
	}

	public int getY() {
		// return y;

		return val[1];
	}

	public int getZ() {
		// return z;

		return val[2];
	}

	public int getA() {
		// return a;

		return val[3];
	}

	public int getB() {
		// return b;

		return val[4];
	}

	public int getC() {
		// return c;

		return val[5];
	}

	public void rotate(int face, int clock) {
		int temp;
		int x, y, z, a, b, c;
		x = val[0];
		y = val[1];
		z = val[2];
		a = val[3];
		b = val[4];
		c = val[5];

		if (face == 1) { // roateX

			if (clock == 1) {
				temp = z;
				z = y;
				y = c;
				c = b;
				b = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}
			if (clock == 2) {
				temp = z;
				z = c;
				c = temp;
				temp = y;
				y = b;
				b = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}
			if (clock == 3) {
				temp = z;
				z = b;
				b = c;
				c = y;
				y = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}

		}
		if (face == 2) { // rotateY
			if (clock == 1) {
				temp = z;
				z = a;
				a = c;
				c = x;
				x = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}
			if (clock == 2) {
				temp = z;
				z = c;
				c = temp;
				temp = x;
				x = a;
				a = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}
			if (clock == 3) {
				temp = z;
				z = x;
				x = c;
				c = a;
				a = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}

		}
		if (face == 3) { // rotateZ
			if (clock == 1) {
				temp = y;
				y = x;
				x = b;
				b = a;
				a = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}
			if (clock == 2) {
				temp = y;
				y = b;
				b = temp;
				temp = y;
				x = a;
				a = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}
			if (clock == 3) {
				temp = y;
				y = a;
				a = b;
				b = x;
				x = temp;

				val[0] = x;
				val[1] = y;
				val[2] = z;
				val[3] = a;
				val[4] = b;
				val[5] = c;
				return;
			}

		}

	}

	/**
	 * 
	 * @param clock
	 *            1= 90 degree,2= 180 degree,2= 270 degree,
	 * 
	 */
	// private void rotateX(int clock) {
	// int temp;
	//
	// if (clock == 1) {
	// temp = z;
	// z = y;
	// y = c;
	// c = b;
	// b = temp;
	// return;
	// }
	// if (clock == 2) {
	// temp = z;
	// z = c;
	// c = temp;
	// temp = y;
	// y = b;
	// b = temp;
	// return;
	// }
	// if (clock == 3) {
	// temp = z;
	// z = b;
	// b = c;
	// c = y;
	// y = temp;
	// return;
	// }
	//
	// }
	//
	// private void rotateY(int clock) {
	// int temp;
	//
	// if (clock == 1) {
	// temp = z;
	// z = a;
	// a = c;
	// c = x;
	// x = temp;
	// return;
	// }
	// if (clock == 2) {
	// temp = z;
	// z = c;
	// c = temp;
	// temp = x;
	// x = a;
	// a = temp;
	// return;
	// }
	// if (clock == 3) {
	// temp = z;
	// z = x;
	// x = c;
	// c = a;
	// a = temp;
	// return;
	// }
	//
	// }
	//
	// private void rotateZ(int clock) {
	// int temp;
	//
	// if (clock == 1) {
	// temp = y;
	// y = x;
	// x = b;
	// b = a;
	// a = temp;
	// return;
	// }
	// if (clock == 2) {
	// temp = y;
	// y = b;
	// b = temp;
	// temp = y;
	// x = a;
	// a = temp;
	// return;
	// }
	// if (clock == 3) {
	// temp = y;
	// y = a;
	// a = b;
	// b = x;
	// x = temp;
	// return;
	// }
	//
	// }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			if (isVisible[i]){
				sb.append(val[i]);
			}
		}
		// return "" + x + y + z + a + b + c;
		return sb.toString();
	}

	public int[] getXYZ() {
		return val;
		// int[] xyz = new int[6];
		// xyz[0] = x;
		// xyz[1] = y;
		// xyz[2] = z;
		// xyz[3] = a;
		// xyz[4] = b;
		// xyz[5] = c;
		//
		// return xyz;
	}

}
