## Features
- *JWT Authentication*: Secure token-based authentication
- *Role-Based Access Control (RBAC)*: Two roles - ADMIN and USER
- *Domain-Based Access Control*: Restricts access based on request origin
- *MySQL Database Support*: Flexible database configuration
- *Comprehensive Security*: Spring Security integration

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA)
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (Java Web Token)
- H2/MySQL (for user-role storage)


### Authentication Endpoints
- POST /api/auth/login - User login
- POST /api/auth/register - User registration

### User Endpoints (USER and ADMIN roles)
- GET /api/user/profile - Get user profile

### Admin Endpoints (ADMIN role only)
- GET /api/admin/dashboard - Admin dashboard

## API Endpoints

### 1. create user
**POST** `api/auth/register`

**Request Body:**
```json
{
    "userName" : "Deep",
    "email" : "deep@gmail.com",
    "password" : "Deep@123"
}
```
**Response:**
```json
{
    "userId": 1,
    "userName": "Deep",
    "email": "deep@gmail.com",
    "password": "$2a$10$00dJRSFVy33ApnG2y8FyYOTw087bcdDatDK8uEmwzxiog8kaUJxAy",
    "roles": [
        {
            "roleId": 2,
            "roleName": "ROLE_USER"
        }
    ]
}
```

### 2. create admin
**POST** `api/auth/register`

**Request Body:**
```json
{
    "userName" : "Sachin",
    "email" : "sachin@gmail.com",
    "password" : "Sachin@123"
}
```
**Response:**
```json
{
    "userId": 1,
    "userName": "Sachin",
    "email": "sachin@gmail.com",
    "password": "$2a$10$00dJRSFVy33ApnG2y8FyYOTw087bcdDatDK8uEmwzxiog8kaUJxAy",
    "roles": [
        {
            "roleId": 1,
            "roleName": "ROLE_ADMIN"
        }
    ]
}
```

### 3. login admin
**POST** `api/auth/login`

**Request Body:**
```json
{
    "userName" : "sachin@gmail.com",
    "password" : "Sachin@123"
}
```
**Response:**
```json
{
    "username": "sachin@gmail.com",
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJzdWIiOiJiYWNrQGdtYWlsLmNvbSIsImlhdCI6MTc1MDM1MTU2NywiZXhwIjoxNzUwMzY5NTY3fQ.b7_e--XSPuY6TloUaDNZgHyLmC9-XJaR2fd7sYIk7EE",
    "role": [
        {
            "roleId": 1,
            "roleName": "ROLE_ADMIN"
        }
    ]
}
```

### 4. login user
**POST** `api/auth/login`

**Request Body:**
```json
{
    "userName" : "deep@gmail.com",
    "password" : "Deep@123"
}
```
**Response:**
```json
{
    "username": "deep@gmail.com",
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJzdWIiOiJiYWNrQGdtYWlsLmNvbSIsImlhdCI6MTc1MDM1MTU2NywiZXhwIjoxNzUwMzY5NTY3fQ.b7_e--XSPuY6TloUaDNZgHyLmC9-XJaR2fd7sYIk7EE",
    "role": [
        {
            "roleId": 2,
            "roleName": "ROLE_USER"
        }
    ]
}
```

### 5. Admin access url
**GET** `/api/admin/dashboard`
```
header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwic3ViIjoiYW1pdEBnbWFpbC5jb20iLCJpYXQiOjE3NTAzNTY0OTYsImV4cCI6MTc1MDM3NDQ5Nn0.SXpYAi4uyBTfBlBFJ0dKAbFBsYdAa0dTV7UG17AXOqg' \
```

**Response:**
```json
{
  "message": "Welcome Dashboard, sachin@gmail.com"
}
```
### 6. Admin access user url
**GET** `/api/user/profile`

```
header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwic3ViIjoiYW1pdEBnbWFpbC5jb20iLCJpYXQiOjE3NTAzNTY0OTYsImV4cCI6MTc1MDM3NDQ5Nn0.SXpYAi4uyBTfBlBFJ0dKAbFBsYdAa0dTV7UG17AXOqg' \
```
**Response:**
```json
{
  "message": "Welcome Profile, sachin@gmail.com"
}
```

### 5. user access admin url then error
**GET** `/api/admin/dashboard`

```
header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwic3ViIjoiYW1pdEBnbWFpbC5jb20iLCJpYXQiOjE3NTAzNTY0OTYsImV4cCI6MTc1MDM3NDQ5Nn0.SXpYAi4uyBTfBlBFJ0dKAbFBsYdAa0dTV7UG17AXOqg' \
```
**Response:**
```json
{
  "message": "Access Denied !! Full authentication is required to access this resource",
  "status": 401
}
```
### 5. user access user url
**GET** `/api/user/profile`

```
header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwic3ViIjoiYW1pdEBnbWFpbC5jb20iLCJpYXQiOjE3NTAzNTY0OTYsImV4cCI6MTc1MDM3NDQ5Nn0.SXpYAi4uyBTfBlBFJ0dKAbFBsYdAa0dTV7UG17AXOqg' \
```
**Response:**
```json
{
  "message": "Welcome Profile, deep@gmail.com"
}
```