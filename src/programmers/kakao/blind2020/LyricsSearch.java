package programmers.kakao.blind2020;

import java.util.HashMap;
import java.util.Map;

public class LyricsSearch {

	public static void main(String[] args) {
		String words[] = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String queries[] = {"?????", "fro??", "????o", "fr???", "fro???" };

		int[] ans = solution(words, queries);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

//		Map<Integer, Trie[]> tries = new HashMap<>();

//		for (int j = 1; j <= 10000; j++) {
//			tries.put(j, new Trie[2]);
//			tries.get(j)[0] = new Trie();
//			tries.get(j)[1] = new Trie();
//		}

		Trie[] tries = new Trie[2];
		tries[0] = new Trie();
		tries[1] = new Trie();
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			StringBuffer sb = new StringBuffer(w);

			int length = w.length();
			tries[0].insert(w);
			tries[1].insert(sb.reverse().toString());
		}

		for (int i = 0; i < queries.length; i++) {
			String q = queries[i];
			StringBuffer sb = new StringBuffer(q);
			int length = q.length();

//			Trie[] trieArray = tries.get(length);

			if (q.charAt(0) == '?') {
				answer[i] = tries[1].count(sb.reverse().toString());
			} else {
				answer[i] = tries[0].count(q);
			}

		}

		return answer;
	}
}

class Trie {
	private Node root;

	public Trie() {
		this.root = new Node(' ');
	}

	public void insert(String string) {
		Node tmp = root;

		int length = string.length();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);

			Map<Integer, Integer> map = tmp.getLengthCount();
			if (map.containsKey(length))
				map.put(length, map.get(length) + 1);
			else
				map.put(length, 1);
			tmp = tmp.getChildren().computeIfAbsent(c, p -> new Node(p));

		}
	}

	public int count(String key) {
		Node tmp = root;

		int length = key.length();

		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			Node child = tmp.getChildren().get(c);

			if (c == '?')
				return tmp.getLengthCount().get(length);

			if (child == null)
				return 0;

			tmp = child;
		}

		return 0;
	}

	class Node {
		private char c;
		private Map<Character, Node> children;
		private Map<Integer, Integer> lengthCount;

		public Node(char c) {
			super();
			this.c = c;
			this.children = new HashMap<>();
			this.lengthCount = new HashMap<>();
		}

		public char getC() {
			return c;
		}

		public void setC(char c) {
			this.c = c;
		}

		public Map<Character, Node> getChildren() {
			return children;
		}

		public void setChildren(Map<Character, Node> children) {
			this.children = children;
		}

		public Map<Integer, Integer> getLengthCount() {
			return lengthCount;
		}

		public void setLengthCount(Map<Integer, Integer> lengthCount) {
			this.lengthCount = lengthCount;
		}
	}
}
