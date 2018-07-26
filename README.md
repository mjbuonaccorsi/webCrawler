# Simple WebCrawler Simulator
Sample WebCrawler using json file as simulated Internet

# Run the Spring Boot Application
Default application uses the internet.JSON included under resources.
To build and run the app use:
mvn package && java -jar target/WebCrawler-0.0.1-SNAPSHOT.jar

To override the default json file with the alternate json file run:

java -jar target/WebCrawler-0.0.1-SNAPSHOT.jar --internet.json=internet2.json

# Executing the crawler
Hitting the default server (localhost:8080) from either Postman or a Browser
will return a JSON string containing the results as well as print the results 
to standard out.

# ToDo
Add Test cases
Create default implementation for Internet interface that truly access the web.
Move JSON implementations to testing side and create more sample data.
