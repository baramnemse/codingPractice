import java.util.ArrayList;
import java.util.List;

public class BookSchedule {
	public static void main(String[] args) {
		int input[] = new int[] { 14, 10, 3, 8, 4, 12, 5, 9, 2, 4, 11, 7, 10, 24 };
		solve(input, 8);
	}

	private static void solve(int[] input, int day) {
		// 평균값을 구한다.
		int average = 0;
		for (int i : input) {
			average += i;
		}
		average = average / day;
		int candidateSum = 0;
		for (int i = 0; i < input.length; i++) {
			List schedule = new ArrayList();
			candidateSum = 0;
			int j = 0;
			// 평균값 보다 작은 후보를 뽑는다.
			do {
				candidateSum += input[i + j];
				schedule.add(i + j);
				j++;
			} while (candidateSum < average && i + j < input.length);
			// 후보와 평균값이 차가 후보+다음 페이지와 평균값의 차이를 계산하여 작은쪽으로 후보를 선택한다.
			if (i - 1 < input.length) {
				int candidate1 = Math.abs(candidateSum - average);
				int candidate2 = Math.abs((candidateSum - input[i + j - 1]) - average);
				if (candidate2 < candidate1) {
					// 마지막에 추가한 쳅터를 뺀다.
					schedule.remove(schedule.size() - 1);
				}
				i = i + schedule.size() - 1;
				System.out.println(schedule);
			}
		}

	}

}
