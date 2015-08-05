package com.ithinkbest.cube001;

public class Main {
	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		test4();

	}

	public static void test4() {
		Rubik r ;
		System.out.println("---test4---\n");
		
		for (int i = 0; i < 27; i++) {
			r = new Rubik();
			// System.out.printf("%2d (% d,% d,% d) k=%2d\n", i, r.X[i], r.Y[i],
			// r.Z[i], k);
			System.out.printf("rotate(%2d) => %s ",i, Tool.getRotateName(i));
			System.out.printf("%s %s ", "(1,1,1)", r.getCube(1, 1, 1));
	//		System.out.printf("%s %s ", "(1,1,1)", r.getCube(1, 1, 1));
			
			r.rotate(i);
			System.out.printf("%2d %s\n", i, r.getCube(1, 1, 1));

		}

	}

	public static void test3() {
		Rubik r = new Rubik();
		System.out.println("---test3---\n");
		int k = 0;
		for (int i = 0; i < 27; i++) {
			// System.out.printf("%2d (% d,% d,% d) k=%2d\n", i, r.X[i], r.Y[i],
			// r.Z[i], k);
			System.out.printf("%2d %s\n", i, r.getCube(i));

		}

	}

	public static void test2() {
		Rubik r = new Rubik();
		System.out.println("---test2---\n");
		int k = 0;
		for (int i = 0; i < 27; i++) {
			k = r.XYZ[r.X0[i]][r.Y0[i]][r.Z0[i]];
			System.out.printf("%2d (% d,% d,% d) k=%2d\n", i, r.X[i], r.Y[i], r.Z[i], k);

		}

	}

	public static void test1() {
		Cube1 c1;
		for (int i = 0; i < 9; i++) {
			c1 = new Cube1();
			System.out.printf("c1 is %s, ", c1);
			c1.rotate(i);
			System.out.printf("after roating %2d, %3s\n", i, c1);
		}
	}

}
