import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {
//		 int n = 1;
//		 int t = 1;
//		 int m = 5;
//		 String timetable[] = { "08:00", "08:01", "08:02", "08:03" };

		 int n = 2;
		 int t = 10;
		 int m = 2;
		 String timetable[] = { "09:10", "09:09", "08:00" };

//		int n = 2;
//		int t = 1;
//		int m = 2;
//		String timetable[] = { "09:00", "09:00", "09:00", "09:00" };
		getBoardingTime(n, t, m, timetable, 540);
	}

	static void getBoardingTime(int n, int t, int m, String[] timetable, int startTime) {
		int time = startTime;
		int answer = -1;
		List timeTableList = new ArrayList();
		Arrays.sort(timetable);
		for (String timeString : timetable) {
			String token[] = timeString.split(":");
			timeTableList.add(Integer.parseInt(token[0]) * 60 + Integer.parseInt(token[1]));
		}

		for (int i = 0; i < n; i++) {
			int leftRoom = m;
			for (int j = 0; j < m; j++) {
				if (timeTableList.size() < 1) {
				} else {
					if ((int) timeTableList.get(0) <= time) {
						timeTableList.remove(0);
						leftRoom--;
					}
				}
			}
			// 빈자리가 있는지 확인
			if (leftRoom > 0) {
				answer = time;
			}
			time = time + t * i;
			if (i == n - 1) {
				// System.out.println(leftRoom);
				if (answer == -1) {
					getBoardingTime(n, t, m, timetable, startTime - 1);
				} else {
					System.out.println(String.format("%02d:%02d", (answer) / 60, (answer) % 60));
				}

			}
		}
	}

}
