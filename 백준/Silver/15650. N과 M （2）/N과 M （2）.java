import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isUsed = new boolean[N+1];
		
		comb(0, 1);
	}
	
	private static void comb(int idx, int start) {
		if(idx==M) {
			for (int i = 1; i <= N; i++) {
				if(isUsed[i]) System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=N; i++) {
			if(isUsed[i]) continue;
			isUsed[i] = true;
			comb(idx+1, i+1);
			isUsed[i] = false;
		}
	}

}