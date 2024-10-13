#외래키 추가중
CREATE DATABASE IF NOT EXISTS RESTAURANT;

CREATE TABLE IF NOT EXISTS RESTAURANT.USER(
	User_id varchar(15) primary key,
    user_type varchar(5) not null default '사용자',
    user_name varchar(10) not null,
    user_pw varchar(256) not null,
    user_email varchar(50),
    user_report int,
    user_freeze datetime
);

CREATE TABLE IF NOT EXISTS RESTAURANT.RESTAURANT(
	Res_id int primary key auto_increment ,
    address varchar(100) not null,
    res_name varchar(20) not null,
    res_type varchar(20),
    res_score int,
    permission boolean,
    res_info varchar(200),
    res_banner varchar(100),
    User_id varchar(15),
    foreign key (User_id) references USER (User_id)
);

CREATE TABLE IF NOT EXISTS RESTAURANT.REVIEW(
	Rev_id int primary key auto_increment,
    content varchar(100),
    score int,
    User_id varchar(15),
    Res_id int,
    foreign key (User_id) references USER (User_id),
    foreign key (Res_id) references RESTAURANT (Res_id)
);

CREATE TABLE IF NOT EXISTS RESTAURANT.REPORT(
	Rev_id int primary key,
    rep_reason varchar(100),
    res_state boolean,
    foreign key (Rev_id) references REVIEW (Rev_id)
);

CREATE TABLE IF NOT EXISTS RESTAURANT.FAVORITES(
	Fav_id int primary key auto_increment,
    User_id varchar(15),
    Res_id int,
    foreign key (User_id) references USER (User_id),
    foreign key (Res_id) references RESTAURANT (Res_id)
);


  
CREATE TABLE IF NOT EXISTS RESTAURANT.SEARCH_HISTORY(
	SH_id int primary key auto_increment,
    history varchar (30) not null,
    his_date datetime default current_timestamp,
    User_id varchar(15),
    foreign key (User_id) references USER (User_id)
);

CREATE TABLE IF NOT EXISTS RESTAURANT.REPORT_MANAGE(
	Report_stack int primary key,
    report_date int not null
);