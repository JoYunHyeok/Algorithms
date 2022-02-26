import java.util.Scanner;

public class BOJ_2810_컵홀더 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int seatCnt = sc.nextInt();
		String seat = sc.next();
		
		int cupCnt =0;
		for(int s=0; s<seat.length(); s++) {
			if(seat.charAt(s) == 'L') s++;
			cupCnt++;
		}
		cupCnt++;
		
		System.out.println(Math.min(seatCnt, cupCnt));
	}
	
	
}
