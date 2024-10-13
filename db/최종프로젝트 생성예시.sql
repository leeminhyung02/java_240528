use RESTAURANT;
# 사용자 생성 예시
insert into restaurant.user(User_id,  user_name, user_pw, user_email)
values('test1', '사용자1', 'test_1', 'test_1@email.com');

# 음식점 생성 예시
insert into restaurant.restaurant(address, res_name, res_type, res_score, permission, res_info, res_banner, User_id)
values('주소', '가게이름', '가게 타입', 10, false, '가게 정보', '가게 배너', 'test');

update restaurant as res, review as rev
	set res.res_score = rev.score
	where res.res_id = rev.res_id;

# 리뷰 생성 예시
insert into restaurant.review(content, score, User_id, Res_id)
values('리뷰내용', 10, 'test1', 1);

# 신고 생성 예시
insert into restaurant.report(Rev_id, rep_reason, res_state)
values(1, '신고 이유', false);

# 즐겨찾기 생성 예시
insert into restaurant.favorites(User_id, Res_id)
values('test1', 1);

# 검색기록 생성 예시
insert into restaurant.search_history(User_id, history)
values('test1', '검색기록');

# 제제기준(report_manage) 생성 예시
insert into restaurant.report_manage(Report_stack, report_date)
values(10, 9999);