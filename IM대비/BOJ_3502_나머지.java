import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_3502_나머지 {
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			num %= 42;
			if(!set.contains(num)) {
				set.add(num);
			}
		}
		System.out.println(set.size());
	}

}
