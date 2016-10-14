Create schema eshop;

create table eshop.common_dict(
id integer not null auto_increment,
dict_id integer,
value varchar(4000),
primary key (id)
);

create table eshop.content_info(
id integer not null auto_increment,
category integer,
content varchar(4000),
primary key (id)
);
create table eshop.user (
id integer not null auto_increment,
role varchar(1000),
name varchar(4000),
surname varchar(4000),
email varchar(2000),
coutry varchar(2000),
area varchar(3000),
region varchar(3000),
city varchar(2000),
street varchar(3000),
house varchar(3000),
phone varchar(2000),
address_info varchar(2000),
primary key (id)
);

create table eshop.img (
id integer not null auto_increment,
picture longblob,
alt varchar(2000),
primary key (id)
);

create table eshop.company(
id integer not null auto_increment,
name varchar(3000),
primary key(id)
);


create table eshop.seller (
id integer not null auto_increment,
name varchar(2000),
full_name varchar(3000),
id_content_info integer,
id_img integer,
primary key(id),
foreign key (id_content_info) references content_info(id),
foreign key (id_img) references img(id)
);

create table eshop.goods (
id integer not null auto_increment,
id_company integer,
id_img integer,
description varchar(3000),
title varchar(3000),
price integer,
primary key (id),
foreign key (id_company) references company(id),
foreign key (id_img) references img(id)
);

create table eshop.goods_seller(
id_seller integer,
id_goods integer,
count_things integer,
status_goods integer,
foreign key (id_seller) references seller(id),
foreign key (id_goods) references goods(id)
);

create table eshop.basket (
id integer not null auto_increment,
id_goods integer,
id_user integer,
id_seller integer,
count_things integer,
price_things integer,
primary key (id),
foreign key (id_seller) references seller(id),
foreign key (id_user) references user(id),
foreign key (id_goods) references goods(id)
);

create table eshop.orders (
id integer not null auto_increment,
id_goods integer,
id_user integer,
id_seller integer,
status_order integer,
count_things integer,
price integer,
primary key(id),
foreign key (id_user) references user(id),
foreign key (id_goods) references goods(id),
foreign key (id_seller) references seller(id)
);

Insert into eshop.user (id,name, role) values(1,"ANONIMUS", "ANONIMUS");
Insert into eshop.img (id,alt) values (1,"Bosch");
Insert into eshop.content_info (id,category, content) VALUES (1,1, "Nothing");
Insert into eshop.seller (id,name,full_name,id_content_info,id_img) values(1,"Gertruda","Ltd Gertruda",1,1);
insert into eshop.company (id,name) values (1,"Bosch");
insert into eshop.goods (id,id_company,id_img,description,title,price) VALUES (1,1,1,"Hrttt","mixer",12);
insert into eshop.basket (id,id_goods, id_user, id_seller, count_things, price_things) VALUES (1,1,1,1,2,12);



