drop table if exists `gig` CASCADE 
create table gig (id bigint AUTO_INCREMENT, artist varchar(255), city varchar(255), gig_date date, gig_time integer not null, venue varchar(255), primary key (id))