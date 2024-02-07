import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int N, M, min;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Math.min(N, M);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			int cal = Integer.parseInt(st.nextToken());
			switch(cal) {
			case 1:
				updown();
				break;
			case 2:
				leftright();
				break;
			case 3:
				right90();
				break;
			case 4:
				left90();
				break;
			case 5:
				subright();
				break;
			case 6:
				subleft();
				break;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	private static void updown() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N-i-1][j];
				arr[N-i-1][j] = temp;
			}
		}
	}
	
	private static void leftright() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M-1-j];
				arr[i][M-1-j] = temp;
			}
		}
	}
	
	private static void right90() {
		int temp[][] = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[j][N-1-i] = arr[i][j];
			}
		}
		arr = temp;
		int k = N;
		N = M;
		M = k;
	}
	
	private static void left90() {
		int temp[][] = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				temp[M-1-j][i] = arr[i][j];
			}
		}
		arr = temp;
		int k = N;
		N = M;
		M = k;
	}
	
	private static void subright() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N/2+i][j];
				arr[N/2+i][j] = arr[N/2+i][M/2+j];
				arr[N/2+i][M/2+j] = arr[i][M/2+j];
				arr[i][M/2+j] = temp;
			}
		}
	}
	
	private static void subleft() {
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M/2+j];
				arr[i][M/2+j] = arr[N/2+i][M/2+j];
				arr[N/2+i][M/2+j] = arr[N/2+i][j];
				arr[N/2+i][j] = temp;
			}
		}
	}

}