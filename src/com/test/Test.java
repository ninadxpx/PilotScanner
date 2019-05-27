package com.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	
	public static boolean checkForChange( Map <Integer,Integer> counter , int amt ){
		
	
		if (amt == 0){
			return true;
		}
		else if (amt <= counter.get(0)){   //if return amt less than total balance
			
			if( amt >15){				
			
				int no = amt/15;
				//first check availability..
				
				if (counter.get(15) >= no ){
				counter.put(15, counter.get(15)-no);
				amt=amt- (15*no);
				checkForChange (counter,amt);	
				}
			}
			else if ( amt >10 ){				
			
				int no = amt/10;
				counter.put(10, counter.get(10)+no);
				amt=amt- (10*no);
				checkForChange (counter,amt);
				
			}
			
			
			 if (amt %15 ==0){
				int reqno = amt/15;
				
				int availno = counter.get(15);
				
				if (availno>=reqno){
				counter.put(15, counter.get(15)-reqno );				
				return true;
				}
				else {
					return false;
				}
				
				
			}
			else if (amt %10 ==0){
				int no = amt/10;
				int availno =counter.get(10);
				
				if (availno>=no){
				counter.put(10, counter.get(10)-no );
				return true;
				}
				else{
					return false;
				}
				
			}
			else if (amt %5 ==0){
	            
				int no = amt/5; 
				int availno = counter.get(5);
				
				if (availno>=no){
				counter.put(amt, counter.get(5)-no );
				return true;
				}
				else {
					return false;
				}
			}
			
		}
		else{		
		     return false;
		}
		return false;
	
	
	}
	
	// 5$ burger problem
	public static void test(int [] custs){
		
        Map <Integer,Integer> counter = new HashMap<>();	    
	    counter.put(5, 0);
	    counter.put(10, 0);
	    counter.put(15, 0);
	    counter.put(50, 0);
	
	    counter.put(0, 0); //total balance		
		
		for(int amt : custs){
			
			counter.put(0, counter.get(0)+amt);	
			counter.put(amt, counter.get(amt)+1);	
			
			System.out.println(" Customer has paid "+amt+ " $" );
			if (checkForChange(counter, amt-5)){	
		
		          System.out.println(" Transaction successfull");
		          counter.put(0, counter.get(0)-(amt-5));
		    
			}
			else {
				System.out.println("Sorry , Change not available ");
				counter.put(0, counter.get(0)-amt);	
				counter.put(amt, counter.get(amt)-1);	
			}
			System.out.println(counter);	
			System.out.println();	
			
		}
		
		System.out.println("At the END ");
		System.out.println(counter);
	}

	public static void main(String[] args) {		
		
		int [] custs = {5,10,5,10,10,10};

	    test(custs);
	    
		
	}

}
