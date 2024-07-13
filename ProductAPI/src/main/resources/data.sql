create table product (id bigint not null, asset_class varchar(255), cusip varchar(255), description varchar(255), primary key (id));

insert into product(id,asset_class,cusip,description) values (1,'Equity','IBM','IBM');
insert into product(id,asset_class,cusip,description) values (2,'Equity','INFY','Infosys');
insert into product(id,asset_class,cusip,description) values (3,'Equity','GOOG','Google');
insert into product(id,asset_class,cusip,description) values (4,'Equity','TESLA','Tesla');
insert into product(id,asset_class,cusip,description) values (5,'Equity','NVIDIA','NVIDIA');
insert into product(id,asset_class,cusip,description) values (6,'Equity','MS','Microsoft');
insert into product(id,asset_class,cusip,description) values (7,'Equity','GS','Goldman Sachs');
insert into product(id,asset_class,cusip,description) values (8,'Equity','JPMC','JP Morgan Chase');