create table meberdb (
id varchar2(20),
pw varchar2(20),
name varchar2(20),
addr varchar2(300),
reply varchar2(300),
primary key(id)
);

insert into teamMember values('test','1234','홍길동','서울시','안녕하세요');

commit;
