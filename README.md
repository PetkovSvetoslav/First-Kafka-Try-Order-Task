# Real-Time Order Processing System

This project is a **real-time order processing system** built with a Spring Boot backend, Apache Kafka for message brokering, MySQL as the database, and a simple HTML frontend. The system demonstrates asynchronous order creation, processing, and retrieval, adhering to the given task requirements.

---

## 📋 Features

- **Frontend:**
  - Place a new order (fields: `name`, `product`, `quantity`).
  - View processed orders in real-time.

- **Backend:**
  - REST API for:
    - Creating new orders.
    - Fetching processed orders.
  - Simulates order processing using Kafka and a delay of 2 seconds per order.

- **Message Broker:**
  - Uses **Apache Kafka** for asynchronous messaging:
    - Orders are pushed to a Kafka topic.
    - A consumer processes the orders and updates their status.

- **Database:**
  - Stores processed orders using **MySQL**.

---

## 🛠️ Technologies Used

- **Spring Boot** (Backend Framework)
- **Apache Kafka** (Message Broker)
- **MySQL** (Relational Database)
- **HTML, CSS, JavaScript** (Frontend)
- **Docker** (Containerization)
- **Docker Compose** (Infrastructure Setup)

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed on your machine:
- **Docker** and **Docker Compose**
- **Java 17** (for backend development)

---

### 🐳 Running the Application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/PetkovSvetoslav/First-Kafka-Try-Order-Task/
   cd First-Kafka-Try-Order-Task
   ```
2. **Build the Spring Boot Application**:
   Maven
   ```bash
   mvn clean package
   ```
3. **Build and start the Docker containers**:
   ```bash
   docker-compose up --build
   ```
4. **Access the application**:
5. Backend API: http://localhost:8080
   - **Backend API:** [http://localhost:8080](http://localhost:8080)

6. **Kafka UI** (optional for debugging messages):
   - Access Kafka messages at [http://localhost:8081](http://localhost:8081).

---

### 📜 API Endpoints

#### 1. Create an Order
- **Endpoint:** `POST /orders`
- **Request Body (JSON):**
  ```json
  {
    "name": "John Doe",
    "product": "Laptop",
    "quantity": 2
  }
  ```
- **Response:** `201 Created`

#### 2. Fetch Processed Orders
- **Endpoint:** `GET /orders/processed`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "product": "Laptop",
      "quantity": 2,
      "status": "PROCESSED",
      "processedAt": "2024-11-25T12:00:00"
    }
  ]
  ```

---

### 🛠️ Debugging

#### MySQL
- Enter the MySQL container:
  ```bash
  docker exec -it mysql bash
  ```
- Log in to MySQL:
  ```bash
  mysql -u root -p
  ```
- View orders:
  ```sql
  USE order_app;
  SELECT * FROM orders;
  ```

#### Kafka
- View Kafka topics and messages using Kafka UI:
  - Navigate to [http://localhost:8081](http://localhost:8081).

---

### 🔧 Project Structure

```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.task.Order.Processing.system
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       ├── service
│   │   │       └── repository
│   │   ├── resources
│   │   │   ├── static (Frontend HTML)
│   │   │   └── application.properties
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```

---

## 📂 Docker Setup

The `docker-compose.yml` file orchestrates the setup:
- **MySQL:** Stores order data.
- **Kafka:** Message broker for order processing.
- **Kafka-UI:** (http://localhost:8081/)
- **Kafka-Client:** 
- **Zookeeper:** Required by Kafka.
- **Backend:** Spring Boot application.
- **Frontend:** Nginx serving the HTML UI.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
