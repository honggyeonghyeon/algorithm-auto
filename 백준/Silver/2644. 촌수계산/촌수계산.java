import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, a, b;
	static boolean tree[][], visited[];
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		
		tree = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree[x][y] = true;
			tree[y][x] = true;
		}
		
		bfs(a, 0, 0);
		
		System.out.println(result);
		
	}
	
	private static void bfs(int idx, int cnt, int count) {
		if(cnt==N) return;
		for (int i=1; i<N+1; i++) {
			if(visited[i] || !tree[idx][i]) continue;
			if(i==b) {
				result = count+1;
				return;
			}
			visited[i] = true;
			bfs(i, cnt+1, count+1);
			visited[i] = false;
		}
	}

}