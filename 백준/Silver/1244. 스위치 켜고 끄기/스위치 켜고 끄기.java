import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] state;
	static int[][] student;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		state = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			state[i] = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		student = new int[M][2]; // 0: 성별 , 1: 받은 번호
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken());
			student[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int[] i : student) {
			switch (i[0]) {
			case 1:
				man(i[1]);
				break;
			case 2:
				state[i[1]] ^= 1;
				woman(i[1], 1);
				break;
			}
		}
		
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
	
	private static void man(int idx) {
		int j = 1;
		for (int i = idx; i <=N; i = idx*j) {
			state[i] ^= 1;
			j++;
		}
	}
	
	private static void woman(int idx, int i) {
		if(idx-i<=0 || idx+i >N) return;
		if((state[idx-i]^state[idx+i])==0) {
			state[idx-i] ^= 1;
			state[idx+i] ^= 1;
			woman(idx, i+1);
		}
	}

}