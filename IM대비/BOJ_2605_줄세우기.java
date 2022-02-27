import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	static int N;
	static List<Integer> list = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i=1; i<=N; i++) {
			int num = sc.nextInt();
			if(i==1)
				list.add(i);
			list.add(list.size()-num, i);
		}
		
		for(int i=1; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
