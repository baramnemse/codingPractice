import java.util.HashMap;
import java.util.Map;

public class DPFibonacci {
	static Map resultMatrix = new HashMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		resultMatrix.put(1L, 1L);
		resultMatrix.put(2L, 2L);

		System.out.println(getFibo(1));
		System.out.println(getFibo(2));
		System.out.println(getFibo(3));
		System.out.println(getFibo(11));
		System.out.println(getFibo(30));
	}

	static long getFibo(long n) {
		// 캐시확인
		if (resultMatrix.get(n) != null) {
			return (long) resultMatrix.get(n);
		} else {
			// 캐시에 없기 때문에 분활하여 계산
			long result = getFibo(n - 1) + getFibo(n - 2);
			resultMatrix.put(n, result);
			return result;
		}
	}

}
