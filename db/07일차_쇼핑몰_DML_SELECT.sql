USE shoppingmall;
# 분류별 등록된 제품수를 조회하는 쿼리 
SELECT 
    CA_NAME 분류명, COUNT(PR_CODE) 제품수
FROM
    PRODUCT
RIGHT JOIN
	CATEGORY ON CA_NUM = PR_CA_NUM
GROUP BY CA_NUM;

# 옷으로 등록된 제품들을 조회하는 쿼리
SELECT
 * 
 FROM
	PRODUCT 
	JOIN 
	CATEGORY ON PR_CA_NUM = CA_NUM 
 WHERE
	CA_NAME = '옷';

# 시원함이 들어간 제품을 검색 => 제목에 시원한이 포함된 제품을 조회하는 쿼리
SELECT * FROM PRODUCT WHERE PR_NAME LIKE '%시원한%';

# 판매량이 가장 많은 제품들을 조회하는 쿼리 => 
SELECT
	DENSE_RANK() OVER(ORDER BY SUM(BU_AMOUNT) DESC) 판매순위,PRODUCT.*,SUM(BU_AMOUNT) 판매랑
FROM 
	PRODUCT 
		LEFT JOIN
	(SELECT * FROM BUY WHERE BU_STATE IN('구매','구매확정'))B ON BU_PR_CODE = PR_CODE
group by PR_CODE;

# 옷 제품들 중에서 가격이 높은순으로 제품을 조회하는 쿼리
select 
	me_id, ifnull(format(sum(pr_price * bu_amount),0),0) 누적구매금액
from
	member
		left join
	(select * from buy where bu_state in ('구매', '구매확정'))b on me_id = bu_me_id
		left join
	product on pr_code = bu_pr_code
group by me_id;

# 회원별 누적 금액을 조회하는 쿼리
