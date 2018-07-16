import java.util.ArrayList;
import java.util.List;

public class Sort {

	public static void main(String[] args) {
		int input[] = { 66, 10, 1, 34, 5, -10, 44, 23 };
		// int result[] = sortBubble(input);
		// int result[] = sortSelection(input);
		// sortQuick(input, 0, input.length - 1);
		sortMerge(input, 0, input.length - 1);
		for (int sortedItem : input) {
			System.out.println(sortedItem);
		}
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

	/**
	 * 2개씩 윈도우 비교/교환
	 * 
	 * @param input
	 * @return
	 */
	static int[] sortBubble(int input[]) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length - (i + 1); j++) {
				if (input[j] > input[j + 1]) {
					int tmp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = tmp;
				}
			}
		}

		return input;
	}

	/**
	 * 가장 큰것을 뒤에다 두는 정렬
	 * 
	 * @param input
	 * @return
	 */
	static int[] sortSelection(int input[]) {
		int maxIndex = -1;
		int maxNum = -1;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length - (i); j++) {
				if (input[j] > maxNum) {
					maxIndex = j;
					maxNum = input[j];
				}
			}
			// 뒤에 큰수를 둔다.
			if (maxIndex != -1) {
				int tmp = input[input.length - (i + 1)];
				input[input.length - (i + 1)] = input[maxIndex];
				input[maxIndex] = tmp;
				maxIndex = -1;
				maxNum = -1;
			}
		}

		return input;
	}

	/**
	 * n 번째를 기준으로 비교하여 위치를 변경하고 n은 입력길이 만큼 증가
	 * 
	 * @param input
	 * @return
	 */
	static int[] sortInsertion(int input[]) {
		for (int i = 0; i < input.length - 1; i++) {
			int keyIndex = i + 1;
			int keyValue = input[keyIndex];
			for (int j = 0; j < keyIndex; j++) {
				if (input[j] > keyValue) {
					keyValue = input[j];
					input[j] = input[keyIndex];
					input[keyIndex] = keyValue;
				}
			}
		}

		return input;
	}

	public static void sortMerge(int arr[], int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			sortMerge(arr, l, mid);
			sortMerge(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	public static void merge(int arr[], int l, int mid, int r) {
		int leftIndex = l;
		int rightIndex = mid + 1;
		if (r > l) {
			int resultCount = 0;
			int result[] = new int[r - l + 1];
			while (resultCount < r - l + 1) {
				// 좌우측에 가장 작은 것끼리 비교 가장 작은것을 새 배열에 넣는다.
				if (arr[leftIndex] < arr[rightIndex]) {
					result[resultCount] = arr[leftIndex];
					resultCount++;
					leftIndex++;
				} else {
					result[resultCount] = arr[rightIndex];
					resultCount++;
					rightIndex++;
				}
				if ((r - l + 1) != resultCount) {
					// 다병합후 우측에 남아있는경우
					if (leftIndex > mid && rightIndex < r) {
						System.arraycopy(arr, rightIndex, result, resultCount, r - rightIndex + 1);
						resultCount += (r - rightIndex + 1);
					}
					// 다합병후 좌측에 남아있는겨우
					if (rightIndex > r && leftIndex < mid + 1) {
						System.arraycopy(arr, leftIndex, result, resultCount, mid - leftIndex + 1);
						resultCount += (mid - leftIndex + 1);
					}
				}
			}
			System.arraycopy(result, 0, arr, l, r - l + 1);
		}
	}
}
