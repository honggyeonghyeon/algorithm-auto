import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Heap implements Comparable<Heap>{
		int number;
		int absNum;
		
		public Heap(int number) {
			super();
			this.number = number;
			this.absNum = Math.abs(number);
		}

		@Override
		public int compareTo(Heap o) {
			if(this.absNum == o.absNum) {
				return this.number >= o.number ? 1 : -1;
			}
			return this.absNum >= o.absNum ? 1 : -1;
		}
	}
	
	
	static PriorityQueue<Heap> heap = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(!heap.isEmpty()) {
					Heap result = heap.poll();
					System.out.println(result.number);
				}
				else {
					System.out.println(0);
				}
				continue;
			}
			heap.add(new Heap(num));
		}
	}

	
}