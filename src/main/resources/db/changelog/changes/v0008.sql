alter table caffee rename column work_time to work_time_id;

alter table caffee alter column work_time_id type bigint using work_time_id::bigint;

alter table caffee
    add constraint caffee_work_time_id_fk
        foreign key (work_time_id) references work_time;

