import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		for(int i=0; i<K; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		long result = 0;
		
		if(N!=K) result = search(1, arr[K-1]);
		else result = Math.max(arr[0], search(1, arr[K-1]));
		
		System.out.println(result);
	}
	
	private static long search(long start, long end) {
		long result = (start+end)/2;
		while(start <= end) {
			long mid = (start+end)/2;
			int count = 0;
			for(int i=0; i<K; i++) {
				count += (arr[i]/mid);
			}
			if(count >= N) {
				result = mid;
				start = mid+1;
			}
			else end = mid-1;
		}
		return result;
	}

}