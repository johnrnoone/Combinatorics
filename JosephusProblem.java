package Combinatorics;

public class JosephusProblem {

/*************************************************************************
 *  Compilation:  javac Josephus.java
 *  Execution:    java Josephus M N
 *  Dependencies: Queue.java
 *
 *  Solves the Josephus problem.
 *
 *  % java Josephus 5 9
 *  5 1 7 4 3 6 9 2 8 
 *
 *************************************************************************/

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        // initialize the queue
        Queue q = new Queue();
        for (int i = 1; i <= N; i++)
            q.enqueue(i);

        q.printList();
        int loopCount = 0;
        
        while (!q.isEmpty()) {
        	loopCount++;
            for (int i = 0; i < M - 1; i++)
                q.enqueue(q.dequeue());
//            System.out.print(q.dequeue() + " ");         System.out.println();
//            System.out.print("After loop "+loopCount+": "); q.printList();
        } 
        System.out.println();
    }
}


