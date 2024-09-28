# Hotel Microservices

Este projeto consiste em dois microserviços criados com Spring Boot e Docker. O primeiro microserviço é responsável pelo gerenciamento de clientes, hotéis e reservas. O segundo microserviço envia notificações ao console quando uma nova reserva é feita.

## Arquitetura dos Microserviços

1. **Hotel Service (Micro-1)**: 
   - Gerencia operações de criação de clientes, hotéis e reservas.
   - API REST desenvolvida em Spring Boot.

2. **Notification Service (Micro-2)**: 
   - Recebe eventos de criação de reserva e envia notificações para o console.
   - Também desenvolvido em Spring Boot.

## Instruções de Instalação e Execução

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/hotel-microservices.git
   cd hotel-microservices

2. Compile os dois microserviços
   ```bash
   cd micro-1
   mvn package -DskipTests
   cd micro-2
   mvn package -DskipTests
   
3. Execute os microserviços
   ```bash
   cd ../
   docker compose up --build

## Endpoints da API

### 1. Criar Cliente

- **URL**: `localhost:8080/client`
- **Payload**:
  ```json
  {
    "name": "John Doe",
    "age": 30,
    "email": "john.doe@example.com"
  }
  
### 2. Criar Hotel

- **URL**: `localhost:8080/hotel`
- **Payload**:
  ```json
  {
    "name": "Hotel example",
    "city": "Example City",
    "cep": "199999903"
  }
  
### 3. Criar Reserva

- **URL**: `localhost:8080/reservation`
- **Payload**:
  ```json
  {
  "client_id": 1,
  "hotel_id": 1,
  "date": "2024-10-01T15:00:00"
  }

## Funcionamento dos Microserviços

Este projeto consiste em dois microserviços independentes que interagem entre si para realizar o gerenciamento de reservas e enviar notificações:

### 1. **Hotel Service (Micro-1)**

- **Responsabilidade**: Este microserviço gerencia operações como criação de clientes, hotéis e reservas. Ele expõe uma API REST que permite criar novos clientes e hotéis, além de registrar novas reservas.
- **Fluxo**:
  1. O usuário faz uma requisição para um dos endpoints (como `/client`, `/hotel` ou `/reservation`).
  2. As informações fornecidas são processadas e armazenadas no banco de dados do Hotel Service.
  3. Quando uma reserva é criada com sucesso, um evento é emitido para notificar o sistema.

### 2. **Notification Service (Micro-2)**

- **Responsabilidade**: O Notification Service é responsável por monitorar os eventos gerados pelo Hotel Service, especificamente a criação de reservas.
- **Fluxo**:
  1. Quando uma nova reserva é registrada no Hotel Service, o Notification Service é acionado e recebe os detalhes da reserva.
  2. O Notification Service então envia uma mensagem para o console com os detalhes da reserva, como o cliente, o hotel e a data da reserva.

### Exemplo de Integração

Quando uma reserva é criada no Hotel Service via o endpoint `/reservation`, o sistema segue os passos:
1. O Hotel Service valida e armazena a reserva.
2. Um evento é emitido para o Notification Service.
3. O Notification Service, ao receber o evento, imprime no console:
## Ferramentas Usadas

O projeto utiliza as seguintes tecnologias dentro dos containers Docker:

1. **Spring Boot**:
   - Framework utilizado para desenvolver os dois microserviços, permitindo a criação de APIs REST de forma simples e eficiente.

2. **PostgreSQL**:
   - Banco de dados relacional usado pelo **Hotel Service** para armazenar informações de clientes, hotéis e reservas.

3. **Apache Kafka**:
   - Utilizado para comunicação entre os microserviços. Quando uma nova reserva é criada, um evento é enviado através do Kafka para o **Notification Service**, que então processa e exibe uma notificação no console.
