create table price (
    id bigint not null,
    cusip varchar(255),
    price numeric(38,2),
    price_date date, primary key (id));



insert into price(id,cusip,price,price_date) values (1,'IBM',100.00,'2024-01-01');
insert into price(id,cusip,price,price_date) values (2,'INFY',200.00,'2024-01-01');
insert into price(id,cusip,price,price_date) values (3,'GOOG',345.00,'2024-01-01');
insert into price(id,cusip,price,price_date) values (4,'TESLA',527.00,'2024-01-01');
insert into price(id,cusip,price,price_date) values (5,'NVIDIA',10000.00,'2024-01-01');
insert into price(id,cusip,price,price_date) values (6,'MS',2980.00,'2024-01-01');
insert into price(id,cusip,price,price_date) values (7,'GS',100.00,'2024-01-01');
insert into price(id,cusip,price,price_date) values (8,'JPMC',7.00,'2024-01-01');


insert into price(id,cusip,price,price_date) values (9,'IBM',101.00,'2024-01-02');
insert into price(id,cusip,price,price_date) values (10,'INFY',201.00,'2024-01-02');
insert into price(id,cusip,price,price_date) values (11,'GOOG',341.00,'2024-01-02');
insert into price(id,cusip,price,price_date) values (12,'TESLA',521.00,'2024-01-02');
insert into price(id,cusip,price,price_date) values (13,'NVIDIA',10090.00,'2024-01-02');
insert into price(id,cusip,price,price_date) values (14,'MS',2985.00,'2024-01-02');
insert into price(id,cusip,price,price_date) values (15,'GS',190.00,'2024-01-02');
insert into price(id,cusip,price,price_date) values (16,'JPMC',17.00,'2024-01-02');

insert into price(id,cusip,price,price_date) values (17,'IBM',102.00,'2024-01-03');
insert into price(id,cusip,price,price_date) values (18,'INFY',202.00,'2024-01-03');
insert into price(id,cusip,price,price_date) values (19,'GOOG',342.00,'2024-01-03');
insert into price(id,cusip,price,price_date) values (20,'TESLA',522.00,'2024-01-03');
insert into price(id,cusip,price,price_date) values (21,'NVIDIA',10002.00,'2024-01-03');
insert into price(id,cusip,price,price_date) values (22,'MS',2982.00,'2024-01-03');
insert into price(id,cusip,price,price_date) values (23,'GS',102.00,'2024-01-03');
insert into price(id,cusip,price,price_date) values (24,'JPMC',12.00,'2024-01-03');