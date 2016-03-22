


import java.util.PriorityQueue;

/**
 * @author Chandan Singh
 */
public class PQDemo
{
		public static void main(String[] args)
    {
		    PriorityQueue<Request> queueExample = new PriorityQueue<>();
		    queueExample.offer(new Request("ABC", 2));
		    queueExample.offer(new Request("ABC", 5));
		    queueExample.offer(new Request("ABC", 1));
		    while(!queueExample.isEmpty())
		    		System.out.println(queueExample.poll());//remove and print the top element	   
		    
    }
		
}

