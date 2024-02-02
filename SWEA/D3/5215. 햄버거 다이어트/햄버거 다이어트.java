import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L, good;
	static int taste[][]; //0: 맛 , 1: 칼로리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			taste = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i][0] = Integer.parseInt(st.nextToken());
				taste[i][1] = Integer.parseInt(st.nextToken());
			}
			combTaste(0, 0, 0);
			System.out.printf("#%d %d%n",t, good);
			good = 0;
		}
	}

	private static void combTaste(int idx, int sumT, int sumK) {
		if(sumK>L) return;
		if(idx==N) {
			good = Math.max(good, sumT);
			return;
		}

		combTaste(idx+1, sumT+taste[idx][0], sumK+taste[idx][1]);
		combTaste(idx+1, sumT, sumK);
	
	}
}