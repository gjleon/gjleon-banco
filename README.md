# gjleon-banco

Uma API RESTful para cadastro de usuários, implementada em Java com Spring Boot.

## Descrição

Este projeto fornece uma API para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) em usuários. A API é estruturada utilizando o padrão REST e é documentada com Swagger.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **Spring Boot**: Framework para construção da aplicação.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Swagger**: Para documentação da API.
- **SLF4J**: Para registro de logs.

## Estrutura da API

### UserController

O `UserController` gerencia as operações relacionadas a usuários.

#### Endpoints

1. **GET /users/{id}**
   - **Descrição:** Recupera um usuário específico pelo ID.
   - **Respostas:**
     - **200**: Operação bem-sucedida, retorna o usuário.
     - **404**: Usuário não encontrado.

2. **GET /users**
   - **Descrição:** Recupera uma lista de todos os usuários registrados.
   - **Respostas:**
     - **200**: Operação bem-sucedida, retorna a lista de usuários.

3. **POST /users**
   - **Descrição:** Cria um novo usuário e retorna os dados do usuário criado.
   - **Corpo da Requisição:** `UserDto` com as informações do usuário.
   - **Respostas:**
     - **201**: Usuário criado com sucesso.
     - **422**: Dados do usuário inválidos fornecidos.

4. **PUT /users/{id}**
   - **Descrição:** Atualiza os dados de um usuário existente com base no ID.
   - **Corpo da Requisição:** `UserDto` com as novas informações do usuário.
   - **Respostas:**
     - **200**: Usuário atualizado com sucesso.
     - **404**: Usuário não encontrado.
     - **422**: Dados do usuário inválidos fornecidos.

5. **DELETE /users/{id}**
   - **Descrição:** Deleta um usuário existente com base no ID.
   - **Respostas:**
     - **204**: Usuário deletado com sucesso.
     - **404**: Usuário não encontrado.

### GlobalExceptionHandler

O `GlobalExceptionHandler` trata exceções lançadas na aplicação.

#### Tratamento de Exceções

1. **BusinessException**
   - **Resposta:** 422 (UNPROCESSABLE_ENTITY).

2. **NotFoundException**
   - **Resposta:** 404 (NOT_FOUND).

3. **Throwable (exceções não tratadas)**
   - **Resposta:** 500 (INTERNAL_SERVER_ERROR).

4. **IllegalArgumentException**
   - **Resposta:** 422 (UNPROCESSABLE_ENTITY).

### UserServiceImpl

O `UserServiceImpl` é a implementação do serviço que gerencia a lógica de negócio relacionada aos usuários.

#### Métodos

1. **findAll()**: Recupera todos os usuários.
2. **findById(Long id)**: Recupera um usuário específico pelo ID.
3. **create(User userToCreate)**: Cria um novo usuário.
4. **updateById(Long id, User userToUpdate)**: Atualiza um usuário existente.
5. **deleteById(Long id)**: Deleta um usuário pelo ID.

## Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```

2. **Navegue até o diretório do projeto:**
   ```bash
   cd gjleon-banco
   ```

3. **Compile e execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

---
