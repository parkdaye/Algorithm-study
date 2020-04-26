package programmers.hyundai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hyundai2 {

	public static void main(String[] args) {
		String[] ip = { "7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0",
				 "7.124.10.0"};
		String[] langs = { "C++", "Java", "C#", "C#", "C", "Python3" };
		int[] scores = {314, 225, 45, 0, 155, 400};
		System.out.println(solution(ip, langs, scores));
	}

	public static int solution(String[] ip_addrs, String[] langs, int[] scores) {

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < ip_addrs.length; i++) {
			if (!map.containsKey(ip_addrs[i]))
				map.put(ip_addrs[i], 1);
			else
				map.put(ip_addrs[i], map.get(ip_addrs[i]) + 1);
		}

		int cheat = 0;
		for (String key : map.keySet()) {
			int count = map.get(key);

			List<IP> ip = new ArrayList<>();
			for (int i = 0; i < ip_addrs.length; i++) {
				if (key.equals(ip_addrs[i])) {
					ip.add(new IP(ip_addrs[i], langs[i], scores[i]));
				}
			}

			if (count == 2) {
				IP ip1 = ip.get(0);
				IP ip2 = ip.get(1);
				if (ip1.getLangs() == ip1.getLangs() && ip1.getScores() == ip2.getScores())
					cheat += 2;
			} else if (count == 3) {
				IP ip1 = ip.get(0);
				IP ip2 = ip.get(1);
				IP ip3 = ip.get(2);
				if (ip1.getLangs() == ip2.getLangs() && ip1.getLangs() == ip3.getLangs())
					cheat += 3;
			} else if (count >= 4) {
				cheat += count;
			}
		}

		int answer = ip_addrs.length - cheat;
		return answer;
	}

}

class IP {
	String ip_addrs;
	int langs;
	int scores;

	public IP(String ip_addrs, String langs, int scores) {
		super();
		this.ip_addrs = ip_addrs;
		this.langs = setGroup(langs);
		this.scores = scores;
	}

	private int setGroup(String langs) {
		if (langs.equals("C") || langs.equals("C++") || langs.equals("C#"))
			return 1;
		else if (langs.equals("Java"))
			return 2;
		else if (langs.equals("JavaScript"))
			return 3;
		else if (langs.equals("Python3"))
			return 4;

		return -1;
	}

	public String getIp_addrs() {
		return ip_addrs;
	}

	public void setIp_addrs(String ip_addrs) {
		this.ip_addrs = ip_addrs;
	}

	public int getLangs() {
		return langs;
	}

