# This is a configuration file for R8, the new code shrinker from Google.
# https://r8.googlesource.com/r8

# If you want to enable compression in release builds,
# you should add this boilerplate to your proguard-rules.pro file.

# Hilt rules
-keep class dagger.hilt.** { *; }
-keep interface dagger.hilt.** { *; }

# Room rules
-keep class androidx.room.** { *; }
-keep interface androidx.room.** { *; }

# Keep your app's model classes
-keep class com.tonidev.detoxfocus.data.local.** { *; }
-keep class com.tonidev.detoxfocus.data.** { *; }