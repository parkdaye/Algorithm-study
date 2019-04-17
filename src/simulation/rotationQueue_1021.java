package simulation;
import java.util.*;
import java.io.*;

public class rotationQueue_1021 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for(int i = 1; i <= N; i++)
			a.add(i);
		
		st = new StringTokenizer(br.readLine());
		
		int nowIndex = 0;
		int sum = 0;
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int targetIndex = a.indexOf(target);
			int leftMove, rightMove;
			
			if(targetIndex == nowIndex) {
				a.remove(targetIndex);
				nowIndex = targetIndex;
				continue;
			}
			
			if(nowIndex < targetIndex) {
				leftMove = targetIndex - nowIndex;
				rightMove = a.size() - leftMove;
			} else {
				rightMove = nowIndex - targetIndex;
				leftMove = a.size() - rightMove;
			}
			
			if(leftMove < rightMove) {
				sum += leftMove;
			} else {
				sum += rightMove;
			}
		
				
			for(int j = 0; j < a.size(); j++)
				if(a.get(j) == target) {
					a.remove(j);
					nowIndex = j;
				}
			
		}

		System.out.println(sum);
	}

}
