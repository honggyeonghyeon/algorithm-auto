/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] ladder = new int[100][100];
	static int[] vec = new int[2];
	static int[] dx = {-1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int tc=1; tc<=10; tc++) {
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(ladder[i][j] == 2) {
						vec[0] = i;
						vec[1] = j;
					}
				}
			}
			
			Ladder();
			System.out.printf("#%d %d%n", t, vec[1]);
		}
	}
	
	private static void Ladder() {
		while(vec[0]>=0) {
			if(((vec[1]+dx[0])>=0) && (ladder[vec[0]][vec[1]+dx[0]]==1)) {
				//System.out.println(location[1]+" "+location[0]);
				vec[1] += dx[0];
				Ladder2(0);
			}
			else if(((vec[1]+dx[1])<100) && (ladder[vec[0]][vec[1]+dx[1]]==1)) {
				vec[1] += dx[1];
				Ladder2(1);
			}
			vec[0]--;
		}
	}
	
	private static void Ladder2(int idx) {
		if((vec[1]+dx[idx])>=0 && (vec[1]+dx[idx])<100 && (ladder[vec[0]][vec[1]+dx[idx]]==1)) {
			vec[1] += dx[idx];
			Ladder2(idx);
		}
		else return;
	}
}