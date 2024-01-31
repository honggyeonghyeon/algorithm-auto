import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] height = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		Arrays.sort(height);
		int a = -1, b=-1;
		int result = sum;
		
		A: for(int i=0; i<9; i++) {
			for(int j=1; j<9; j++) {
				result -= (height[i] + height[j]);
				if(result==100) {
					a = i;
					b = j;
					break A;
				}
				result = sum;
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i==a || i==b) continue;
			System.out.println(height[i]);
		}
	}
}