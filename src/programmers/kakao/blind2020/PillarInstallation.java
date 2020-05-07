package programmers.kakao.blind2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PillarInstallation {

	public static void main(String[] args) {
		int[][] build = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};

		int[][] ans = solution(5, build);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(ans[i][j]);
			System.out.println();
		}
	}

	public static int[][] solution(int n, int[][] build_frame) {
		List<Point> pi = new ArrayList<>();
		List<Point> bo = new ArrayList<>();
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];

			if (b == 0) {
				if (a == 0) {
					List<Point> copy = new ArrayList<>();
					for (int j = 0; j < pi.size(); j++)
						copy.add(pi.get(j));

					int index = 0;
					for (int j = 0; j < copy.size(); j++) {
						Point p = copy.get(j);
						if (p.x == x && p.y == y) {
							index = j;
							copy.remove(j);
							break;
						}
					}

					boolean isDelete = true;
					for (Point p : copy) {
						if (!isPi(copy, bo, p.x, p.y)) {
							isDelete = false;
						}
					}

					for (Point p : bo) {
						if (!isBo(copy, bo, p.x, p.y)) {
							isDelete = false;
						}
					}

					if (isDelete)
						pi.remove(index);
				} else {
					List<Point> copy = new ArrayList<>();
					for (int j = 0; j < bo.size(); j++)
						copy.add(bo.get(j));

					int index = 0;
					for (int j = 0; j < copy.size(); j++) {
						Point p = copy.get(j);
						if (p.x == x && p.y == y) {
							index = j;
							copy.remove(j);
							break;
						}
					}

					boolean isDelete = true;
					for (Point p : pi) {
						if (!isPi(pi, copy, p.x, p.y)) {
							isDelete = false;
						}
					}

					for (Point p : copy) {
						if (!isBo(pi, copy, p.x, p.y)) {
							isDelete = false;
						}
					}

					if (isDelete)
						bo.remove(index);
				}
			} else {
				if (a == 0) {
					if (isPi(pi, bo, x, y))
						pi.add(new Point(x, y));
				} else {
					if (isBo(pi, bo, x, y))
						bo.add(new Point(x, y));
				}
			}
		}
		
		List<Point> result = new ArrayList<>();
		
		for(int i = 0; i < pi.size(); i++) {
			Point p = pi.get(i);
			result.add(new Point(p.x, p.y, 0));
		}
		
		for(int i = 0; i < bo.size(); i++) {
			Point p = bo.get(i);
			result.add(new Point(p.x, p.y, 1));
		}
		
		Collections.sort(result);
		int[][] answer = new int[result.size()][3];
		for(int i = 0; i < result.size(); i++) {
			Point p = result.get(i);
			answer[i][0] = p.x;
			answer[i][1] = p.y;
			answer[i][2] = p.a;
		}
		return answer;
	}

	private static boolean isBo(List<Point> pi, List<Point> bo, int x, int y) {
		for (Point p : pi) {
			if ((p.x == x + 1 && p.y == y - 1) || (p.x == x && p.y == y - 1)) {
				return true;
			}
		}

		List<Integer> boX = new ArrayList<>();
		for (Point p : bo) {
			if (p.y == y)
				boX.add(p.x);
		}
		if (boX.contains(x - 1) && boX.contains(x + 1))
			return true;

		return false;
	}

	private static boolean isPi(List<Point> pi, List<Point> bo, int x, int y) {
		if (y == 0)
			return true;

		for (Point p : pi) {
			if (p.x == x && p.y == y - 1) {
				return true;
			}
		}

		for (Point p : bo) {
			if ((p.x == x && p.y == y) || (p.x == x - 1 && p.y == y)) {
				return true;
			}
		}

		return false;
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	int a;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, int a) {
		super();
		this.x = x;
		this.y = y;
		this.a = a;
	}

	@Override
	public int compareTo(Point p) {
		if(this.x > p.x) {
            return 1; 
        }
        else if(this.x == p.x) {
            if(this.y > p.y) { 
                return 1;
            }
            if(this.y == p.y) { 
            	if(this.a > p.a) { 
                    return 1;
                }
            }
        }
        return -1;
	}

}
