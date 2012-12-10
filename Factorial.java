package Combinatorics;

import java.util.Calendar;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.print("Type the number: "); long n = (long) in.nextInt();
			System.out.format("Local time: %tT", Calendar.getInstance()); System.out.println("");
			long result = factorial (n);
			System.out.println ("Factorial result " + n + "! = " + result);
			System.out.format("Local time: %tT", Calendar.getInstance()); System.out.println("");
			int x = 4; int y = 10;			
			System.out.println ("x before swap = " + x + ", y before swap = " + y);
			x=x+y; y=x-y; x=x-y;
			System.out.println ("x after swap = " + x + ", y before swap = " + y);
		}

	}

	public static long factorial (long n) {
//		System.out.println ("factorial gets n = " + n);
		if (n == 0)	{ return 1l;
		} else {return n * factorial (n-1);
		}
	}
}
