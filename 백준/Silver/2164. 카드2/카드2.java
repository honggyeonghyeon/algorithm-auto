import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/* 31,636KB 136ms
 * 문제 해석
	N장의 카드 1 → N번 카드 순
	제일 위에 있는 카드를 버리고 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
	
	입력
	N
	
	출력
	첫번째 줄에 남게 되는 카드의 번호
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1; i<=N; i++)
			q.offer(i);
		while(q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}
}