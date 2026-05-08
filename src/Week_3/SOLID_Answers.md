### SOLID Violations Hunt

**1. Single Responsibility Principle (SRP) Violation:**
The `HospitalSystem` class is a "God Class." It handles patient admission, invoicing, notifications, database connections, report printing, and insurance calculations. These are entirely different responsibilities. If the database connection logic changes or the reporting format changes, this class has to be modified.

**2. Open/Closed Principle (OCP) Violation:**
The `calculateInsurance(String plan, double amount)` method likely relies on conditional statements (like `if` or `switch`) to check the `plan`. If a new insurance plan is introduced, you are forced to modify this class.
Additionally, `sendSMS` is hardcoded to SMS. Adding an Email or Push notification would require modifying the class.

**3. Dependency Inversion Principle (DIP) Violation:**
The class depends directly on low-level implementation details like `connectToDatabase()` and `sendSMS()`. It should depend on abstractions (like a `DatabaseService` interface or `Notifier` interface) so that the underlying database or notification mechanism can be swapped out without modifying the high-level logic.

---

### Corrected Version
The code should be broken down into separate classes and interfaces to adhere to SOLID principles. The `HospitalSystem` can either be removed entirely in favor of these independent services, or it can be refactored into a **Facade** that simply delegates tasks to these injected services.

*(See `HospitalSystemRefactored.java` for the actual Java implementation)*
