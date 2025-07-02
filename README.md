# 🚗 UniRide - Java Desktop Ride Sharing System

UniRide is a Java Swing-based desktop application that simulates a ride-sharing platform for university students. It allows users to register as **Drivers** or **Riders**, post rides, and book available rides, all backed by an embedded SQLite database.

---

## 🛠️ Features

- GUI built with **Java Swing**
- Multi-role system: **Driver** and **Rider**
- SQLite database integration (local `.db` file)
- Object-Oriented Programming structure
- Real-time ride availability and booking
- Modular design using **CardLayout** for view switching
- Self-contained `.exe` installer built via **Launch4j** and **Inno Setup**

---

## 📦 Tech Stack

| Category     | Stack / Tool                      |
|--------------|-----------------------------------|
| Language     | Java 17+                          |
| UI Library   | Java Swing                        |
| Database     | SQLite (via JDBC)                 |
| Build Tool   | IntelliJ IDEA / Manual Compilation|
| Installer    | Launch4j + Inno Setup             |
| Architecture | OOP, MVC-Like Panel Separation    |

---

## 📁 Folder Structure

RideSharingApp/  
├── GUI/ # GUI panels (Login, Register, Dashboards, etc.)  
├── models/ # Model classes (Driver, Rider, Ride)  
├── utils/ # Utility classes (DatabaseManager, Validator)  
├── carpool.db # SQLite Database file  
├── RideSharingApp.java # Main launcher  
├── RideSharingApp.jar # Compiled JAR  
├── RideSharingApp.exe # Wrapped Executable (via Launch4j)  
└── setup.exe # Final Installer (via Inno Setup)  


## 🚀 How to Run

### 🧪 Development Mode
> Requires Java JDK installed

1. Clone the repository
2. Make sure `sqlite-jdbc.jar` is added to your classpath
3. Run:
   bash
  javac Main.java
  java Main



## 💡 Production Mode (Executable)
1.	Use setup.exe to install the application.  
2.	It includes:  
    -	Bundled .exe  
    -	Database (carpool.db)  
    -	Custom icon and install directory  


## 📦 Deployment (Optional/Future Scope)  
    -	Convert to Web App using Webswing or Spring Boot  
    -	Containerization using Docker + Kubernetes  
    -	Host on Railway, Render, or GCP  


## 👨‍💻 Developer
**Pritam Kumar**  
    - Designed GUI and UX using Swing  
    -	Applied OOP principles in Models and Logic  
    -	Integrated SQLite via JDBC  
    -	Built .jar using IntelliJ  
    -	Converted to .exe via Launch4j  
    -	Built final installer with Inno Setup  


## 📃 License  
    This project is for educational/demo purposes only. Fork and build upon it freely.  

