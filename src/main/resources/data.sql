create table "user"
(
    id       bigserial not null
        constraint user_pk
            primary key,
    login    varchar   not null,
    password varchar   not null,
    role     varchar   not null
);

alter table "user"
    owner to postgres;

create unique index user_id_uindex
    on "user" (id);

create unique index user_login_uindex
    on "user" (login);

create table token
(
    id      bigserial not null
        constraint token_pk
            primary key,
    user_id bigint    not null
        constraint token_user_id_fk
            references "user",
    value   varchar   not null
);

alter table token
    owner to postgres;

create unique index token_id_uindex
    on token (id);

create unique index token_value_uindex
    on token (value);

create table caffee
(
    id        bigserial not null
        constraint caffee_pk
            primary key,
    name      varchar   not null,
    address   varchar   not null,
    work_time varchar   not null,
    user_id   bigint    not null
        constraint caffee_user_id_fk
            references "user"
);

alter table caffee
    owner to postgres;

create unique index caffee_id_uindex
    on caffee (id);

create unique index caffee_name_uindex
    on caffee (name);

