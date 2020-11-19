create table work_time
(
    id serial not null,
    caffee_id int not null
        constraint work_time_caffee_id_fk
            references caffee
);

create unique index work_time_id_uindex
    on work_time (id);

alter table work_time
    add constraint work_time_pk
        primary key (id);

create table day_work_time
(
    id bigserial not null,
    day varchar not null,
    start_time time not null,
    end_time time not null,
    day_off boolean not null,
    work_time_id bigint not null
        constraint day_work_time_work_time_id_fk
            references work_time (id)
);

create unique index day_work_time_id_uindex
    on day_work_time (id);

alter table day_work_time
    add constraint day_work_time_pk
        primary key (id);

