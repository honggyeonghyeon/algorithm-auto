import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][] = new int[20][20];
	static int dx[] = {0, 1, 1, 1}, dy[] = {1, 1, 0, -1};
	static int res[] = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int result = 0;
		
		for(int i=1; i<=19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		A: for(int i=1; i<=19; i++) {
			for(int j=1; j<=19; j++) {
				if(arr[i][j]==0) continue;
				int num = arr[i][j];
				if(width(num, i, j, 0) && (arr[i-dx[0]][j-dy[0]]!=num)) {
					result = num;
					break A;
				}
				if(width(num, i, j, 1) && (arr[i-dx[1]][j-dy[1]]!=num)) {
					result = num;
					break A;
				}
				if(width(num, i, j, 2) && (arr[i-dx[2]][j-dy[2]]!=num)) {
					result = num;
					break A;
				}
				if(width(num, i, j, 3) && (arr[i-dx[3]][j-dy[3]]!=num)) {
					result = num;
					break A;
				}
			}
		}
		
		System.out.println(result);
		if(result>0) System.out.println(res[0]+" "+res[1]);
	}
	
	private static boolean width (int num, int x, int y, int idx) {
		int cnt = 0;
		int nx = x, ny = y;
		while(arr[nx][ny]==num) {
			cnt++;
			nx += dx[idx];
			ny += dy[idx];
			if(nx<1 || ny<1 || nx>19 || ny>19) break;
		}
		if(cnt==5) {
			if(idx==3) {
				res[0] = nx-dx[idx];
				res[1] = ny-dy[idx];
				return true;
			}
			res[0] = x;
			res[1] = y;
			return true;
		}
		else return false;
	}

}
