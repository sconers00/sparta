create table member (
        created_at datetime(6),
        modified_at datetime(6),
        userid bigint not null auto_increment,
        email varchar(255) not null,
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (userid)
    )

create table schedule (
        created_at datetime(6),
        id bigint not null auto_increment,
        member_user_id bigint,
        modified_at datetime(6),
        contents varchar(255),
        title varchar(255) not null,
        primary key (id)
    )