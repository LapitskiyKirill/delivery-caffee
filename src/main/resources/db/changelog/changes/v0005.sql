alter table item drop constraint item_menu_id_fk;

alter table item drop column menu_id;

create table menu_items
(
    id bigserial not null,
    menu_id bigint not null
        constraint menu_items_menu_id_fk
            references menu,
    item_id bigint not null
        constraint menu_items_item_id_fk
            references item
);

create unique index menu_items_id_uindex
    on menu_items (id);

alter table menu_items
    add constraint menu_items_pk
        primary key (id);

