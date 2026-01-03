SELECT i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, a.score
from rest_info i,
(SELECT i.rest_id, ROUND(avg(r.review_score), 2) as score
from rest_info i, rest_review r
where r.rest_id = i.rest_id
group by r.rest_id) a
where i.rest_id = a.rest_id and address like '서울%'
order by a.score desc, i.favorites desc
