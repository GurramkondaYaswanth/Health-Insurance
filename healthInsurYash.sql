use health_insurance;

create table customers (
customer_id varchar(15) primary key not null,
customer_name varchar(255),
customer_password varchar(15),
customer_address varchar(255),
customer_phonenumber varchar(20),
customer_email varchar(255),
customer_city varchar(50)
);

insert into customers value ('2118041455', 'yashwanth','Yash@123','P.C.N.Residency, New balaji clony, tirupathi',
'9110365727','gurram@gmail.com','Tirupathi');

select * from customers;


create table insurance_policy(
customer_id varchar(15),
policy_id varchar(15),
monthly_premium int,
insurance_amount bigint,
plan_duration int,
family_members int,
months_paid int, 
FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
CONSTRAINT PK_insurance_policy PRIMARY KEY (customer_id,policy_id)
);

insert into insurance_policy value ('2118041455','210422',10000,800000,24,2,0);
select * from insurance_policy;

create table family_members_details(
aadhaar_number bigint primary key not null,
customer_id varchar(15),
policy_id varchar(15),
members_name varchar(255),
dob varchar(20),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

insert into family_members_details value (111111111112,'2118041455','210422','yaswanth','27/02/2000'),
(111111111113,'2118041455','210422','gurram','27/02/2000');
select * from family_members_details;


create table pre_existing_illness(
aadhaar_number bigint not null,
customer_id varchar(15),
policy_id varchar(15),
illness varchar(255),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
FOREIGN KEY (aadhaar_number) REFERENCES family_members_details(aadhaar_number));

insert into pre_existing_illness value (111111111112,'2118041455','210422','null'),(111111111113,'2118041455','210422','asthma');

select * from pre_existing_illness;
