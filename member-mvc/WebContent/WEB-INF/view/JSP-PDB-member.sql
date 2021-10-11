--MEMBER 테이블 DDL(oracle)
create table member(
    id varchar2(10),
    pwd varchar2(10),
    name varchar2(50),
    email varchar2(50),
    joinDate date
);

--데이터 입력
insert into member values('jin', '1111','이요신','jins@gmail.com', SYSDATE);
insert into member values('lee', '1111','이순신','lee@gmail.com', SYSDATE);
insert into member values('song', '1111','이주신','song@gmail.com', SYSDATE);

select * from member;