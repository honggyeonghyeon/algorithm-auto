import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M, cnt = 0, num = N;
		
		while(true) {
			if(num==0) break;
			M = (int) Math.sqrt(num);
			num -= M*M;
			cnt++;
		}
		min = cnt;	
		sumCnt(N, 0);
		System.out.println(min);
	}
	
	public static void sumCnt(int num, int cnt) {
		if(cnt>=min) return;
		if(num==0) {
			min = cnt;
			return;
		}
		int M = (int) Math.sqrt(num);
		for(int i=M; i>=1; i--) {
			if(num-i*i < 0) continue;
			sumCnt(num-i*i, cnt+1);
		}
	}
}