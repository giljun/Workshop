desc dept;
desc emp;

select * from emp;
select * from dept;

/*
	Query 3
*/
select e.ename, e.sal, d.dname from emp as e
join dept as d on e.deptno = d.deptno;

/*
	Query 4
*/
select e.ename, d.dname from emp as e
join dept as d on e.deptno = d.deptno
where e.ename like '%KING%';

/*
	Query 5
*/
select e.ename, e.deptno, d.dname, e.sal from emp as e
join dept as d on e.deptno = d.deptno;

/*
	Query 6
*/
select concat(e1.ename,'의 매니저는 ',e2.ename,'이다') as 관계 from emp e1, emp e2
where e1.mgr = e2.empno;

/*
	Query 7
*/
select e.ename, d.dname, e.sal, e.job from emp as e
join dept as d on e.deptno = d.deptno
where e.job in (select job from emp where ename like '%SCOTT%');

/*
	Query 8
*/
select empno, ename, hiredate, sal from emp
where deptno in (select deptno from emp where ename like '%SCOTT%');

/*
	Query 9
*/
select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal from emp as e
join dept as d on e.deptno = d.deptno
where e.sal > (select avg(sal) from emp);

/*
	Query 10
*/
select e.empno, e.ename, d.dname, d.loc, e.sal from emp as e
join dept as d on e.deptno = d.deptno
where e.job in (select job from emp where deptno = 30);

/*
	Query 11
*/
select e.empno, e.ename, d.dname, e.hiredate, d.loc from emp as e
join dept as d on e.deptno = d.deptno
where e.job not in (select job from emp where deptno = 30) and e.deptno = 10;

/*
	Query 12
*/
select empno, ename, sal from emp
where sal in (select sal from emp where ename like '%KING%' or ename like '%JAMES%'); 

/*
	Query 13
*/
select empno, ename, sal from emp
where sal > (select max(sal) from emp where deptno = 30);

/*
	Query 14
*/
CREATE index eidx on emp (ename);

/*
	Query 15
*/
select ename, sal
from emp
where year(hiredate) in ( select year(hiredate) from emp where ename='ALLEN');

/*
	Query 16
*/
CREATE OR REPLACE VIEW EVIEW
AS
SELECT DEPTNO, SUM(SAL) SSAL
FROM EMP
group by DEPTNO
order by SSAL; 

/*
	Query 17
*/
SELECT * FROM EVIEW ORDER BY SSAL DESC LIMIT 3;