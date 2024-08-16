
<p align="center">
<img src="https://maven.handsomesteve.net/data/images/banners/handsomesteves-colorful-logger-banner.png" alt="Handsome Steve's Colorful Logger">
</p>

[ko-fi]:https://ko-fi.com/handsomesteve
[modrinth]:https://modrinth.com/mod/colorfulloggerlib

<br><br>

[<img src="https://maven.handsomesteve.net/data/images/buttons/github-buttons-kofi-trans.png?v15-08-2024" width="175em" />][ko-fi]
[<img src="https://maven.handsomesteve.net/data/images/buttons/github-buttons-modrinth-trans.png?v15-08-2024" width="175em" style=""/>][modrinth]

<br><br>
<br>
<br>

#### Ever wanted to add some color to your LOGGER during the development of your minecraft mods in a simple, yet functional manner?<br>
Well look no further, Handsome Steve has you covered! This simple library allows you to do just that by utilizing a wide range of pre-defined ANSI codes.<br>

**EDIT: Please prioritize the [Handsome Steve Maven](https://maven.handsomesteve.net/) as this also serves the Jar's Sources file.** Alternatively, the installation code below has been updated to reflect [Modrinth Maven](https://support.modrinth.com/en/articles/8801191-modrinth-maven) in case the maven is ever offline, apologies in for any inconveniences.
<br><br>
## FAQ
**Q: Is this a mod?**
<br>Techinally, no. This is a library, so it's only really used when developing a mod, however, it may be required as a dependency when the dependent mod is being installed on a client/server depending on what platform the dependent mod is targeting and how the mod developer is utilising the library.
<br><br>
**Q: Can I use this library as a dependency in my project?**
<br> Absolutely, go nuts!
<br><br>
**Q: Does this library require a specific Fabric Version?**
<br> Nope, it's now standalone, so as long as your modding platform uses `org.slf4j.Logger`, it will work regardless of the version.
<br><br>

## Current Version
Please note that the current version only has the `Logger.info()` method colorized, the rest will be added in future updates, such as `Logger.error()` etc.
<br><br>

## Installation
Add the required Maven Repositories to your `build.gradle` in the *repositories* section:
```groovy
    repositories {
        // Initial Maven Repository
        // Priority
        exclusiveContent {
            forRepository {
                maven {
                    name = "Handsome Steve's Maven"
                    url = "https://maven.handsomesteve.net/releases"
                }
            }
            filter {
                includeGroup "net.handsomesteve"
            }
        }
        
        // Modrinth Fallback Maven
        // Optional, but strongly recommended
        exclusiveContent {
            forRepository {
                maven {
                    name = "Modrinth"
                    url = "https://api.modrinth.com/maven"
                }
            }
            filter {
                includeGroup "maven.modrinth"
            }
        }
    }
```
<br>

Add an implementation to your `build.gradle` in the dependencies section:
```groovy
    dependencies {
        //Handsome Steve's Colorful Logger // This automatically downloads the sources file as well.
        implementation include("net.handsomesteve:colorfulloggerlib:${project.hs_colorful_logger}")
        
        // Modrinth Fallback (De-comment if preferred maven is down).
        //implementation include ("maven.modrinth:colorfulloggerlib:${project.hs_colorful_logger}")
        // SOURCES FILE NEEDS MANUAL DOWNLOAD, SEE BOTTOM OF PAGE (if using fallback maven).
    }
```
> [**SEE:** Fabric - Dependency Configuration](https://fabricmc.net/wiki/documentation:fabric_loom#options)<br>
> [**SEE:** Modrinth - Dependency configuration](https://support.modrinth.com/en/articles/8801191-modrinth-maven#h_2484bbd424)

<br>Add the version variable to your `gradle.properties` and replace `{version}` by the desired available library version of your choice:
```groovy
    hs_colorful_logger={version}
```

## Implementation
Create a `public static final` instance of the `ColorfulLogger` class. This instance will allow you to utilize the internal reference of `org.slf4j.Logger` from the `ColorfulLogger` class throughout your project.

```java
    import net.handsomesteve.api.ColorfulLogger;
    import net.handsomesteve.api.ansi.AnsiColorBackground;
    import net.handsomesteve.api.ansi.AnsiColorText;
    
    public class FabricMod implements ModInitializer {
        public static final String MOD_ID = "your-mod-id";
        public static final ColorfulLogger LOGGER = ColorfulLogger.getInstance("your-mod-id", false);
 
       @Override
       public void onInitialize() {
           LOGGER.info(">>> This is a plain message without any colouring");
           LOGGER.info(">>> I want some green text", AnsiColorText.ANSI_BRIGHT_GREEN);
           LOGGER.info(">>> I want some red text with a black background", AnsiColorText.ANSI_BRIGHT_RED, AnsiColorBackground.ANSI_BLACK_BACK);
       }
    }
```
> **NOTE:** `ColorfulLogger` can be declared anywhere in the project. It is recommended, however, ***to only ever declare this once***. To import the declared variable as a *static import* when referencing the instantiated instance:
> ```java
> import static com.packagename.FabricMod.LOGGER;
> ```
> **ALTERNATIVELY:** `ColorfulLogger` can be instanced anywhere in the project and declared as follows if required:
> ```java
> public class References {
>       private static final ColorfulLogger LOGGER = ColorfulLogger.getInstance();
>       public static ColorfulLogger getLogger() {
>           return LOGGER;
>       }
> }
> ```
> Then accessed:
> ```java
> import static com.package.References.getLogger;
> 
> public class MyClass {
>       References.getLogger();
> }
> ```

<p>If required, the `Logger` can be interfaced with by calling it as follows:</p>

```java
    LOGGER.getLogger(); // Returns the Logger to be interfaced with.
```

<p>This will, however, not implement the ANSI color coding to your output if accessed this way.</p>

<br>

## Sources
### [Only if using Modrinth Maven as a dependency]
*<p>There is a sources file available in the versions download.</p>*
<p>This is a well define sources file where all variables, methods and constructors are well-defined as well as the class itself.
You should download and add this file in the folder path:</p>

```
.gradle/loom-cache/remapped_mods/net_fabricmc_yarn{version}/maven/colorfulloggerlib/{hs_colorful_logger_version}/
```
> **Note:** Replace curly-braced text with current versions etc.