# Cadastro-Medico

# Voll.med API

A **Voll.med API** é uma API REST para gerenciamento de médicos, pacientes e consultas médicas. O sistema permite o cadastro, atualização, listagem e exclusão de médicos e pacientes, além do agendamento e cancelamento de consultas.

## 📌 Funcionalidades

- CRUD de Médicos e Pacientes
- Autenticação via JWT
- Agendamento e Cancelamento de Consultas

## 🚀 Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Security**
- **JPA/Hibernate**
- **Banco de Dados (ex: PostgreSQL, MySQL)**
- **Swagger/OpenAPI**

## 🛠 Instalação e Configuração

1. **Clone o repositório**  
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```
2. **Configure o banco de dados**  
   Atualize o `application.properties` com as credenciais do banco.

3. **Execute a aplicação**  
   ```sh
   mvn spring-boot:run
   ```
4. **Acesse a API**  
   - Base URL: `http://localhost:8080`
   - Documentação Swagger: `http://localhost:8080/swagger-ui.html`

## 📺 Endpoints Principais

- **Autenticação**  
  - `POST /login` → Autentica um usuário e retorna um token JWT.

- **Pacientes**  
  - `GET /pacientes` → Lista pacientes paginados.  
  - `POST /pacientes` → Cadastra um novo paciente.  
  - `PUT /pacientes` → Atualiza um paciente existente.  
  - `GET /pacientes/{id}` → Detalha um paciente pelo ID.  
  - `DELETE /pacientes/{id}` → Remove um paciente.

- **Médicos**  
  - `GET /medicos` → Lista médicos paginados.  
  - `POST /medicos` → Cadastra um novo médico.  
  - `PUT /medicos` → Atualiza um médico existente.  
  - `GET /medicos/{id}` → Detalha um médico pelo ID.  
  - `DELETE /medicos/{id}` → Remove um médico.

- **Consultas**  
  - `POST /consulta` → Agenda uma consulta.  
  - `DELETE /consulta` → Cancela uma consulta.

## 🔒 Autenticação

A API usa autenticação **JWT Bearer Token**. Para acessar os endpoints protegidos, inclua o token no cabeçalho da requisição:

```
Authorization: Bearer <seu-token>
```

## 📝 Licença

Esta API está licenciada sob a **Apache 2.0**. Veja mais detalhes [aqui](http://voll.med/api/licenca).

