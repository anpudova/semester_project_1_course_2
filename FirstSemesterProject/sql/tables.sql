create table users (
    id bigserial primary key,
    name varchar,
    email varchar,
    password varchar,
    role varchar
)

create table cats (
    id_c bigserial primary key,
    name_c varchar,
    owner_id bigserial,
    age int,
    breed varchar,
    character varchar,
    photo varchar,

    foreign key (owner_id) references users(id)
)

create table articles (
    id_a bigserial primary key,
    name_a varchar,
    content text,
    image varchar
)

create table category (
    id_c bigserial primary key,
    name_c varchar
)

create table list_art_categ (
    id_article bigserial,
    id_category bigserial,

    foreign key (id_article) references articles(id_a),
    foreign key (id_category) references category(id_c),
    constraint artic_categ_constr unique (id_article, id_category)
)
