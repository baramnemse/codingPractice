import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int input[] = new int[] { 5, 4, 1, 3, 2 };
		sort(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));

	}

	static void swap(int input[], int start, int end) {
		int temp = input[start];
		input[start] = input[end];
		input[end] = temp;
	}
	
	static public void sortQuick(int[] data, int start, int end) {
		// pivot 설정
		int s = start;
		int e = end;
		int pivot = data[(end + start) / 2];
		// 피봇보다 큰것과 작은것을 찾아 위치 교환
		while (e >= s) {
			while (data[s] < pivot) {
				s++;
			}
			while (data[e] > pivot) {
				e--;
			}
			if (e >= s) {
				swap(data, s, e);
				s++;
				e--;
			}
		}
		// 좌우 블럭을 다시 퀵소트
		if (end > s) {
			sortQuick(data, s, end);
		}
		if (e > start) {
			sortQuick(data, start, e);
		}
	}

	static void sort(int input[], int start, int end) {
		int pivot = (start + end) / 2;
		int pivotValue = input[pivot];
		int left = start;
		int right = end;
		// 교차를 유도하기 위해 같은 경우도 허용
		while (left <= right) {
			// 왼쪽에서 피봇보다 큰것을 찾는다.
			while (input[left] < pivotValue) {
				left++;
			}
			// 오른쪽에서 피봇보다 작은것을 찾느다.
			while (input[right] > pivotValue) {
				right--;
			}
			// 서로 위치를 바꾼다,교차를 유도하기 위해 같은 경우도 허용
			if (left <= right) {
				swap(input, left, right);
				left++;
				right--;
			}
		}
		if(right>start)
		sort(input, start, right);
		if(end>left)
		sort(input, left, end);
	}

}
