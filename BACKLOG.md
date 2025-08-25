# 📚 Bookstore API — Backlog

## 🎯 Опис
Bookstore API — навчальний проєкт для демонстрації архітектури, SOLID, GoF-патернів і практик бекенд-розробки на Java (Spring Boot + PostgreSQL).

---

## 🗂️ Milestones & Tasks

### Milestone A — Bootstrap & ADR
- [ ] Ініціалізувати репозиторій (структура модулів/пакетів)
- [ ] Додати Flyway/Liquibase + базову конфігурацію PostgreSQL
- [ ] ADR-000: шарова архітектура, транзакції, ідемпотентність
- [ ] Налаштувати Swagger + health-check

### Milestone B — Catalog & Customer
- [ ] Створити міграції для books, categories, customers (+ індекси)
- [ ] Catalog API: GET /books (фільтри, сортування, пагінація)
- [ ] Catalog API: GET /books/{id}, GET /categories, SEARCH /books
- [ ] Customer API: POST /customers, GET/PUT /customers/{id}, GET /customers/{id}/orders
- [ ] Реалізувати GoF: Composite / Iterator / Flyweight / Interpreter у Catalog
- [ ] Написати тести для Catalog & Customer (controller/service)

### Milestone C — Orders
- [ ] Створити міграції для orders, order_items, inventory
- [ ] POST /orders (ідемпотентність через Idempotency-Key)
- [ ] GET /orders/{id}, PUT /orders/{id}/cancel, PUT /orders/{id}/pay
- [ ] Реалізувати Chain of Responsibility: валідації (stock → discounts → taxes → antifraud)
- [ ] Реалізувати State: життєвий цикл замовлення
- [ ] Реалізувати Builder + Facade: побудова/обробка замовлення
- [ ] Написати тести на транзакційність і edge-cases

### Milestone D — Payments & Delivery
- [ ] Створити міграції для payments, deliveries
- [ ] Payments API: POST /payments, GET /payments/{id}, POST /payments/{id}/refund
- [ ] Delivery API: POST /delivery, GET /delivery/{id}, GET /delivery/options
- [ ] Реалізувати GoF: Adapter / Strategy / Proxy (payments), Bridge / Observer (delivery)
- [ ] Написати інтеграційні тести для payments/delivery

### Milestone E — Discounts & Taxes
- [ ] Discounts API: /discounts/apply
- [ ] Taxes API: /taxes/calculate
- [ ] Реалізувати GoF: Strategy + Decorator + Chain (накопичувані правила)
- [ ] Написати тести для комбінацій знижок/податків

### Milestone F — Notifications & Admin
- [ ] Notifications API: POST /notifications/*, GET /notifications/{id}
- [ ] Реалізувати Observer / Mediator / Facade інтеграцію з Orders/Delivery
- [ ] Admin API: CRUD для books, discounts, статистика продажів
- [ ] Реалізувати GoF: Command / Visitor / Proxy в адмін-операціях
- [ ] Написати тести: події → рівно одна нотифікація

### Milestone G — Infrastructure & Performance
- [ ] Уніфікований ErrorResponse + traceId
- [ ] Кеш каталогу (Redis або in-memory) + інвалідація на BookUpdated
- [ ] Простий rate-limit критичних ендпоїнтів
- [ ] Логування audit trail для ключових команд

### Milestone H — Docs, Tests, Docker
- [ ] Контрактні тести для Strategy (payments/discounts)
- [ ] Swagger опис + приклади curl/Postman
- [ ] Dockerfile (опц. docker-compose для Postgres/Redis)
- [ ] Оновити README: патерни/де застосовано/чому, як запустити ≤10 хв

---

## 🧪 Тест-кейси (регрес)
1. CRUD книги: створення → оновлення → пошук (з фільтрами/пагінацією)
2. Замовлення з різними типами книг + дві різні стратегії знижок → коректний total
3. Недостатній склад → помилка 409/422 без побічних ефектів
4. Ідемпотентність POST /orders → повторний виклик повертає той самий результат
5. Декоратори доставки: без/з експрес-доставкою → різна ціна
6. Нотифікація ORDER_CONFIRMED → рівно один раз
7. Payments: падіння зовнішнього провайдера → 5xx + коректна обробка

---
