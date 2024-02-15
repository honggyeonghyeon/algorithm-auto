import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, idx, min = Integer.MAX_VALUE;
	static int dr[] = {1, 0, -1, 0}, dc[] = {0, 1, 0, -1};
	static int arr[][], a[][], ope[][], p[];
	static boolean isUsed[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		a = new int[N+1][M+1];
		
		ope = new int[K][3];
		p = new int[K];
		isUsed = new boolean[K];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			ope[i][0] = Integer.parseInt(st.nextToken());
			ope[i][1] = Integer.parseInt(st.nextToken());
			ope[i][2] = Integer.parseInt(st.nextToken());
		}
		
		permu(0);
		
		System.out.println(min);
	}
	
	private static void permu(int cnt) {
		if(cnt==K) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					arr[i][j] = a[i][j];
				}
			}
			for(int i=0; i<K; i++) {
				rotation(ope[p[i]][0], ope[p[i]][1], ope[p[i]][2]);
			}
			minSum();
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(isUsed[i]) continue;
			isUsed[i] = true;
			p[cnt] = i;
			permu(cnt+1);
			isUsed[i] = false;
		}
	}

	private static void minSum() {
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=M; j++) {
				sum += arr[i][j];
			}
			min = Math.min(min, sum);
		}
	}
	private static void rotation(int r, int c, int s) {
		for(int k=0; k<s; k++) {
			int nr = r-s+k, nc = c-s+k;
//			System.out.println(nr+" "+nc+" "+arr[nr][nc]);
			int temp = arr[nr][nc];
			while(true) {
				if(nr+dr[idx]<r-s+k || nr+dr[idx]>r+s-k ||
						nc+dc[idx]<c-s+k || nc+dc[idx]>c+s-k)
					idx++;
				if(idx==4) break;
				arr[nr][nc] = arr[nr+dr[idx]][nc+dc[idx]];
				nr += dr[idx];
				nc += dc[idx];
			}
			arr[r-s+k][c-s+k+1] = temp;
			idx = 0;
			
//			for(int i=1; i<=N; i++) {
//				for(int j=1; j<=M; j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
		}

	}
}