package Combinatorics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

public class MagicNumber {
	public static void main(String[] args) {
		System.out.format("Local time: %tT", Calendar.getInstance()); System.out.println("");
		Scanner in = new Scanner(System.in);

		//	method1();
		//	method2();
		method3();

	}
	private static void method1() {
		Scanner in = new Scanner(System.in);

		ArrayList<Integer> magicNumbers = new ArrayList<Integer>();

		//998+1 = 999 and 999^2 = 998001, which is the original number.
		int count = 0;
		for (int i=310006; i<=998001; i++) {
			count++;
			//					System.out.println("testing i = " + i + ", upper = " + upper + ", lower = " + lower);
			int testValue = getTestValue (i); 
			//					System.out.println("testValue = " + testValue);
			if (i == testValue) {
				System.out.println ("magic number i = " + i + " testValue = " + testValue);
				magicNumbers.add(i);
				//System.out.println("Do you wish to continue?"); in.nextLine();
			}			
		}
		System.out.println ("iteration count = " + count);
		System.out.println ("magic numbers count = " + magicNumbers.size());
	}

	private static void method2 () {
		ArrayList<Integer> magicNumbers = new ArrayList<Integer>();
		int count = 0;
		for (int i=310; i<=998; i++) {
			for (int j = 0; j <=999; j++) {
				count++;
				int input = (i*1000) + j;
				int testValue = getTestValue (input);
				if (testValue > input) break;			
				if (input == testValue) {
					System.out.println ("magic number i = " + i + " testValue = " + testValue);
					magicNumbers.add(i);
				}
			}
		}
		System.out.println ("iteration count = " + count);
		System.out.println ("magic numbers count = " + magicNumbers.size());
	}

	private static int getTestValue (int input) {
		int upper = input / 1000; int lower = input - (upper*1000);
		return (upper+lower)*(upper+lower); 
	}

	private static void method3 () {
		ArrayList<Integer> magicNumbers = new ArrayList<Integer>();
		Iterator<Integer> it = magicNumbers.iterator();
		while (it.hasNext()) {
			System.out.println ("initially, it.next() = " + it.next());
		}

		int count = 5;
		System.out.println ("count ^ 2 = " + (count^2));
		System.out.println ("Math.pow(count,2) = " + Math.pow(count,2));


		count = 0;
		for (int i=0; i<=999; i++) {
			int testValue = (int) Math.pow (i, 2);
			int upperTest = testValue / 1000;
			int lowerTest = testValue - (upperTest * 1000);
			int upperLowerSquared = (int) Math.pow((upperTest + lowerTest), 2);
			if (testValue == upperLowerSquared) {
				System.out.println ("magic number i = " + i + " testValue = " + testValue);
				magicNumbers.add(i); count++;
			}
		}
		System.out.println ("iteration count = " + count);
		System.out.println ("magic numbers count = " + magicNumbers.size());
		it = magicNumbers.iterator();
		while (it.hasNext()) {
			int magic = it.next(); int magicSq = (int)Math.pow(magic, 2);
			System.out.println ("finally, it.next() = " + magic + ", magic number = " + magicSq);
		}
	}
}
