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
<img width="1560" height="1044" alt="WhatsApp Image 2026-06-04 at 12 53 40 AM" src="https://github.com/user-attachments/assets/cc8a3edf-2ca4-4912-a7a1-a1e9d37d0f32" />


### Dashboard
<img width="1600" height="1018" alt="WhatsApp Image 2026-06-04 at 12 53 40 AM (1)" src="https://github.com/user-attachments/assets/2e83cad3-d821-478a-9a4d-027f72982aa7" />


### Vehicle Management
<img width="1600" height="1018" alt="WhatsApp Image 2026-06-04 at 12 53 40 AM (3)" src="https://github.com/user-attachments/assets/dcdf2e4b-7991-4955-a528-df6fdf7fd1e2" />


### Rental Processing
<img width="1600" height="1018" alt="WhatsApp Image 2026-06-04 at 12 53 40 AM (3)" src="https://github.com/user-attachments/assets/cafe8e07-7c03-4755-8cf9-86138962aa1c" />


### Analytics Dashboard
<img width="1600" height="1002" alt="WhatsApp Image 2026-06-04 at 12 53 40 AM (4)" src="https://github.com/user-attachments/assets/cd995f4f-0c10-4dc3-8f23-19d7d5f2e049" />


---

## 👨‍💻 Author

**Karim Boukai**
**Ahmad Saeedy**
**Hamza Malas**

Software Engineering Student  
Bahçeşehir University

---

## 📜 License

This project was developed for **educational and academic purposes** as part of the **Software Architecture** course.

---

<div align="center">

### ⭐ If you found this project interesting, consider giving it a star!

</div>
