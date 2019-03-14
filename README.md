# Android VIPER Boilerplate
Source code to start an Android application in VIPER clean architecture. The source code contains different layers of VIPER architecture which is demonstrated through movie app.

# Code Structure
There are four packages:
1. **data -** The package contains data stores i.e. `MoviesDataStore` which is implemented by `RemoteMoviesDataStore` and `LocalMoviesDataStore`. These data stores provide movies data to `MovieRepository` which provides movies data to domain layer. 
2. **domain -** This is the core logical layer in which main part is interactors(also called use cases). `GetPopularMovies` is the interactor which gets data from `MovieRepository` and provide it to presentation layer.
3. **presentation -** It contains `MoviesPresenter` and `MoviesView`. `MoviesListActivity` implements `MoviesView`. `MoviesPresenter` gets movies list from `GetPopularMovies` interactor. `MoviesRounter` handles navigations from movies list.
4. **common -** It contains common base classes and constants.

## Technologies
1. RxAndroid
2. Retrofit
3. Dagger2
