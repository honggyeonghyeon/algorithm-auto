import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static int one[] = {2, 3, 5, 7}, two[] = {1, 3, 7, 9};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int num : one) {
			PrimeNum(1, num);
		}
		
		System.out.println(sb);
	}

	private static void PrimeNum(int cnt, int num) {
		if(cnt == N) {
			sb.append(num).append('\n');
			return;
		}
		for(int j=0; j<4; j++) {
			int n = num*10 + two[j];
			if(isPrime(n)) PrimeNum(cnt+1, n);
		}
	}

	private static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num%i == 0)
				return false;
		}
		return true;
	}

}