# Delivery Caffee requirements

App focuses on the management of a cafe.

## Core features

- Personnel management
- Menu management
- Discount system
- Special offers (combo)
- Delivery system
    * Order status tracking
    * Delivery GPS tracking
    * Payment
    * Feedback (Complaints & Ratings)

## Domain model

### Users

Roles:
- Admin
- Manager (personnel management)
- Menu manager (menu, discounts)
- Cooker (order status update)
- Courier (delivery)
- Client (order creation, feedback)

### Menu item

### Discount

Applicable to menu items

### Special offer

List of menu items with lower price

### Order

From specific user, list of menu items, payment method, status

### Order status

To specific order

### Rating

Ratings by user per order, stars and comments

### Payment ???

## Roadmap

Each saturday

### 2020-11-07 Week 1
- CI configuration
- Swagger
- Entity model (liquibase)
- Web project setup
- Web design

### 2020-11-14 Week 2
- Spring security config (+ roles config)
- Web login/sign up
- Personnel management

### 2020-11-21 Week 3
- Menu management
- Discount & special offers

### 2020-11-28 Week 4
- Order management (+ status tracking)

### 2020-12-05 Week 5
- Payment system
- Feedback

### 2020-12-12 Week 6
