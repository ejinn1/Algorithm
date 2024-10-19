select a.author_id, a.author_name, b.category, sum(sales*price) as total_sales
from book as b
join book_sales as bs on b.book_id = bs.book_id
join author as a on b.author_id = a.author_id
where year(bs.sales_date) = '2022' and month(bs.sales_date) = '1'
group by a.author_id, b.category
order by a.author_id asc, b.category desc