# Test Automation Project - Amazon

## Project Structure

📂 ProjectRoot/ 
├── 📂 src/test/java - Contains test features
├── 📂 src/main/java - Contains page objects and utilities
├── 📂 features/ - Cucumber feature files
├── 📂 stepDefinitions/ - Step definitions for Cucumber
├── 📂 utils/ - Helper classes such as WebDriver manager
├── 📜 pom.xml - Maven dependencies and project configurations
├── 📜 README.md - Project documentation



## Technologies Used

- **Java** (Programming language)
- **Selenium WebDriver** (Browser automation)
- **Cucumber** (BDD framework)
- **TestNG** (Test execution)
- **Maven** (Dependency management)
- **Allure** (Test reporting)

## How to Run Tests

### 1) **Setup**
- Install **Java JDK 11+**
- Install **Maven**
- Install **ChromeDriver** or the required WebDriver

### 2) **Run Tests**
- Using Maven:
  ```sh
  mvn test
### 3) **Allure Report**
- Using Maven:
  ```sh
  mvn allure:report

