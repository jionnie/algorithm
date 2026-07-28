import java.util.*;

/**
 * 문제 분석
 * 1. 먼저 작업 처리이기 때문에, 먼저 들어온 작업부터 처리하는 큐를 사용한다.
 * 2. 큐에서 먼저 들어와있던 프로세스부터 꺼내보는데, 매개값으로 주어진 우선순위를 확인한다.
 * 3. 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣는다. (rear에 삽입)
 * 4. 우선순위가 더 높은 프로세스가 없다면 방금 꺼낸 프로세스를 그냥 실행한다.
 * 5. 한 번 실행한 프로세스는 그대로 꺼낸다. (종료)
 * 6. 우선순위는 숫자가 클 수록 높다.
 * 7. location은 0부터 시작한다.
 * 8. return 값은 1부터 시작한다. (몇 번째로 실행되는지)
 */
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        int searchItem = 0;
        int index = 0;
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] { priorities[i], i }); // 작업 프로세스를 들어온 순서대로 배정 (FIFO) { 우선 순위, 원래 인덱스 }

            if (queue.peek() != null && i == location) {
                searchItem = location; // 몇 번째에 실행되는지 알고 싶은 프로세스 저장
            }
        }

        // 하나씩 꺼내면서 우선 순위 체크
        while (!queue.isEmpty()) {
            int[] pollItem = queue.poll(); // Queue에서 가장 먼저 들어온 값 꺼내기
            boolean hasHigherPriority = false;
            int size = queue.size();

            // 꺼내온 pollItem과 Queue 전체를 돌면서 비교 (전부 poll 하고 다시 offer 해주면 원위치)
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();

                if (pollItem[0] < temp[0]) {
                    hasHigherPriority = true;
                }

                queue.offer(temp);
            }

            // 우선 순위가 높은 것이 있었다면 다시 Queue에 집어넣음
            if (hasHigherPriority) {
                queue.offer(pollItem);
                continue; // 프로세스가 실제로 실행 됐을 때만 index가 증가하도록 continue
            }

            // 꺼낸 값이 찾는 값과 동일하면 꺼내는 순서를 알기 위해 인덱스에 +1
            if (pollItem[1] == searchItem) {
                answer = index + 1;
            }

            index++;
        }

        return answer;
    }
}