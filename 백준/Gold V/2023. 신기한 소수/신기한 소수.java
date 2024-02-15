import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static List<Integer> prime = new ArrayList<Integer>();
	static List<Integer> p = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p.add(2); p.add(3); p.add(5); p.add(7); //1의 자리 소수
		int one[] = {1, 3, 7, 9}; //마지막 자리에 올 수 있는 소수
		
		for(int n=1; n<N; n++) {
			for(Integer i : p) {
				for(int j=0; j<4; j++) {
					int num = i*10 + one[j];
					if(isPrime(num)) prime.add(num);
				}
			}
			p.clear();
			p.addAll(prime);
			prime.clear();
		}
		
		for (Integer number : p) {
			System.out.println(number);
		}
	}

	private static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num%i == 0)
				return false;
		}
		return true;
	}

}