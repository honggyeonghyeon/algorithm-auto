import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int A[];
	static char ope[];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static boolean isUsed[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		ope = new char[N-1];
		isUsed = new boolean[N-1];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int [] oper = new int[4];
		int k = 0;
		char []o = {'+', '-', '*', '/'};
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<oper[i]; j++) {
				ope[k] = o[i];
				k++;
			}
		}
		operator(0, A[0]);
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void operator(int idx, int sum) {
		if(idx==N-1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(isUsed[i]) continue;
			isUsed[i] = true;
			switch(ope[i]) {
			case '+':
				operator(idx+1, sum+A[idx+1]);
				break;
			case '-':
				operator(idx+1, sum-A[idx+1]);
				break;
			case '*':
				operator(idx+1, sum*A[idx+1]);
				break;
			case '/':
				operator(idx+1, sum/A[idx+1]);
				break;
			}
			isUsed[i] = false;
		}
	}
}