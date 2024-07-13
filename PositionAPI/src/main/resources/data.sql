create table position (id bigint not null, account_id varchar(255), cusip varchar(255), position_date date, quantity numeric(38,2), primary key (id));

insert into position (id, account_id, cusip, position_date, quantity) values(1,'ABC', 'IBM', '2024-01-01', 100.00);
insert into position (id, account_id, cusip, position_date, quantity) values(2,'ABC', 'INFY', '2024-01-01', 500.00);
insert into position (id, account_id, cusip, position_date, quantity) values(3,'XYZ', 'GS', '2024-01-01', 1000.00);
insert into position (id, account_id, cusip, position_date, quantity) values(4,'XYZ', 'MS', '2024-01-01', 1090.00);

insert into position (id, account_id, cusip, position_date, quantity) values(5,'ABC', 'IBM', '2024-01-02', 100.00);
insert into position (id, account_id, cusip, position_date, quantity) values(6,'ABC', 'INFY', '2024-01-02', 500.00);
insert into position (id, account_id, cusip, position_date, quantity) values(7,'XYZ', 'GS', '2024-01-02', 1000.00);
insert into position (id, account_id, cusip, position_date, quantity) values(8,'XYZ', 'NVIDIA', '2024-01-02', 1090.00);


insert into position (id, account_id, cusip, position_date, quantity) values(9,'ABC', 'IBM', '2024-01-03', 100.00);
insert into position (id, account_id, cusip, position_date, quantity) values(10,'ABC', 'INFY', '2024-01-03', 500.00);
insert into position (id, account_id, cusip, position_date, quantity) values(11,'ABC', 'GOO', '2024-01-03', 500.00);
insert into position (id, account_id, cusip, position_date, quantity) values(12,'ABC', 'TESLA', '2024-01-03', 500.00);
insert into position (id, account_id, cusip, position_date, quantity) values(13,'XYZ', 'GS', '2024-01-03', 1000.00);
insert into position (id, account_id, cusip, position_date, quantity) values(14,'XYZ', 'NVIDIA', '2024-01-03', 1090.00);

