import java.util.*;

/**
 * 문제 분석
 * 1. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 스코빌 지수가 가장 낮은 두 음식을 섞는다.
 * 2. 섞은 음식의 스코빌 = 가장 안 매운 음식 스코빌 + (두 번째로 안 매운 음식 스코빌 * 2)
 * 3. 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞는다.
 */
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본이 Min Heap
        int answer = 0;

        // 우선순위 큐에 스코빌 지수 저장
        for (int s : scoville) {
            pq.offer(s);
        }

        // 우선순위 큐에 저장했으므로 최소 힙으로 정렬되어 저장됨
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            } else {
                int newScoville = pq.poll() + (pq.poll() * 2);
                pq.offer(newScoville);
                answer++;
            }
        }

        return answer;
    }
}