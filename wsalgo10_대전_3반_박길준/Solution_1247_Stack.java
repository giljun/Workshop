import java.awt.Point;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1247 {
	
	// 회사, 집
	static Point company;
	static Point home;
	
	// 방문검사
	static boolean[] visited;
	
	// 최단경로
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			company = new Point(sc.nextInt(), sc.nextInt());
			home = new Point(sc.nextInt(), sc.nextInt());
			result = Integer.MAX_VALUE;
			
			Point[] customers = new Point[N];
			for (int i = 0; i < N; i++) {
				customers[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			visited = new boolean[N];
			
			go(customers, 0, new Stack<Point>());
			
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void go( Point[] customers, int visit, Stack<Point> pstack) {
		// 방문 수가 customer의 길이와 일치하면, 모든 곳을 다 들린 것으로 판단한다.
		if( visit == customers.length ) {
			// 스택에 저장한 순서대로 경로를 계산하여, 최단 경로를 찾아낸다.
			find_distance(pstack);
			return;
		}
		for (int i = 0; i < customers.length; i++) {
			// 방문했으면, 다음 집으로!
			if(visited[i]) {
				continue;
			} else { // 방문하지 않았다면, 방문하자!
				visited[i] = true;
				// 방문한 고객의 좌표를 스택에 넣어준다.
				pstack.push(customers[i]);
				// 다음 집으로 가즈아!
				go(customers, visit+1, pstack);
				// 함수가 끝나면, 스택에 있는 정보를 하나씩 빼주고, 방문기록도 지워준다.
				pstack.pop();
				visited[i] = false;
			}
		}
	}
	
	static void find_distance(Stack<Point> pstack) {
		int distance = 0;
		int x = company.x;
		int y = company.y;
		// 회사-고객
		for (int i = 0; i < pstack.size(); i++) {
			distance += Math.abs(x-pstack.get(i).x)+Math.abs(y-pstack.get(i).y);
			x = pstack.get(i).x;
			y = pstack.get(i).y;
		}
		// 고객-집
		distance += Math.abs(x-home.x)+Math.abs(y-home.y);
		
		// 최단 경로를 찾아야 하므로, 연산한 계산값이 결과값보다 작으면, 연산한 계산값을 결과값으로 수정한다.
		result = result < distance ? result : distance;
	}
	
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
