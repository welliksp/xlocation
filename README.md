# XLocation - Encontrando Pontos de Interesse Próximos

**XLocation** é uma aplicação Spring Boot que permite encontrar pontos de interesse próximos a uma localização específica.

**Funcionalidades**:

* **Cadastro de Pontos de Interesse**: Permite adicionar novos pontos de interesse com nome, coordenadas X e Y.

* **Busca por Pontos de Interesse Próximos**: Permite buscar pontos de interesse dentro de um raio definido a partir de coordenadas X e Y.

* **API REST**: A aplicação expõe uma API REST para acesso às funcionalidades de cadastro e busca.

**Tecnologias**:

* **Spring Boot**: Framework para desenvolvimento de aplicações Java.
* **Spring Data JPA**: Framework para acesso a dados com JPA.
* **MySQL**: Banco de dados relacional.
* **Flyway**: Ferramenta para gerenciamento de migrações de banco de dados.
* **Lombok**: Biblioteca para reduzir código boilerplate.

**Instalação e Execução**:

* **Pré-requisitos**:
  * Java 21
  * MySQL
  * Maven
  
* **Clone o repositório**:
  * git clone https://github.com/seu-usuario/xlocation.git

* **Configure o banco de dados**:
  * Crie um banco de dados chamado xlocation.
  * Configure as credenciais de acesso ao banco de dados no arquivo application.properties.

* **Execute o Maven**:
  * mvn spring-boot:run


* **API**:

  * **POST** /api/points-of-interest:  Cadastra um novo ponto de interesse.
  * **GET** /api/points-of-interest:  Lista todos os pontos de interesse.
  * **GET** /api/points-of-interest/ near- me? x= { x} & y= { y} & dmax= { dmax} :  Busca pontos de interesse próximos a uma localização específica.

    * **Exemplo de Uso:**

      * **Cadastrar um novo ponto de interesse**: 

        * curl -X POST -H "Content-Type: application/json" -d '{"name": "Restaurante X", "x": 10, "y": 20}' http://localhost:8080/api/points-of-interest
      
        * Buscar pontos de interesse próximos a (10, 10) com raio de 5 unidades 
          * curl http://localhost:8080/api/points-of-interest/near-me?x=10&y=10&dmax=5
* **Observações**:
  * As coordenadas X e Y representam uma localização no plano cartesiano.
  * O raio dmax é definido em unidades.
  * A aplicação utiliza o algoritmo de distância euclidiana para calcular a distância entre pontos.
* **Contribuições**:
  * Contribuições são bem-vindas! Abra um issue ou um pull request para reportar bugs, solicitar funcionalidades ou contribuir com o código.
* **Licença**:
 * Este projeto está licenciado sob a licença MIT.