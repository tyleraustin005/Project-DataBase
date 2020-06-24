Course Project – Deliverable Two

Tyler Austin – 7867800
Malissa Ekanayake - 6927445

CSI 2132
Due: April 7th 2019
1. We used the following languages for our implementation.
a. Database Language (DBMS) - PostgreSQL (pgAdmin 4)
b. Client-server communication = Apache Tomcat v9.0
c. Server side = Java (eclipse ide)
d. Client side = HTML5


///// 


2. The following queries are examples of how we implemented our model into the database;
CREATE TABLE public.room (
    room_id serial primary key,
    hotel_id integer NOT NULL,
    price integer,
    capacity character varying(50),
    room_view character varying(80),
    can_be_extended character varying(3),
    room_quality character varying(80),
    CONSTRAINT check_room CHECK ((((capacity)::text = ANY ((ARRAY['single'::character varying, 'double'::character varying, 'queen'::character varying, 'king'::character varying, '2 singles'::character varying, '2 doubles'::character varying, '2 queens'::character varying, '2 kings'::character varying])::text[])) AND ((room_view)::text = ANY ((ARRAY['mountain'::character varying, 'park'::character varying, 'city'::character varying, 'river'::character varying, 'ocean'::character varying, 'square'::character varying])::text[])) AND ((can_be_extended)::text = ANY ((ARRAY['yes'::character varying, 'no'::character varying])::text[])) AND ((room_quality)::text = ANY ((ARRAY['very poor'::character varying, 'poor'::character varying, 'fair'::character varying, 'good'::character varying, 'excellent'::character varying, 'very good'::character varying])::text[])))),
	foreign key(hotel_id) references hotel(hotel_id) on delete cascade );
CREATE TABLE public.hotel_chain (
    chain_id integer primary key,
    address_id integer NOT NULL,
    num_hotels integer,
    contact_emails character varying(300),
    contact_numbers character varying(10),
    chain_name character varying(100),
	foreign key(address_id) references address(address_id) );
insert into hotel_chain values(1,41,0,'contact@email.com' ,'1235678909','Westin');
insert into hotel_chain values(2,42,0,'contact@email.com' ,'1235678909','Radison');
insert into hotel_chain values(3,43,0,'contact@email.com' ,'1235678909','Best Northern');
insert into hotel_chain values(4,44,0,'contact@email.com' ,'1235678909','Holiday Inn');
insert into hotel_chain values(5,45,0,'contact@email.com' ,'1235678909','Comfort Zone');

create table address(
	address_id serial primary key,
	street varchar(150),
	city varchar(100),
	country varchar(100)
);
CREATE TABLE public.hotel_chain (
    chain_id integer primary key,
    address_id integer NOT NULL,
    num_hotels integer,
    contact_emails character varying(300),
    contact_numbers character varying(10),
    chain_name character varying(100),
	foreign key(address_id) references address(address_id)
	
);


3. The following are two triggers and trigger functions we used in our database;
//the following updates the number of hotels at hotel chain has when a hotel is added
create function trigger1() returns trigger
Language plpgsql as
$$begin
update hotel_chain
set num_hotels = num_hotels + 1;
end;$$;

create trigger trigger2 after 
insert on hotel for each row
	execute procedure trigger1();
//the following updates the number of rooms at hotel has when a room is added	
create function trigger3() returns trigger
Language plpgsql as
$$begin
update hotel
set num_rooms = num_rooms + 1;
end;$$;

create trigger trigger4 after 
insert on room for each row
	execute procedure trigger1();


4. Installation Steps
1. Take the backup_backup file or the backup_sql file and restore your public schema with these backups.
a. Note; you may need to change all instances of the owner in backup_backup to your username as seen below (taust005 to YOURUSERNAME)
b. 
c. Do this by finding all instances of taust005 and changing to YOURUSERNAME
2. Unzip the dataTest.zip file
3. Open the dataTest file from a file system inside of your java ide.
a. In eclipse: File -->open project from file system
4. Change the runtime to your own tomcat server
a. right click the project->Properties->project facets->runtimes->select your own tomcat server
5. Change the PGADMIN username and password to your own
a. In hotelchain.database.conn package --> PostgreSqlConn.java
6. Open index.html and run on your server
7. Finished!

5. Please see attached backup_backup and open as a text file to see all the DDL’s used to create our database.

6. Finally, the attached file csi2132projtxt.txt is a catch all for most queries used during the implementation of the database. It is a messy file and should only be opened and read to create, update or insert table values should the backup files fail.

