import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int s;
	static int p;
	static int[] acgtCnt = new int['Z'];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		acgtCnt['A'] = Integer.parseInt(st.nextToken());
		acgtCnt['C'] = Integer.parseInt(st.nextToken());
		acgtCnt['G'] = Integer.parseInt(st.nextToken());
		acgtCnt['T'] = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		for(int i=0; i<p; i++) {
			char c = str.charAt(i);
			acgtCnt[c]--;
		}
		
		if (isValidACGT())	result++;
		
		for (int i = 0; i < s-p; i++) {
			char front = str.charAt(i);
			acgtCnt[front]++;

			char back = str.charAt(i + p);
			acgtCnt[back]--;

			if (isValidACGT())	result++;
		}

		System.out.println(result);
	}
	
	private static boolean isValidACGT() {
		String acgt = "ACGT";
		for (int i=0; i<4; i++) {
			if (acgtCnt[acgt.charAt(i)] > 0)
				return false;
		}
		return true;

	}
	
}