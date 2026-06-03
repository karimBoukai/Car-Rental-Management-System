<div align="center">

# 🚗 Car Rental Management System

### A Modern JavaFX-Based Desktop Application for Vehicle Rental Management

![Java](https://img.shields.io/badge/Java-8-orange?style=for-the-badge&logo=java)
![JavaFX](https://img.shields.io/badge/JavaFX-UI-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![JDBC](https://img.shields.io/badge/JDBC-Connectivity-green?style=for-the-badge)
![MVC](https://img.shields.io/badge/Architecture-MVC-red?style=for-the-badge)

</div>

---

## 📖 Overview

The **Car Rental Management System** is a desktop application developed using **JavaFX**, **MySQL**, and **JDBC** to automate and simplify vehicle rental operations.

The system enables administrators to manage vehicles, customers, rental transactions, and business analytics through a modern graphical interface while following **Software Architecture best practices** and the **Model-View-Controller (MVC)** design pattern.

This project was developed as part of the **SEN3006 – Software Architecture** course and demonstrates the practical implementation of layered architecture, database integration, object-oriented programming, and software design principles.

---

## ✨ Key Features

### 🔐 Authentication
- Secure Administrator Login
- Session Management
- User Validation

### 🚘 Vehicle Management
- Add New Vehicles
- Update Vehicle Information
- Delete Vehicles
- Search and Filter Vehicles
- Track Vehicle Availability

### 👥 Customer Management
- Store Customer Information
- Manage Rental Records
- Monitor Rental History

### 💳 Rental Processing
- Vehicle Booking
- Rental Cost Calculation
- Payment Processing
- Remaining Balance Calculation
- Automatic Vehicle Status Updates

### 📊 Dashboard & Analytics
- Total Customers Overview
- Vehicle Availability Statistics
- Income Monitoring
- Sales Analytics
- Interactive Charts & Reports

### 📁 Additional Utilities
- CSV Export Functionality
- Dashboard Refresh
- Reset Operations
- Data Visualization

---

## 🏗️ Software Architecture

The application follows a **Layered Architecture** combined with the **MVC Design Pattern**.

```text
┌─────────────────────────────┐
│      Presentation Layer     │
│ JavaFX • FXML • CSS         │
└─────────────┬───────────────┘
              │
┌─────────────▼───────────────┐
│     Controller Layer        │
│ Business Logic & Validation │
└─────────────┬───────────────┘
              │
┌─────────────▼───────────────┐
│       Data Access Layer     │
│ JDBC • Database Services    │
└─────────────┬───────────────┘
              │
┌─────────────▼───────────────┐
│       MySQL Database        │
└─────────────────────────────┘
```

---

## 🎯 Design Patterns

### Model – View – Controller (MVC)

The system separates responsibilities into three independent components:

| Component | Responsibility |
|------------|----------------|
| Model | Data and Database Operations |
| View | JavaFX GUI Components |
| Controller | Application Logic and User Interaction |

### DAO-Inspired Database Access

Database connectivity is centralized to improve maintainability and reduce duplicated code.

---

## 🛠️ Technology Stack

| Technology | Purpose |
|------------|----------|
| Java 8 | Core Development |
| JavaFX | User Interface |
| FXML | UI Layout Design |
| CSS | Styling |
| MySQL | Database Management |
| JDBC | Database Connectivity |
| Scene Builder | Interface Design |
| JFreeChart | Data Visualization |

---

## 📂 Main Modules

- 🔐 Authentication Module
- 🚘 Vehicle Management Module
- 👥 Customer Management Module
- 💳 Rental Processing Module
- 📊 Dashboard Module
- 📈 Analytics & Reporting Module
- 📁 Export Module

---

## 🎓 Educational Objectives

This project demonstrates:

- Software Architecture Principles
- Layered System Design
- MVC Pattern Implementation
- Database-Driven Development
- Object-Oriented Programming
- Software Maintainability
- Enterprise Application Design
- Data Visualization Techniques

---

## 🚀 Future Enhancements

- Role-Based Access Control (RBAC)
- BCrypt Password Encryption
- Online Reservation System
- Payment Gateway Integration
- RESTful API Development
- Spring Boot Migration
- Email & SMS Notifications
- Cloud Deployment Support
- Mobile Application Integration

---

## 📸 Screenshots

### Login Screen
_Add screenshot here_

### Dashboard
_Add screenshot here_

### Vehicle Management
_Add screenshot here_

### Rental Processing
_Add screenshot here_

### Analytics Dashboard
_Add screenshot here_

---

## 👨‍💻 Author

**Karim Boukai**  
Software Engineering Student  
Bahçeşehir University

---

## 📜 License

This project was developed for **educational and academic purposes** as part of the **Software Architecture** course.

---

<div align="center">

### ⭐ If you found this project interesting, consider giving it a star!

</div>
