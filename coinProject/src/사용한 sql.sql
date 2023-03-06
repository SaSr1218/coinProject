
drop database if exists project;
create database project;

use project;

-- 멤버 테이블
drop table if exists member;
create table member (
	mNo int auto_increment primary key,  	-- 멤버 고유키
    mId varchar(20) unique,					-- 멤버 아이디 ( 계정 )
    mPw varchar(20),						-- 멤버 패스워드
    mName varchar(20) ,						-- 멤버 이름
    mPhone varchar(20) unique,				-- 멤버 휴대전화
    mEmail varchar(20) unique,				-- 이메일
    mState boolean
);

drop table if exists coinlist;
create table coinlist(
	cNo int auto_increment primary key,		-- 코인 고유번호
    cName varchar(20) unique,				-- 코인 이름
    cPrice int ,							-- 코인 가격
    cAmount int	,							-- 코인 전체수량
    cFirstprice int  						-- 코인 초기가격
);

-- 구매 테이블
drop table if exists buy;
create table buy (
	bNo int auto_increment primary key,				-- 구매 고유번호
    bPrice int not null,							-- 구매 가격
    bAmount int not null,							-- 구매 수량
    bDate datetime default now(),					-- 구매날짜
    mNo int,										-- 구매한사람(멤버) 고유번호
    cNo int,
    foreign key ( mNo ) references member ( mNo ) on delete cascade,
    foreign key ( cNo ) references coinlist ( cNo ) on delete cascade
);

-- 판매 테이블
drop table if exists sell;
create table sell(
	sNo int auto_increment primary key,				-- 판매 고유번호
    sPrice int not null,							-- 판매 가격
    sAmount int not null,							-- 판매 수량
    sDate datetime default now(),					-- 판매날짜
    bNo int,										-- 구매
    cNo int,
    foreign key ( bNo ) references buy ( bNo ) on delete cascade ,
    foreign key ( cNo ) references coinlist ( cNo ) on delete cascade
);

drop table if exists account;
create table account(							
	aNo int auto_increment primary key,				-- account 고유번호
    aName int  ,									-- 계좌멤버 이름
    aAcount int  ,									-- 계좌번호
    aBalance int ,									-- 잔고
    aAmount int ,									-- 잔여갯수
    adeposit int ,									-- 입금금액
    withdraw int ,									-- 출금금액
    mNo int,										-- 멤버 고유번호
    cNo int,										-- 코인 고유번호
    foreign key ( mNo ) references member ( mNo ) on delete cascade ,
    foreign key ( cNo ) references coinlist ( cNo )  on delete cascade
);

drop table if exists create_acc;
create table create_acc(
	accNo int auto_increment primary key,
    accName varchar(20),
    accountNo varchar(20),					-- 계좌번호
    accBalance int	,						-- 계좌 잔고
    mNo int,
    foreign key ( mNo ) references member ( mNo ) on delete cascade
);



drop table if exists coinmarketP ;
create table coinmarketP(
	CMNo int auto_increment primary key,
    CIPrice int not null,
    CMprice int not null,
    CMRemaining int not null,
    CMDate datetime default now(),
    cNo int,
    foreign key ( cNo ) references coinlist ( cNo ) on delete cascade
);

drop table if exists coinTradeList;
create table coinTradeList(
	CTNo int auto_increment primary key,
    CTPrice int not null,
    CTVolume int not null,
    CTDate datetime default now(),
    Buystate char(1),
    Sellstate char(1) default null,
    cNo int,
    mNo int,
    foreign key ( cNo ) references coinlist ( cNo ) on delete cascade,
    foreign key ( mNo ) references member ( mNo ) on delete cascade
);

drop table if exists personal_coinlist;
create table personal_coinlist(
	pcNo int auto_increment primary key,
    pcAmount int not null,
    pcSumPrice int not null,
    mno int,
    cno int,
    foreign key ( mno ) references member ( mno ) on delete cascade,
    foreign key ( cno ) references coinlist ( cno ) on delete cascade
);

insert into member ( mId , mPw , mName , mPhone , mEmail , mstate ) values ( 'admin' , 'admin' ,  '관리자' , '00000000000' , 'admin@admin' , true);

select * from coinmarketP;