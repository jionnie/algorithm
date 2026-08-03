import java.util.*;

/**
 * 문제 분석
 * 1. 단 한 명의 선수를 제외하고 모든 선수가 마라톤을 완주했다.
 * 2. 마라톤에 참여한 선수들의 이름이 담긴 participant 배열이 주어진다.
 * 3. 완주한 선수들의 이름이 담긴 배열 completion이 주어진다.
 * 4. 완주하지 못한 선수의 이름을 return 해라.
 */
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String name = "";

        // 동명이인 가능 -> 몇 명인지를 저장해야함
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                name = entry.getKey();
            }
        }

        return name;
    }
}