/**
 * Module path constants for the multi-module Android project.
 * This object provides centralized module references for Gradle dependency declarations,
 * following clean architecture principles with separated layers.
 */
object BuildModules {

    //:core
    /** Core module containing shared utilities and base classes */
    const val CORE = ":core"
    
    /** Core Android module with Android-specific shared components */
    const val CORE_ANDROID = ":core-android"

    //data
    /** Artist data layer module handling data operations and repository implementations */
    const val DATA = ":artist-data"
    
    /** Artist data source module containing remote API and data source implementations */
    const val DATA_SOURCE = ":artist-datasource"

    //domain
    /** Artist domain layer module containing business logic and use cases */
    const val DOMAIN = ":artist-domain"


    //presentation
    /** Artist presentation layer module containing ViewModels and presentation logic */
    const val PRESENTATION = ":artist-presentation"

    //artist
    /** Artist UI module containing fragments, composables, and UI components */
    const val ARTIST = ":artist-ui"

    //:APP
    /** Main app module that integrates all feature modules */
    const val APP = ":app"


}