import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		int input[] = new int[] { 2, 2, 3, 7 };
		System.out.println(s.equal(input));
	}

	// Complete the equal function below.
	static int equal(int[] cookies) {
		Arrays.sort(cookies);

		int sum = Integer.MAX_VALUE;

		for (int base = 0; base < 3; base++) {
			int current_sum = 0;
			for (int i = 0; i < cookies.length; i++) {
				int delta = cookies[i] - cookies[0] + base;
				current_sum += (int) delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;
			}
			sum = Math.min(current_sum, sum);
		}

		return sum;

	}

	// public static void main(String[] args) {
	// Solution s = new Solution();
	// System.out.println(s.solution((int)(Math.random()*Integer.MAX_VALUE)));
	// }
	//
	// public int solution(int N) {
	// String result = Integer.toBinaryString(N);
	// System.out.println(result);
	//
	// int startIndex = -1;
	// int endIndex = -1;
	// int answer = 0;
	//
	// for (int i = 0; i < result.length(); i++) {
	// if (result.charAt(i) == '1') {
	// if (startIndex != -1) {
	// endIndex = i;
	// if (endIndex - startIndex - 1 > answer) {
	// answer = endIndex - startIndex - 1;
	// }
	// }
	// startIndex = i;
	// }
	// }
	// return answer;
	// }
	// public static void main(String[] args) {
	// Solution s = new Solution();
	// System.out.println(s.solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }));
	// }
	// public int[] solution(int N, int[] A) {
	// int counter[] = new int[N];
	// int n = A.length;
	// int max=-1,current_min=0;
	//
	// for(int i=0;i<n;i++){
	// if(A[i]>=1 && A[i]<= N){
	// if(counter[A[i] - 1] < current_min) counter[A[i] - 1] = current_min;
	// counter[A[i] - 1] = counter[A[i] - 1] + 1;
	// if(counter[A[i] - 1] > max) max = counter[A[i] - 1];
	// }
	// else if(A[i] == N+1){
	// current_min = max;
	// }
	// }
	// for(int i=0;i<N;i++){
	// if(counter[i] < current_min) counter[i] = current_min;
	// }
	// return counter;
	// }

	// public int[] solution(int N, int[] A) {
	// int result[] = new int[N];
	// int maxNum = 0;
	//
	// for (int i = 0; i < A.length; i++) {
	// if (A[i] > N) {
	// Arrays.fill(result,maxNum);
	// } else {
	// if (result[A[i] - 1] + 1 > maxNum) {
	// maxNum = result[A[i] - 1] + 1;
	// }
	// result[A[i] - 1] = result[A[i] - 1] + 1;
	// }
	// }
	// return result;
	// }

	// public static void main(String[] args) {
	// Solution s = new Solution();
	// System.out.println(s.solution(10, 85, 30));
	// }
	//
	// public int solution(int X, int Y, int D) {
	// double result = (Y * 1.0 - X) / D * 1.0;
	// return (int) Math.ceil(result);
	// }
}