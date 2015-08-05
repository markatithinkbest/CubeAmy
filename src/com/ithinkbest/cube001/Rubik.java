package com.ithinkbest.cube001;

import com.ithinkbest.spec.cube.SpecCube;
import com.ithinkbest.spec.cube.SpecRubik;

public class Rubik implements SpecRubik {
	public static final int[] X,Y,Z,X0,Y0,Z0;
	public static final int[][][] XYZ;
	
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
	
	static {
		// for array index, 0,1,2
		X0=new int[27];
		Y0=new int[27];
		Z0=new int[27];
		
		// for natural coordination, -1,0,1 
		X=new int[27];
		Y=new int[27];
		Z=new int[27];
		
		
		XYZ=new int[3][3][3];
		int cnt=0;
		for (int c = 0; c <= 2; c++) {
			for (int b = 0; b <= 2; b++) {
				for (int a = 0; a <= 2; a++) {
					X0[cnt]=a;
					Y0[cnt]=b;
					Z0[cnt]=c;
					X[cnt]=a-1;
					Y[cnt]=b-1;
					Z[cnt]=c-1;
					XYZ[a][b][c]=cnt;
				//	System.out.printf("%2d (% d,% d,% d) \n",cnt++,a-1,b-1,c-1);
					cnt++;
				}
			}

		}
		
		
	}
	
	SpecCube[][][] rubik;
	
	

	public Rubik() {
		rubik = new Cube1[3][3][3];
		int cnt=0;
		
		for (int i=0;i<27;i++){
			rubik[X0[i]][Y0[i]][Z0[i]]=new Cube1();
		}
		
		
//		for (int c = 0; c <= 2; c++) {
//			for (int b = 0; b <= 2; b++) {
//				for (int a = 0; a <= 2; a++) {
//					rubik[a][b][c]=new Cube1();
//		//			System.out.printf("%2d (% d,% d,% d) \n",cnt++,a-1,b-1,c-1);
//				}
//			}
//
//		}

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

	@Override
	public void rotate(int k) {
		int face=FACE[k]; // 0:X, 1:Y, 2:Z
		int ring=RING[k]-1; // 0:-1, 1:0, 2:1
		int degree=(DEGREE[k]+1)*90;// 0: 90, 1:180, 2:270
		
		
		
	}

	@Override
	public int[] getVisibleColor(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecCube getCube(int x, int y, int z) {
		//int k=XYZ[1+x][1+y][1+z];
		return rubik[1+x][1+y][1+z];
	}

	@Override
	public SpecCube getCube(int i) {
		return rubik[X0[i]][Y0[i]][Z0[i]];
	}

}
