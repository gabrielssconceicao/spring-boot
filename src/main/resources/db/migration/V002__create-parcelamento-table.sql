create table parcelamento (
	id bigint not null auto_increment,
    client_id bigint not null,
    descriptions varchar(20) not null,
    amount decimal(10,2) not null,
    qtd_parcelas tinyint,
    creation_date datetime not null,

    primary key (id)
);

alter table parcelamento add constraint fk_parcelamento_client
foreign key (client_id) references client (id);