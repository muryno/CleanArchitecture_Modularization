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



### Modularization 
- Data module: handle talking to server and providing data source 
- Domain module: handle business logic
- Presentation module: contain viewmodel to communicate with domain usecase
- artist module: for artist view and adapter
- app module for app entry point and dependency inject module

This approach help to build scalable, maintainable and robust application with software good practice(SOLID ,DRY,KISS, design patterm) in place 





