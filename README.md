# Mini Banking App (Java + Spring Boot + React)

Full-stack banking demo built with Java Spring Boot and React.

Features:
- User registration and login
- Account creation
- Balance lookup
- Deposits
- Transfers
- Transaction history

Tech Stack:
- Java Spring Boot
- React
- REST APIs
- In-memory storage (demo)

How to run:

Backend:
./mvnw spring-boot:run

Frontend:
npm start

Endpoints:
POST /api/auth/register
POST /api/auth/login
GET /api/auth/balance/{id}
POST /api/auth/deposit/{id}
POST /api/auth/transfer
GET /api/auth/transactions
