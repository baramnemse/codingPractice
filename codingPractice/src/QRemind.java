import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QRemind {
	public static void main(String[] args) {
		int input[] = { 66, 10, 1, 34, 5, -10, 44, 23 };
		int size = input.length;
		sort(input, 0, size - 1);
		System.out.println(Arrays.toString(input));

	}

	static void swap(int input[], int start, int end) {
		int temp = input[start];
		input[start] = input[end];
		input[end] = temp;
	}

	static void sort(int input[], int start, int end) {
		final int pivot = (start + end) / 2;
		if (end > start) {
			sort(input, start, pivot);
			sort(input, pivot + 1, end);
			merge(input, start, end, pivot + 1);
		}
	}

	static void merge(int input[], int start, int end, int pivot) {
		int size = end - start + 1;
		int result[] = new int[size];
		int left = start;
		int right = pivot;
		int count = 0;

		while (count < size) {
			if (input[left] < input[right]) {
				result[count] = input[left];
				left++;
			} else {
				result[count] = input[right];
				right++;
			}
			count++;
			// 왼쪽만 남았는지 확인
			if (right >= end && count < size) {
				System.arraycopy(input, left, result, count, size - count);
				count += (size - count);
			}

			if (left >= pivot && count < size) {
				System.arraycopy(input, right, result, count, size - count);
				count += (size - count);
			}
		}
		System.arraycopy(result, 0, input, start, size);
	}
}
