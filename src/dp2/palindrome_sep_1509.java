package dp2;
import java.io.*;

public class palindrome_sep_1509 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int d[];
		int c[][];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		d = new int[s.length()+1];
		c = new int[2501][2501];
		
		for(int i = 0; i < d.length; i++)
			d[i] = 2501;
		
		for(int i = 1; i <= s.length(); i++) {
			c[i][i] = 1;
		}
		
		for(int i = 1; i <= s.length()-1; i++) {
			if(s.charAt(i-1) == s.charAt(i))
				c[i][i+1] = 1;
		}
		
		for(int i = 3; i <= s.length(); i++) {
			for(int j = 0; j < s.length()-i+1; j++) {
				if(s.charAt(j) == s.charAt(i+j-1)) {
					if(c[j+2][i+j-1] == 1)
						c[j+1][i+j] = 1;
				}
			}
		}
		
	
		d[0] = 0;
		for(int to = 1; to <= s.length(); to++) {
			for(int from = 1; from <= to; from++) {
				if(c[from][to] == 1) {
					if(d[to] > d[from-1] + 1)
						d[to] = d[from-1] + 1;
				}
			}
		}
		
		System.out.println(d[s.length()]);
	}
	

}
