# Spring JDBC Basics Project

A simple project demonstrating **Spring JDBC** with **MySQL** integration using Maven and Spring’s `JdbcTemplate`.  
It covers basic CRUD operations: **Insert**, **Update**, **Delete**, and **Fetch**.

---

## Project Structure

- `AppConfig.java`  
  Spring @Configuration class to define **DataSource** and **Repo** beans.

- `Repo.java`  
  Repository class using **JdbcTemplate** to perform database operations (insert, update, delete, fetch).

- `MainApp.java`  
  The main application to test all functionalities.

---

## Technologies Used
- Java 8+
- Spring Framework 5.3.22
- Spring JDBC
- Maven
- MySQL 8.0.31
- Spring Context

---

## Prerequisites
- Java installed on your machine
- MySQL server running
- Maven installed
- A database named `firstdb` created in MySQL
- A table named `jdbc` with the following structure:

```sql
CREATE TABLE jdbc (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);
```

---

## Maven Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.3.22</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.31</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.22</version>
    </dependency>
</dependencies>
```

---

## Database Configuration

In `AppConfig.java`, database connection is configured like this:

```java
dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
dataSource.setUrl("jdbc:mysql://localhost:3306/firstdb");
dataSource.setUsername("root");
dataSource.setPassword("your passsword");
```
> **Note:** Change the username and password if your database credentials are different.

---

## How to Run

1. **Clone the project** or create the structure manually.
2. **Import it as a Maven Project** into your IDE (like Eclipse, IntelliJ).
3. **Ensure your MySQL database and table are ready**.
4. **Run `MainApp.java`** as a Java Application.
5. **Uncomment** the operations you want to test (Insert, Update, Delete, Fetch).
6. **Check console output** for results!

---

## Sample Usage (MainApp.java)

```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
Repo repo = context.getBean(Repo.class);

// Insert Example
// repo.insertData(2, "Amar");

// Update Example
// repo.updateData(2, "Akshay");

// Delete Example
// repo.deleteData(2);

// Fetch All Example
// List<String> records = repo.fetchData();
// records.forEach(System.out::println);

// Fetch By ID Example
String name = repo.fetchById(1);
System.out.println(name);
```

---

## Important Notes

- **JdbcTemplate** internally manages connection creation and closing.
- **@Repository** annotation marks the Repo class as a DAO.
- **@Configuration** and **@Bean** annotations are used for Java-based configuration (no XML needed).
- **Spring Context** manages the beans lifecycle.
- Remember to **handle SQL exceptions** properly in a real-world project (you can enhance this example by adding try-catch or AOP based error handling).

---

## Project Flow Diagram

```text
MainApp.java
    |
    v
AppConfig.java (Configuration)
    |
    v
DataSource Bean ---> Repo Bean
    |
    v
Database Operations via JdbcTemplate
    |
    v
MySQL Database (firstdb -> jdbc table)
```

---


## This project is for educational purposes only.
---

