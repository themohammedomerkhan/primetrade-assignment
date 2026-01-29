# Primetrade Backend Developer Internship Assignment

## Project Overview
Secure REST API with JWT Authentication and 
Role Based Access with React frontend.

## Tech Stack

Backend:
- Java
- Spring Boot
- Spring Security
- JWT
- MySQL
- Swagger

Frontend:
- React.js
- Axios
- React Router

## Features

- User Registration & Login
- JWT Authentication
- Role Based Access (USER / ADMIN)
- Task CRUD APIs
- Protected APIs
- React Frontend UI

## Database Setup

Create MySQL database:

CREATE DATABASE primetrade_db;

Update credentials inside application.properties.

## Backend Run Steps

1. Start MySQL
2. Update application.properties
3. Run:

mvn spring-boot:run

Backend URL:
http://localhost:4040

Swagger:
http://localhost:4040/swagger-ui.html

## Frontend Run Steps

cd primetrade-frontend
npm install
npm start

Frontend URL:
http://localhost:3000

## API Authentication Flow

1. Register User using /api/auth/register  
2. Login User using /api/auth/login  
3. JWT Token will be returned  
4. Use token in header for protected APIs:

Authorization: Bearer YOUR_TOKEN


## API Documentation

Postman collection available in /postman folder.

## Scalability Notes

- Stateless JWT Authentication (horizontal scaling supported)
- Layered Architecture (Controller-Service-Repository)
- Can be containerized using Docker
- Redis caching can be added for performance
- Load balancer ready architecture

## Scalability Notes

- Stateless JWT Authentication
- Layered Architecture
- Can scale using Docker & Microservices
- Redis caching can be added

## Author
Mohammed Omer Khan
