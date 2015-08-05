package com.ithinkbest.cube;

public class Test {
	public static void main(String[] args) {
//		test1();
		test2();
		
	}
	
	public static void test1(){
		System.out.println("=== basic cube ===");
		Cube cube=new Cube();
		System.out.println(cube);
		cube.rotate(0);
		System.out.println(cube);
		cube.setIsFace(new boolean[]{true,true,true,false,false,false} );
		System.out.println(cube);
		
	}
	public static void test2(){
		System.out.println("=== Rubik ===");
		Rubik rubik=new Rubik();
		System.out.println( rubik.getFaceColor());
		rubik.rotate(0);
		System.out.println( rubik.getFaceColor());
		System.out.println( rubik.getFaceColorTextImg());
		System.out.println( rubik.getFaceColorTextImg(".RBYogw"));
		System.out.println( rubik.getFaceColorTextImg(".紅藍黃橘綠白"));
		
	}
	
}
