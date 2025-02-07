# Use Maven 3.9.2 with Java 8 to build the project
FROM maven:3.9.2-eclipse-temurin-8 AS builder

# Set working directory
WORKDIR /main

# Clone the repository
RUN git clone https://github.com/sagbhu/apartment-building-app.git .

# Build the WAR file using Maven
RUN mvn clean package -DskipTests

# Debugging step: Check if the WAR file exists
RUN ls -l /main/target/

# Use Tomcat 9.0.98 as the runtime environment
FROM tomcat:9.0.98-jdk8-temurin

# Set Tomcat webapps directory
WORKDIR /usr/local/tomcat/webapps/

# Copy the generated WAR file into Tomcat
COPY --from=builder /main/target/*.war ./ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
