package com.ithinkbest.cube001;

public class Tool {
	
	public static final int[] DEGREE,RING,FACE;
	//public static final int[][][] XYZ;
	
	
	static {
		// for array index, 0,1,2
		DEGREE=new int[27];
		RING=new int[27];
		FACE=new int[27];
		
	
		
		
	//	XYZ=new int[3][3][3];
		int cnt=0;
		for (int c = 0; c <= 2; c++) {
			for (int b = 0; b <= 2; b++) {
				for (int a = 0; a <= 2; a++) {
					DEGREE[cnt]=a;
					RING[cnt]=b;
					FACE[cnt]=c;
					cnt++;
				}
			}

		}
		
		
	}
	
	public static String getRotateName(int k) {
		int face=FACE[k]; // 0:X, 1:Y, 2:Z
		int ring=RING[k]-1; // 0:-1, 1:0, 2:1
		int degree=(DEGREE[k]+1)*90;// 0: 90, 1:180, 2:270
		char charX='X';
//		String cmd="cmd:"+(charX+face);
		//System.out.printf("rotate:%c(% d) %3d° ",(charX+face),ring, degree);
		return String.format("%c(% d) %3d° ",(charX+face),ring, degree);
		
	}

}
