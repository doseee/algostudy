SELECT
    c.car_id,
    CASE
        WHEN COUNT(h.history_id) > 0 THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY c
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY h
  ON c.car_id = h.car_id
 AND DATE('2022-10-16') BETWEEN h.start_date AND h.end_date
GROUP BY c.car_id
ORDER BY c.car_id DESC;
