import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 	53,008kb 328ms
 * 문제 해석
	빵집이 있는 곳 R*C 격자로 표현
	첫째 열은 근처 빵집의 가스관, 마지막 열은 원웅이의 빵집
	가스관과 빵집을 연결하는 파이프 설치 
	단, 건물이 있으면 파이프를 놓을 수 없음
	첫째 열에서 시작하여 마지막 열에서 끝나야 함
	각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결 가능, 각 칸의 중심끼리 연결
	많은 가스를 훔치려고 하는데, 각 칸을 지나는 파이프는 하나여야 함
	파이프 라인의 최대 개수
	
	입력
	1. R, C (1≤R<10,000, 5≤C≤500)
	2. R개의 줄에 빵집 근처의 모습이 주어짐 
	    ‘.’ 빈 칸, ‘x’ 건물
	
	출력
	최소 개수 (N킬로그램을 만들 수 없다면 -1 출력)
 */
public class Main {
	static int R, C, result;
	static char arr[][];
	static boolean b, visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) arr[i] = br.readLine().toCharArray();
		
		for(int i=0; i<R; i++) {
			b = false;
			pipe(i, 0);
		}
		
		System.out.println(result);
	}
	
	private static boolean pipe(int r, int c) {
		visited[r][c] = true; //방문 처리, 한 번 방문 처리된 곳은 이미 파이프가 설치되었거나 나아갈 길이 없음
		if(c==C-1) {
			result++;
			return true;
		}
		
		//오른쪽 위
		if(r-1>=0 && !visited[r-1][c+1] && arr[r-1][c+1]=='.') {
			if(pipe(r-1, c+1)) return true;
		}
		//오른쪽
		if(arr[r][c+1]=='.' && !visited[r][c+1]) {
			if(pipe(r, c+1)) return true;
		}
		//오른쪽 아래
		if(r+1<R && !visited[r+1][c+1] && arr[r+1][c+1]=='.') {
			if(pipe(r+1, c+1)) return true;
		}
		
		return false;
	}
}