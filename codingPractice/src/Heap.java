import java.util.PriorityQueue;

public class Heap {

	public static void main(String[] args) {
		PriorityQueue heap = new PriorityQueue();
		heap.add(2);
		heap.add(1);
		heap.add(3);
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}

}
