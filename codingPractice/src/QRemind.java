import java.util.HashMap;
import java.util.Map;

public class QRemind {
	static Map resultMatrix = new HashMap();

	public static void main(String[] args) {
		int result = getMaxValue(new int[][] { { 5, 10 }, { 4, 40 }, { 6, 30 },
				{ 3, 50 } }, 4, 10);
		System.out.println(result);

	}

	static int getMaxValue(int[][] input, int i, int maxWeight) {
		Map resultMap = new HashMap();
		// 캐시에 있는지 확인
		Object result = resultMap.get(new int[i][maxWeight]);
		if (result != null) {
			return (int) result;
		} else {
			int weight = input[i - 1][0];
			int value = input[i - 1][1];
			// i가 1인 경우 계산필요
			if (i == 1) {
				return (maxWeight / weight) * value;
			}
			// 캐시에 없는 경우 재귀식으로 해결

			if (maxWeight >= weight) {
				// 새로 계산한값과 이전값중에 큰값이 이윤을 최대화한 값이다
				return Math.max(getMaxValue(input, i - 1, maxWeight - weight)
						+ value, getMaxValue(input, i - 1, maxWeight));
			} else {
				// 무게가 초과하므로 이전 값이 최고다
				return getMaxValue(input, i - 1, maxWeight);
			}
		}
	}
}
