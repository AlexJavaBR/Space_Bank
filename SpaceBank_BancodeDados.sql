create database spaceBank; 

use spaceBank; 

create table usuarios(Nome char(60), CPF int primary key, Endereco char(60), Profissao char(60), Renda double, Senha char(60)); 
 
select * from usuarios; 