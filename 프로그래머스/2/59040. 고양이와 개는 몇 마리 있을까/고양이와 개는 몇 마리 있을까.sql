SELECT ANIMAL_TYPE,count(Animal_type) as count
from animal_ins
group by animal_type
order by Animal_type Asc;