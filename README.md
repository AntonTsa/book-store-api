# 📚 Bookstore API

## 🎯 Overview
**Bookstore API** — навчальний проєкт для демонстрації архітектури, SOLID, GoF-патернів і практик бекенд-розробки на Java.  
Мета: показати вміння проєктувати систему, застосовувати шаблони проєктування та будувати чистий, масштабований код.

---

## ⚙️ Tech Stack
- **Java 17+**
- **Spring Boot** (Web, Validation, Data JPA, Security)
- **PostgreSQL** + Flyway/Liquibase
- **JUnit 5 + Mockito** (unit tests)
- **Swagger / OpenAPI** (документація)
- **Dockerfile** (для швидкого запуску)

---

## 🏗️ Architecture
- Layered architecture: `Controller → Service → Repository`
- Domain-driven structure: `catalog`, `customer`, `orders`, `payments`, `delivery`, `notifications`, `admin`, `infrastructure`
- DTOs + (MapStruct/manual mapping)
- Configurable via `application.yml`

---

## 🎨 Design Patterns (GoF)
У проєкті застосовано такі патерни:

- **Creational**: Factory, Abstract Factory, Builder, Singleton, Prototype  
- **Structural**: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy  
- **Behavioral**: Strategy, Observer, Chain of Responsibility, Command, Template Method, State, Visitor, Mediator, Memento, Iterator, Interpreter  

👉 Приклади:  
- Factory/Abstract Factory → створення різних типів книг (eBook, Paperback, Audiobook)  
- Strategy → різні способи оплати (PayPal, Card, BonusPoints)  
- Observer → нотифікації про статус замовлення  
- Chain of Responsibility → валідація замовлення (stock → discounts → taxes)  
- Decorator → подарункова упаковка або експрес-доставка  
- State → життєвий цикл замовлення  

---

## 📦 Features
- CRUD для книг і клієнтів
- Кошик та оформлення замовлення
- Розрахунок знижок і податків
- Оплата (емуляція через різні провайдери)
- Доставка (кур’єр, пошта, електронна)
- Нотифікації (e-mail, SMS, push)
- Адмін-панель для керування товарами, акціями, статистикою

---

## 🚀 Getting Started

### Prerequisites
- Java 21
- Maven 3
- PostgreSQL (локально або в Docker)
- Spring Boot 
- Spring Modulith 1.4.1

### Run locally
```bash
mvn clean install
mvn spring-boot:run
