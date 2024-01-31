import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] height = new int[9]; //아홉 난쟁이들의 키
	static int[] result = new int[7]; //일곱 난쟁이들의 키
	static boolean[] isSelected = new boolean[9]; //선택된 난쟁이
	static boolean found; //키의 합이 100인 경우
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(height);
		comb(0, 0);
		
	}
	
	private static void comb(int cnt, int start) {
		if(found) return;
		if(cnt == 7) {
			if(Arrays.stream(result).sum()==100){
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
				found = true;
			}
			return;
		}
		for(int i=start; i<9; i++) {
			if(isSelected[i]) continue;
			result[cnt] = height[i];
			isSelected[i] = true;
			comb(cnt+1, start+1);
			isSelected[i] = false;
		}
	}

}