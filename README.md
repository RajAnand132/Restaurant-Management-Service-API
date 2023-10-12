# <h1 align="center"> Restaurant Management Service API</h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
  </a>
  <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
  </a>
   <img alt = "GPL v3" src="https://img.shields.io/badge/License-GPLv3-blue.svg" />
</p>

---

<p align="left">

## Overview

This is a Spring Boot application for a restaurant management system, providing CRUD operations for Users, Food Items, and Orders. The system also includes role-based access control for Admin, User, and Visitor roles.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

## Data Flow Diagram



                            ┌─────────────────────────┐
                            │   Restaurants API       │
                            └───────────┬─────────────┘
                                        │
                                        ▼
                            ┌─────────────────────────┐
                            │       Controllers       │
                            └───────────┬─────────────┘
                                        │
                                        ▼
                            ┌─────────────────────────┐
                            │       Services          │
                            └───────────┬─────────────┘
                                        │
                                        ▼
                            ┌─────────────────────────┐
                            │       Repositories      │
                            └───────────┬─────────────┘
                                        │
                                        ▼
                            ┌─────────────────────────┐
                            │       Database          │
                            └─────────────────────────┘


## Features

- **User Management**:
  - Admins can create, update, and delete user accounts.
  - Users can sign up, view their profile, and update their details.
  - Visitors can browse the menu without authentication.

- **Food Item Management**:
  - Admins can add, update, and delete food items.
  - Each food item includes a title, description, price, image URL, and creation timestamp.

- **Order Placement**:
  - Users can create orders for selected food items.
  - Orders have a status (created, dispatched, delivered) and are associated with a user and food item.

- **Role-Based Access Control**:
  - Admins have full privileges to manage users and food items.
  - Users have limited access to their profile and can place orders.
  - Visitors have read-only access to view food items.

## Entity Models
- User
  - id
  - username
  - password
  - email
  - role
  - createdDateTime
- FoodItem
  - id
  - title
  - description
  - price
  - dummyImageUrl
  - createdDateTime
- Order
  - orderId
  - foodItemId
  - userId
  - quantity
  - status
  - createdDateTime

## API Endpoints
- Users
  - `POST /api/users/signup`: Create a new user account.
  - `GET /api/users/{userId}`: Get a user's details.
  - `GET /api/users/`: Get a list of all users.
  - `PUT /api/users/{userId}`: Update a user's details.
  - `DELETE /api/users/{userId}`: Delete a user account.

- Food Items
  - `POST /api/foodItems/`: Create a new food item.
  - `GET /api/foodItems/{foodItemId}`: Get details of a food item.
  - `GET /api/foodItems/`: Get a list of all food items.
  - `PUT /api/foodItems/{foodItemId}`: Update a food item.
  - `DELETE /api/foodItems/{foodItemId}`: Delete a food item.

- Orders
  - `POST /api/orders/`: Place a new order.
  - `GET /api/orders/{orderId}`: Get details of an order.
  - `GET /api/orders/user/{userId}`: Get a list of orders for a user.
  - `PUT /api/orders/{orderId}`: Update an order's status.
  - `DELETE /api/orders/{orderId}`: Delete an order.

## Controllers
- UserController
  - Manages user-related CRUD operations
- FoodItemController
  - Manages food item-related CRUD operations
- OrderController
  - Manages order-related CRUD operations

## Security
- Implement Spring Security for role-based access control and user authentication.

## User Roles
- ADMIN: Full privileges
- USER: Limited privileges
- VISITOR: Read-only access

## Optional Features
- Added date and time fields to entities.
- Added a dummy image URL to Food Items.

Please note that this is a simplified example. For a production-ready application, you should enhance security, error handling, and implement more features.

## Getting Started
1. Clone this repository.
2. Configure your database connection in `application.properties`.
3. Build and run the application.
4. Access the API endpoints to manage users, food items, and orders.

For a more detailed guide on setting up and running the application, please refer to the project documentation.

## Project Structure
- `src/main/java/com.example.restaurantmanagement/`: Contains the Java source code.
- `src/main/resources/`: Contains application properties and configurations.

## Dependencies
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database (for demonstration purposes, replace with your database of choice)
- Other dependencies as specified in `build.gradle` or `pom.xml`.
#### Swagger Configuration
```
http://localhost:8080/swagger-ui/index.html#/
```
## Contact Information

If you have any questions, issues, or need further assistance related to the  Model-Based CRUD Operations Portal project, feel free to contact us. We are here to help!

- **Raj Anand**
  - Email: rajanandxxxx@example.com
  - LinkedIn: [Raj Anand's LinkedIn Profile]()
  - GitHub: [Raj Anand's GitHub Profile]()


Please don't hesitate to reach out if you have any inquiries or need assistance with any aspect of the project. Your feedback and questions are important to us.


## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.