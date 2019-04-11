/* Query 1, 2 */
insert into book(isbn, title, author, publisher, price, description)
values('123-1-14','java와 coffee','diana','자바닷컴',8000,'삶의 즐거움');
insert into book(isbn, title, author, publisher, price, description)
values('555-23-2','AI와 미래','현주','미래닷컴',2000,'');
insert into book(isbn, title, author, publisher, price, description)
values('888-88-8','2019년 4월 11일 3시 11분','임현철','사피닷컴',8888,'현철이의 하루');
insert into book(isbn,title,author,publisher,price,description)
values('123-2-15','Java와 놀기','김태희','자바닷컴',22000, 'Java 정복'); 
insert into book(isbn,title,author,publisher,price,description)
values('123-6-24','Java와 알고리즘','서민규','자바닷컴',20000, '성능 업!!');
insert into book(isbn,title,author,publisher,price,description)
values('423-5-36','IoT세상','이세준','미래닷컴',25000,'');
insert into book(isbn,title,author,publisher,price,description)
values('019-4-11','Java200제','조효은','한빛미디어',2500,''); 
 
/* Query 3 */ 
select * from book;
update book set price=price*0.9;

/* Query 4 */
select isbn from book where title like '%AI%';
update book set price=price*1.2
where title like '%AI%';
select * from book;

/* Query 5 */
delete from book
where title like '%Java%' and price < 10000;
select * from book;

/* Query 6 */
select count(*) as '출판사별 도서의 개수', sum(price) as '합계', avg(price) as '평균' from book 
group by publisher;