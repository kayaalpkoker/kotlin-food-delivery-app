# Food Delivery App

This project represents an increment of a Food Delivery application written in Kotlin for Android.

## Features

- List and view details of meals
- Add meals to the cart
- View cart and checkout

<img src="https://github.com/kayaalpkoker/kotlin-food-delivery-app/blob/main/demo.gif" width="300">

## Libraries and Technologies Used

- **AndroidX Libraries**: Used for backwards compatibility and additional functionalities
- **Retrofit**: Used for handling network requests
- **Dagger-Hilt**: Used for dependency injection
- **Glide**: Used for image loading
- **Navigation Component**: Used for implementing navigation between different screens
- **ViewBinding**: Used to more easily interact with Views
- **DataBinding**: Allows to bind UI components in layouts to data sources in app using a declarative format
- **LiveData**: Lifecycle-aware observables for managing data in a lifecycle conscious way
- **Navigation Safe Args Plugin**: Used for passing data between destinations in a type-safe way

## Project Structure

The application follows a structured MVVM (Model-View-ViewModel) architecture with separation of concerns principle for better readability and maintenance. The project structure is as follows:

- `data`: This package contains data handling classes including data sources and repositories.
- `di`: Contains classes related to dependency injection using Dagger-Hilt.
- `retrofit`: This package includes the networking setup and interfaces using Retrofit.
- `ui`: This package holds all user interface related classes such as adapters, fragments and view models.
- `utils`: Contains utility classes used throughout the application.

## Setup

The application is developed using Android Studio. To setup this project locally, you need to:

1. Clone the repository: `git clone https://github.com/kayaalpkoker/kotlin-food-delivery-app.git`
2. Open the project in Android Studio.
3. Sync the Gradle files and run the build.
