import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][], result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = new int[2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		part(0, 0, N, arr[0][0]);
		System.out.printf("%d\n%d\n", result[0], result[1]);
	}
	private static void part(int r, int c, int n, int color) {
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(arr[i][j] != color) {
					part(r, c, n/2, arr[r][c]);
					part(r, c+n/2, n/2, arr[r][c+n/2]);
					part(r+n/2, c, n/2, arr[r+n/2][c]);
					part(r+n/2, c+n/2, n/2, arr[r+n/2][c+n/2]);
					return;
				}
			}
		}
		result[color]++;
	}

}
