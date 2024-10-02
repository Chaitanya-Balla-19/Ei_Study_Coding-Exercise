# Ei_Study_Coding-Exercise
# Project Structure
The project is organized into two main exercises:

# Exercise 1: Design Pattern Use Cases
Behavioral Design Patterns
1. Mediator Pattern for Multiplayer Game Lobby
2. Strategy Pattern for Payment Processing System

Creational Design Patterns
1. Notification System using Factory Pattern
2. Thread Pool for Task Processing

Structural Design Patterns
1. Adapter Pattern for Different File Format Readers
2. Decorator Pattern for Streaming Service Subscription Customization

# Exercise 2: Astronaut Daily Schedule Organizer
In this exercise, an Observer Pattern, Factory Pattern, and Singleton Pattern are used to build a schedule organizer for astronauts. The organizer allows astronauts to manage their daily tasks while ensuring there are no overlapping tasks, and notifications are sent in case of conflicts.

# Design Patterns Used:
Singleton Pattern: Ensures only one ScheduleManager instance exists, which manages the astronaut’s schedule.
Factory Pattern: Creates tasks via the TaskFactory to simplify task creation.
Observer Pattern: Observers (users) are notified of task conflicts and task additions, removals, or updates.
# Files:
AstronautScheduleOrganizer.java
ScheduleManager.java
Task.java
TaskFactory.java
TaskObserver.java
User.java
Validator.java
# Description:
This system manages the daily tasks of astronauts, ensuring that no two tasks overlap. It uses the Observer Pattern to notify users (astronauts) about task conflicts or updates. The Factory Pattern is used to create tasks, and the Singleton Pattern ensures only one schedule manager is responsible for all the astronaut's tasks.

# Features:
Add, edit, or remove tasks.
Mark tasks as completed.
View tasks by priority (High, Medium, Low).
Notifications for task conflicts or updates.

