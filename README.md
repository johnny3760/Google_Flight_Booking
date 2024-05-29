# Google Flight Booking Tests
This repo employs Serenity BDD to perform automation tests on the Google Flight Booking system. <br />
Successful completion of these tests demonstrate that the system is working as expected in all critical areas.

## How do I get set up? ##

### Pre-requisites ###

* Google Chrome installed
* Java 8 (Min) or higher installed. Recommended Java 11 or higher
* Maven 3.1.2 or higher installed

### Configuration ###

* Check the configuration and credentials within the `config.properties` file
* Ensure the installed java version (`java -version` in command line) matches the source & target version
  in `pom.xml`
```javascript
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <source>11</source>    <--- Change to match java version
                    <target>11</target>    <--- Change to match java version
                </configuration>
            </plugin>
```
* Check the environment configuration within the `serenity.conf` file. See below for more details
* Serenity uses WebDriverManager to automatically download the WebDriver binaries at execution. <br />
  However, if explicitly required, they should be manually downloaded, placed in the project, and their path specified
  within the `serenity.conf` file

  **Note:** If the WebDriverManager is using the wrong ChromeDriver version, delete the existing 'selenium' folder
  within `C:\Users\<user>\.cache\`. WebDriverManager should then download and use the correct ChromeDriver version.

## Executing the tests ##

To run the project, you can either just run the `TestRunner` test runner class, or run the following in command line

```bash
$ mvn clean verify
```

By default, the tests will run using Chrome. You can run them in another browser by amending the `serenity.conf` file,
then by overriding the `driver` system property, e.g.

```bash
$ mvn clean verify -Ddriver=firefox
```

## Environment-specific configurations ##

We can also configure environment-specific properties and options, so that the tests can be run in different
environments. Here are 3 example environments, __dev__, __staging__ and __prod__, with different starting URLs for each:

```javasript
environments {
    default {
        webdriver.base.url = "https://duckduckgo.com"
    }
    dev {
      webdriver.base.url = "https://duckduckgo.com/dev"
    }
    staging {
      webdriver.base.url = "https://duckduckgo.com/staging"
    }
    prod {
      webdriver.base.url = "https://duckduckgo.com/prod"
    }
}
```

Alternatively, if you require different URLs for each environment, an example config would be:

```javasript
environments {
    default {
        duckduck.url = "https://duckduckgo.com"
        google.url = "https://google.com"
    }
    dev {
        duckduck.url = "https://duckduckgo.com/dev"
        google.url = "https://google.com/dev"
    }
}

Note: the @DefaultUrl("page:google.url")
```

If using the above setup, the specific pages that are called to `.open()` must be annotated accordingly. Eg,
`@DefaultUrl("page:duckduck.url")` on one class/page  
`@DefaultUrl("page:google.url")` on another class/page

You use the `environment` system property to determine which environment to run against. For example to run the tests in
the staging environment, you could run:

```bash
$ mvn clean verify -Denvironment=staging
```

See [__this article__](https://johnfergusonsmart.com/environment-specific-configuration-in-serenity-bdd/) for more
details about this feature.

## Generating the reports ##

Since the Serenity reports contain aggregate information about all the tests, they are not generated after each
individual test (as this would be extremely inefficient). <br />
After executing the tests using one of the above methods, the results will be recorded in the `target/site/serenity`
directory.<br /><br />
To view these results, look for the index.html file in this directory and open it in any browser.

## Want to learn more about Serenity BDD? ##

* [__Serenity BDD User Guide__](https://serenity-bdd.github.io/docs/guide/user_guide_intro) - the official online
  Serenity documentation source
* [__Serenity BDD GitHub__](https://github.com/serenity-bdd) - includes starter and example projects
* [__Serenity BDD Blog__](https://serenity-bdd.github.io/blog) - regular articles about Serenity BDD
