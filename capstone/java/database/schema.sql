

BEGIN TRANSACTION;

DROP TABLE IF EXISTS event_user, users, event, hours, message, cause CASCADE;

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	name varchar(100),
	username varchar (50) NOT NULL UNIQUE,
	birth_date varchar(10),
	phone_number varchar (15),
	description varchar(500),
	address varchar (100),
	profile_pic varchar(300),
	hero_banner varchar(300),
	password_hash varchar(200) NOT NULL,
	organization boolean,
	verified boolean, --figure out how to verify a business
	minor boolean, --will be used to filter underage users
	role varchar(50) NOT NULL
);
CREATE TABLE event (
	id SERIAL PRIMARY KEY,
	name varchar (50) NOT NULL,
	org_owner int REFERENCES users(user_id),
	org_logo varchar(200),
	address varchar (100),
	start_date date NOT NULL,
	end_date date NOT NULL,
	start_time time NOT NULL,
	end_time time NOT NULL,
	description varchar(500),

);
CREATE TABLE message (
	id SERIAL PRIMARY KEY,
	sender_id int REFERENCES users(user_id) NOT NULL,
	receiver_id int REFERENCES users(user_id) NOT NULL,
	time_stamp TIMESTAMP NOT NULL,
	message_text varchar (300) NOT NULL,
	attachment varchar(300),
	archive boolean
);
CREATE TABLE event_user(
	id SERIAL PRIMARY KEY,
	user_id int REFERENCES users (user_id),
	event_id int REFERENCES event (id),
	approval_status varchar(10)
);
CREATE TABLE hours (
	id SERIAL PRIMARY KEY,
	user_id int REFERENCES users (user_id),
	event_id int REFERENCES event (id),
	hours int,
	approval_status varchar(10)
);
CREATE TABLE cause(
	id SERIAL PRIMARY KEY,
	event_id int REFERENCES event (id),
	description varchar(50)
);

COMMIT;

--ROLLBACK;

