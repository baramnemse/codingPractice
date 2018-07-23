import java.util.Arrays;

/**
 * 손코딩후 구현해봄 머지 부분 사이즈계산, end-start+1, 소트할수 있는 조건 end>start 틀림
 * 
 * @author WONJIN
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int input[] = new int[] { 5, 4, 1, 3, 2 };
		mergeSort(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));
	}

	static void mergeSort(int input[], int start, int end) {
		if (end > start) {
			int pivot = (start + end) / 2;
			// 2등분한다.
			mergeSort(input, start, pivot);
			mergeSort(input, pivot + 1, end);
			// 합치면서 소트
			merge(input, start, pivot + 1, end);
		}
	}

	static void merge(int[] input, int start, int pivot, int end) {
		// 입력길이
		int size = end - start + 1;
		// 비교할 왼쪽 인덱스
		int left = start;
		// 비교할 오른쪽 인덱스
		int right = pivot;
		// 완성한 새블록의 길이
		int count = 0;
		// 머지한 결과저장소
		int result[] = new int[size];
		while (count < size) {
			// 작은것을 저장소에 넣는다.
			if (input[left] < input[right]) {
				result[count] = input[left];
				left++;
			} else {
				result[count] = input[right];
				right++;
			}
			count++;
			// 왼쪽의 모든것이 저장소에 들어간경우, 오른쪽 나머지를 저장소에 복사
			if (left >= pivot && right < end) {
				System.arraycopy(input, right, result, count, size - count);
				count += (size - count);
			}
			// 오른쪽의 모든것이 저장소에 들어간경우, 왼쪽 나머지를 저장소에 복사
			if (right > end && left < pivot) {
				System.arraycopy(input, left, result, count, size - count);
				count += (size - count);
			}
		}
		// input에 다시 복사
		System.arraycopy(result, 0, input, start, size);
	}

}
