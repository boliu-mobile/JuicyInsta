# JuicyInsta#

This repository holds the source code of the JuicyInsta, a simple Android client for the Instagram API.
This application was created as an assignment by Farhad Faghihi, as part of the technical assessment by the [Cafe Bazaar](http://cafebazaar.ir) development team.

### What is this repository for? ###

* JuicyInsta Android Application
* v1.0
* Last Update : Sun Feb 7, 2016 07:17a.m

### Development Tools ###

* Android Studio v1.5.1
* gradle-plugin v1.5.0
* Android SDK Build Tools 23.0.2
* CompileSDKVersion 23

### Dependencies ###
* AppCompat-v7-23.1.1
* SupportDesign v23.1.1
* Android Support RecyclerView-v7-23.1.1
* Android Support CardView-v7-23.1.1
* Retrofit v2.0.0-beta1
* Okhttp v2.4.0
* Retrofit converter-gson v2.0.0-beta1
* Butterknife v7.0.1
* Picasso v2.5.2
* EventBus v3.0.0

### Important Notes ###

The application has two main Activities
** AuthActivity**,
** ProfileActivity**

The former, is responsible for authentication and authorization of the JuicyInsta application by the user, using the instagram OAuth 2.0 [implicit flow](https://www.instagram.com/developer/authentication/) for serverless applications.

The latter shows the basic profile information of the user, in addition to the most recent media posted by her.

Since the applications that interact with Instagram API, are first authorized in [SandBox ](https://www.instagram.com/developer/sandbox/)mode, they will only receive the last twenty media, including photos and videos, from the Instagram data provider.

### Application Structure ###
The activities are implemented and structured bases on the MVP, mostly compilant to the version implemented and contributed by the [Antonio Leiva](http://antonioleiva.com/mvp-android/).

The networking is all managed by [Retrofit ](http://square.github.io/retrofit/)and OkHttp as its httpclient, developed and contributed by the [Square](http://square.github.io).

The settings of the application is persisted using AppSetting, a wrapper for Android SharedPreferences, which takes advantages of HashMaps for faster save and retrieval, developed by Farhad Faghihi.