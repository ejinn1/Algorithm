with co as (
select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where year(START_DATE) = 2022 and month(START_DATE) in (8,9,10)
    group by CAR_ID
    having count(*) > 4
)

select MONTH(START_DATE) as MONTH, CAR_ID, COUNT(CAR_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as his inner join co as c using(CAR_ID)
where MONTH(START_DATE) in (8,9,10)
group by MONTH, CAR_ID
order by MONTH asc, CAR_ID DESC;