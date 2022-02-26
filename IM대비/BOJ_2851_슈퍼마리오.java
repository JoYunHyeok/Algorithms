import java.util.Scanner;

public class BOJ_2851_슈퍼마리오 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tmp = 0;
		int sum = 0;
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			tmp = sum;
			sum += num;
			if(sum >= 100)
				break;
		}
		
		if(sum-100 <= 100-tmp) System.out.println(sum);
		else System.out.println(tmp);
		
	}

}
