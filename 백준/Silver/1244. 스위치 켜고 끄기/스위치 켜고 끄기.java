import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1부터 연속적으로 번호가 붙어있는 스위치 상태 0: 꺼짐 1: 켜짐
 * 남학생: 자기가 받은 숫자의 배수 상태 바꿈
 * 여학생: 받은 번호부터 좌우가 비대칭일 때까지 비교하여 대칭인 구간 상태 바꿈
 * 
 * 입력
 * 스위치 개수 ≤ 100
 * 각 스위치 상태 0:꺼짐 1:켜짐
 * 학생수 ≤ 100
 * 성별, 받은 수 (남학생1, 여학생2)
 * 
 * 출력
 * 1번 스위치에서 시작하여 마지막 스위치까지 한줄에 20개씩 출력
 * 
 * 11624KB 80ms
 */

public class Main {
	static int N;
	static int[] state;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		state = new int[N+1]; //1~N개의 스위치 상태
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			state[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			switch (gender) {
			case 1:
				man(num);
				break;
			case 2:
				state[num] ^= 1;
				woman(num, 1);
				break;
			}
		}
		
		/*
		 * N과 20을 나눈 값만큼 20번씩 출력 반복
		 * N과 20을 나눈 나머지 만큼 출력 반복
		 */
		int len = N/20;
		for(int i=0; i<len; i++) {
			for(int j=1; j<=20; j++) {
				System.out.print(state[j+20*i]+" ");
			}
			System.out.println();
		}
		for(int i=1; i<=(N%20); i++) {
			System.out.print(state[i+20*len]+" ");
		}
		
	}
	
	/*
	 * idx: 학생이 부여 받은 숫자
	 * idx*1부터 N개를 넘어가지 않은 범위 내에서 배수의 스위치 상태 바꿈
	 * ^ 연산: 같으면 0, 다르면 1 반환
	 */
	private static void man(int idx) {
		int j = 1;
		for (int i = idx; i <=N; i = idx*j) {
			state[i] ^= 1;
			j++;
		}
	}
	
	/*
	 * idx: 학생이 부여 받은 숫자, i: 주변 스위치 상태 확인
	 * idx-i와 idx+i의 상태가 같으면 ^ 연산 시 0 반환
	 * 이 경우 스위치 상태 바꿈
	 */
	private static void woman(int idx, int i) {
		if(idx-i<=0 || idx+i >N) return;
		if((state[idx-i]^state[idx+i])==0) {
			state[idx-i] ^= 1;
			state[idx+i] ^= 1;
			woman(idx, i+1);
		}
	}

}