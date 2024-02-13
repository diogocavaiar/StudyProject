# :construction: IN DEVELOPMENT...


# StudyProject

Welcome to the repository of Android Development Study Project! This project has been created with the aim of exploring and applying best practices and the latest technologies available in the Android world.

![Screenshot_20240214_002351_StudyProject_](https://github.com/diogocavaiar/StudyProject/assets/31456362/72076bc7-60a2-485f-98a4-4b4c2676c52d)
![Screenshot_20240214_002359_StudyProject_](https://github.com/diogocavaiar/StudyProject/assets/31456362/ad095065-fa5b-4f79-98e1-53cd383e6b78)



## Objective
Main goal is to develop a robust, scalable, and high-quality Android application while learning and applying the latest techniques and tools available on the Android platform. This project serves as a learning platform for Android developers interested in enhancing their skills and staying up-to-date with recommended practices.

## Technologies Used

- Kotlin: We use Kotlin as the primary programming language due to its conciseness, safety, and interoperability with Java.
- Jetpack Components: We leverage Jetpack components such as ViewModel, Navigation, Paging, Room, among others, to develop a robust and scalable architecture.
- Retrofit: For API communication, we use Retrofit due to its ease of use and customization power.
- Coroutines: We use coroutines to handle asynchronous operations in a simpler and more concise way.
- Flow: It offers a sequential and asynchronous stream of data that emits multiple values over time. Flow is particularly useful for handling asynchronous operations in a more efficient and concise manner compared to traditional callback-based or reactive programming approaches.
- Material Design: We follow Material Design principles and guidelines to ensure a cohesive and intuitive user experience.
- Unit and Instrumented Testing: We implement unit and instrumented tests to ensure code quality and application stability.
- Dependency Injection: We use Dagger/Hilt for dependency injection to ensure a decoupled and testable architecture.
- Jetpack Compose: We explore the possibility of using Jetpack Compose to develop user interfaces in a declarative and more efficient manner.
- Version Catalog: We use it to centralize all dependencies, making it easier to manage and update them.
- Gradle Convention Plugins: Is a powerful tool for reusing build configuration. They allow you to define a set of conventions for a project or module, and then apply those conventions to other projects or modules. This can greatly simplify build management and increase efficiency.

## Architeture

The MVI (Model-View-Intent) Architecture is a design pattern used in Android app development. It consists of three main components:

![Architecture_MVI_](https://github.com/diogocavaiar/StudyProject/assets/31456362/d84da3c3-58eb-4259-8bf8-e52c180d298c)


Model: Represents the current state of the application and contains business logic.
View: Responsible for presenting data to the user and interacting with them.
Intent: Represents user intentions, such as actions they want to perform in the app interface.

The key idea behind the MVI architecture is the unidirectional flow of data. User intents are captured by the View and transformed into "intent" events sent to the Model. The Model then processes these events, updates its internal state, and emits a new state. The View then reacts to this state change and updates the user interface accordingly.

The MVI architecture promotes a clear separation between business logic and presentation, making code testing and maintenance easier. Additionally, by using a unidirectional data flow, it helps to avoid common synchronization and state issues in Android apps.

## Concept Used - Feature Module

This architectural approach promotes code modularization by dividing the application into independent components that focus on specific functionalities or related sets of features.Each feature module typically contains not only the code related to the feature itself but also its own dependencies, resources, and associated tests. This facilitates code maintenance, testing, and reusability while enabling parallel development of different parts of the application by separate teams. Adopting feature modules helps improve scalability, readability, and organization of code in Android projects, making it easier to add and remove features and allowing the application to grow in a more flexible and controlled manner.

## Features

- Movie
- Movie Detail

## Core

- analytics
- common
- designsystem
- model
- navigation
- network
- network-framework
- ui

## Development

Want to contribute? Great!

If you are an Android developer interested in learning and contributing to this project, feel free to open an issue or send a pull request. We are always open to new ideas, suggestions, and improvements.
