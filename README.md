# Projeto Caça Palíndromo

# Descrição
Este projeto é uma API REST para encontrar palíndromos em uma matriz de caracteres. O projeto é construído usando Spring Boot, Java, Maven e H2 Database.

# Configuração Inicial
Pré-requisitos
Java 8 ou superior
Maven
Git

# Instalação
Clone o repositório:
git clone do repositório

Entre na pasta do projeto:
cd caca_palindromo_h2_project

Compile e empacote o projeto usando Maven:
mvn clean install

# Como Utilizar
Iniciar o Servidor:
Após o passo de instalação, você pode iniciar o servidor executando:
java -jar target/palindromo-0.0.1-SNAPSHOT.jar

O servidor deve iniciar na porta 8080 ou na porta especificada no arquivo application.properties.

# Testar a API
Você pode testar a API usando curl, Postman ou qualquer outro cliente HTTP.
curl -X POST http://localhost:8080/api/palindrome -d '{"matrix": "abc,def,ghi"}'

# Cobertura de testes unitários utilizando SonarQube
![image](https://github.com/Daanty/palindromos-dantielly-razera/assets/12103742/df43ea5f-06d4-4ad1-b08f-d5c669e0b94f)

# Documentação da API
Para acessar o Swagger/OpenAPI da API REST utilize a url: http://localhost:8080/swagger-ui.html após iniciar o servidor.

