# apartment-building-app
- git clone https://github.com/sagbhu/apartment-building-app
- use java -version 1.8 for both compiler-source and compiler-target.
- use maven -version 3.9.2.
- use tomcat server version 9.0.98.
- go to project properties-> project facets-> select tomcat in runtime.
- build the project using : mvn clean install.
- to run project : Run On Server.
# docker image run
- docker build -t apartment-building-app .
- docker run -p 8080:8080 apartment-building-app
- http://localhost:8080/
