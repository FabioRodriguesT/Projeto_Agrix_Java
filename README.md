## Rotas
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
      <td>Lista todas as fazendas</td>
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
