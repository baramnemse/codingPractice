import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/editorial?h_l=playlist&slugs%5B%5D=interview&slugs%5B%5D=interview-preparation-kit&slugs%5B%5D=dictionaries-hashmaps
 * 
 * @author WONJIN
 *
 */
public class CountTriplets {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		long ans = fastCountTriplets(arr, r);
		System.out.println(ans);
		bufferedWriter.write(String.valueOf(ans));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	/**
	 * O(n^3) 안좋은 알고리즘
	 * 
	 * @param arr
	 * @param r
	 * @return
	 */
	static long countTriplets(List<Long> arr, long r) {
		long count = 0;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				for (int k = j + 1; k < arr.size(); k++) {
					if (arr.get(j) / arr.get(i) == r && arr.get(k) / arr.get(j) == r) {
						System.out.println(arr.get(i) + " " + arr.get(j) + " " + arr.get(k));
						System.out.println(i + " " + j + " " + k);
						count++;
					}
				}
			}
		}

		return count;
	}

	/**
	 * 이해안감
	 * 
	 * @param arr
	 * @param r
	 * @return
	 */
	static long fastCountTriplets(List<Long> arr, long r) {
		if (arr.size() < 3) {
			return 0;
		}
		long cnt = 0;
		Map<Long, Long> map = new HashMap<>();
		Map<Long, Long> rMap = new HashMap<>();
		for (long n : arr) {
			if (n % r == 0) {
				long pre = n / r;
				Long cnt2 = rMap.get(pre);
				if (cnt2 != null)
					cnt += cnt2;

				Long cnt1 = map.get(pre);
				if (cnt1 != null)
					rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
			}
			map.put(n, map.getOrDefault(n, 0L) + 1);
		}
		return cnt;
	}

}
