package com.ithinkbest.spec.cube;

public interface SpecCube {
// 0 base

	/*
	 * k[0]: x=1
	 * k[1]: y=1
	 * k[2]: z=1
	 * k[3]: x=-1
	 * k[4]: y=-1
	 * k[5]: z=-1
	 * initial color code is {1,2,3,4,5,6}
	 * sample color code
	 * 1 as red
	 * 2 as blue
	 * 3 as yellow
	 * 4 as orange
	 * 5 as green
	 * 6 as white
	 */
	int[] getFaceColors();
	
	int[] setFaceColors();
	
	int[] getVisibleFaces();
	int[] setVisibleFaces();
	
	/**
	 * 
	 * @return default is {true,true,true,true,true,true}
	 */
	boolean[] getVisibleMasks();
	boolean[] setVisibleMasks();
	
	
	/*
	 * showing x,y,z 3 faces
	 * facing x|y|z =1
	 * r=1, rotate clockwise 90 degree
	 * r=2, rotate clockwise 180 degree
	 * r=3, rotate clockwise 270 degree, or as counter clockwise 90 degree
	 * 0: x1
	 * 1: x2
	 * 2: x3
	 * 3: y1
	 * 4: y2
	 * 5: y3
	 * 6: z1
	 * 7: z2
	 * 8: z3
	 * 
	 */
	void rotate (int k);
}
