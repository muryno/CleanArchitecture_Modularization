# Artist App



### Architecture
* Clean Architecture & MVVM & Moduarization

Below is the image of the architecture used

<img width="745" alt="Screenshot 2022-10-24 at 02 50 02" src="https://user-images.githubusercontent.com/26343440/197883565-e35a36da-811d-4891-a2e7-d5a0fcbe80db.png">




### Library used
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) (Jetpack)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) (Jetpack)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Retrofit2](https://square.github.io/retrofit/)
* [coroutine](https://developer.android.com/kotlin/coroutines)
* [UNIT TEST](https://developer.android.com/training/testing/unit-testing)
* [Navigation graph](https://developer.android.com/guide/navigation/navigation-getting-started)


### Features
- search for list of artist.. default is drake as he is my favorite
- click on artist to fetch artist album
- dark mode supported
- Unit testing
- git log to track progress



### Modularization
- Data module: handle communicating with server and providing data source
- Domain module: handle business logic
- Presentation module: contain viewmodel to communicate with domain usecase
- artist module: for artist view and adapter
- app module for app entry point and dependency inject module

### Best practice
* [Coroutine best practice](https://developer.android.com/kotlin/coroutines/coroutines-best-practices)
* This approach help to build scalable, maintainable and robust application with software good practice(SOLID ,DRY,KISS, design pattern) in place


Here is the app screen

<img width="336" alt="Screenshot 2022-10-25 at 22 43 48" src="https://user-images.githubusercontent.com/26343440/197887992-51323194-0dcb-48e6-ae93-e570633aa807.png">

