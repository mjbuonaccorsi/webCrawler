# webCrawler
Sample WebCrawler using json file as simulated Internet

Default application uses the internet.JSON included under resources.
To build and run the app use:
mvn package && java -jar target/WebCrawler-0.0.1-SNAPSHOT.jar

To override the default json file with the alternate json file run:

java -jar target/WebCrawler-0.0.1-SNAPSHOT.jar --internet.json=internet2.json

