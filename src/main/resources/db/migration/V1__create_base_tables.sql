create table relationship_status
(
    id   bigserial primary key,
    name text not null
);

insert into relationship_status (id, name) values (1, 'Active');
insert into relationship_status (id, name) values (2, 'Moved to better place');

create table client
(
    id                     bigserial primary key,
    name                   text      not null,
    relationship_type      text      not null,
    relationship_status_id bigint    not null references relationship_status (id),
    created_at             timestamp not null default now(),
    updated_at             timestamp not null default now()
);