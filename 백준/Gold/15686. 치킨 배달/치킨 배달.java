import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, m, choice[][], min = Integer.MAX_VALUE;
	static List<city> chicken = new ArrayList<>();
	static List<city> home = new ArrayList<>();
	static boolean isSelected[];
	
	static class city {
		int r, c;

		public city(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		choice = new int[M][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int k = Integer.parseInt(st.nextToken());
				if(k==1) home.add(new city(i, j));
				else if(k==2) chicken.add(new city(i, j));
			}
		}
		
		isSelected = new boolean[chicken.size()];
		m = Math.min(M, chicken.size()-M);
		comb(0, 0);
		System.out.println(min);
	}

	private static void comb(int idx, int num) {
		if(idx==m) {
			int k = 0;
			for(int i=0; i<chicken.size(); i++) {
				if(M == m) {
					if(isSelected[i]) {
						choice[k][0] = chicken.get(i).r; 
						choice[k][1] = chicken.get(i).c;
						k++;
					}
				}else {
					if(!isSelected[i]) {
						choice[k][0] = chicken.get(i).r; 
						choice[k][1] = chicken.get(i).c;
						k++;
					}
				}
			}
			minDist();
			return;
		}
		for(int i=num; i<chicken.size(); i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			comb(idx+1, i+1);
			isSelected[i] = false;
		}
	}

	private static void minDist() {
		int dist = 0;
		for(int i=0; i<home.size(); i++) {
			dist += distance(home.get(i));
		}
		min = Math.min(min, dist);
	}

	private static int distance(city city) {
		int dist = Math.abs(city.r-choice[0][0])+Math.abs(city.c-choice[0][1]);
		for(int i=1; i<M; i++) {
			int dist2 = Math.abs(city.r-choice[i][0])+Math.abs(city.c-choice[i][1]);
			dist = Math.min(dist, dist2);
		}
		return dist;
	}
}