SELECT p.product_id, p.product_name, sum(price * amount) as total_sales
from food_product p join food_order o on o.product_id = p.product_id
where date(o.produce_date) like '2022-05%'
group by product_id
order by total_sales desc, p.product_id;
