import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QRemind {
	public static void main(String[] args) {
		int input[] = { 66, 10, 1, 34, 5, -10, 44, 23 };
		// quickSort(input, 0, input.length - 1);
		mergeSort(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));

	}

	static void swap(int input[], int start, int end) {
		int temp = input[start];
		input[start] = input[end];
		input[end] = temp;
	}

	static void quickSort(int input[], int start, int end) {
		if (end > start) {

			int pivot = (start + end) / 2;
			int left = start;
			int right = end;

			// 교차유도를 위해 같은것도 포함
			if (left <= right) {
				// 왼쪽에서 큰것 찾기
				while (input[left] < input[pivot]) {
					left++;
				}
				// 오른쪽에서 작은것 찾기
				while (input[right] > input[pivot]) {
					right--;
				}
				if (left <= right) {
					swap(input, left, right);
					left++;
					right--;
				}
			}
			// 교차된상태로 루프를 빠져나오기때문에 start right left end 순이 된다.
			quickSort(input, start, right);
			quickSort(input, left, end);
		}
	}

	static void mergeSort(int input[], int start, int end) {
		if (end > start) {
			int pivot = (start + end) / 2;
			// 왼쪽과 오른쪽을나눔
			mergeSort(input, start, pivot);
			mergeSort(input, pivot + 1, end);
			// 합치면서 소트
			merge(input, start, end, pivot + 1);
		}
	}

	static void merge(int input[], int start, int end, int pivot) {
		// 결과저장소
		int result[] = new int[end - start + 1];
		int size = end - start + 1;
		// 저정소에 저장한양
		int count = 0;
		int left = start;
		int right = pivot;
		while (count < size) {
			// 왼쪽에 작은것이 있다
			if (input[left] < input[right]) {
				result[count] = input[left];
				left++;
			} else {
				result[count] = input[right];
				right++;
			}
			count++;
			// 왼쪽만남은 경우 확인
			if (right > end && count < size) {
				System.arraycopy(input, left, result, count, size - count);
				count += (size - count);
			}
			// 오른쪽만남은 경우 확인
			if (left > pivot && count < size) {
				System.arraycopy(input, right, result, count, size - count);
				count += (size - count);
			}
		}
		// 최종결과 복사
		System.arraycopy(result, 0, input, start, size);
	}
}
