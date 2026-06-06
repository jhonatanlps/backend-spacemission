# Backend SpaceMission

API REST para gerenciamento de sensores, sistemas e alertas usada no projeto SpaceMission.

**Projeto**
- **Descrição**: Serviço backend em Java com Spring Boot que expõe endpoints para CRUD de sensores, sistemas e alertas.

**Tecnologias**
- **Java**: 17
- **Framework**: Spring Boot 4
- **Banco**: H2 (arquivo, configurado em `data/consultas`)
- **Build**: Maven (com wrapper `mvnw`)
- **Outros**: Lombok (anotações/geração), JPA/Hibernate

**Pré-requisitos**
- Java 17 instalado
- (Opcional) IDE com suporte a Maven

**Como executar (desenvolvimento)**

1. Rodar a aplicação com o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

2. Acessar a API em `http://localhost:8080` (porta padrão)

3. Console H2 (web): `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:file:./data/consultas`
- User: `sa` (senha vazia)

**Build e execução do JAR**

```bash
./mvnw package
java -jar target/backend-spacemission-0.0.1-SNAPSHOT.jar
```

**Testes**

```bash
./mvnw test
```

**Configurações importantes**
- Aplicação: [src/main/java/com/fiap/ec/backend_spacemission/BackendSpacemissionApplication.java](src/main/java/com/fiap/ec/backend_spacemission/BackendSpacemissionApplication.java)
- Propriedades: [src/main/resources/application.properties](src/main/resources/application.properties)

**Endpoints principais**

Base: `http://localhost:8080`

- **Sensores** (`/sensores`)
	- `POST /sensores` — cria um sensor
		- Exemplo JSON:
			```json
			{ "nome": "Sensor A", "descricao": "Sensor de temperatura" }
			```
	- `GET /sensores` — lista todos os sensores
	- `GET /sensores/{id}` — obter sensor por id
	- `PUT /sensores/{id}` — atualizar sensor
	- `DELETE /sensores/{id}` — deletar sensor

- **Sistemas** (`/sistemas`)
	- `POST /sistemas` — cria um sistema
		- Exemplo JSON:
			```json
			{ "nome": "Sistema X", "descricao": "Controle de vôo", "status": true }
			```
	- `GET /sistemas` — lista todos os sistemas
	- `GET /sistemas/{id}` — obter sistema por id
	- `PUT /sistemas/{id}` — atualizar sistema
	- `DELETE /sistemas/{id}` — deletar sistema

- **Alerta** (`/alerta`)
	- `POST /alerta` — cria um alerta
		- Exemplo JSON (associando um sistema existente por id):
			```json
			{ "descricao": "Temperatura alta", "status": "ATIVO", "sistemas": { "id": 1 } }
			```
	- `GET /alerta` — lista todos os alertas
	- `GET /alerta/{id}` — obter alerta por id
	- `PUT /alerta/{id}` — atualizar alerta
	- `DELETE /alerta/{id}` — deletar alerta

**Observações**
- O banco H2 está configurado para arquivo em `data/consultas` (veja `application.properties`).
- A aplicação usa `spring.jpa.hibernate.ddl-auto=update`, então o esquema será criado/atualizado automaticamente em execução.

**Contribuição**
- Abra issues ou envie pull requests com melhorias.

**Licença**
- (Adicionar informação de licença, se aplicável)

