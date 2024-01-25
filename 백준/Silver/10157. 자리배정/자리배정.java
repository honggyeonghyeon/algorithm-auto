import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken()); //가로
		int r = Integer.parseInt(st.nextToken()); //세로
		int k = Integer.parseInt(br.readLine()); //관객 번호
		
		int[][] seat = new int[c+1][r+1]; //(1,1)부터 (c, r) 좌석의 관객 번호
		int n = 0; //0:상 1:우 2:하 3:좌
		int man = 1; //관객 번호
		
		int i=1, j=1;
		int vec[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
		
		if(c*r < k) System.out.println(0);
		else {
			while(true) {
				if(man==k) {
					System.out.println(i+" "+j);
					break;
				}
				seat[i][j] = man;
				i+=vec[n][0];
				j+=vec[n][1];
				man++;
				if(i<1||i>c||j<1||j>r||seat[i][j]!=0) {
					i-=vec[n][0];
					j-=vec[n][1];
					n = (n+1)%4;
					i+=vec[n][0];
					j+=vec[n][1];
				}
			}
		}
	}

}
