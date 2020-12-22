--历史记录表
create table log_history
(logid int not null identity(1,1),
 tablename varchar(10),
 operate varchar(100),
 date datetime
)


--触发器1，水电费改动记录
create trigger fee_log on fees
after update
as
begin
	declare @oldfpaid bit ,@newfpaid bit
	select 
	@newfpaid=fpaid 
	from 
	inserted
	select 
	@oldfpaid=fpaid 
	from 
	deleted
	if @newfpaid=1
		insert into
		 log_history 
		 values('fees','未缴纳->未缴纳',getdate())
	if @newfpaid=0
		insert into 
		log_history 
		values('fees','已缴纳->未缴纳',getdate())
	end
go

--触发器2，物品存放改动记录   存入 0 取出 1
create trigger item_in_log on items
after insert
as
begin
	declare @olditype bit ,@newitype bit
	select 
	@newitype=itype 
	from 
	inserted
	select 
	@olditype=itype 
	from 
	deleted
	if @newitype=0
		insert into
		log_history 
		values('items','空->存入',getdate())
	end
go

create trigger item_out_log on items
after update
as
begin
	declare @olditype bit ,@newitype bit
	select 
	@newitype=itype 
	from 
	inserted
	select 
	@olditype=itype 
	from 
	deleted
	if @newitype=1
		insert into 
		log_history 
		values('items','存放->已取走',getdate())
	end
go

--触发器3，访客出入记录   进入 0 离开 1
create trigger guest_in_log on guest
after insert
as
begin
	declare @oldgtype bit ,@newgtype bit
	select 
	@newgtype=gtype 
	from 
	inserted
	select 
	@oldgtype=gtype 
	from 
	deleted
	if @newgtype=0
		insert into 
		log_history 
		values('guest','空->进入',getdate())
	end
go

create trigger guest_out_log on guest
after update
as
begin
	declare @oldgtype bit ,@newgtype bit
	select 
	@newgtype=gtype 
	from 
	inserted
	select 
	@oldgtype=gtype 
	from 
	deleted
	if @newgtype=1
		insert into 
		log_history 
		values('guest','进入->已离开',getdate())
	end
go
--触发器4，维修状态级联
create trigger update_status on resheet
after update
as 
begin 
	declare @rsno char(8)
	declare @restatus varchar(10)
	select 
	@restatus=restatus 
	from 
	inserted
	select 
	@rsno=rsno 
	from 
	inserted
	update 
	rsheet 
	set 
	rprogress=@restatus 
	where 
	rsno=@rsno
	end
go


create trigger inserted_status on resheet
after insert
as 
begin 
	declare @rsno char(8)
	declare @restatus varchar(10)
	select 
	@restatus=restatus 
	from 
	inserted
	select 
	@rsno=rsno 
	from 
	inserted
	update 
	rsheet 
	set 
	rprogress=@restatus 
	where 
	rsno=@rsno
	end
go

--触发器5，报修单和维修单单号级联
create trigger insert_rsno on resheet
after insert
as 
begin 
	declare @reno char(8)
	declare @rsno char(8)
	declare @restatus varchar(10)
	select
	@restatus=restatus 
	from inserted
	select 
	@rsno=rsno
	from 
	inserted
	select 
	@reno=reno 
	from 
	inserted
	update 
	rsheet 
	set 
	rprogress=@restatus 
	where 
	rsno=@rsno
	update 
	rsheet 
	set 
	reno=@reno 
	where 
	rsno=@rsno
	end
go

