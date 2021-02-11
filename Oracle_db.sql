create table users(
user_id number(10) primary key,
user_name varchar2(25) not null,
password varchar2(255) not null,
user_type varchar2(15) not null);

Create sequence users_sequence
start with 100
increment by 1;

insert into users (users_sequence.nextval,'admin','$2a$10$XTw8V9NDc4AdVxc/sS.SzejKV/Kov0RK/wr/N/kDRI2dBmHmI2TaK','admin');

create table customers(
customer_id number(10) primary key,
first_name varchar2(25) not null,
last_name varchar2(25) not null,
email varchar2(50) not null,
mobile varchar2(10) not null,
nic_no varchar2(15) not null,
user_id number(10) not null,
constraint fk_customers foreign key(user_id) references users(user_id) on delete cascade);

Create sequence customers_sequence
start with 200
increment by 1;

create table owners(
owner_id number(10) primary key,
first_name varchar2(25) not null,
last_name varchar2(25) not null,
email varchar2(50) not null,
mobile varchar2(10) not null,
br_no varchar2(15) not null,
user_id number(10) not null,
constraint fk_owners foreign key(user_id) references users(user_id) on delete cascade);

Create sequence owners_sequence
start with 300
increment by 1;

create table halls(
hall_id number(10) primary key,
hall_name varchar2(25) not null,
hall_type varchar2(25) not null,
hall_location varchar2(50) not null,
hall_contact varchar2(10) not null,
no_of_seats number(5) not null,
owner_id number(10) not null,
constraint fk_halls foreign key(owner_id) references owners(owner_id) on delete cascade);

Create sequence halls_sequence
start with 400
increment by 1;

create table events(
event_id number(10) primary key,
event_name varchar2(25) not null,
event_type varchar2(25) not null,
event_description varchar2(250) not null,
event_date date not null,
start_time timestamp not null,
end_time timestamp not null,
ticket_price binary_double not null,
event_image varchar2(500),
hall_id number(10) not null,
constraint fk_events foreign key(hall_id) references halls(hall_id) on delete cascade);

Create sequence events_sequence
start with 500
increment by 1;

create table tickets(
ticket_id number(10) primary key,
customer_id number(10) not null,
event_id number(10) not null,
seat_no varchar2(25) not null,
commission binary_double not null,
payment_date date not null,
payment_amount binary_double not null,
payment_status varchar2(25) not null,
constraint fk_ticket1 foreign key(customer_id) references customers(customer_id) on delete cascade,
constraint fk_ticket2 foreign key(event_id) references events(event_id) on delete cascade);

Create sequence tickets_sequence
start with 1000
increment by 1;

create table seats(
seat_id number(5) primary key,
seat_no varchar2(10) not null,
status char(1) not null,
event_id number(10) not null,
constraint fk_seats foreign key(event_id) references events(event_id) on delete cascade);

Create sequence seats_sequence
start with 1
increment by 1;

