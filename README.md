# University Console Application

This is a Spring Boot Java project that simulates a university with departments and lectors. The application uses an H2 relational database to store the data.

## Features

The application provides the following functionalities:

1. **Who is head of department {department_name}**
    - Example Input: `Who is head of department Computer Science`
    - Example Output: `Head of Computer Science department is John Doe`

2. **Show {department_name} statistics**
    - Example Input: `Show Computer Science statistics.`
    - Example Output:
      ```
      Assistants - 5
      Associate Professors - 3
      Professors - 2
      ```

3. **Show the average salary for the department {department_name}**
    - Example Input: `Show the average salary for the department Computer Science`
    - Example Output: `The average salary of Computer Science is 50000`

4. **Show count of employee for {department_name}**
    - Example Input: `Show count of employee for Computer Science`
    - Example Output: `10`

5. **Global search by {template}**
    - Example Input: `Global search by John`
    - Example Output:
      ```
      John Doe
      John Smith
      ```

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/andreytikholoz/university-pr.git

2. Navigate to the project directory:

   ```bash
   cd university-pr
   
3. Build and run the application:
   ```bash
   mvn spring-boot:run
   
Access the application at http://localhost:8080

## Database

The application uses an H2 in-memory database. You can access the H2 console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## Project Structure

The project follows the standard Spring Boot structure:

- `src/main/java/com/test/task` - Contains the main application code.
- `src/main/resources` - Contains database schema initialization.

## Technologies Used

- Spring Boot
- H2 Database
- Maven
