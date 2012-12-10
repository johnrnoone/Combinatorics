package Combinatorics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class nChooseR {

	public static void main (String[] args) {

		Scanner scan = new Scanner (System.in);

		ArrayList<ArrayList<Integer>> testArray = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(1); 		
		primes.add(2); 
		primes.add(3); 
		primes.add(4);
//		primes.add(2); 		
//		primes.add(2); 
//		primes.add(2); 
//		primes.add(3);
		printProduct (primes);
		testArray = permuteArrayList(primes);
		System.out.print("Call printMultiples on results of permuteArrayList()...");
		printMultiples (testArray);
		System.out.print("Continue?"); scan.nextLine(); System.out.println();


		ArrayList<ArrayList<Integer>> newArray = nChooseR ( primes, 2);
		System.out.print("Call printMultiples on results of nChooseR(2)...");
		printMultiples (newArray);

		//		testArray.addAll(newArray);
		//		System.out.println ("Calling nChooseR, 3");
				newArray = nChooseR ( primes, 3);
				System.out.println("Call printMultiples on results of nChooseR(3)...");
				printMultiples (newArray);
		//		testArray.addAll(newArray);
		//		printMultiples (testArray);
		System.out.print("Continue?"); scan.nextLine(); System.out.println();
		
	}

	static ArrayList<ArrayList<Integer>> nChooseR (ArrayList<Integer> primes, Integer r) {
		Scanner scan = new Scanner (System.in);
		Integer n = primes.size();
		System.out.println ("nChooseR gets n, r = " + n + ", " + r);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> permutedPrimes = permuteArrayList(primes);

		for (int i = 0; i<permutedPrimes.size(); i++) {
			ArrayList<Integer> candidate = new ArrayList<Integer>();
			for (int j = 0; j<r; j++) {
			candidate.add(permutedPrimes.get(i).get(j));
			}
			if (!isDuplicate (candidate, results)) results.add(candidate);
		}
		return results;
	}

	static void printMultiples (ArrayList<ArrayList<Integer>> multiples) {
		Integer product = new Integer(1);
		System.out.println ("printMultiples, list of factor lists: ("+multiples.size()+")");
		for (int i = 0; i<multiples.size(); i++) {
			ArrayList<Integer> factors = multiples.get(i);
			printProduct (factors);
		}
	}

	static void printProduct (ArrayList<Integer>factors) {
		Integer product = new Integer(1);
		System.out.print ("printProduct (product of "+factors.size()+" factors): ");
		for (int i = 0; i<factors.size(); i++) {
			product = product * factors.get(i);
			if (i==factors.size()-1) System.out.print (factors.get(i));
			else System.out.print (factors.get(i) + " x ");
		}
		System.out.println (" = " + product);
	}

	static void printFactors (ArrayList<Integer>factors) {
		System.out.print ("printFactors: ");
		for (int i = 0; i<factors.size(); i++) {
			if (i==factors.size()-1) System.out.print (factors.get(i));
			else System.out.print (factors.get(i) + " x ");
		}
		System.out.println ();
	}
	
	static ArrayList<ArrayList<Integer>> permuteArrayList (ArrayList<Integer> factors) {
//		System.out.print ("permuteArrayList gets factors: "); printFactors(factors);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if (factors.size() <= 1) {
			results.add(factors);
		} else {
			ArrayList<Integer> newFactors = new ArrayList<Integer>();
			for (int i = 0; i<factors.size(); i++) {
				newFactors = new ArrayList<Integer>();
				Integer thisFactor = factors.get(i); newFactors.addAll(factors); newFactors.remove(i);
//				System.out.print ("permuteArrayList gets newFactors: "); printFactors(newFactors);
				ArrayList<ArrayList<Integer>> tempList = permuteArrayList (newFactors);
				ArrayList<Integer> addRec = new ArrayList<Integer>();
				for (int j = 0; j<tempList.size(); j++){
					addRec = new ArrayList<Integer>();
				 addRec.add(thisFactor); addRec.addAll(tempList.get(j));
					results.add(addRec);
				}
			}
		}
		return results;
	}
	static boolean isDuplicate (ArrayList<Integer>candidates, ArrayList<ArrayList<Integer>>testVectors) {
		Collections.sort(candidates);
		for (int i = 0; i<testVectors.size(); i++) {
			ArrayList<Integer>factors = testVectors.get(i);
			boolean result = compareLists (candidates, factors);
			if (result) return true;
		}
		return false;
	}

	static boolean compareLists (ArrayList<Integer>candidateA, ArrayList<Integer>candidateB){
		if (candidateA.size() != candidateB.size()) return false;
		Collections.sort(candidateB);
		for (int j=0; j<candidateA.size(); j++){
			if (candidateA.get(j) != candidateB.get(j)) return false;
		}
		return true;
	}
}


