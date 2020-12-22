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