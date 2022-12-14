BEGIN TRANSACTION;

DROP TABLE IF EXISTS user, event, hours, message, event_user CASCADE;

CREATE TABLE user(
	user_id SERIAL PRIMARY KEY,
	first_name varchar (50),
	last_name varchar(50),
	org_name varchar(50),
	username varchar (50), NOT NULL UNIQUE, --username is gonna be email!!!!!
	birth_date date,
	phone_number varchar (15),
	address varchar (100),
	profile_pic bytea(1gb),
	hero_banner bytea(1gb),
	password_hash varchar(200) NOT NULL,
	organization boolean,
	verified boolean,
	minor boolean,
	role varchar(50) NOT NULL,
);
CREATE TABLE event (
	event_id SERIAL PRIMARY KEY,
	name varchar (50) NOT NULL,
	address varchar (100),
	start_date date NOT NULL,
	end_date date NOT NULL,
	start_time time NOT NULL,
	end_time time NOT NULL,
	description varchar (300),
	user_counter varchar (200), 
);
CREATE TABLE message (
	message_id SERIAL PRIMARY KEY,
	sender_id SERIAL NOT NULL,
	receiver_id SERIAL NOT NULL,
	time_stamp smalldatetime NOT NULL,
	message_text varchar (300) NOT NULL,
	attachment bytea(1gb),
	archive boolean, --what data type?
);
CREATE TABLE event_user(
	user_id int REFERENCES user (user_id),
	event_id int REFERENCES event (event_id),
	approval_status boolean,
);
CREATE TABLE hours (
	user_id int REFERENCES user (user_id),
	event_id int REFERENCES event (event_id),
	hours int,
	approval_status boolean,
);

COMMIT;

--ROLLBACK;