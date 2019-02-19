import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124 {
	static int N, E; // 정점의 수, 간선의 수
	static boolean[] visit;
	static int[] parent;
	static PriorityQueue<Edge> pq;
	static ArrayList<Edge> mst;
	static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			result = 0;
			mst = new ArrayList<>();
			visit = new boolean[N + 1];
			parent = new int[N + 1];
			pq = new PriorityQueue<>(new EdgeComparator());

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}

			kruskal();
			
			for (int i = 0; i < mst.size(); i++) {
				result += mst.get(i).value;
			}

			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void kruskal() {
		// 1. 모든 정점들을 일단 각각 전부 대표로 만들어 놓고 시작.
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		// 2. 가중치가 작은 순선대로 우선순위 큐에서 꺼낸다.
		for (int i = 0; i < E; i++) {
			Edge edge = pq.poll();
			
		// 3. 가중치가 작은 간선의 시작정점과 끝정점의 대표자가 같으면, 사이클이므로 연결하면 안됨.
			if(find(edge.start) == find(edge.end)) {
				continue;
			}
			
		// 4. 사이클이 안생기는 간선의 양 접점을 하나로 합병
			union(edge.start, edge.end);
			
		// 5. 선택된 간선을 mst에 추가한다.
			mst.add(edge);
		}
	}
	
	static int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}
	
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1!=p2) {
			parent[p1] = p2;
		}
	}
	
	static class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value > o2.value ? 1 : -1;
		}
	}

	static class Edge {
		int start, end;
		long value;

		Edge(int s, int e, long v) {
			start = s;
			end = e;
			value = v;
		}
	}
}
