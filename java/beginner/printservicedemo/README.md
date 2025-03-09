# CruxPress - Printing Service Application

CruxPress is a Spring Boot web application that provides printing service quotes and order management. This application allows customers to enter their printing requirements, view a detailed price quotation, and submit their order.

## Features

- **Modern Web Interface**: Clean, responsive design optimized for all devices
- **Real-time Quote Calculation**: Instantly calculate costs based on quantity and paper type
- **Detailed Price Breakdown**: Transparent pricing showing raw materials, labor, overhead, and taxes
- **Order Management**: Submit and track printing orders

## Technology Stack

- **Backend**: Java, Spring Boot
- **Frontend**: Thymeleaf, CSS3, HTML5, JavaScript
- **Build Tool**: Maven

## Getting Started

### Prerequisites

- JDK 17 or later
- Maven 3.6+ (or use the included Maven wrapper)
- Git

### Installation

1. Clone the repository:
   ```bash
   git clone git@github.com:bytecodecrux/TechRoots.git
   ```

2. Navigate to the project directory:
   ```bash
   cd java/beginner/printservicedemo
   ```

3. Build the project:
   ```bash
   ./mvnw clean install
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Access the application:
   Open your browser and go to `http://localhost:8080`

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── bcrux
│   │           └── printing
│   │               ├── CruxPressApplication.java
│   │               ├── controller
│   │               │   └── OrderController.java
│   │               ├── model
│   │               │   ├── Order.java
│   │               │   └── Quote.java
│   │               └── service
│   │                   └── QuoteService.java
│   └── resources
│       ├── static
│       │   └── css
│       │       └── style.css
│       └── templates
│           ├── order-confirmation.html
│           ├── order-form.html
│           └── quote-result.html
```

## Pricing Calculation Logic

CruxPress calculates printing costs based on the following components:

- **Raw Materials**: Base paper cost (15 cents per page)
- **Ink Cost**: 5 milliliters per page at 2 cents per milliliter
- **Labor**: 5 cents per page
- **Overhead**: 15% of materials and labor costs
- **Tax**: 8% of total production cost

---

## Video Tutorials

- **BCrux YouTube Channel**: [Watch Now](https://www.youtube.com/watch?v=rZ_epDtn2ac)
- **BCrux Website**: [Visit Here](https://bcrux.com/)

---

## Join the Community

Have questions or want to connect with other learners? Join our community:

- **Discord**: [Join Here](https://discord.com/invite/3hKrqXzC9n)
- **Patreon**: [Support and Learn More](https://patreon.com/bytecodecrux)

---

Feel free to explore, experiment, and share your progress. Happy coding! 😊