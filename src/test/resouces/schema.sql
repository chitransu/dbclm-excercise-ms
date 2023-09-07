create table nace_details (
        order_id varchar(20) not null,
        code varchar(10),
        description varchar(255),
        level varchar(10),
        parent varchar(10),
        reference_to_isic_rev4 varchar(10),
        ruling varchar(10),
        this_item_also_includes CLOB,
        this_item_excludes CLOB,
        this_item_includes CLOB,
        primary key (order_id)
    );