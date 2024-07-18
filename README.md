# Handsome Steve's Colorful Logger

#### Ever wanted to add some color to your LOGGER during the development of your minecraft mods in a simple, yet functional manner?<br>
Well look no further, Handsome Steve has you covered! This simple library allows you to do just that by utilizing a wide range of pre-defined ANSI codes.<br>

## Installation
Add the Modrinth Maven Repository to your `build.gradle` in the repositories section:
```groovy
    repositories {
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
    api "maven.modrinth:colorfulloggerlib:${project.handsomesteves_colorful_logger}"
    // SOURCES FILE NEEDS MANUAL DOWNLOAD, SEE BOTTOM OF PAGE
    //api "maven.modrinth:colorfulloggerlib:${project.handsomesteves_colorful_logger}:sources"
    
    // Embed the API into your mod so users do not have to manually download it here.
    include "maven.modrinth:colorfulloggerlib:${project.handsomesteves_colorful_logger}"
}
```
<br>

Add the version variable to your `gradle.properties` and replace the version by the desired available library version of your choice:
```groovy
    handsomesteves_colorful_logger=1.0.1
```

## Implementation
Create a `public static final` instance of the `ColorfulLogger` class. This instance will allow you to utilize the internal reference of `org.slf4j.Logger` from the `ColorfulLogger` class throughout your project.

```java
    import com.handsomesteve.api.ColorfulLogger;
    import com.handsomesteve.api.ansi.AnsiColorBackground;
    import com.handsomesteve.api.ansi.AnsiColorText;
    
    public class FabricMod implements ModInitializer {
        public static final String MOD_ID = "your-mod-id";
        public static final ColorfulLogger LOGGER = new ColorfulLogger("your-mod-id", false);
 
       @Override
       public void onInitialize() {
           LOGGER.info(">>> This is a plain message without any colouring");
           LOGGER.info(">>> I want some green text", AnsiColorText.ANSI_BRIGHT_GREEN);
           LOGGER.info(">>> I want some red text with a black background", AnsiColorText.ANSI_BRIGHT_RED, AnsiColorBackground.ANSI_BLACK_BACK);
       }
    }
```
> **NOTE:** `ColorfulLogger` can be declared anywhere in the project. It is recommended, however, to import the declared variable as a *static import* when referencing the instantiated instance:
>> ```java
>> import static com.packagename.FabricMod.LOGGER;
>> ```

If required, the `Logger` can be interfaced with by calling it as follows:
```java
    LOGGER.getLogger(); // Returns the Logger to be interfaced with.
```
This will, however, not implement the ANSI color coding to your output if accessed this way.<br>

## Sources
***While I try and figure out how to get Modrinth to add the sources file to their Maven, there is a sources file available in the versions download.***<br>
This is a well define sources file where all variables, methods and constructors are well-defined as well as the class itself.
You should download and add this file in the folder path:
```
.gradle/loom-cache/remapped_mods/net_fabricmc_yarn{version}/maven/ccolorfulloggerlib/1.0.0+1.21/
```