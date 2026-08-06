import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        // 가장 먼저 들어온 처음 작업부터 작업 완료까지 걸리는 날을 계산해서 Queue에 저장
        for (int i = 0; i < progresses.length; i++) {
            int workCompleteDay = (100 - progresses[i] + speeds[i] - 1) / speeds[i]; // 올림 나눗셈 공식
            queue.offer(workCompleteDay);
        }

        int standardDay = queue.poll(); // 현재 배포의 기준일
        int deploymentCnt = 1; // 배포 개수

        while (!queue.isEmpty()) {
            int nextDay = queue.poll();

             if (nextDay <= standardDay) {
                deploymentCnt++; // 기준일 보다 빨리 끝나거나 같이 끝나면 같이 배포
            } else {
                 answer.add(deploymentCnt);
                 standardDay = nextDay;
                 deploymentCnt = 1;
            }
        }
        // 누락된 마지막 배포 그룹 추가
        answer.add(deploymentCnt);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}