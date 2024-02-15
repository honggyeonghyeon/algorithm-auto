import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alpha, result;
	static boolean[] isUsed;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new char[C];
		result = new char[L];
		isUsed = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) 
			alpha[i] = st.nextToken().charAt(0);
		
		Arrays.sort(alpha);
		comb(0, 0);
		System.out.println(sb);
	}

	private static void comb(int cnt, int idx) {
		if(cnt == L) {
			if(check()) {
				for(char c : result) {
					sb.append(c);
				}
				sb.append('\n');
			}
			return;
		}
		
		for(int i=idx; i<C; i++) {
			if(isUsed[i]) continue;
			result[cnt] = alpha[i];
			isUsed[i] = true;
			comb(cnt+1, i+1);
			isUsed[i] = false;
		}
	}

	private static boolean check() {
		int cnt1 = 0, cnt2 = 0;
		for(int i=0; i<L; i++) {
			char c = result[i];
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') cnt1++;
			else cnt2++;
		}
		if(cnt1>=1 && cnt2>=2) return true;
		return false;
	}
	
	

}