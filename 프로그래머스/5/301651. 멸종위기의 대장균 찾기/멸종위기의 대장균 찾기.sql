# 자신을 PARENT_ID 값으로 가지는 ID가 없어야 한다.
# EXISTS와 NOT EXISTS는 괄호 안의 서브쿼리가 행을 반환하는지 여부를 검사하는 조건이다.
# SELECT 1은 EXISTS 안에서 조건을 만족하는 행이 존재하는지 확인하기 위해 사용하는 표현이다.
WITH RECURSIVE ECOLI_GENERATION AS (
    # 1. 시작점: 부모가 없는 대장균
    SELECT ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    # 2. 반복: 앞에서 찾은 대장균의 자식 찾기
    SELECT E.ID, G.GENERATION + 1
    FROM ECOLI_DATA E
    JOIN ECOLI_GENERATION G ON E.PARENT_ID = G.ID
)

SELECT COUNT(*) AS COUNT,
       G.GENERATION
FROM ECOLI_GENERATION G
WHERE NOT EXISTS (SELECT 1
                  FROM ECOLI_DATA C
                  WHERE C.PARENT_ID = G.ID)
GROUP BY G.GENERATION
ORDER BY G.GENERATION ASC