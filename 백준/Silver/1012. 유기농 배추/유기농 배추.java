import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n, m, k;
	static int[][] field;
	static boolean[][] visited;
	static int vec[][] = {{1, 0}, {0, 1}};

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
			visited = new boolean[n][m];
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
		if(x<n && x>=0 && y<m && y>=0 && !visited[x][y] && field[x][y]==1) {
			visited[x][y] = true;
			field[x][y] = 0;
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y+1);
			dfs(x, y-1);
		}else return;
	}

}
