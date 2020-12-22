--select某学生寝室所参加的所有卫生评比记录
create procedure selectCleanContestsWithSno
	@sno char(8)
as
	select c.* 
	from 
		ccontest c, 
		student s 
	where 
	s.sno = @sno and 
	c.dbno = s.dbno and 
	c.dbd = s.dbd and 
	c.drbno = s.drbno 
	order by c.cdate desc;

--select某学生所对应寝室的所有费用记录
create procedure selectFeesWithSno
	@sno char(8)
as
	select f.* 
	from 
		fees f, 
		student s 
	where 
	s.sno = @sno and 
	f.dbno = s.dbno and
	f.dbd = s.dbd and 
	f.drbno = s.drbno;

	
--插入无分楼类寝室楼
create procedure newDorm_0
	@dbno char(2),
	@height int,
	@rooms int,
	@err varchar(50) output
as
begin
	declare 
		@i		int,
		@j		int
	begin try
	begin tran
		set @i = 1;
		set @j = 1;
		insert into dbuilding(dbno,dbd) 
			values(@dbno, '0');
		while @i <= @height
		begin
			set @j = 1;
			while @j <= @rooms
			begin
				insert into droom(dbno,dbd,drbno,dcap) 
					values(@dbno, '0', str(@i, 1) + replace(str(@j, 2), ' ', '0'), 5);
				set @j = @j + 1;
			end
			set @i = @i + 1;
		end
		commit
	end try
	begin catch
		rollback
		select @err = ERROR_MESSAGE()
	end catch
end

--插入东西分类寝室楼
create procedure newDorm_12
	@dbno char(2),
	@height int,
	@rooms int,
	@err varchar(50) output
as
begin
	declare 
	@i int,
	@j int
	begin try
	begin tran
		set @i = 1;
		set @j = 1;
		insert into dbuilding(dbno,dbd) 
		values(@dbno, '1');
		insert into dbuilding(dbno,dbd) 
		values(@dbno, '2');
		while @i <= @height
			begin
			set @j = 1;
			while @j <= @rooms
				begin
				insert into droom(dbno,dbd,drbno,dcap) 
				values(@dbno, '1', str(@i, 1) + replace(str(@j, 2), ' ', '0'), 5);
				insert into droom(dbno,dbd,drbno,dcap) 
				values(@dbno, '2', str(@i, 1) + replace(str(@j, 2), ' ', '0'), 5);
				set @j = @j + 1;
			end
			set @i = @i + 1;
		end
		commit
	end try
	begin catch
		rollback
		select @err = ERROR_MESSAGE()
	end catch
end
--插入南北分类寝室楼
create procedure newDorm_34
	@dbno char(2),
	@height int,
	@rooms int,
	@err varchar(50) output
as
begin
	declare 
		@i int,
		@j int
	begin try
	begin tran
		set @i = 1;
		set @j = 1;
		insert into dbuilding(dbno,dbd) 
		values(@dbno, '3');
		insert into dbuilding(dbno,dbd) 
		values(@dbno, '4');
		while @i <= @height
			begin
			set @j = 1;
			while @j <= @rooms
				begin
				insert into droom(dbno,dbd,drbno,dcap) 
				values(@dbno, '3', str(@i, 1) + replace(str(@j, 2), ' ', '0'), 5);
				insert into droom(dbno,dbd,drbno,dcap) 
				values(@dbno, '4', str(@i, 1) + replace(str(@j, 2), ' ', '0'), 5);
				set @j = @j + 1;
			end
			set @i = @i + 1;
		end
		commit
	end try
	begin catch
		rollback
		select @err = ERROR_MESSAGE()
	end catch
end

--select不满的寝室
create procedure selectDRoomNotFull
as
	select
	drbno,dbno,dbd
	from
	droom
	except
	select
	a.drbno,a.dbno,a.dbd
	from (
	select
	s.drbno,s.dbno,s.dbd,count(*) num
	from 
	student s
	group by 
	s.drbno,s.dbno,s.dbd
	)as a , droom d
	where 
	d.dcap=num 
	group by 
	a.drbno,a.dbno,a.dbd;

--select某寝室所有学生
create procedure selectDormStudents
	@dbno char(2),
	@dbd char(1),
    @drbno char(3)
as
	select s.*
	from 
	student s
	where 
	@drbno=s.drbno 
	and
	@dbno=s.dbno 
	and
	@dbd=s.dbd;

--建立未住满的寝室视图
create view droom_not_full
as
select
    drbno,dbno,dbd
from
    droom
    except
select
    a.drbno,a.dbno,a.dbd
from (
         select
             s.drbno,s.dbno,s.dbd,count(*) num
         from
             student s
         group by
             s.drbno,s.dbno,s.dbd
     )as a , droom d
where
        d.dcap=num
group by
    a.drbno,a.dbno,a.dbd;

--建立平均卫生评比分数高于80的寝室视图
create view ccontest_80
as
    select d.dbno, d.drbno, d.dbd
    from droom d
    inner join ccontest c2 on
    d.dbno = c2.dbno
    and d.drbno = c2.drbno
    and d.dbd = c2.dbd
    group by d.dbno, d.drbno, d.dbd
    having avg(c2.cscore) > 80
    with check option;

--建立寝室楼为12南的学生物品取出记录的视图
create view item_out
as
    select i.*
    from items i
    inner join student s2 on s2.sno = i.sno
    inner join droom d on
    s2.drbno = d.drbno
    and s2.dbd = d.dbd
    and s2.dbno = d.dbno
    where d.dbno = '12'
    and d.dbno = '3'
    and i.itype = 1
    with check option;

--建立寝室为12北的访客来访记录的视图
create view guest_out
as
    select g.*
    from guest g
    inner join droom d on
    d.dbno = g.dbno
    and d.dbd = g.dbd
    where
    d.dbno = '12'
    and d.dbd = '4'
    and g.gtype = 0
    with check option;
