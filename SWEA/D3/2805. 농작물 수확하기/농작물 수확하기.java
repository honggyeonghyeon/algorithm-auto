import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n;
	static int benefit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			benefit = new int[n][n];
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<n; j++) {
					benefit[i][j] = str.charAt(j)-48;
				}
			}
			
			int m = n/2, result = 0;
			for(int i=1; i<=m; i++) {
				for(int j=i; j<n-i; j++) {
					result += benefit[m-i][j];
					result += benefit[m+i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				result += benefit[m][i];
			}
			
			System.out.printf("#%d %d%n", t, result);
		}
	}

}
