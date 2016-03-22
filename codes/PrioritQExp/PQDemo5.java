
	import java.util.*;

	public class PQDemo5 {

	   public static void main(String[] args) {
	       // bir PriorityQueue yarat
	       PriorityQueue<Double> p = new PriorityQueue<Double>();
	       // kuyruða öðe ekle
	       p.add(new Double(100));
	       p.add( 23.47);
	       p.add(new Double(13));
	       p.add(new Double(47));
	       p.add(new Double(25));
	       p.add(new Double(16));
	       while(p.size()>0)
	       System.out.println("Kuyruðun baþý : " + p.poll());
	   }
	}



