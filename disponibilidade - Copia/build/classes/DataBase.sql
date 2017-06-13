use master
go
drop database disponibilidade
----------Query Estrutura das Tabelas--------------
create database disponibilidade
go
use disponibilidade

drop table professor
create table professor(

id int not null identity,
email varchar(100) not null unique,
senha varchar(100) not null,
nome varchar(100) not null,
telefone varchar(14) not null,
celular varchar(15) not null,
endereco varchar(100) not null,
bairro varchar(100) not null,
cep varchar(9) not null,

ads varchar(1),
comex varchar(1),
logi varchar(1),
pol varchar(1),
gemp varchar(1),

carga int not null,

seg_manha_1 varchar(1),
ter_manha_1 varchar(1),
qua_manha_1 varchar(1),
qui_manha_1 varchar(1),
sex_manha_1 varchar(1),
sab_manha_1 varchar(1),

seg_manha_2 varchar(1),
ter_manha_2 varchar(1),
qua_manha_2 varchar(1),
qui_manha_2 varchar(1),
sex_manha_2 varchar(1),
sab_manha_2 varchar(1),

seg_manha_3 varchar(1),
ter_manha_3 varchar(1),
qua_manha_3 varchar(1),
qui_manha_3 varchar(1),
sex_manha_3 varchar(1),

seg_tarde_1 varchar(1),
ter_tarde_1 varchar(1),
qua_tarde_1 varchar(1),
qui_tarde_1 varchar(1),
sex_tarde_1 varchar(1),

seg_tarde_2 varchar(1),
ter_tarde_2 varchar(1),
qua_tarde_2 varchar(1),
qui_tarde_2 varchar(1),
sex_tarde_2 varchar(1),

seg_tarde_3 varchar(1),
ter_tarde_3 varchar(1),
qua_tarde_3 varchar(1),
qui_tarde_3 varchar(1),
sex_tarde_3 varchar(1),

seg_noite_1 varchar(1),
ter_noite_1 varchar(1),
qua_noite_1 varchar(1),
qui_noite_1 varchar(1),
sex_noite_1 varchar(1),

seg_noite_2 varchar(1),
ter_noite_2 varchar(1),
qua_noite_2 varchar(1),
qui_noite_2 varchar(1),
sex_noite_2 varchar(1),

primary key(id)
)

select* from professor

insert into professor VALUES ('testeExcluir@gmail.com','11', 'Teste de excluir', '9999999' ,'99999999','São Paulo','bairro', '999999', '' ,'','','','',25, '' ,'','','', '','','' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','','','')
insert into professor VALUES ('teste@gmail.com','123', 'Teste', '9999999' ,'99999999','São Paulo','bairro', '999999', '' ,'','','','',35, '' ,'','','', '','','' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','','','')
insert into professor VALUES ('admin','123456', 'admin', '' ,'','','', '','', '' ,'','','',0, '' ,'','','', '','','' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','', '','', '' ,'','','','','')

