

	import java.util.Comparator;
	import java.util.PriorityQueue;
	import java.util.Queue;

	public class PQDemo3 {

		public static void main(String[] args) {
			// Comparator çift sayýlara öncelik veriyor
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20,
					new Comparator<Integer>() {
						public int compare(Integer i, Integer j) {
							int result = i % 2 - j % 2;
							if (result == 0)
								result = i - j;
							return result;
						}
					});
			// ters sýrada sayýlarý kuyruða ekle
			for (int i = 0; i < 20; i++) {
				pq.offer(20 - i);
			}
			// öðeleri Comparator'un sýrayla yazdýr
			for (int i = 0; i < 20; i++) {
				System.out.print("\t" + pq.poll());
			}
		}
	}


