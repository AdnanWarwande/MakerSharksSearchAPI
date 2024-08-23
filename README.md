# Manufacturer Search API - MakerSharks Internship Task

## Project Overview

This is a Spring Boot RESTful API for searching manufacturers based on specific criteria such as location, nature of business, and manufacturing processes. The API allows querying manufacturers from a MySQL database and is designed to be efficient, reliable, and scalable.

## Features

- Search manufacturers based on:
  - Location
  - Nature of business
  - Manufacturing processes
- RESTful API endpoints following best practices

## Tech Stack

- Java 11
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Project Setup

Follow these steps to set up the project locally:

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/manufacturer-search-api.git
    cd manufacturer-search-api
    ```

2. Open the project in IntelliJ IDEA.

3. Install the dependencies:

    ```bash
    mvn clean install
    ```

4. Update the `application.properties` file with your MySQL credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/manufacturer_db
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    ```

## Database Configuration

Before running the application, set up your MySQL database:

1. Create a new database:

    ```sql
    CREATE DATABASE manufacturer_db;
    ```

2. The application will automatically handle table creation based on the JPA entities.

## Running the Application

You can run the application using:

```bash
mvn spring-boot:run
```

Once the application is running, the API will be available at `http://localhost:8080`.

## Testing the API in Postman

1. Open Postman and create a new collection.

2. Add the following request:

    - **Method**: POST
    - **URL**: `http://localhost:8080/api/supplier/query`
    - **Query Parameters**:
      - `location`: (e.g., "New York")
      - `natureOfBusiness`: (e.g., "Small_scale")
      - `manufacturingProcess`: (e.g., "3d_printing")

3. Send the request to view the filtered results.

You can add more queries to test different combinations.

## How the Project Works

The API is designed to filter manufacturers based on the provided criteria using Spring Data JPA. The service layer handles business logic, while the controller layer manages the incoming requests and the response handling.

### Flow:

1. User sends a request with filters via the API.
2. The controller processes the request and calls the service.
3. The service queries the database using JPA methods.
4. Results are returned and displayed as JSON.
