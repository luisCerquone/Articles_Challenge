# Articles_Challenge

An App made in multiplatform Kotlin, where the business logic is made in Kotlin, the Android UI in
Jetpack Compose and the iOS UI in SwiftUI.

The App has two main functionalities, showing a list of news with its details and showing a list of
users in which each user is shown on the Google map.

## Architecture

The project is made in MVVM with the following scheme:

- The Layers of MVVM with Clean Architecture.

- The code is divided into three separate layers:

- Presentation Layer
- Domain Layer
- Data Layer

https://assets.toptal.io/images?url=https%3A%2F%2Fuploads.toptal.io%2Fblog%2Fimage%2F127608%2Ftoptal-blog-image-1543413671794-80993a19fea97477524763c908b50a7a.png

## External libraries

- KTOR: This library is responsible for calls to APIs. https://ktor.io/
- KOIN: It takes care of dependency injections throughout the project. https://insert-koin.io/
- COIL: Handles the download of images asynchronously. https://github.com/coil-kt/coil
- SQLDELIGHT: Handles SQL calls or requests made to the internal database of the app or
  device. https://github.com/cashapp/sqldelight

## External APIs

- https://www.jsonplaceholder.org/ was used to call the endpoint to users.
- https://newsapi.org/ was used for the endpoint call to the news. I preferred to use this one since
  I wanted to test some knowledge, it is only used for developer purposes.

## Why Kotlin multiplatform?

Kotlin multiplatform is backward compatible with old android versions or legacy projects, you can
run a project that is already made in compose or xml and migrate it little by little to kmp.

One of the bets is that the business logic and presentation will be shared with a single language,
for the different business areas.

With which you only have to develop the views natively, Compose for Android and SwiftUI for iOS.
