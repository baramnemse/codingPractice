import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Median값을 빠르게 가져와야 속도 개선 가능
 * O(n)
 * 실시간 Median찾기 좋은설명 : https://o-tantk.github.io/posts/finding-median/
 * @author Wonjin Heo
 *
 */
public class FraudulentActivityNotifications {

	/**
	 * 중간값을 가져온다. 느린방법
	 */
	static double getMedian(int[] expenditure, int d, int start) {
		double average = 0.0;
		int temp[] = new int[d];
		System.arraycopy(expenditure, start, temp, 0, d);
		Arrays.sort(temp);
		if (d % 2 == 0) {
			average = (temp[d / 2] + temp[d / 2 - 1]) / 2.0;
		} else {
			average = temp[d / 2];
		}
		return average;
	}

	/**
	 * 중간값을 가져온다. 빠른방법
	 * @param frequencyArray
	 * @param d
	 * @return
	 */
	static double getMedianFast(int[] frequencyArray, int d) {
		int findIndex1 = d / 2;
		int findIndex2 = d / 2 + 1;
		// 짝수
		if (d % 2 == 0) {
			return (find(frequencyArray, findIndex1) + find(frequencyArray, findIndex2)) / 2D;
		} else {
			// 홀수
			return (find(frequencyArray, findIndex2));
		}
	}

	static int find(int[] frequencyArray, int d) {
		int sum = 0;
		for (int i = 0; i < frequencyArray.length; i++) {
			sum += frequencyArray[i];
			if (sum >= d) {
				return i;
			}
		}
		return 0;
	}

	static void updateFrequency(int frequencyArray[], int in, int out) {
		if (in >= 0) {
			frequencyArray[in]++;
		} else {
			// System.out.println(in);
		}
		if (out >= 0) {
			frequencyArray[out]--;
		} else {
			// System.out.println(out);
		}
	}

	static int activityNotifications(int[] expenditure, int d) {
		int leftPointer = 0;
		int rightPointer = 0;
		int alert = 0;
		int frequencyArray[] = new int[201];

		while (rightPointer + 1 < expenditure.length) {
			if (rightPointer - leftPointer + 1 < d && leftPointer < 1) {
				// 프리퀀시 테이블 업데이트
				updateFrequency(frequencyArray, expenditure[rightPointer], -1);
				rightPointer++;
				if (rightPointer - leftPointer + 1 == d) {
					updateFrequency(frequencyArray, expenditure[rightPointer], -1);
				}
			} else if (rightPointer - leftPointer + 1 == d) {
				double median = getMedianFast(frequencyArray, d);

				if (expenditure[rightPointer + 1] >= median * 2) {
					alert++;
				}
				leftPointer++;
				rightPointer++;
				// 프리퀀시 테이블 업데이트
				updateFrequency(frequencyArray, expenditure[rightPointer], expenditure[leftPointer - 1]);
			}
		}
		return alert;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileInputStream("in.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);
		System.out.println(result);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
