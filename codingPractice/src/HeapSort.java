import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int input[] = new int[] { 2, 4, 5, 6, 1 };
		// 힙구조로 만든다. length/2부터 힙구조로 만들어도 전체가 적용받는다. 리프노드는 수행할 필요가 없기 때문이다.
		for (int i = input.length / 2; i >= 0; i--) {
			heapify(input, i, input.length);
		}
		// 같은 레벨의 리프노드중 어떤것이 가장 작은지는 모르나 루트는 제일크다는 성질 이용
		for (int i = input.length - 1; i >= 0; i--) {
			//가장큰것을 뒷쪽으로 보낸다.
			swap(input, 0, i);
			//루트부터 다시 힙구조로 만들어준다. size가 i인 이유는 리프노드에 큰것이 간상태이기 때문이다.
			heapify(input, 0, i);
		}
		System.out.println(Arrays.toString(input));

	}

	static void swap(int input[], int start, int end) {
		int temp = input[start];
		input[start] = input[end];
		input[end] = temp;
	}

	static public void heapify(int[] input, int parentIndex, int size) {

		int leftIndex = 2 * parentIndex + 1;
		int rightIndex = 2 * parentIndex + 2;
		int largest = parentIndex;
		// 왼쪽 자식이 부모보다 큰 경우
		if (leftIndex < size && input[leftIndex] > input[largest]) {
			largest = leftIndex;
		}
		// 오른쪽 자식이 부모보다 큰 경우
		if (rightIndex < size && input[rightIndex] > input[largest]) {
			largest = rightIndex;
		}
		// 가장 큰것이 부모가 아닐 경우
		if (largest != parentIndex) {
			swap(input, largest, parentIndex);
			heapify(input, largest, size);
		}

	}

}
