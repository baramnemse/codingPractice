import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		System.out.println(getRunningTime(3, new String[] { "Jeju", "Pangyo",
				"Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork",
				"LA" }));
		System.out.println(getRunningTime(0, new String[] { "Jeju", "Pangyo",
				"Seoul", "NewYork", "LA" }));
		System.out.println(getRunningTime(5, new String[] { "Jeju", "Pangyo",
				"Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome",
				"Paris", "Jeju", "NewYork", "Rome" }));

	}

	/**
	 * LRU
	 * @param i
	 * @param input
	 * @return
	 */
	private static int getRunningTime(int i, String input[]) {
		int time = 0;
		int runningTime = 0;
		Map cache = new HashMap();
		for (String city : input) {
			Object cacheResult = cache.get(city);
			if (cacheResult != null) {
				// 캐시 시간만 업데이트
				runningTime++;
			} else {
				// 가장 오래된 캐시 제거
				if (cache.size() >= i) {
					int oldTime = Integer.MAX_VALUE;
					String doomKey = null;
					Set set = cache.keySet();
					for (Object key : set) {
						if ((int) cache.get(key) < oldTime) {
							oldTime = (int) cache.get(key);
							doomKey = (String) key;
						}
					}
					cache.remove(doomKey);
				}
				runningTime += 5;
			}
			cache.put(city, time);
			time++;
		}
		return runningTime;
	}
	// LRU(least recently used) 오래된것 중 안쓰는것 삭제
	// FIFO(first in first out) 오래된 데이터 삭제
	// LFU(least frequently used) 가장 안쓰는것 삭제

}
