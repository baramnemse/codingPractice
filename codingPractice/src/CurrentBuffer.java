import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 정렬을 위한 비교연산자 구현
 * @author Wonjin Heo
 *
 */
public class CurrentBuffer {

	public static void main(String[] args) {
		// input
		// 5
		// amy 100
		// david 100
		// heraldo 50
		// aakansha 75
		// aleksa 150
		// output
		// aleksa 150
		// amy 100
		// david 100
		// aakansha 75
		// heraldo 50
		
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
        

	}

}

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player left, Player right) {
		if (left.score > right.score)
			return -1;
		if (left.score < right.score)
			return 1;
		return left.name.compareTo(right.name);
	}

}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}