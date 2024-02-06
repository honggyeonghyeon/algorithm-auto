import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int n, m, r, k;
	static int array[][], result[][];
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static int idx, index;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		n = N;
		m = M;
		r = R;
		
		k = Math.min(n, m)/2; //루프를 돌 박스 개수
		array = new int[n][m];
		result = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		loofBox(0);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void loofBox(int cnt) {
		if(cnt==k) return;
		int R = r % (2*(m+n)-4);
		int x = cnt;
		int y = cnt;
		for(int i=0; i<R; i++) {
			if(x+dx[idx]<cnt||x+dx[idx]>=(n+cnt)||y+dy[idx]<cnt||y+dy[idx]>=(m+cnt)) idx = (idx+1)%4;
			x+=dx[idx];
			y+=dy[idx];
		}
		printArray(x, y, cnt, cnt, cnt);
		n -= 2;
		m -= 2;
		loofBox(cnt+1);
	}
	
	private static void printArray(int x, int y, int cnt, int i, int j) {
		for(int a=0; a<(2*(m+n)-4); a++) {
			result[i][j] = array[x][y];
			if(x+dx[idx]<cnt||x+dx[idx]>=(n+cnt)||y+dy[idx]<cnt||y+dy[idx]>=(m+cnt)) idx = (idx+1)%4;
			if(i+dx[index]<cnt||i+dx[index]>=(n+cnt)||j+dy[index]<cnt||j+dy[index]>=(m+cnt))index = (index+1)%4;
			i += dx[index];
			j += dy[index];
			x += dx[idx];
			y += dy[idx];
		}
		index = 0;
		idx = 0;
	}

}