-- group by는 select 절에 있는 값을 모두 select 해야함 (집계함수는 미포함)
select a.category, a.max_price, f.product_name
from food_product f, (
SELECT category, max(price) as max_price
from food_product
where category in ('과자', '국', '김치', '식용유')
group by category) a
where a.max_price = f.price and a.category = f.category
order by a.max_price desc;
