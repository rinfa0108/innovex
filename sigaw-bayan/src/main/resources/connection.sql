create table UserConnection (userId varchar(255) not null,
    providerId varchar(255) not null,
    providerUserId varchar(255),
    rank int not null,
    displayName varchar(255),
    profileUrl varchar(512),
    imageUrl varchar(512),
    accessToken varchar(255) not null,					
    secret varchar(255),
    refreshToken varchar(255),
    expireTime bigint,
    primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);


create table opendata.users (
    username varchar(255) not null,
    password varchar(255),
    email varchar(255),
    enabled varchar(255)
);
 
create table opendata.authorities (
    username varchar(255) ,
    authority varchar(255)
);

create table opendata.projects (
    saroNo varchar(255) not null,
    description varchar(255),
    amount bigint,
    region varchar(255),
    purpose text,
    issueDate date,
    primary key (saroNo)
);


create table opendata.sentiments (
    saroNo varchar(255) not null,    
    sentiment text,
    dateCreated timestamp,
    type varchar(255),
    rating float
);


