import java.util.*;

/**
 * 문제 해석
 * 1. 정수 배열 array가 주어진다.
 * 2. i, j, k가 담긴 2차원 배열. commands가 주어진다. (여러 개란 뜻)
 * 3. i부터 j까지 자른 배열을 정렬 후 k번째에 있는 숫자들을 담은 배열을 구하는 문제
 */
class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        /**
         * 풀이 흐름
         * 1. commands에서 1차원 배열을 하나씩 꺼낸다.
         * 2. 돌아가면서 array를 i, j에 맞춰 배열을 자른다. (인덱스에 유의)
         * 3. 자른 배열을 정렬한 후 k에 맞춰 값을 꺼낸다.
         * 4. 값을 미리 선언해둔 1차원 배열에 넣는다.
         * 5. 결과가 완성되면 반환한다.
         */
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] newArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(newArr);
            answer[i] = newArr[commands[i][2] - 1];
        }
        
        return answer;
    }
}