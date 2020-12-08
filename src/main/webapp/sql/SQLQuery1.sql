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

create procedure newDorm_0
	@dbno char(2),
	@height int,
	@rooms int
as
	declare 
	@i int,
	@j int,
	@temp char(2)
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


create procedure newDorm_12
	@dbno char(2),
	@height int,
	@rooms int
as
	declare 
	@i int,
	@j int,
	@temp char(2)
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

create procedure newDorm_34
	@dbno char(2),
	@height int,
	@rooms int
as
	declare 
	@i int,
	@j int,
	@temp char(2)
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