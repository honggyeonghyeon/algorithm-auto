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
		int num[] =  new int[N];
		int sum[] =  new int[N];
		st = new StringTokenizer(br.readLine());
		num[0] = Integer.parseInt(st.nextToken());
		sum[0] = num[0];
		for(int i=1; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+num[i];
		}
		
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if(i==1) System.out.println(sum[j-1]);
			else System.out.println(sum[j-1]-sum[i-2]);
		}
	}
}