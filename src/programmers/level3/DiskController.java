package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiskController {

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {

		int now = 0;
		int sum = 0;

		List<Job> list = new ArrayList<>();
		for (int i = 0; i < jobs.length; i++) {
			list.add(new Job(jobs[i][0], jobs[i][1]));
		}

		Collections.sort(list);

		while (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Job j = list.get(i);
				if (j.getStartTime() <= now) {
					sum = sum + (now - j.getStartTime()) + j.getWork();
					now += j.getWork();
					list.remove(i);
					break;
				}

				if (i == list.size() - 1) {
					now++;
				}
			}

		}

		int answer = sum / jobs.length;
		return answer;
	}
}

class Job implements Comparable<Job> {
	int startTime;
	int work;

	public Job(int startTime, int work) {
		super();
		this.startTime = startTime;
		this.work = work;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getWork() {
		return work;
	}

	public void setWork(int work) {
		this.work = work;
	}

	@Override
	public int compareTo(Job o) {
		if (this.work < o.work)
			return -1;
		else if (this.work == o.work)
			if (this.startTime < o.startTime)
				return -1;

		return 1;
	}
}