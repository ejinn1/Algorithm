-- 코드를 입력하세요
SELECT category, price, product_name from food_product
where PRICE IN (
    SELECT MAX(PRICE)
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY
) and category in ('과자','국','김치','식용유')
order by price desc