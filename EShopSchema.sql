Drop SCHEMA eshop;

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


create table eshop.seller(
  id integer not null auto_increment,
  name varchar(2000),
  full_name varchar(3000),
  id_content_info integer,
  id_img integer,
  primary key(id),
  foreign key (id_content_info) references eshop.content_info(id),
  foreign key (id_img) references eshop.img(id)
);

create table eshop.goods (
  id integer not null auto_increment,
  id_company integer,
  id_img integer,
  description varchar(3000),
  title varchar(3000),
  price integer,
  primary key (id),
  foreign key (id_company) references eshop.company(id),
  foreign key (id_img) references eshop.img(id)
);

create table eshop.goods_seller(
  id_seller integer,
  id_goods integer,
  count_things integer,
  status_goods integer,
  foreign key (id_seller) references eshop.seller(id),
  foreign key (id_goods) references eshop.goods(id)
);

create table eshop.basket (
  id integer not null auto_increment,
  id_goods integer,
  id_user integer,
  id_seller integer,
  count_things integer,
  price_things integer,
  primary key (id),
  foreign key (id_seller) references eshop.seller(id),
  foreign key (id_user) references eshop.user(id),
  foreign key (id_goods) references eshop.goods(id)
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
  foreign key (id_user) references eshop.user(id),
  foreign key (id_goods) references eshop.goods(id),
  foreign key (id_seller) references eshop.seller(id)
);

CREATE TABLE eshop.user_login(
  user_name varchar(2000) UNIQUE NOT NULL,
  password VARCHAR(4000) not NULL,
  enable INT DEFAULT 1,
  PRIMARY KEY (user_name)
);

CREATE TABLE eshop.user_role(
  user_name VARCHAR(2000),
  role VARCHAR(50),
  FOREIGN KEY (user_name) REFERENCES  eshop.user_login(user_name)
);

Insert into eshop.user_login (user_name, password, enable) VALUES ('admin', 'admin123', true);
insert into eshop.user_role (user_name, role) values ('admin', 'ROLE_ADMIN');
Insert into eshop.user_login (user_name, password, enable) VALUES ('Superadmin', 'superadmin123', true);
insert into eshop.user_role (user_name, role) values ('Superadmin', 'ROLE_SUPERADMIN');
Insert into eshop.user_login (user_name, password, enable) VALUES ('seller', 'seller123', true);
insert into eshop.user_role (user_name, role) values ('seller', 'ROLE_SELLER');
Insert into eshop.user_login (user_name, password, enable) VALUES ('buyer', 'buyer123', true);
insert into eshop.user_role (user_name, role) values ('buyer', 'ROLE_BUYER');

Insert into eshop.user (id,name, role) values(1,"ANONIMUS", "ANONIMUS");
Insert into eshop.img (id,alt) values (1,"Bosch");
Insert into eshop.content_info (id,category, content) VALUES (1,1, "Nothing");
Insert into eshop.seller (id,name,full_name,id_content_info,id_img) values(1,"Gertruda","Ltd Gertruda",1,1);
insert into eshop.company (id,name) values (1,"Bosch");
insert into eshop.goods (id,id_company,id_img,description,title,price) VALUES (1,1,1,"Hrttt","mixer",12);
insert into eshop.basket (id,id_goods, id_user, id_seller, count_things, price_things) VALUES (1,1,1,1,2,12);



