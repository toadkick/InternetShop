insert into category values (1,'classic',null);
insert into category values (11,'romanticism',1);
insert into category values (12,'modernism',1);
insert into category values (2,'fantastic',null);
insert into category values (21,'fantasy',2);
insert into category values (22,'sci-fi',2);

insert into products values(1,1,'Poems','Gomer',null,120,6,TO_DATE('2000','YYYY'));
insert into products values(2,11,'Encyclopedic Dictionary','F.Schlegel',null,150,5,TO_DATE('2005','YYYY'));
insert into products values(3,11,'The Mirror of Swabia','H.Heine',null,110,10,TO_DATE('2008','YYYY'));
insert into products values(4,12,'The Magic Mountain','T.Mann',null,200,1,TO_DATE('1999','YYYY'));
insert into products values(5,12,'The Silver Dove','A.Bely',null,50,15,TO_DATE('2001','YYYY'));

insert into products values(6,2,'The Dark Tower: The Gunslinger','S.King',null,100,8,TO_DATE('2001','YYYY'));
insert into products values(7,2,'The Dark Tower II: The Drawing of the Three','S.King',6,110,7,TO_DATE('2001','YYYY'));

insert into products values(8,21,'Elric of Melnibone','M.Moorcock',null,450,2,TO_DATE('1995','YYYY'));
insert into products values(9,22,'The Time Machine','H.Wells',null,90,9,TO_DATE('2010','YYYY'));
insert into products values(10,22,'Stranger in a Strange Land','R.A.Heinlein',null,120,5,TO_DATE('2015','YYYY'));
