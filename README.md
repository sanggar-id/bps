Notes
1. Do not create a feature under app module
2. Use app module as a bridge between feature modules
3. "com.android.application" mandatory for build android app
4. "com.android.library" for multi modules
5. at least the feature module contain a single activity even though
   we have a lot of fragments inside.
6. For the applink, we have to standarized the scheme & host.
   scheme -> bps-app://
   :features:home -> bps-app://home
   :features:splash-screen -> bps-app://splash-screen
7. If we have a few fragments in the feature module, how to navigate into a specific fragment?
   :features:news
   NewsActivity -> Tab 1 (Directory), Tab 2 (Favorites)
   
   Path:
   bps-app://news/directories
   bps-app://news/favorites

   Query:
   bps-app://news?tab=directories
   bps-app://news?tab=favorites

Step to module deletion
1. Unload module in settings.gradle
2. Delete the dependencies in app/build.gradle (if any)
3. Sync Now
4. Simply right-click the module -> Delete

Steps to create module
1. Create directory -> features
2. Create module -> Android library -> module name:
   :features:nama-module
3. Make sure the feature module already registered in settings.gradle
4. Add the feature module as a part of app module by:
   implementation(project(":features:nama-module"))
5. For a special case (such as: the activity launcher), we have to remove
   the manifest from their own feature module's manifest for that activity,
   thus, we are able to define the activity inside the app module's manifest.

   feature module's manifest:
   <manifest/>

   app module's manifest:
   <activity
       android:name="com.isfa.splash.SplashScreenActivity"
       android:exported="true">
       <intent-filter>
           <action android:name="android.intent.action.MAIN"/>
           <category android:name="android.intent.category.LAUNCHER"/>
       </intent-filter>
   </activity>
6. Create the applink
   <intent-filter>
       <action android:name="android.intent.action.VIEW"/>
       <category android:name="android.intent.category.BROWSABLE"/>
       <category android:name="android.intent.category.DEFAULT"/>
       <data
           android:scheme="bps-app"
           android:host="home"/>
   </intent-filter>
7. To navigate the feature module from another module, do like this:
   val applink = "sample-schema://host"
   val intent = Intent(Intent.ACTION_VIEW, Uri.parse(applink))
   startActivity(intent)


Step to manage the similar dependencies
1. Create the toml file for dependencies management
2. Enable the toml file in settings.gradle.kts
   versionCatalogs {
      create("libs") {
         from(files("libs.dependencies.toml"))
      }
   }
3. How to define the dependencies:
   [versions]
   variable-name-ver = "1.2.3"

   [libraries]
   variable-name = { module = "sample.test:test", version.ref = "variable-name-ver" }
4. How to call it ?
   implementation(libs.variable.name)


Architecture Components
1. We have to differentiate between mutable and immutable
   a. Mutable -> read-write (for data changes inside ViewModel)
   b. Immutable -> read-only (for consuming outside ViewModel, e.g. Activity)
2. 