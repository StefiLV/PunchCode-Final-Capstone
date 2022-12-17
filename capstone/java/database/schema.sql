BEGIN TRANSACTION;

DROP TABLE IF EXISTS user, event, hours, message, event_user, cause CASCADE;

CREATE TABLE user(
<<<<<<< HEAD
	user_id SERIAL PPRIMARY KEY,
	first_name varchar (50),
	last_name varchar (50),
	org_name varchar (50),
	email varchar (50) NOT NULL UNIQUE,
=======

	user_id SERIAL PRIMARY KEY,
	name varchar(100),
	username varchar (50), NOT NULL UNIQUE, --username is gonna be email!!!!!
>>>>>>> 8c3a98edb1af45bc752c9b765303290aaf4102a3
	birth_date date,
	phone_number varchar (15),
	description varchar(Max),
	address varchar (100),
	profile_pic varchar(300),
	hero_banner varchar(300),
	password_hash varchar(200) NOT NULL,
	organization boolean,
	verified boolean,
	minor boolean,
	role varchar(50) NOT NULL,
);
CREATE TABLE event (
	id SERIAL PRIMARY KEY,
	name varchar (50) NOT NULL,
	address varchar (100),
	start_date date NOT NULL,
	end_date date NOT NULL,
	start_time time NOT NULL,
	end_time time NOT NULL,
	description varchar(Max),
	user_counter varchar (200), 
);
CREATE TABLE message (
	id SERIAL PRIMARY KEY,
	sender_id SERIAL NOT NULL,
	receiver_id SERIAL NOT NULL,
	time_stamp smalldatetime NOT NULL,
	message_text varchar (300) NOT NULL,
	attachment varchar(300),
	archive boolean, --what data type?
);
<<<<<<< HEAD
CREATE TABLE event_volunteer (
	user_id int REFERENCES user (user_id),
	event_id int REFERENCES event (event_id),
	approval_status boolean
);
CREATE TABLE hours (
	user_id int REFERENCES user (user_id),
	event_id int REFERENCES event (event_id),
=======
CREATE TABLE event_user(
	id SERIAL PRIMARY KEY,
	user_id int REFERENCES user (user_id),
	id int REFERENCES event (id),
	approval_status varchar(10),
);
CREATE TABLE hours (
	id SERIAL PRIMARY KEY,
	user_id int REFERENCES user (user_id),
	id int REFERENCES event (id),
>>>>>>> 8c3a98edb1af45bc752c9b765303290aaf4102a3
	hours int,
	approval_status varchar(10),
);
CREATE TABLE cause(
	id SERIAL PRIMARY KEY,
	id int REFERENCES event (id),
	description varchar(50),
);

COMMIT;

--ROLLBACK;