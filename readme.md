# Flickr Gallery

The propose of this app is just for a test. This project has been developed in approximately 6 hours. 

It has been developed without any 3rd party library, it only uses the android libraries (androidx), kotlin libraries and the Jetpack. It has **manual Dependency Injection**

This app has been developed following the [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html), dividing the feature in three layers (in this case, each layer is a different module). Is an easy way to have a scalable project in a simple way. In this case, I just created the three modules (one on each module), but if the app increase, I would create a module for each feature. 

## Modules

### Data

Uses **Coroutines** to **execute the api calls in a different thread than the main thread** to don't block the screen. Also, it follows [the Repository Pattern](https://martinfowler.com/eaaCatalog/repository.html). As you can see, it has an Api Repository (who calls de api rest to get the data) and the data repository. This last one, can be deleted and the Api Repository can implement the repository, but, i created the Data Repository with the idea of create a cache repository and the data repository decide which repo use to get the data. For time, I haven't implemented it but I left the data repository to explain this logic, and implement the cache repository easily if needed.

All the repositories and entity mappers have unit tests, using JUnit and Mockito. Because of the usage of JSONObject (part of the android sdk) I have to create androidTests to test the mapping from Json as string to the object.

### Domain

Here we only have the description of the repository and the use cases (with the business logic) and the Domain Entities (entities used in presentation)

All use cases have unit tests, using JUnit and Mockito.

### Presentation

In this module, is where the app is initialized. The dependency injector is initialized too, and is provided to the activity. 

For the presentation part, I used the MPV pattern. Easy to use and test. The view only have one method, which is render. The render function gets the view state and this function know how to render each state. Each view state is unique. With this strategy, the ui test is really easy, because I only have to test each view state. I added android test to the activity and you can see how it's done. I should test the button press but I haven't had enough time to add it.

In the presenter, I used the coroutines. As you can see, is a very simple usage. I think I can improve te usage of coroutines a lot (especially the image downloading). The main think to improve is the images downloading by download each image in parallel and asynchronously (to make the scroll smother because right now the scroll is lagging). Right know the image downloading lag the app. I think it's because they are blocking the thread or something and with more time is has to be improved downloading the images in paralel and async. Another think to improve is the UI/UX, for example executing the search when the user write (every time user adds a letter in the search, execute the search and cancel the previous search). Being honest, I know the basics of coroutins and instead of that I would use RxJava (because right now is more mature and I know more about it). On the other hand, I used coroutines instead other tools (creating Threads, Runnable, AsyncTask) because I think is easier and is the future, but I need more time to understand better who it works and how to implement it well.

I don't had enough time to do the presenter test (because test coroutines is a bit difficult), but it must be in production.

## Other

### Libraries

As you can see, I used the gradle kts to create a Libs kotlin file, and have the libraries in the same kotlin file (centralized). With this, I can autocomplete the libraries in the gradle of each module, what is very useful.

### Android Gradle Centralization

Another topic is that the common logic gradle of each module (except the app module, because is the module that initialize the app and which is installed in the mobile) is centralized in a android-build gradle file. It is very useful when the app scales and there is a lot of modules.

For more questions, please send me an e-mail to gerard.serrano.ginebra@gmail.com