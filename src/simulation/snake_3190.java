package simulation;
import java.io.*;
import java.util.*;

public class snake_3190 {
	static int ax[] = {0, 0, -1, 1};
	static int ay[] = {-1, 1, 0, 0}; 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		//init apple location
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = -1; //apple
		}
		
		//init snake location, direction
		int snakeX = 1, snakeY = 1;
		q.add(snakeX);
		q.add(snakeY);
		board[snakeX][snakeY] = 1;
		int k = 1;
		
		int L = Integer.parseInt(br.readLine());

		int[] second = new int[L+1];
		char[] direction = new char[L+1];
		
		for(int i = 0; i < L; i++) { //init input
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			
			second[i] = s;
			direction[i] = d;
		}
		
		
		int answer = 0; 
		int index = 0;
		while(true) {
			snakeX += ax[k];
			snakeY += ay[k];
			
			answer++;
			
			if(snakeX >= 1 && snakeX <= N && snakeY >= 1 && snakeY <= N) {
				
				if(board[snakeX][snakeY] == 1) { //collide with itself
					System.out.println(answer);
					System.exit(0);
				}
				
				if(board[snakeX][snakeY] == 0) { //no apple
					int x = q.remove();
					int y = q.remove();
					board[x][y] = 0;
				}
				
				q.add(snakeX);
				q.add(snakeY);
				board[snakeX][snakeY] = 1;
			
			} else { //collide with wall
				System.out.println(answer);
				System.exit(0);
			}
			
			if(answer == second[index]) { //change direction
				switch(k) {
				case 0 : //left
					if(direction[index] == 'L')
						k = 3;
					else
						k = 2;
					break;
				case 1 : //right
					if(direction[index] == 'L')
						k = 2;
					else 
						k = 3;
					break;
				case 2 : //up
					if(direction[index] == 'L')
						k = 0;
					else
						k = 1;
					break;
				case 3 : //down
					if(direction[index] == 'L')
						k = 1;
					else
						k = 0;
					break;
				}
				
				index++;
			}

		}
		
	}

}
