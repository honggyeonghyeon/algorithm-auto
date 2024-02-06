import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r, k, i, j;
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
		k = Math.min(n, m)/2;
		array = new int[N][M];
		result = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
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
			x+=dx[idx];
			y+=dy[idx];
			if(x<cnt||x>=(n+cnt)||y<cnt||y>=(m+cnt)) {
				x-=dx[idx];
				y-=dy[idx];
				idx = (idx+1)%4;
				x+=dx[idx];
				y+=dy[idx];
			}
		}
		i = cnt; 
		j = cnt;
		printArray(x, y, cnt);
		n -= 2;
		m -= 2;
		idx = 0;
		loofBox(cnt+1);
	}
	
	private static void printArray(int x, int y, int cnt) {
		result[i][j] = array[x][y];
		for(int a=0; a<(2*(m+n)-5); a++) {
			i += dx[index];
			j += dy[index];
			x += dx[idx];
			y += dy[idx];
			if(x<cnt||x>=(n+cnt)||y<cnt||y>=(m+cnt)) {
				x-=dx[idx];
				y-=dy[idx];
				idx = (idx+1)%4;
				x += dx[idx];
				y += dy[idx];
			}
			if(i<cnt||i>=(n+cnt)||j<cnt||j>=(m+cnt)) {
				i-=dx[index];
				j-=dy[index];
				index = (index+1)%4;
				i += dx[index];
				j += dy[index];
			}
			result[i][j] = array[x][y];
		}
		index = 0;
	}

}