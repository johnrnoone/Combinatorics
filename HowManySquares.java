package Combinatorics;

import java.util.Scanner;

public class HowManySquares {
	
	public static void main (String[] args) {
		
		System.out.println ("This is HowManySquares");
		Scanner in = new Scanner (System.in);
		
		boolean stop = false;
		
		while (!stop) {
			System.out.print("Type the height: "); long height = (long) in.nextInt();
			System.out.print("Type the width: ");  long width  = (long) in.nextInt();
			long answer = countSquares (height, width);
			System.out.println("countSquares returns: " + answer);
		}
	}
		
	static private long countSquares (long h, long w) {
		if (h == w) {
			System.out.println ("countSquares returns 1");
			return 1;
		} else if (h < w) {
			System.out.println ("countSquares gets h,w = " + h + ", " + w + ", returns (1+countSquares(h,w-h)");
			return (1 + countSquares(h, w-h));
		} else {
			System.out.println ("countSquares gets h,w = " + h + ", " + w + ", returns (1+countSquares(h-w,w)");
			return (1 + countSquares(h-w, w));	
		}
	}

}
