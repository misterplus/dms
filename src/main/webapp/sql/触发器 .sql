--历史记录表
create table log_history
(logid int not null identity(1,1),
 tablename varchar(10),
 operate varchar(100),
 date datetime
)

--触发器1，删除学生寝室人数自动减1
create trigger dcap_dec on student
after delete
as
begin
	declare @sno char(8)
	select @sno=sno from deleted
	update droom set dcap=dcap-1 
	where drbno in(select drbno from deleted where sno=@sno)
	and dbno in (select dbno from deleted where sno=@sno)
	and dbd in (select dbd from deleted where sno=@sno)
	end
go

--触发器2，水电费改动记录
create trigger fee_log on fees
after update
as
begin
	declare @oldfpaid bit ,@newfpaid bit
	select @newfpaid=fpaid from inserted
	select @oldfpaid=fpaid from deleted
	if @newfpaid=1
		insert into log_history values('fees','未缴纳->未缴纳',getdate())
	if @newfpaid=0
		insert into log_history values('fees','已缴纳->未缴纳',getdate())
	end
go

--触发器3，物品存放改动记录   1-有东西  0-没东西
create trigger item_in_log on items
after insert
as
begin
	declare @olditype bit ,@newitype bit
	select @newitype=itype from inserted
	select @olditype=itype from deleted
	if @newitype=1
		insert into log_history values('items','空->存放',getdate())
	end
go

create trigger item_out_log on items
after update
as
begin
	declare @olditype bit ,@newitype bit
	select @newitype=itype from inserted
	select @olditype=itype from deleted
	if @newitype=0
		insert into log_history values('items','存放->已取走',getdate())
	end
go