import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char video[][];
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		video = new char[N][N];
		for(int i=0; i<N; i++) video[i] = br.readLine().toCharArray();
		
		QuadTree(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void QuadTree(int r, int c, int n) {
		char color = video[r][c];
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(video[i][j]!=color) {
					sb.append("(");
					QuadTree(r, c, n/2);
					QuadTree(r, c+n/2, n/2);
					QuadTree(r+n/2, c, n/2);
					QuadTree(r+n/2, c+n/2, n/2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(color);
	}

}