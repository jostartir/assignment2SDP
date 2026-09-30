# Assignment 2 -- Factory Method & Abstract Factory

## Project Overview

This smart home project uses Factory Method and Abstract Factory to create lights, locks, and thermostats for HomeKit, Tuya, Xiaomi, and Aqara. Users select an ecosystem and run three simulated home routines.
## Design Patterns

**Factory Method:** Creates smart lights within a shared installation and configuration workflow.

**Abstract Factory:** Creates a related family of lights, locks, and thermostats for the selected ecosystem.

## How to Run the Project

### Prerequisites

- JDK 17 or later
- Java IDE
- JUnit 5 for tests

### Run the Application

Run `src/Main.java`

### Run Automated Tests

Run `SmartHomeEcosystemTest.java`

## Automated Testing Summary

The project contains 16 tests covering product creation, family consistency, runtime selection, business-operation execution, negative scenarios, the Aqara extension, and client abstraction.


## Adding the fourth family

**ADDED**

devices/aqara/AqaraLight

devices/aqara/AqaraLock

devices/aqara/AqaraThermostat

factory/AqaraFactory

**MODIFIED**

factory/FactorySelector

## UML Diagram

![uml.png](uml.png)



