package Combinatorics;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss.SS");
		Scanner in = new Scanner(System.in);

//		    0,\;1,\;1,\;2,\;3,\;5,\;8,\;13,\;21,\;34,\;55,\;89,\;144,

		while (true) {
			System.out.print("Type the number: "); long n = (long) in.nextInt();
		    Date today = Calendar.getInstance().getTime();
		    String dateStr = formatter.format(today); System.out.println("Local time: " + dateStr);
			long result = fibonacci (n);
			System.out.println ("Fibonacci result fib(" + n + ") = " + result);
		    today = Calendar.getInstance().getTime();
		    dateStr = formatter.format(today); System.out.println("Local time: " + dateStr);
			long []result2 = linearFib (n);
			System.out.println ("Fibonacci result lineraFib(" + n + ") = " + result2[0]);
		    today = Calendar.getInstance().getTime();
		    dateStr = formatter.format(today); System.out.println("Local time: " + dateStr);

		}
	}

	public static long fibonacci (long n) {
		if (n == 0)	{return 0l;
		} else if (n == 1) { return 1l;
		} else {return (fibonacci(n-1) + fibonacci (n-2));}
	}
	
	public static long[] linearFib (long n) {
		if (n <= 1)	{
			long []ret = {n, 0};
			return ret;}
		else {
			long [] prev = linearFib(n-1);
			long [] ret = {prev[0]+prev[1], prev[0]};
			return (ret);
		}
	}
}

