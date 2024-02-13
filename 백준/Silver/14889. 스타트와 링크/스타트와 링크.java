import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, result = Integer.MAX_VALUE;
	static int S[][], start[], link[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		start = new int[N/2];
		link = new int[N/2];
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
			int index = 0;
			for(int i=0; i<N; i++) {
				if((flag & 1<<i) == 0) link[index++] = i;
			}
			sum();
			return;
		}
		for(int i=num; i<N; i++) {
			start[idx] = i;
			comb(idx+1, i+1, flag | (1<<i));
		}
	}
    
	private static void sum() {
		int s = 0, l = 0;
		for(int i=0; i<N/2; i++) {
			for(int j=i; j<N/2; j++) {
				s += S[start[i]][start[j]]+S[start[j]][start[i]];
				l += S[link[i]][link[j]]+S[link[j]][link[i]];
			}
		}
		result = Math.min(result, Math.abs(s-l));
	}

}