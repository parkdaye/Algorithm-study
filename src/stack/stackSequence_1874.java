package stack;
import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.util.*;

public class stackSequence_1874 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans[] = new int[n+1];
		boolean check[] = new boolean[n+1];
		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= n; i++) {
			ans[i] = Integer.parseInt(br.readLine());
		}
		
		int temp = 1;
		
		for(int i = 1; i <= n; i++) {
			int j;
			for(j = temp; j <= ans[i]; j++) {
				stack.push(j);
				sb.append('+');
			}
			temp = j;
			
			for(int k = i + 1; k <= n; k++) {
				if(!stack.isEmpty()) {
					al.add(stack.pop());
					sb.append('-');
					
					if(ans[i] < ans[k]) {
						break;
					}
				
				}
				
				i++;
			}
			
		}
		
		//al.add(1);
		sb.append('-');
		
		for(int i = 1; i < n; i++) {	
			if(ans[i] != al.get(i-1)) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		for(int j = 0; j < sb.length(); j++)
			System.out.println(sb.charAt(j));
		

	}

}
