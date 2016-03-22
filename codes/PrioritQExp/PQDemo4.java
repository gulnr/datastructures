

	import java.util.Comparator;
	import java.util.PriorityQueue;

	public class PQDemo4 {

		static class PQsort implements Comparator<Integer> {

			public int compare(Integer n1, Integer n2) {
				return n2 - n1;
			}
		}
		public static void main(String[] args) {
			int[] ia = { 21, 52, 13, 17, 67, 94, 81 };
			PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
			for (int x : ia) {
				pq1.offer(x);				
			}
			while (!pq1.isEmpty())
				System.out.print(pq1.poll() + " ");
			
			System.out.println(" ");

			PQsort pqs = new PQsort();
			PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs);

			for (int x : ia) {
				pq2.offer(x);	
			}

			System.out.println("size " + pq2.size());
			System.out.println("peek " + pq2.peek());
														
			System.out.println("size " + pq2.size());
			System.out.println("poll " + pq2.poll());
																										
			System.out.println("size " + pq2.size());
			for (int x : ia) {
				System.out.print(pq2.poll() + " ");
			}
			System.out.println("  son!");
		}
	}


