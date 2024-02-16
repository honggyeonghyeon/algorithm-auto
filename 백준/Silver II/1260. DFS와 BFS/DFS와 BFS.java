import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static List<Integer>[] list;
	static boolean[] d, b;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		list = new List[N+1];
		d = new boolean[N+1];
		b = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(0, V);
		sb.append('\n');
		bfs();
		System.out.println(sb);
	}
	
	private static void dfs(int idx, int v) {
		//if(idx == N) return;
		d[v] = true;
		sb.append(v).append(' ');
		for(int i : list[v]) {
			if(d[i]) continue;
			dfs(idx+1, i);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(V);
		b[V] = true;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int i : list[v]) {
				if(b[i]) continue;
				q.add(i);
				b[i] = true;
			}
			sb.append(v).append(" ");
		}
	}

}
