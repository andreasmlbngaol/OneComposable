
# OneComposable Library

OneComposable is a Jetpack Compose library that provides ready-to-use Composable functions for various screen types, such as Authentication and layouts with Top and Bottom bars. This library is designed to help you accelerate your app development by providing reusable components.

## Requirements

- **compileSdk**: 35 or higher
- **Jetpack Compose**
- **Hilt** for Dependency Injection
- **Firebase Authentication**

## Getting Started

### Project Setup

#### 1. Update `settings.gradle.kts`

Add the following to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

#### 2. Update `build.gradle.kts` in the app module

In your `app/build.gradle.kts`, add:

```kotlin
android {
    namespace = "your.app.namespace"
    compileSdk = 35 // Minimum is 35
}

dependencies {
    // Other dependencies
    implementation("com.github.andreasmlbngaol:OneComposable:1.0.8")
}
```

Check the [releases](https://github.com/andreasmlbngaol/OneComposable/releases) for the latest version.

### Firebase and Hilt Setup

1. **Update `build.gradle.kts` in the root project**

Add the following plugins:

```kotlin
plugins {
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}
```

2. **Update `build.gradle.kts` in the app module**

In your `app/build.gradle.kts`, add:

```kotlin
plugins {
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

dependencies {
    // Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Firebase
    implementation("com.google.firebase:firebase-auth:23.1.0")
}

kapt {
    correctErrorTypes = true
}
```

3. **Add Firebase Configuration**

- Connect your app to Firebase.
- Add your app's SHA-1 fingerprint in the Firebase console.
- Download the `google-services.json` file and place it in the `/app` folder.

4. **Update `AndroidManifest.xml`**

```xml
<application
    android:name=".OneApp">
</application>
```

### Create `OneApp.kt`

Create a file named `OneApp.kt` and add the following code:

```kotlin
import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.mightysana.onecomposable.composable.auth.AccountService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@HiltAndroidApp
class OneApp : Application()

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideAccountService(auth: FirebaseAuth): AccountService = FirebaseAccountService(auth)
}

class FirebaseAccountService @Inject constructor(
    private val auth: FirebaseAuth
) : AccountService {
    override val currentUser: FirebaseUser? get() = auth.currentUser
    override suspend fun reloadUser() {
        auth.currentUser?.reload()
    }

    override suspend fun isEmailVerified(): Boolean {
        return auth.currentUser?.isEmailVerified == true
    }

    override suspend fun signInWithGoogle(idToken: String) {
        val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(firebaseCredential)
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun signOut() {
        auth.signOut()
    }
}
```

### Modify `MainActivity.kt`

Add the following code to your `MainActivity.kt`:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mightysana.onecomposable.composable.auth.AccountService
import com.mightysana.onecomposable.composable.auth.AuthCheck
import com.mightysana.onecomposable.model.SIGN_IN
import com.mightysana.onecomposable.model.authGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var accountService: AccountService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainRoute = "Main" // Your app's main route

            val navController = rememberNavController()
            var navStart: String? by remember { mutableStateOf(null) }
            var authStart by remember { mutableStateOf(SIGN_IN) }

            AuthCheck(mainRoute, accountService) { nav, auth ->
                navStart = nav
                authStart = auth
            }

            navStart?.let { startRoute ->
                NavHost(
                    navController = navController,
                    startDestination = startRoute
                ) {
                    authGraph(
                        navController = navController,
                        startDestination = authStart,
                        mainRoute = mainRoute,
                        defaultWebClientId = "YOUR_WEB_CLIENT_ID" // replace with your client ID
                    )

                    composable(mainRoute) {
                        // Your Main Screen content
                    }
                }
            }
        }
    }
}
```

### Notes

- Make sure to replace `"YOUR_WEB_CLIENT_ID"` with your actual web client ID from Firebase Authentication.
- Check the [releases](https://github.com/andreasmlbngaol/OneComposable/releases) for the latest version.
