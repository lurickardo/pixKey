create table account (
    account_number integer not null,
    agency integer not null,
    registration_date datetime(6) not null,
    update_date datetime(6) not null,
    id binary(16) not null,
    holder_name varchar(30) not null,
    holder_surname varchar(45),
    account_type enum ('CHECKING','SAVINGS') not null,
    person_category enum ('PF','PJ') not null,
    primary key (id)
) engine=InnoDB;

create table pix_key (
    registration_date datetime(6) not null,
    update_date datetime(6) not null,
    account_id binary(16) not null,
    id binary(16) not null,
    key_value varchar(77) not null,
    key_type enum ('CELL_PHONE','CNPJ','CPF','EMAIL','RANDOM') not null,
    status enum ('ACTIVE','INACTIVE') not null,
    primary key (id)
) engine=InnoDB;

alter table pix_key
   add constraint FKrmm0mc1yirxx67ljank3pxe28
   foreign key (account_id)
   references account (id);