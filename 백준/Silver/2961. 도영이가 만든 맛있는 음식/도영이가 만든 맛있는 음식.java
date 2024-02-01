import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][]food;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		food = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
	
		for(int i=0; i<N; i++)
			min = Math.min(min, Math.abs(food[i][0]-food[i][1]));
		
		if(N==1) {
			System.out.println(min);
			return;
		}
		SubSet(0, 1, 0);
		System.out.println(min);
	}
	
	private static void SubSet(int cnt, int t1, int t2) {
		if(cnt==N) {
			if(t1 == 1 && t2 == 0) return;
			min = Math.min(min, Math.abs(t1-t2));
			return;
		}
		SubSet(cnt+1, t1*food[cnt][0], t2+food[cnt][1]);
		SubSet(cnt+1, t1, t2);
	}
}