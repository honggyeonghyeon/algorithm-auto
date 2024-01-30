import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n, m, k;
	static int[][] field;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int x=0, y=0;
		for(int t=0; t<T; t++) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			field = new int[n][m];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				field[x][y] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(field[i][j]==1) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];

			if(nx>=0 && nx<n && ny>=0 && ny<m && field[nx][ny] == 1) {
				field[nx][ny] = -1;
				dfs(nx, ny);
			}
		}
	}

}
