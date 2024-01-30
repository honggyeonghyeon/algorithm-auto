import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean isUsed[];
	static int[] per;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());;
		M = Integer.parseInt(st.nextToken());;
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
