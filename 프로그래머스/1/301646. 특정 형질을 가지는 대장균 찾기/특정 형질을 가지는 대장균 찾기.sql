-- 2번 형질이 보유하지 않으면서 = GENOTYPE & 2 = 0 → 2번 형질 없음
-- 1번 or 3번 형질을 보유하고 있는 대장균 개체의 수 = (GENOTYPE & 1) <> 0 OR (GENOTYPE & 4) <> 0
-- 3번 형질 = 4 인 이유는 2진수에서 “세 번째 비트 자리값”이 4이기 때문
SELECT COUNT(*) AS COUNT 
FROM ECOLI_DATA
WHERE GENOTYPE & 2 = 0 AND (GENOTYPE & 1 <> 0 OR GENOTYPE & 4 <> 0)