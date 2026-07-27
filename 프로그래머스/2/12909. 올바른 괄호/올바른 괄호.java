import java.util.*;

/**
 * 문제 분석
 * 1. 가장 나중에 나온 열린 괄호를 기억해야 하나씩 닫아 나갈 수 있다. -> 스택
 * 2. 열린 괄호를 계속 스택에 담아서 가장 마지막 열린 괄호부터 닫아 나간다.
 * 3. 닫힌 괄호와 함께 소거하며 계속 닫아 나가다가 문자열을 다 돈 후 스택이 비어있으면 true
 * 4. 열린 괄호가 없는데 닫힌 괄호가 나오거나, 괄호 개수가 안 맞으면 false
 */
class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}