import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=n/5; i>=0; i--) {
			result = i;
			if((n-i*5)%3==0) {
				result += (n-i*5)/3;
				System.out.println(result);
				return;
			}
		}
		
		System.out.println(-1);
	}

}
