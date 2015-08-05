package com.ithinkbest.spec.cube;

public interface SpecRubik extends SpecCube{
	int[]getVisibleColor(int x, int y, int z);
	SpecCube getCube(int x,int y, int z);
	SpecCube getCube(int index);
	
}
