## Descrição

O Agrix é um sistema criado em Java que facilita a gestão e o monitoramento das fazendas participantes. Este projeto exemplifica o uso de diversos conceitos e tecnologias do ecossistema Spring para desenvolver uma API robusta e segura. O objetivo principal é otimizar a eficiência no cultivo de plantações e promover a sustentabilidade, com ênfase na redução do desperdício de recursos.


## Sumário

- [Diagrama de Entidade e Relacionamento](#Diagrama-de-Entidade-e-Relacionamento)
- [Sobre o projeto](#Sobre-o-projeto)
- [Instalação](#Instalação)
- [Instruções de utilização do projeto](#Instruções-de-utilização-do-projeto)
- [Dependências](#Dependências)
- [Licença](#Licença)

## Diagrama de Entidade e Relacionamento

Para orientar a construção das tabelas através do ORM, utilize o DER a seguir:
<p align="center"><img src="./agrix_database.png"></p>

## Sobre o projeto

### O que foi desenvolvido

#### Fase A

- Estruturação de um projeto em camadas
- Implementação de uma API
- Implementação de persistência no projeto
- Testes unitários
- Dockerização da aplicação

#### Fase B

- Aplicar o conhecimento do ecossistema Spring para criar rotas da API.
- Aplicar a injeção de dependência para conectar as camadas de controle, serviço e persistência.
- Utilizar o Spring Data JPA para implementar entidades e repositórios para a persistência em banco de dados, bem como implementar buscas customizadas.
- Utilizar campos de data nas rotas da API e no banco de dados.
- Criar testes unitários para garantir a qualidade e funcionamento correto da implementação, com cobertura de código adequada.

#### Fase C

- Aplicar o conhecimento do ecossistema Spring para criar rotas da API.
- Aplicar a injeção de dependência para conectar as camadas de controle, serviço e persistência.
- Utilizar o Spring Data JPA para implementar entidades e repositórios para a persistência em banco de dados, bem como implementar buscas customizadas.
- Utilizar o Spring Security para implementar autenticação e autorização de pessoas usuárias.
- Utilizar campos de data nas rotas da API e no banco de dados.

## Instalação

1. Clone o repositório

- Use o comando: `git clone git@github.com:FabioRodriguesT/Projeto_Agrix_Java.git`
- Entre na pasta do repositório que você acabou de clonar:
    - `cd Projeto_Agrix_Java`

2. Instale as dependências

- `mvn install -DskipTests`

3. Execute a aplicação

- `Executar a Classe Principal (AgrixApplication.java)`

## Instruções de utilização do projeto

### Rotas
<table>
  <thead>
    <tr>
      <th>Rota</th> 
      <th>Descrição</th>
      <th>Método HTTP</th>
    </tr>
  </thead>
  <tbody>
    <tr>      
      <td>/farms</td>
      <td>Cadastra uma nova fazenda.</td>
      <td>POST</td>
    </tr>
    <tr>     
      <td>/farms</td>
      <td>Lista todas as fazendas cadastradas.</td>
      <td>GET</td>
    </tr>
    <tr>      
      <td>/farms/:id</td>
      <td>Lista as informações de uma fazenda específica baseado no ID passado na URL.</td>
      <td>GET</td>
    </tr>
    <tr>      
      <td>/farms/:farmId/crops</td>
      <td>Lista as informações de todas as plantações de uma fazenda específica baseado no ID passado na URL.</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>/crops</td>
      <td>Lista as informações de todas as plantações cadastradas.</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>/crops/:id</td>
      <td>Lista as informações de uma plantação específica baseado no ID passado na URL.</td>
      <td>GET</td>
    </tr>
<!-- ROTAS FASE B -->
    <tr>
      <td>/crops/search</td>
      <td>Busca informações de plantações em um período de tempo específico, baseado na data de inicio e na data de fim deste periodo, passado como paramêtro no corpo da requisição.</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>/farms/:farmId/crops</td>
      <td>Cadastra uma nova plantação em uma fazenda específica baseada no ID passado na URL.</td>
      <td>POST</td>
    </tr>
    <tr>
      <td>/farms/:farmId/crops</td>
      <td>Lista as informações de todas as plantações de uma fazenda específica baseado no ID passado na url.</td>
      <td>GET</td>
    </tr>
    <!--
    <tr>
      <td>/crops</td>
      <td>Lista todas as informações de todas as plantações cadastradas.</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>/crops/:id</td>
      <td>Lista as informações de uma plantação baseado no ID passado na URL.</td>
      <td>GET</td>
    </tr>
    -->
    <tr>
      <td>/fertilizers</td>
      <td>Cadastra um novo fertilizante.</td>
      <td>POST</td>
    </tr>
    <tr>
      <td>/fertilizers</td>
      <td>Lista as informações de todos os fertilizantes cadastrados.</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>fertilizers/:id</td>
      <td>Lista as informações de um fertilizante baseado no ID passado na URL.</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>crops/:cropId/fertilizers/:ferilizersId</td>
      <td>Realiza a associação de uma plantação com um fertilizante, utilizando o ID de plantação e o ID de fertilizante passado na URL.</td>
      <td>POST</td>
    </tr>
    <tr>
      <td>crops/:cropId/fertilizers</td>
      <td>Lista as informações de todos os fertilizantes associados a plantação específica baseado no id passado na URL.</td>
      <td>GET</td>
    </tr>
    <!-- ROTAS FASE B -->
    <tr>
      <td>/persons</td>
      <td>Cadastra uma nova pessoa.</td>
      <td>POST</td>
    </tr>
  </tbody>
</table>


## Dependências

- hibernate-validator
- h2
- jakarta.validation-api
- java-jwt
- junit-jupiter
- junit-jupiter-api
- junit-jupiter-engine
- mysql-connector-j
- spring-boot-starter
- spring-boot-starter-actuator
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-test
- spring-boot-starter-web
- spring-security-test

## Licença

Este projeto é licenciado sob a Licença MIT. Boa codificação!

<!-- Olá, Tryber!
Esse é apenas um arquivo inicial para o README do seu projeto.
É essencial que você preencha esse documento por conta própria, ok?
Não deixe de usar nossas dicas de escrita de README de projetos, e deixe sua criatividade brilhar!
:warning: IMPORTANTE: você precisa deixar nítido:
- quais arquivos/pastas foram desenvolvidos por você; 
- quais arquivos/pastas foram desenvolvidos por outra pessoa estudante;
- quais arquivos/pastas foram desenvolvidos pela Trybe.
-->
