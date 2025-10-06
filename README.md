# E-Commerce Backend (Spring Boot)

## Overview
Minimal monolithic Spring Boot backend with:
- MySQL persistence
- Product CRUD
- User signup/login (JWT)
- Cart and Order management
- Postman collection included

## How to run
1. Create a MySQL database named `ecomdb` and update `src/main/resources/application.yml` with your DB credentials.
2. Build:
   ```bash
   mvn clean package
   ```
3. Run:
   ```bash
   mvn spring-boot:run
   ```
4. Import `postman_collection.json` into Postman to test APIs.

Default JWT secret is in `application.yml` — change it for production.
