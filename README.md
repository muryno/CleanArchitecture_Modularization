# Clean Architecture Modularization

The "Practical Guide to Building Android Apps with Clean Architecture, Modularization, and Unit Testing" is a comprehensive resource that outlines best practices for developing robust and maintainable Android applications. Detailed in a Medium article [ Practical Guide to Building Powerful and Easy-to-Maintain Android Apps with Clean Architecture, Modularization ](https://murainoyakubu.medium.com/practical-guide-to-building-powerful-and-easy-to-maintain-android-apps-with-clean-architecture-c6c8b592a0f2), this guide emphasizes on the importance of using Clean Architecture, modularization, and unit testing to enhance app quality and scalability.


## Project Modules

### **artist-domain** 
Business logic layer - Contains use cases, domain models, and repository interfaces (pure Kotlin, no Android dependencies)

### **artist-data**
Data layer - Implements repositories and handles data mapping between data sources and domain

### **artist-datasource**
Remote data layer - Handles API calls using Retrofit and maps API responses to data models

### **artist-presentation**
Presentation layer - Contains ViewModels, presentation models, and UI state management

### **artist-ui**
UI layer - Contains Fragments, Compose screens, and UI components

### **app**
Application module - App entry point, dependency injection setup (Hilt), and navigation


## Features
- Search for artists (default: Drake) using MusicBrainz API
- View artist albums and release information
- Dark/light mode support with Material Design
- Built with Jetpack Compose and traditional Views


## Tech Stack
- **Architecture**: Clean Architecture, MVVM, Repository Pattern
- **DI**: Hilt
- **UI**: Jetpack Compose + XML Views
- **Networking**: Retrofit, OkHttp, Gson
- **Async**: Kotlin Coroutines
- **Testing**: JUnit, Mockito, MockK, Espresso


## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Build and run

```bash
./gradlew build
./gradlew installDebug
```


## Screen

<img width="336" alt="Screenshot 2022-10-25 at 22 43 48" src="https://user-images.githubusercontent.com/26343440/197887992-51323194-0dcb-48e6-ae93-e570633aa807.png">

