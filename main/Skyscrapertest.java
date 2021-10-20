package com.greatlearning.main;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Skyscrapertest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building");
		int buildingcount=sc.nextInt();
		Integer[] floorNums = new Integer[buildingcount];
		for(int i=0;i<buildingcount;i++){
			System.out.println("Enter the floor size given on day "+(i+1));
			floorNums[i]=sc.nextInt();
		}
		Skyscrapertest skyscrap = new Skyscrapertest();
		skyscrap.orderOfConstruction(floorNums,buildingcount);
	}
	private void orderOfConstruction(Integer[] floorNums,int buildingcount) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < buildingcount; i++) {
            stack.push(i);
        }
		
		/*for (int i = 0; i < buildingcount; i++) {
			Integer element = (Integer)stack.peek();
            if(buildingcount==element){
            	 Integer  y= (Integer)stack.pop();
    			System.out.println(y);
    		}else{
    			System.out.println();
    		}
        }*/
		for (int i = 1; i < buildingcount; i++) {
		Integer pos = (Integer)stack.search(i);
		if(pos==buildingcount){
			System.out.println("Day:"+(i));
			System.out.println(pos);
		}else if(pos==(buildingcount-i)){
			System.out.println("Day:"+(i));
			System.out.println(pos);
		}else{
			System.out.println("");
		}
		}
		
		
}
		
	
	}


