import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 아무것도 안하는 코드를 넣어도 시간초과됨 시스템 버그로 보임
 * @author WONJIN
 *
 */
public class FrequencyQueries {

	// public static void main(String[] args) {
	// List input = new ArrayList();
	// List list1= new ArrayList();
	// list1.add(1);
	// list1.add(1);
	// List list2= new ArrayList();
	// list2.add(2);
	// list2.add(2);
	// List list3= new ArrayList();
	// list3.add(3);
	// list3.add(2);
	// List list4= new ArrayList();
	// list4.add(1);
	// list4.add(1);
	// List list5= new ArrayList();
	// list5.add(1);
	// list5.add(1);
	// List list6= new ArrayList();
	// list6.add(2);
	// list6.add(1);
	//
	// input.add(list1);
	// input.add(list2);
	// input.add(list3);
	// input.add(list4);
	// input.add(list5);
	// input.add(list6);
	// List result=freqQuery(input);
	// System.out.println(result);
	// }

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input09.txt")));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		long current = System.currentTimeMillis();
		List<Integer> ans = freqQuery(queries);
		System.out.println(System.currentTimeMillis() - current);
		bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}

	/**
	 * 일부 케이스 fail, 연산복잡도 만족 못함
	 * 
	 * @param queries
	 * @return
	 */
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> result = new ArrayList();
		Map<Integer, Integer> freqMap = new HashMap();
		for (List<Integer> query : queries) {
			switch (query.get(0)) {
			case 1: {
				Integer value = freqMap.get(query.get(1));
				if (value == null) {
					freqMap.put(query.get(1), 1);
				} else {
					freqMap.put(query.get(1), value + 1);
				}
			}
				break;
			case 2: {
				Integer value = freqMap.get(query.get(1));
				if (value != null) {
					if (value > 0) {
						freqMap.put(query.get(1), value - 1);
					}
				}
			}
				break;
			case 3:
//				if (freqMap.values().contains(query.get(1))) {
//					result.add(1);
//
//				} else {
//					result.add(0);
//				}
				break;
			}
		}
		return result;
	}

}
