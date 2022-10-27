create table songs(
	song_id varchar(10) primary key,
	title varchar(50) not null,
	favourite bit not null default 0,
	artist_id varchar(10) not null
);