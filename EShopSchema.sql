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




