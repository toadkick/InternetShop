DELIMETER ##
create sequence NEXT_SEQ start with 1000 increment by 1##
create table shop_users (login varchar2(20) primary key,password varchar2(20),phone varchar2(9),e_mail varchar2(50))##
create table authorities (user_role_id number primary key,login varchar2(20),authority varchar2(15))##
create table cart(cart_id number primary key,login varchar2(20))##
create table cart_products(cart_products_id number primary key,cart_id number,product_id number,quanitity number)##
create table products(product_id number primary key,category_id number,name varchar2(50),author varchar2(50),parent_id number, price number,quanitity number,year_date number, imgSource VARCHAR2(50))##
create table category (category_id number primary key,category_name varchar2(20),parent_category_id number)##
create table product_attribute_value(product_attribute_value_id number primary key,product_id number,attribute_id number,this_value varchar2(10))##
CREATE table attribute(attribute_id number primary key,attribute_name varchar2(20))##
alter table authorities add  foreign key (login) references shop_users (login)##
alter table cart add  foreign key (login) references shop_users (login)##
alter table cart_products add  foreign key (cart_id) references cart (cart_id)##
alter table cart_products add  foreign key (product_id) references products (product_id)##
alter table products add  foreign key (category_id) references category (category_id)##
alter table product_attribute_value add  foreign key (product_id) references products (product_id)##
alter table product_attribute_value add  foreign key (attribute_id) references attribute (attribute_id)##
alter table category add UNIQUE (category_id,parent_category_id)##
insert into category values (1,'classic',null)##
insert into category values (11, 'romanticism',1)##
insert into category values (12, 'modernism',1)##
insert into category values (2,'fantastic',null)##
insert into category values (21,'fantasy',2)##
insert into category values (22,'sci-fi',2)##
insert into products values(1,1,'Poems','Gomer',null,120,6,2000,'1.jpg')##
insert into products values(2,11,'Encyclopedic Dictionary','F.Schlegel',null,150,5,2005,'2.jpg')##
insert into products values(3,11,'The Mirror of Swabia','H.Heine',null,110,10,2008,'3.jpg')##
insert into products values(4,12,'The Magic Mountain','T.Mann',null,200,1,2010,'4.jpg')##
insert into products values(5,12,'The Silver Dove','A.Bely',null,50,15,2011,'5.jpg')##
insert into products values(6,2,'The Dark Tower: The Gunslinger','S.King',null,100,8,2001,'6.jpg')##
insert into products values(7,2,'The Dark Tower II: The Drawing of the Three','S.King',6,110,7,2001,'7.jpg')##
insert into products values(8,21,'Elric of Melnibone','M.Moorcock',null,450,2,1995,'8.jpg')##
insert into products values(9,22,'The Time Machine','H.Wells',null,90,9,2010,'9.jpg')##
insert into products values(10,22,'Stranger in a Strange Land','R.A.Heinlein',null,120,5,2015,'10.jpg')##
insert into SHOP_USERS values('user', 'user','02', 'user@mail.com')##
insert into SHOP_USERS values('admin', 'admin', '02', 'admin@mail.com')##
insert into AUTHORITIES values(1, 'admin', 'ADMIN')##
insert into AUTHORITIES values(2, 'admin', 'USER')##
insert into AUTHORITIES values(3, 'user', 'USER')##
COMMIT##
DELIMETER;





