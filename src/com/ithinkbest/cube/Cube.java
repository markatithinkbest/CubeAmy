package com.ithinkbest.cube;

import java.util.Arrays;

public class Cube {

	private static final int[] XR = { 1, 5, 4, 2 };
	private static final int[] YR = { 0, 2, 3, 5 };
	private static final int[] ZR = { 0, 4, 3, 1 };
	
	
	private int[] color = { 1, 2, 3, 4, 5, 6 };
	private boolean isFace[] = { true, true, true, true, true, true, };

	public int[] getColor() {
		return color;
	}
	public int getFaceColor(int k) {
		return color[k];
	}

	
	public void setColor(int[] color) {
		this.color = color;
	}

	public boolean[] getIsFace() {
		return isFace;
	}

	public void setIsFace(boolean[] isFace) {
		this.isFace = isFace;
	}

	/**
	 * 
	 * @param k
	 *            0 : X clockwise 90° 1 : X clockwise 180° 2 : X clockwise 270°
	 *            3 : Y clockwise 90° 4 : Y clockwise 180° 5 : Y clockwise 270°
	 *            6 : Z clockwise 90° 7 : Z clockwise 180° 8 : Z clockwise 270°
	 * 
	 */
	void rotate(int k) {
		int temp;

		

		switch (k) {
		case 0:
			temp = color[XR[0]];
			color[XR[0]] = color[XR[1]];
			color[XR[1]] = color[XR[2]];
			color[XR[2]] = color[XR[3]];
			color[XR[3]] = temp;
			break;
		case 1:
			temp = color[XR[0]];
			color[XR[0]] = color[XR[2]];
			color[XR[2]] = temp;
			temp = color[XR[1]];
			color[XR[1]] = color[XR[3]];
			color[XR[3]] = temp;
			break;
		case 2:
			temp = color[XR[0]];
			color[XR[0]] = color[XR[3]];
			color[XR[3]] = color[XR[2]];
			color[XR[2]] = color[XR[1]];
			color[XR[1]] = temp;
			break;
		case 3:
			temp = color[YR[0]];
			color[YR[0]] = color[YR[1]];
			color[YR[1]] = color[YR[2]];
			color[YR[2]] = color[YR[3]];
			color[YR[3]] = temp;
			break;
		case 4:
			temp = color[YR[0]];
			color[YR[0]] = color[YR[2]];
			color[YR[2]] = temp;
			temp = color[YR[1]];
			color[YR[1]] = color[YR[3]];
			color[YR[3]] = temp;
			break;
		case 5:
			temp = color[YR[0]];
			color[YR[0]] = color[YR[3]];
			color[YR[3]] = color[YR[2]];
			color[YR[2]] = color[YR[1]];
			color[YR[1]] = temp;
			break;
		case 6:
			temp = color[ZR[0]];
			color[ZR[0]] = color[ZR[1]];
			color[ZR[1]] = color[ZR[2]];
			color[ZR[2]] = color[ZR[3]];
			color[ZR[3]] = temp;
			break;
		case 7:
			temp = color[ZR[0]];
			color[ZR[0]] = color[ZR[2]];
			color[ZR[2]] = temp;
			temp = color[ZR[1]];
			color[ZR[1]] = color[ZR[3]];
			color[ZR[3]] = temp;
			break;
		case 8:
			temp = color[ZR[0]];
			color[ZR[0]] = color[ZR[3]];
			color[ZR[3]] = color[ZR[2]];
			color[ZR[2]] = color[ZR[1]];
			color[ZR[1]] = temp;
			break;

		}
		
		

	}

	/**
	 * 
	 * @param face
	 * 0:X
	 * 1:Y
	 * 2:Z
	 * @param degree
	 * 0:90°
	 * 1:180°
	 * 2:270°
	 */
	void rotate(int face, int degree) {
		rotate(face*3+degree);
	}

	public Cube() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<6;i++){
			if (isFace[i]){
				sb.append(color[i]);
			}else{
				sb.append('.');
			}
		}
		return sb.toString();
	}
	
	

}
