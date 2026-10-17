# COUNT(*)이 아니라 COUNT(컬럼)으로 조회하면 null은 집계되지 않음
SELECT COUNT(DISTINCT NAME) AS count 
FROM ANIMAL_INS