# springboot-restapi-backend
Backend da aplicação Rest com springboot

## Passos para utilização: 

### 1 - Conectar o banco de dados MYSQL a API 

Crie um banco de dados no MYSQL com o comando "create database nomedobanco", a aplicação ja tem um banco pré-configurado 
com o nome "pessoadb", se criar um banco de dados no MYSQL com esse nome, não terá problemas. Caso crie um banco de dados com outro nome, 
lembre-se de altera-lo também no arquivo de configuração "aplication.properties", lembre-se de 
fazer o mesmo com o usuário e o password, os dados do banco de dados e do arquivo aplication.properties devem ser iguais. Após certificar que os dados 
estão corretos, rode a aplicação. Para configurar se está funcionando, digite na url do navegador: "http://localhost:8080/pessoas", ou utilize o Postman ou 
algum outro método utilizado para testar API's. Caso retorne uma lista de pessoas ou um array vazio, está tudo certo. 

### 2 - URL's da API 

#### 1 - http://localhost:8080/pessoas - Método POST 
Cadastra uma pessoa no banco de dados

#### 2 - http://localhost:8080/pessoas - Método GET 
Lista todas as pessoas cadastradas 

#### 3 - http://localhost:8080/pessoas/id - Método GET
Lista uma pessoa com o id fornecido

#### 4 - http://localhost:8080/pessoas/id - Método PUT
Atualiza os dados de uma pessoa

#### 5 - http://localhost:8080/pessoas/id - Método DELETE
Deleta uma pessoa com o id fornecido

## - Validações da API 

#### 1 - Valida se os inputs estão vazios. 
#### 2 - Valida se o E-mail informado é válido. 
#### 3 - Valida se o CPF informado é válido. 

As validações pelo banco de dados estão na classe Pessoa, presente no package MODEL e na classe Pessoa.Controller, presente na classe Controller. 

## - Validação pelo banco de dados 

#### 1 - Checa se os campos estão nulos. 
#### 2 - limitação no tamanho de string à ser inserida. 

As validações pelo banco de dados estão na classe Pessoa, presente no package MODEL. 

