import java.util.*;

/**
 * 문제 분석
 * 1. 코니의 옷장에서 나올 수 있는 모든 조합의 수를 구하라.
 * 2. 같은 타입에서는 한 가지만 착용할 수 있다. (얼굴에서는 한 가지만, 상의에서는 한 가지만)
 * 3. 조합이 하나라도 다르면 다른 의상으로 간주한다.
 */
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>(); // Key로 Type(Hat, Face...), Value로 Detail 개수(해당 타입의 옷 개수)
        int answer = 1;

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1); // Key로 타입을 저장했으므로, 같은 타입이 나올 때마다 1 증가
        }

        // 각 상세 의류 중에 아예 고르지 않는 경우의 수 1개까지 더해서 전부 곱한다.
        // 즉, 모자 3개, 안경 2개, 겉옷 2개라면 (3+1) * (2+1) * (2+1)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1; // 전부 선택하지 않는 경우는 없어야 하므로 1을 빼준다.
    }
}