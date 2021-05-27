create database db_speedy;

use db_speedy;

create table tb_usuario(
id int not null auto_increment primary key,
nome varchar(50) not null,
cpf char(11) not null,
sexo char(1) not null,
nascimento date not null,
veiculo varchar(50) not null,
valor double not null,
valbase double,
idade int);

drop table tb_usuario;
select * from tb_usuario;