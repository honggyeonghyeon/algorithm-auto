import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 해석
	그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과 출력 프로그램
	방문할 수 있는 정점이 여러 개 → 작은 번호 부터
	더 이상 방문할 수 있는 점이 없으면 종료
	정점 번호는 1부터 N까지
	
	입력
	1.정점 개수 N≤1000, 간선 개수 M≤10000, 탐색을 시작할 정점 번호 V
	2.M개의 줄: 두 정점 번호
	
	출력
	DFS 수행 결과
	BFS 수행 결과
 */

public class Main{
	static int N, M, V;
	static int[][] graph;
	static boolean[] DFS;
	static boolean[] BFS;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		DFS = new boolean[N+1];
		BFS = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		dfs(0, V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb.toString());
	}

	private static void dfs(int idx, int v) {
		if(idx==N) return;
		DFS[v]= true;
		sb.append(v+" ");
		for(int i=1; i<N+1; i++) {
			if(DFS[i] || graph[v][i]==0) continue;
			dfs(idx+1, i);
		}
	}
	
	private static void bfs(int v) {
		q.add(v);
		BFS[v] = true;
		while(!q.isEmpty()) {
			int k = q.poll();
			sb.append(k+" ");
			for(int i=1; i<=N; i++) {
				if(BFS[i] || graph[k][i]==0)continue;
				q.add(i);
				BFS[i] = true;
			}
		}
	}
}
