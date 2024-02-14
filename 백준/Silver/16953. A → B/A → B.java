import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		while(true) {
			count++;
			if(N>M) {
				count = -1;
				break;
			}
			if(N==M) break;
			if(M%10 == 1) M /= 10;
			else if(M%2 == 1) {
				count = -1;
				break;
			}
			else M /= 2;
		}
		
		System.out.println(count);
	}
}