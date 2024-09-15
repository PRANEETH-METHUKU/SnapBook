
# SnapBook

SnapBook is an Android app built with Jetpack Compose that allows users to upload and view posts in real-time. This project uses Firebase Firestore for storing posts and Firebase Storage for media handling.

## Features
- View posts sorted by the latest on top
- Upload new posts with text content
- Real-time updates with Firebase Firestore

## Prerequisites
- Android Studio
- A Firebase account
- Basic knowledge of Jetpack Compose and Firebase

## Setup and Installation

### 1. Clone the Repository
```bash
git clone https://github.com/PRANEETH-METHUKU/SnapBook.git
cd SnapBook
```

### 2. Open the Project in Android Studio
- Open Android Studio.
- Select **File > Open** and choose the project directory you cloned.

### 3. Set Up Firebase
To use Firebase in this project, follow these steps:

#### a. Create a Firebase Project
- Go to the [Firebase Console](https://console.firebase.google.com/).
- Click **"Add project"** and follow the steps to create a new Firebase project.

#### b. Register Your App with Firebase
- In the Firebase Console, click on **"Add app"** and select the Android icon.
- Enter your app's package name (found in `app/build.gradle.kts`).
- Download the `google-services.json` file provided by Firebase.

#### c. Add `google-services.json` to Your Project
- Copy the `google-services.json` file you downloaded.
- Paste it into the `app` directory of your Android project.

#### d. Add Firebase SDK to the Project
- Firebase SDKs are already included in the project dependencies in the `build.gradle.kts` files:
    ```kotlin
    // app/build.gradle.kts
    plugins {
        id("com.android.application")
        kotlin("android")
        id("com.google.gms.google-services") // Apply Google services plugin
    }

    dependencies {
        implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
        implementation("com.google.firebase:firebase-firestore-ktx")
        implementation("com.google.firebase:firebase-storage-ktx")
    }
    ```

- Make sure the following is also included in your project-level `build.gradle.kts` file:
    ```kotlin
    // build.gradle.kts
    buildscript {
        dependencies {
            classpath("com.google.gms:google-services:4.3.15") // Make sure this is the correct version
        }
    }
    ```

#### e. Sync the Project
- Sync the project with Gradle files by clicking **"Sync Now"** in the notification bar in Android Studio.

### 4. Run the App
- Connect an Android device or start an emulator.
- Click **Run > Run 'app'** or press `Shift + F10`.

### 5. Usage
- The app will start with a list of posts fetched from Firebase.
- Use the floating action button (FAB) to navigate to the screen for uploading a new post.
- Add content and submit to see the post appear in the list.

## Troubleshooting
- **Firebase Initialization Error**: If you encounter an error saying "Default FirebaseApp is not initialized," ensure that:
  - The `google-services.json` file is placed in the correct directory (`app` folder).
  - The Firebase project configuration matches your app's package name.
  - The `google-services` plugin is applied in your `build.gradle.kts` files.
  
## Contribution
Contributions are welcome! Please fork the repository and submit a pull request for any bug fixes or enhancements.


# Release Notes

This is initial version where user can upload only text based posts and only view option



