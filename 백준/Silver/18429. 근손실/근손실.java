import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k, count, w;
	static int [] weight;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		weight = new int[n];
		used = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		health(0);
		
		System.out.println(count);
		
	}
	
	public static void health(int index) {
		if(index==n) {
			count++;
			return;
		}
		for(int i=0; i<n; i++) {
			if(used[i]) continue;
			if((w+weight[i]-k)>=0) {
				w += weight[i]-k;
				used[i] = true;
				health(index+1);
				used[i] = false;
				w -= weight[i]-k;
			}
		}
	}

}
