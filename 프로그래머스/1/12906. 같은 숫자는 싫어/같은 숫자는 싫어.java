import java.util.*;

/**
 * 문제 분석
 * 1. 0 ~ 9 사이의 정수로 이루어진 배열 arr가 주어진다.
 * 2. arr에서 연속적으로 숫자가 나타난다면 하나만 남기고 전부 제거한다.
 * 3. 단, 제거된 후 남은 수들의 숫자들은 원래 순서를 유지해야 한다.
 */
public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        int prev = -1;
        int size = stack.size();
        
        for (int i = 0; i < size; i++) {
            int now = stack.pop();

            if (prev == now) {
                prev = now;
                continue;
            }

            answer.add(now);

            prev = now;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}