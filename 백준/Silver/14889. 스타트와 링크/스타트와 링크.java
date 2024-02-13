import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, result = Integer.MAX_VALUE;
	static int S[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0, 0);
		System.out.println(result);
	}

	private static void comb(int idx, int num, int flag) {
		if(idx==N/2) {
			sum(flag);
			return;
		}
		for(int i=num; i<N; i++) {
			comb(idx+1, i+1, flag | (1<<i));
		}
	}

	private static void sum(int flag) {
		int start = 0, link = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((flag&1<<i)!=0 && (flag&1<<j)!=0)
					start += S[i][j];
				else if((flag&1<<i)==0 && (flag&1<<j)==0)
					link += S[i][j];
			}
		}
		result = Math.min(result, Math.abs(start-link));
	}

}