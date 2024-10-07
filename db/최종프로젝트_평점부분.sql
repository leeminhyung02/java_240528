update restaurant , (select res_id, avg(score) as score_avg from review group by Res_id) as rev
	set restaurant.res_score = rev.score_avg
    where restaurant.res_id = rev.res_id;