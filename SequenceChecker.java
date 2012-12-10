package Combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.math.BigInteger;


public class SequenceChecker {

	public static final BigInteger bigMaxInt = BigInteger.valueOf(Integer.MAX_VALUE);
	public static final BigInteger bigMinInt = BigInteger.valueOf(Integer.MIN_VALUE);

	public static void main (String[] args) {
//		System.out.println ("bigMaxInt = " + bigMaxInt); 
//		System.out.println ("bigMinInt = " + bigMinInt); 

		List<Integer> intList1 = new ArrayList<Integer>();
		intList1.add(-2); intList1.add(1); intList1.add(4);
		intList1.add(7); intList1.add(10);
		intList1.add(13); intList1.add(16); //intList1.add(19);
		//intList1.add(7); intList1.add(10);
		//intList1.add(13); intList1.add(16); intList1.add(19);

		System.out.print ("intList1: ");
		for (int item : intList1) {
			System.out.print (item + ", ");
		}
		System.out.println ();
		
		Integer answer1 = guessNextNumber (intList1);
		System.out.println ("guessNextNumber returns answer1 = " + answer1);
		System.out.println ();

		List<Integer> intList2 = new ArrayList<Integer>();
		//intList2.add(-2); intList2.add(-6); intList2.add(-18); intList2.add(-54);
				intList2.add(0); intList2.add(2); intList2.add(6); intList2.add(18); intList2.add(54);

		//		intList2.add(-2); intList2.add(-6);
		//		intList2.add(-18); //intList2.add(-54);
		//intList2.add(2); intList2.add(6);
		//intList2.add(18); intList2.add(54);
		//intList2.add(2000); intList2.add(200000);
		//intList2.add(20000000); intList2.add(2000000000);

		System.out.print ("intList2: ");
		for (int item : intList2) {
			System.out.print (item + ", ");
		}
		System.out.println ();

		Integer answer2 = guessNextNumber (intList2);
		System.out.println ("guessNextNumber returns answer2 = " + answer2);
	}

	static Integer guessNextNumber(List<Integer> sequence) {
		try {
			Integer p = 0;  Integer q = 0;
			if (sequence.size() < 2){
				System.out.println ("Undetermined sequence, insufficient elements."); return 0;
			} else {
				p = sequence.get(0); 
				Integer listSize = sequence.size(); 
				Integer lastValue = sequence.get(listSize-1);

				if (lastValue == p + (sequence.get(1) - p)*(listSize-1)) {
					q = sequence.get(1) - p;
					BigInteger testValue = BigInteger.valueOf(lastValue+q);
					checkOverflow(testValue);
					System.out.println ("Arithmetic sequence, p = "+ p + ", q = "+ q); 
					return lastValue+q;
				} else if (lastValue == p * Math.pow (sequence.get(1) / p, listSize-1)) {
					q = sequence.get(1) / p;
					BigInteger bigLastValue = BigInteger.valueOf(lastValue);
					BigInteger bigQ = BigInteger.valueOf(q);
					BigInteger testValue = bigLastValue.multiply(bigQ);
					checkOverflow(testValue);
					System.out.println ("Geometic sequence, p = "+ p + ", q = "+ q); 
					return lastValue*q;
				} else {
					System.out.println ("Undetermined sequence, p = "+ p + ", q = "+ q); return lastValue;	
				}
			}
		} catch (ArithmeticException e) {
			System.out.println ("Undetermined sequence due to Integer overflow.");
			return 0;
		}
	}

	public static BigInteger checkOverflow(BigInteger testValue) throws ArithmeticException {
		if (testValue.compareTo(bigMaxInt) == 1 || testValue.compareTo(bigMinInt) == -1) {
			throw new ArithmeticException("Integer overflow");
		}
		return testValue;
	}
}
