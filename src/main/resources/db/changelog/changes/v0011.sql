alter table "user"
    add email varchar;

create unique index user_email_uindex
    on "user" (email);

