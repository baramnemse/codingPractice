
/**
 * 중간값구하기
 * 
 * @author WONJIN
 *
 */
public class FindMedian {
	// Complete the findMedian function below.
	static int findMedian(int[] arr) {
		int[] frequencyArray = new int[20001];
		int index = arr.length / 2 + 1;
		// frequency
		for (int i = 0; i < arr.length; i++) {
			int value = arr[i];
			frequencyArray[10000 + value]++;
		}

		int sum = 0;
		for (int i = 0; i < frequencyArray.length; i++) {
			sum += frequencyArray[i];
			if (sum >= index)
				return i - 10000;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