	public void setLangs(String langs) {
		this.langs = setGroup(langs);
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

}

/**
 * 사이버 코딩 대학(Cyber Coding University, 이하 CCU)에서는 학생들을 대상으로 온라인 코딩 경진대회를 실시하였습니다.
 * 심사위원 자격으로 학생들의 접속 로그를 살펴본 당신은, 같은 IP 주소가 여러 학생들에게 중복되는 것을 확인하였습니다. 하지만 같은
 * IP주소가 반복되었다고 해서, 무조건 부정 행위가 있었다고 단정할 수는 없습니다. 같은 방을 쓰는 학생들이 컴퓨터 한 대로 차례차례
 * 경진대회에 응시했다면, 같은 IP를 사용했어도 부정 행위는 아니기 때문입니다. 따라서 당신은, 아래와 같은 3가지 기준을 만들어서 부정
 * 참가자를 판별하기로 했습니다.
 * 
 * [조건 1] 같은 IP주소로 접속한 학생이 4명 이상이면, 해당 IP로 접속한 학생은 모두 부정 참가자 입니다. [조건 2] 같은
 * IP주소로 접속한 학생이 3명이고, 3명이 모두 같은 언어군을 사용했다면 3명은 부정 참가자 입니다. [조건 3] 같은 IP주소로 접속한
 * 학생이 2명이고, 2명이 같은 언어군을 사용했고, 성적도 동일하다면 2명은 부정 참가자 입니다.
 * 
 * 경진대회에서 학생들이 사용할 수 있는 언어는 C, C++, C#, Java, JavaScript, Python3 6가지 입니다. 이
 * 중에서, C, C++, C#은 서로같은 언어군으로 분류합니다. Java, JavaScript, Python3은 자기 자신을 제외하면 같은
 * 언어군인 언어는 없습니다.
 * 
 * 학생들의 IP주소를 담은 문자열 배열 ip_addrs, 사용 언어를 담은 문자열 배열 langs, 시험 점수를 담은 정수형 배열
 * scores가 매개변수로 주어집니다. 이 때, 전체 학생들 중에서 부정 참가자를 제외한 정당한 참가자의 수를 구해서 return 하도록
 * solution 함수를 완성해주세요.
 * 
 * 제한사항 ip_addrs의 길이는 1이상 100,000 이하입니다. ip_addrs의 원소는 숫자와 .로 이루어진 문자열로, IPv4
 * 형식을 준수합니다. IPv4 형식 문자열 형태로, 0부터 255까지의 숫자 4개를 .을 이용해 구분해서 표현합니다. ex) 0.0.0.0
 * ~ 255.255.255.255 0을 제외한 다른 숫자는 0으로 시작하지 않습니다. 0은 0으로만 표시합니다. 즉 00과 같이 표시하지
 * 않습니다. ex) 127.0.0.1 1번 학생의 IP주소부터 차례대로 주어집니다. langs의 길이는 id_addrs의 길이와 동일합니다.
 * langs의 원소는 "C", "C++", "C#", "Java", "JavaScript", "Python3" 6가지 중 하나입니다. 1번
 * 학생이 사용한 언어부터 차례대로 주어집니다. scores의 길이는 id_addrs의 길이와 동일합니다. scores의 원소는 0이상 400
 * 이하인 정수입니다. 1번 학생의 성적부터 차례대로 주어집니다. 입출력 예 ip_addrs langs scores result
 * ["5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5",
 * "155.123.124.111", "10.16.125.0", "10.16.125.0"] ["Java", "C++", "Python3",
 * "C#", "Java", "C", "Python3", "JavaScript"] [294, 197, 373, 45, 294, 62, 373,
 * 373] 3 ["7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0",
 * "7.124.10.0"] ["C++", "Java", "C#", "C#", "C", "Python3"] [314, 225, 45, 0,
 * 155, 400] 2
 * 
 * 입출력 예 설명 입출력 예 #1
 * 
 * 번호 IP 주소 언어 점수 부정 참가 판별 1 5.5.5.5 Java 294 [조건 3]에 의해서 1, 5번 학생은 부정참가자 2
 * 155.123.124.111 C++ 197 [조건 2]에 의해서 2, 4, 6번 학생은 부정 참가자 3 10.16.125.0 Python3
 * 373 정당한 참가자 4 155.123.124.111 C# 45 [조건 2]에 의해서 2, 4, 6번 학생은 부정 참가자 5 5.5.5.5
 * Java 294 [조건 3]에 의해서 1, 5번 학생은 부정참가자 6 155.123.124.111 C 62 [조건 2]에 의해서 2, 4,
 * 6번 학생은 부정 참가자 7 10.16.125.0 Python3 373 정당한 참가자 8 10.16.125.0 JavaScript 373
 * 정당한 참가자 3, 7, 8번 학생들을 살펴보면, 8번 학생이 3, 7번 학생들과 다른 언어군을 사용했으므로 [조건 2]에 해당하지
 * 않습니다. 따라서 정당한 참가자의 수는 3입니다.
 * 
 * 입출력 예 #2
 * 
 * 번호 IP 주소 언어 점수 부정 참가 판별 1 7.124.10.0 C++ 314 [조건 1]에 의해서 1, 2, 4, 6번 학생은 부정
 * 참가자 2 7.124.10.0 Java 225 [조건 1]에 의해서 1, 2, 4, 6번 학생은 부정 참가자 3 0.0.0.0 C# 45
 * 정당한 참가자 4 7.124.10.0 C# 0 [조건 1]에 의해서 1, 2, 4, 6번 학생은 부정 참가자 5 0.0.0.0 C 55
 * 정당한 참가자 6 7.124.10.0 Python3 400 [조건 1]에 의해서 1, 2, 4, 6번 학생은 부정 참가자 3, 5번
 * 학생들을 살펴보면, 같은 언어군을 사용했으나 점수가 다르므로 [조건 3]에 해당하지 않습니다. 따라서 정당한 참가자의 수는 2입니다.
 */