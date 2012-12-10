package Combinatorics;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PascalTriangle {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.print("Type the number: "); int n = scan.nextInt();
		    Date today = Calendar.getInstance().getTime();
		    int [] dummy = {1};
			int[] result = pascalRecursive (n, dummy);
			System.out.println ("PascalTriangle result pt(" + n + ") = " + result);
		}
		
	}		
		
			public static int[] pascalRecursive(int n, int [] dummy) { 
				
		        int[] newArray = new int[n];  
		         
//		        if(height==width || width==0)  
//		            return 1;  
//		        else  
//		            return pascalRecursive(height-1,width)+pascalRecursive(height-1,width-1);  
//		    } 
//	}
 return null;	
	
}
}
