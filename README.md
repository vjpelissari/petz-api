# petz-api
A aplicação consiste em uma API para fazer cadastros de clientes e pets.
As seguintes funcionalidades foram desenvolvidas:
- Inclusão de clientes
- Inclusão de pets do cliente
- Listagem de todos os clientes
- Busca de um cliente
- Listagem de Todos os pets
- Busca de um pet
- Atualização do cliente
- Atualização do pet
- Exclusão do cliente

# Tecnologias e frameworks utilizados

- Sprint Boot (STS):
  Desenvolvimento da Aplicação

- Maven:
  Gerenciador de Pacotes

- H2:
  Banco de dados em memória

- JPA:
  Para a camada de persistencia

- Swagger:
  Para documentar a API

- Postman:
  Para testes na API
 
- GIT:
  Para controle de versão.

- AWS:
  Publicado na Amazon AWS.

# Explicação dos pacotes criados:

- br.com.jantorno.petapi:
  contem a classe de inicial para iniciar a execução do projeto.

- br.com.jantorno.petapi.config:
  contem a classe com a configuração do swagger.

- br.com.jantorno.petapi.domain:
  pacote que contem as classes de model da aplicação (Cliente, Pet).
 
- br.com.jantorno.petapi.handler:
  contem uma classe handler para lidar com exeptions.

- br.com.jantorno.petapi.repository:
  pacote que contem o padrão Repository para realizar a persistencia com o banco de dados.

- br.com.jantorno.petapi.resources:
  contem os controllers da aplicação, responsaveis pelo mapeamento dos recursos da API.

- br.com.jantorno.petapi.services:
  classes que contem a regra de negócio da aplicação.

- br.com.jantorno.petapi.services.exceptions:
  classes de exceptions.

# Teste da API
  - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/clientes
  - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/pets

# Acesso ao Swagger
  - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/swagger-ui.html

# Exemplos de Endpoints da API

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/clientes
  Retorna uma lista com informações de todos os clientes

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/clientes/1
  Retorna informações do cliente de código 1

- POST - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/clientes
  Inclui um Cliente

- PUT - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/clientes/1
  Atualiza o cliente de código 1.

- DELETE - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/cliente/1
  Exclui o cliente de código 1
  
- POST - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/1/pets
  Inclui um pet para o cliente de codigo 1

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/pets
  Retorna uma lista com informações de todos os pets

- GET - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/pets/1
  Retorna informações do pet de código 1

- PUT - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/pets/1
  Atualiza o cliente de código 1.

- DELETE - http://ec2-52-15-239-159.us-east-2.compute.amazonaws.com:8081/pets/1
  Exclui o pet de código 1
