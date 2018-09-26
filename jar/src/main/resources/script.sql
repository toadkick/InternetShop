DECLARE
  type string_array is VARRAY(8) OF VARCHAR2(30);
  table_list string_array := string_array(
      'product_attribute_value',
      'attribute',
      'cart_products',
      'authorities',
      'cart',
      'shop_users',
      'products',
      'category');
BEGIN
  for i in table_list.first .. table_list.last loop
    BEGIN
      EXECUTE IMMEDIATE 'DROP TABLE ' || table_list(i);
      EXCEPTION
      WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
        RAISE;
      END IF;
    END;
  end loop;

  EXECUTE IMMEDIATE 'DROP SEQUENCE NEXT_SEQ';
  exception when others then  null;

  execute immediate 'create sequence NEXT_SEQ start with 1000 increment by 1';

execute immediate 'create table shop_users (login varchar2(20) primary key,password varchar2(20),phone varchar2(9),e_mail varchar2(50))';

execute immediate 'create table authorities (user_role_id number primary key,login varchar2(20),authority varchar2(15))';

execute immediate 'create table cart(cart_id number primary key,login varchar2(20))';

execute immediate 'create table cart_products(cart_products_id number primary key,cart_id number,product_id number,quanitity number)';

execute immediate 'create table products(product_id number primary key,category_id number,name varchar2(50),author varchar2(50),parent_id number, price number,quanitity number,year_date number, imgSource VARCHAR2(50))';

execute immediate 'create table category (category_id number primary key,category_name varchar2(20),parent_category_id number)';

execute immediate 'create table product_attribute_value(product_attribute_value_id number primary key,product_id number,attribute_id number,this_value varchar2(10))';

execute immediate 'CREATE table attribute(attribute_id number primary key,attribute_name varchar2(20))';

execute immediate 'alter table authorities add  foreign key (login) references shop_users (login)';

execute immediate 'alter table cart add  foreign key (login) references shop_users (login)';

execute immediate 'alter table cart_products add  foreign key (cart_id) references cart (cart_id)';

execute immediate 'alter table cart_products add  foreign key (product_id) references products (product_id)';

execute immediate 'alter table products add  foreign key (category_id) references category (category_id)';

execute immediate 'alter table product_attribute_value add  foreign key (product_id) references products (product_id)';

execute immediate 'alter table product_attribute_value add  foreign key (attribute_id) references attribute (attribute_id)';

execute immediate 'alter table category add UNIQUE (category_id,parent_category_id)';

  execute immediate 'insert into category values (1,''classic'',null)';

  execute immediate 'insert into category values (11, ''romanticism'',1)';

  execute immediate 'insert into category values (12, ''modernism'',1)';

  execute immediate 'insert into category values (2,''fantastic'',null)';

  execute immediate 'insert into category values (21,''fantasy'',2)';

  execute immediate 'insert into category values (22,''sci-fi'',2)';

  execute immediate 'insert into products values(1,1,''Poems'',''Gomer'',null,120,6,2000,''1.jpg'')';

  execute immediate 'insert into products values(2,11,''Encyclopedic Dictionary'',''F.Schlegel'',null,150,5,2005,''2.jpg'')';

  execute immediate 'insert into products values(3,11,''The Mirror of Swabia'',''H.Heine'',null,110,10,2008,''3.jpg'')';

  execute immediate 'insert into products values(4,12,''The Magic Mountain'',''T.Mann'',null,200,1,2010,''4.jpg'')';

  execute immediate 'insert into products values(5,12,''The Silver Dove'',''A.Bely'',null,50,15,2011,''5.jpg'')';

  execute immediate 'insert into products values(6,2,''The Dark Tower: The Gunslinger'',''S.King'',null,100,8,2001,''6.jpg'')';

  execute immediate 'insert into products values(7,2,''The Dark Tower II: The Drawing of the Three'',''S.King'',6,110,7,2001,''7.jpg'')';

  execute immediate 'insert into products values(8,21,''Elric of Melnibone'',''M.Moorcock'',null,450,2,1995,''8.jpg'')';

  execute immediate 'insert into products values(9,22,''The Time Machine'',''H.Wells'',null,90,9,2010,''9.jpg'')';

  execute immediate 'insert into products values(10,22,''Stranger in a Strange Land'',''R.A.Heinlein'',null,120,5,2015,''10.jpg'')';

  execute immediate 'insert into SHOP_USERS values(''user'', ''user'',''02'', ''user@mail.com'')';

  execute immediate 'insert into SHOP_USERS values(''admin'', ''admin'', ''02'', ''admin@mail.com'')';

  execute immediate 'insert into AUTHORITIES values(1, ''admin'', ''ADMIN'')';

  execute immediate 'insert into AUTHORITIES values(2, ''admin'', ''USER'')';

  execute immediate 'insert into AUTHORITIES values(3, ''user'', ''USER'')';

  COMMIT;

end;




