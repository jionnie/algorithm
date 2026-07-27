import java.util.*;

/**
 * 문제 분석
 * 1. 가장 나중에 나온 열린 괄호를 기억해야 하나씩 닫아 나갈 수 있다. -> 스택
 * 2. 열린 괄호를 계속 스택에 담아서 가장 마지막 열린 괄호부터 닫아 나간다.
 * 3. 닫힌 괄호와 함께 소거하며 계속 닫아 나가다가 다음 열린 괄호까지 스택이 비게 되면 true
 * 4. 스택이 비지 않았는데 다시 열린 괄호가 나오거나 닫힌 괄호로 시작하면 false
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