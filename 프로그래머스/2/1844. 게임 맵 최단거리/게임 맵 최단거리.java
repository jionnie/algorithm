import java.util.*;

/**
 * 문제 분석
 * 1. 상대팀 진영에 가장 빠르게 갈 수 있는 칸수 (최단거리) 리턴
 * 2. 상대팀 진영에 도달할 수 없을 경우는 -1 리턴
 * 3. 최단거리 문제이므로 BFS 사용
 */
class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>(); // 앞으로 방문할 정점 저장
        int[][] distance = new int[maps.length][maps[0].length]; // 거리와 방문 여부 판별

        queue.offer(new int[] { 0, 0 }); // 시작 위치 저장
        distance[0][0] = 1; // 우리 팀 첫 위치

        int[] dr = new int[] { -1, 1, 0, 0 }; // 상하좌우 (row)
        int[] dc = new int[] { 0, 0, -1, 1 }; // 상하좌우 (col)

        while (!queue.isEmpty()) {
            // 1. 큐에서 현재 위치 꺼내기
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // 2. 현재 위치에서의 상/하/좌/우 확인
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                // 다음 위치가 맵 안에 있는지 조사
                if (nextRow < 0 || nextRow > maps.length - 1 || nextCol < 0 || nextCol > maps[0].length - 1) {
                    continue;
                }

                if (maps[nextRow][nextCol] == 1) { // 다음 위치가 벽인지 아닌지 조사
                    if (distance[nextRow][nextCol] == 0) { // 다음 위치를 이전에 방문했는지 조사
                        queue.offer(new int[]{nextRow, nextCol}); // 전부 해당 안 되면 다음 탐색에 저장
                        distance[nextRow][nextCol] = distance[row][col] + 1; // 거리 저장

                        if (nextRow == maps.length - 1 && nextCol == maps[0].length - 1) {
                            return distance[maps.length - 1][maps[0].length - 1];
                        }
                    }
                }
            }

        }

        // 다 돌았는데 도달하지 못 했으면 -1 리턴
        return -1;
    }
}