use test_db;
# 创建数据表
create table t_students(
	stu_id char(10),
    stu_name char(10),
    stu_age int,
	stu_gender char(2),
    stu_address char(50),
    primary key (stu_id)
)default charset=utf8;
# 插入学生数据的十条SQL语句
insert into t_students values('s001','叶佳',20,'女','上海市浦东新区世纪大道100号'),
('s002','周鸥',21,'男','上海市浦东新区世纪大道101号'),
('s003','李明',14,'男','上海市浦东新区世纪大道102号'),
('s004','王菲',12,'女','上海市浦东新区世纪大道103号'),
('s005','周迅',21,'男','上海市浦东新区世纪大道104号'),
('s006','王勃',15,'男','上海市浦东新区世纪大道105号'),
('s007','章子怡',29,'女','上海市浦东新区世纪大道106号'),
('s008','汪峰',31,'男','上海市浦东新区世纪大道107号'),
('s009','李亚鹏',33,'男','上海市浦东新区世纪大道108号'),
('s010','白百合',14,'女','上海市浦东新区世纪大道109号');
# 使用SQL语句查询年龄大于15岁的男生
select * from t_students where stu_age>15 and stu_gender='男';
#使用SQL语句删除所有男生的数据
delete from t_students where stu_gender='男';

select * from t_students;

# delete from t_students;

# show char set;

# drop table t_students;

