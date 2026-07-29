import java.util.*;

/**
 * 문제 분석
 * 1. 0 ~ 9 사이의 정수로 이루어진 배열 arr가 주어진다.
 * 2. arr에서 연속적으로 숫자가 나타난다면 하나만 남기고 전부 제거한다.
 * 3. 단, 제거된 후 남은 수들의 숫자들은 원래 순서를 유지해야 한다.
 * 4. 가장 나중에 들어간 데이터를 다루는 문제이므로 스택을 사용해서 풀 수 있다.
 * 5. 하지만 스택까지도 사용할 필요 없이 배열을 순회해서 풀 수 있다.
 */
public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int prev = -1;

        for (int now : arr) {
            if (prev != now) {
                answer.add(now);
                prev = now;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}