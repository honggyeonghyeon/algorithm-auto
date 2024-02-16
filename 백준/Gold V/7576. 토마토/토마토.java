import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, date;
	static int[][] tomato;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1) q.add(new int[] {i, j});
			}
		}
		
		while(!check()) {
			if(q.isEmpty()) {
				date = -1;
				break;
			}
			Tomato();
		}
		
		System.out.println(date);
	}

	private static void Tomato() {
		int size = q.size();
		for(int i=0; i<size; i++) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			for(int j=0; j<4; j++) {
				if(!range(x+dx[j], y+dy[j])) continue;
				int nx = x + dx[j];
				int ny = y+ dy[j];
				if(tomato[nx][ny] == 0) {
					tomato[nx][ny] = 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
		date++;
	}

	private static boolean range(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}

	private static boolean check() {
		boolean b = true;
		A : for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomato[i][j] == -1) continue;
				if(tomato[i][j] == 0) {
					b = false;
					break A;
				}
			}
		}
		return b;
	}

}