
create table menu
(
    id bigserial not null,
    caffee_id int not null
        constraint menu_caffee_id_fk
            references caffee
);

create unique index menu_id_uindex
    on menu (id);

alter table menu
    add constraint menu_pk
        primary key (id);

create table description
(
    id bigserial not null,
    description varchar not null
);

create unique index description_id_uindex
    on description (id);

alter table description
    add constraint description_pk
        primary key (id);

create table item
(
    id bigserial not null,
    menu_id bigint not null
        constraint item_menu_id_fk
            references menu,
    description_id bigint not null
        constraint item_description_id_fk
            references description,
    cost bigint not null,
    discount int
);

create unique index item_id_uindex
    on item (id);

alter table item
    add constraint item_pk
        primary key (id);

create table feedback
(
    id bigserial not null,
    user_id bigint not null
        constraint feedback_user_id_fk
            references "user",
    item_id bigint not null
        constraint feedback_item_id_fk
            references item,
    review varchar not null
);

create unique index feedback_id_uindex
    on feedback (id);

alter table feedback
    add constraint feedback_pk
        primary key (id);

create table special_offer
(
    id bigserial not null,
    menu_id bigint not null
        constraint special_offer_menu_id_fk
            references menu,
    description_id bigint not null
        constraint special_offer_description_id_fk
            references description,
    cost int not null
);

create unique index special_offer_id_uindex
    on special_offer (id);

alter table special_offer
    add constraint special_offer_pk
        primary key (id);

create table special_offer_items
(
    id bigserial not null,
    offer_id bigint not null
        constraint special_offer_items_special_offer_id_fk
            references special_offer,
    item_id bigint not null
        constraint special_offer_items_item_id_fk
            references item
);

create unique index special_offer_items_id_uindex
    on special_offer_items (id);

alter table special_offer_items
    add constraint special_offer_items_pk
        primary key (id);

