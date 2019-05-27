package com.test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test2 {

	
	
	
	public static void main(String[] args) {
	
		
		int [] arr = {1,2,3,4,7,9,5};
		String [] sarr = {"a","b","c"};
		
		
		Stream stream = Arrays.stream(sarr);
		
		
	//	stream.collect(        );
		
		
		
		
		IntStream s = Arrays.stream(arr);
		
		//s.forEach(  (a)->System.out.println(a)  );
		
		
		Boolean b = s.anyMatch( a-> {  if(a==567){
									return true;
									}
							     return false;	});
		
		
		
     	System.out.println(b);
		
	}
}