import java.util.HashMap;
import java.util.Map;

public class DynamicKnapsack {
	static Map resultMatrix = new HashMap();

	public static void main(String[] args) {
		int result = getMaxValue(new int[][] { { 5, 10 }, { 4, 40 }, { 6, 30 }, { 3, 50 } }, 4, 10);
		System.out.println(result);

	}

	static int getMaxValue(int[][] input, int i, int maxWeight) {
		Object resultObject = resultMatrix.get(new int[] { i, maxWeight });
		// 캐시에 있는지 확인하여 있으면 캐시값을 리턴한다.
		if (resultObject != null) {
			return (int) resultObject;
		} else {
			// 캐시에 없을경우 점화식을 이용하여 해결한다.
			int weight = input[i - 1][0];
			int value = input[i - 1][1];
			// i가 1인 경우 점화식을 이용할 수 없으므로 직접 계산한다
			if (i == 1) {
				resultObject = (maxWeight / weight) * value;
				resultMatrix.put(new int[] { i, maxWeight }, (int) resultObject);
				return (int) resultObject;
			}

			// i 번째 무게를 더해도 최대값을 넘기지 않으므로 점화식으로 계산
			if (maxWeight >= weight) {
				return Math.max(getMaxValue(input, i - 1, maxWeight - weight) + value,
						getMaxValue(input, i - 1, maxWeight));
			} else {
				// 제한값을 넘치므로 i-1 결과값과 같다
				return (int) getMaxValue(input, i - 1, maxWeight);
			}
		}

	}

}
