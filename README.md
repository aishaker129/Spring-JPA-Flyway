
# Student & University Management System

A Spring Boot RESTful API designed to manage student enrollments and university records. This project demonstrates a clean layered architecture, database versioning with Flyway, and standardized API responses.

## 🚀 Key Features

* **Student Management:** Full CRUD operations for students (Enroll, Update, Delete, Fetch).
* **University Management:** Create and track university entities.
* **Database Migrations:** Automated schema versioning using **Flyway**.
* **Global Response Wrapper:** All API responses follow a consistent `ApiResponse<T>` structure.
* **Data Mapping:** Clean separation between Entities and DTOs using a custom `Mapper` layer.

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot 4.0.1**
* **Spring Data JPA**
* **Flyway DB** (Migration management)
* **Lombok**
* **Gradle**

---

## 📂 Project Structure


Based on the project files, the architecture is organized as follows:
* `controller`: Entry points for Student and University endpoints.
* `service`: Business logic implementation (e.g., `StudentServiceImpl`).
* `repository`: Interface for database communication.
* `dto`: Request and Response data transfer objects.
* `mapper`: Logic to convert between Entities and DTOs.
* `resources/db.migration`: SQL scripts (`V1__`, `V2__`) for Flyway schema evolution.

---

## 🚦 Getting Started

### Prerequisites
* JDK 17 or higher.
* A relational database (configured in `application.yaml`).

### Setup & Run
1.  **Clone the repository:**
    ```bash
    git clone <your-repo-url>
    cd <project-folder>
    ```
2.  **Configure Database:** Update `src/main/resources/application.yaml` with your database credentials.
3.  **Run the Application:**
    ```bash
    ./gradlew bootRun
    ```

---

## 📖 API Documentation

### University Endpoints
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/v1/university` | Create a new university |

### Sample Request Create University
```json
{
    "name":"BUBT",
    "location":"Mirpur-2, Dhaka"
}

```
### Sample Response Structure

All responses return a standardized object:

```json
{
    "status": "201 CREATED",
    "statusCode": 201,
    "message": "University Created successfully",
    "error": false,
    "data": {
        "id": 1,
        "name": "BUBT",
        "location": "Mirpur-2, Dhaka"
    }
}

```

### Student Endpoints
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/v1/students/enroll` | Enroll a new student |
| **GET** | `/api/v1/students` | Get list of all students |
| **GET** | `/api/v1/students/{id}` | Get student by ID |
| **PUT** | `/api/v1/students/{id}/update` | Update student details |
| **DELETE** | `/api/v1/students/{id}` | Remove a student |

### Sample Request (Enroll Student)
**POST** `/api/v1/students/enroll`
```json
{
    "name":"Ai Shaker",
    "dept":"CSE",
    "email":"shaker@gmail.com",
    "phoneNumber":"01512345678",
    "age":25,
    "intake":"49",
    "section":"9",
    "universityId":1
}

```

### Sample Response Structure

All responses return a standardized object:

```json
{
    "status": "201 CREATED",
    "statusCode": 201,
    "message": "Student created successfully",
    "error": false,
    "data": {
        "id": 1,
        "name": "Ai Shaker",
        "dept": "CSE",
        "email": "shaker@gmail.com",
        "phoneNumber": "01512345678",
        "age": 25,
        "intake": 49,
        "section": 9,
        "universityId": 1
    }
}
```

---

## 🛡️ Exception Handling

The system handles the following custom exceptions:

* `UniversityNotFoundException`: Thrown when a Student is assigned to a non-existent University.
* `StudentNotFoundExciption`: Thrown when searching/modifying a non-existent student ID.
* `EntityExistsException`: Thrown when creating a duplicate University name.

```

