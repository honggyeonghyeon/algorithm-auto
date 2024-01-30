import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean isUsed[];
	static int[] per;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		isUsed = new boolean[N+1];
		per = new int[M];
		permu(0);
	}
	
	private static void permu(int idx) {
		if(idx==M) {
			for(int i=0; i<per.length; i++)
				System.out.print(per[i]+" ");
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(isUsed[i]) continue;
			per[idx] = i;
			isUsed[i] = true;
			permu(idx+1);
			isUsed[i] = false;
		}
	}

}
