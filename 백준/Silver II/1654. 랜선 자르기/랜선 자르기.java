import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static long result;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		for(int i=0; i<K; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		if(N!=K) result = search(1, arr[K-1]);
		else result = Math.max(arr[0], search(1, arr[K-1]));
		
		System.out.println(result);
	}
	private static long search(long start, long end) {
		int count = 0;
		long result = 0;
		while(start <= end) {
			long mid = (start+end)/2;
			count = 0;
			for(int i=0; i<K; i++) {
				count += (arr[i]/mid);
			}
			if(count == N) {
				result = Math.max(mid, search(mid+1, end));
				return result;
			}
			else if(count < N) end = mid-1;
			else start = mid+1;
		}
		return (start+end)/2;
	}

}