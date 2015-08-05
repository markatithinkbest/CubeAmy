package com.ithinkbest.cube001;

import com.ithinkbest.spec.cube.SpecCube;

public class Cube1 implements SpecCube {
	private int[] color;
	private boolean[] mask;

	public Cube1() {
		color = new int[] { 1, 2, 3, 4, 5,6 };
		mask = new boolean[] { true, true, true, true, true, true };
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			if (mask[i]) {
				sb.append(color[i]);
			}
		}
		return sb.toString();
	}

	@Override
	public int[] getFaceColors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] setFaceColors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getVisibleFaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] setVisibleFaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getVisibleMasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] setVisibleMasks() {
		// TODO Auto-generated method stub
		return null;
	}

	static final int[][] rule = { //
			{ 1, 5, 4, 2 }, // x1
			{ 1, 4, 2, 5 }, // x2
			{ 1, 2, 4, 5 }, // x3
			{ 0, 2, 3, 5 }, // y1
			{ 0, 3, 2, 5 }, // y2
			{ 0, 5, 3, 2 }, // y3
			{ 0, 4, 3, 1 }, // z1
			{ 0, 3, 1, 4 }, // z2
			{ 0, 1, 3, 4 }, // z3
	};

	/**
	 * 0: x1 1: x2 2: x3 3: y1 4: y2 5: y3 6: z1 7: z2 8: z3
	 */
	@Override
	public void rotate(int k) {
		int temp;

		switch (k) {
		case 0:
		case 2:
		case 3:
		case 5:
		case 6:
		case 8:
			System.out.print(" k="+k+ " ");
			temp = color[rule[k][0]];
			color[rule[k][0]] = color[rule[k][1]];
			color[rule[k][1]] = color[rule[k][2]];
			color[rule[k][2]] = color[rule[k][3]];
			color[rule[k][3]] = temp;
			break;
		case 1:
		case 4:
		case 7:
			System.out.print(" k="+k+ " ");
			temp = color[rule[k][0]];
			color[rule[k][0]] = color[rule[k][1]];
			color[rule[k][1]] = temp;
			temp = color[rule[k][2]];
			color[rule[k][2]] = color[rule[k][3]];
			color[rule[k][3]] = temp;
			break;
		}

		//
		// switch (k) {
		// case 0:
		// temp = color[1];
		// color[1] = color[5];
		// color[5] = color[4];
		// color[4] = color[2];
		// color[2] = temp;
		//
		// }

	}
}