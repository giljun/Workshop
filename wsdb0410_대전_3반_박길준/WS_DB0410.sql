/* 2019. 04. 10 DB_WORKSHOP */
/* Query 1 */
desc emp;

/* Query 2 */
select empno, ename from emp
where ename like '%K';

/* Query 3 */
select * from emp
where hiredate like '2000%';

/* Query 4 */
select * from emp
where comm is not null;

/* Query 5 */
select * from emp
where deptno=30 and sal>=1500;

/* Query 6 */
select * from emp
where deptno=30 order by empno asc;

/* Query 7 */
select * from emp
order by sal desc;

/* Query 8 */
select * from emp
order by deptno asc, sal desc;

/* Query 9 */
select * from emp
order by deptno desc, ename asc, sal desc;

/* Query 10 */
select ename, sal, (sal*comm/100), sal+(sal*comm/100) as total from emp
where comm is not null
order by total desc;

/* Query 11 */
select ename, sal, (sal*1.13) as bonus, deptno from emp
where deptno=10;

/* Query 12 */
select ename, sal, round(sal/12/5) as wage from emp
where deptno=20;

/* Query 13 */
select ename, sal, round(sal*0.15, 1) as fee from emp
where sal between 1500 and 3000;

/* Query 14 */
select ename, sal, (sal-(sal*0.1)) as netpay from emp
order by sal desc;

/* Query 15 */
select lower(substr(ename, 1, 3))as name from emp
where length(ename) >= 6;

/* Query 16 */
select avg(sal), max(sal), min(sal), count(sal) from emp
where deptno=10;

/* Query 17 */
select * from emp;
select deptno, job, count(*) from emp group by deptno, job;

/* Query 18 */
select job, count(*) from emp
group by job
having count(job)>=4;

/* Query 19 */
select ename, hiredate, datediff(now(), hiredate) as workdate from emp;

/* Query 20 */
select ename, ceil(datediff(now(), hiredate)/365) as workyear from emp;