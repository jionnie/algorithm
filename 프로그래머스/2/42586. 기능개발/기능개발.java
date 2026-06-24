import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        // 1. 첫 번째 작업의 배포 날짜를 바로 계산하여 기준으로 설정
        int currentDay = ((100 - progresses[0]) + speeds[0] - 1) / speeds[0];
        int count = 1;
        
        // 2. 두 번째 작업부터 순회하면서 실시간 비교
        for (int i = 1; i < progresses.length; i++) {
            // 남은 작업량 + (속도 - 1) / 속도
            // 정수 나눗셈은 버림이기 때문에 다음 정수 구간으로 넘어가도록 해줌
            int nextDay = ((100 - progresses[i]) + speeds[i] - 1) / speeds[i];
            
            if (nextDay <= currentDay) {
                count++;
            } else {
                result.add(count);
                currentDay = nextDay; // 기준일 갱신
                count = 1; // 카운트 초기화
            }
        }

        result.add(count); // 마지막 배포 추가
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}