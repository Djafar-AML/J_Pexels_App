## Project Name: J Pexels App

**Description:**
  
  Pexels Photo App is an innovative application that allows users to browse and explore
  stunning images from the Pexels.com API. 
  It utilizes pagination, Room database, and a clean architecture approach to provide a
  seamless and reliable user experience, even when the device is offline.
  


**Key Features:**
  - ###### Image Retrieval:
    
    Retrieves images from the Pexels.com API using pagination to ensure efficient data loading and scrolling.
    
  - ###### Offline Support:

    Leverages Room database to cache images and data, enabling users to access content even without an internet connection.

  - ###### Clean Architecture:

    Adopts a clean architecture approach with separate presentation, domain, and data layers for improved maintainability and scalability.

  - ###### Dependency Injection:

    Utilizes Hilt Dagger for dependency injection, simplifying object creation and reducing boilerplate code.
    
  - ###### Network Resiliency:

    Implements a retry mechanism to handle network connectivity issues and ensure data delivery.
    
  - ###### Detail Screen:

    Provides a dedicated screen to display detailed information about a selected image.
    
  - ###### Reactive Programming:

    Employs the Flow API to deliver data to the UI layer reactively, enhancing performance and responsiveness.
    
  - ###### Unit Testing:

    Includes unit test cases for key classes, ensuring code quality and stability.
    
  - ###### Modern Android Development:

    Embraces best practices and cutting-edge technologies for Android development.
    
  - ###### Networking:

    Utilizes Retrofit for efficient and robust network communication with the Pexels.com API.
    
  - ###### Continuous Integration and Delivery:

    Employs GitHub Actions for CI/CD, automatically running lint checks, unit tests, and building a debug APK upon code changes.

**Getting Started:**
  - ###### Prerequisites:

    Android Studio Arctic Fox or higher

    Pexels API key (obtainable from https://www.pexels.com/ )
    
- ###### Installation:

  Clone the repository or download the source code.

  Open the project in Android Studio.

  Update the BuildConfig class with your Pexels API key.

- ###### Usage:
  Build and run the app on an Android device or emulator.

  Browse through the list of images and tap on an image to view its details.

  Enjoy the seamless experience even when offline!

- ###### Contributing:
  Contributions are welcome! Please read the CONTRIBUTING.md file for details.

- ###### License:

  This project is licensed under the Apache License 2.0.

- ###### Contact:

  For any questions or inquiries, please contact [jafar.agha.77@gmail.com] .
