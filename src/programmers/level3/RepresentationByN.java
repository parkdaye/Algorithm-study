package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class RepresentationByN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(2, 11));
	}

	public static int solution(int N, int number) {
        
        List<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[9];
        
        for(int i = 1; i < list.length; i++) {
        	list[i] = new ArrayList<Integer>();
        	list[i].add(init(N, i));
        }
        	
        int answer = 0;
        
        for(int i = 1; i < list.length; i++) {
        	for(int j = 1; j < i / 2 + 1; j++) {
        		for(int op1 : list[j]) {
        			for(int op2 : list[i-j]) {
        				list[i].add(op1 + op2);
        				list[i].add(op1 - op2);
        				list[i].add(op2 - op1);
        				list[i].add(op1*op2);
        				
        				if(op1 != 0)
        					list[i].add(op2/op1);
        				
        				if(op2 != 0)
        					list[i].add(op1/op2);
        			}
        		}
        	}
        	
        	if(list[i].contains(number)) {
        		answer = i;
        		break;
        	}
        }
        
        return answer;
    }

	private static int init(int n, int i) {
		
		int sum = 0;
		for(int j = 1; j <= Math.pow(10, i-1); j *= 10) {
			sum += n * j;
		}
		
		return sum;
	}

}
