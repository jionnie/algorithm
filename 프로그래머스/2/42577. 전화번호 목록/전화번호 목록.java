import java.util.*;

/**
 * 문제 분석
 * 1. phone_book에 들어있는 전화번호 중 하나라도 다른 번호의 접두어인 경우 찾기
 * 2. 접두어인 경우가 있다면 false, 없다면 true
 */
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        for (String phoneNumber : phone_book) {
            set.add(phoneNumber); // Set에 전화번호 전부 저장
        }

        for (String phoneNumber : phone_book) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i); // 접두어(prefix) 후보 생성

                if (set.contains(prefix)) { // prefix 후보 중에서 (매개변수로 주어진 전화번호 중에) 실제로 존재하는 전화번호가 있는지
                    return false;
                }
            }
        }

        return true;
    }
}