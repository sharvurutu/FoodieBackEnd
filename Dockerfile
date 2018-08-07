FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=restuarantdb
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/restuarantdb
ADD ./target/Server-0.0.1-SNAPSHOT.jar /usr/src/Server-0.0.1-SNAPSHOT.jar
#EXPOSE 9002
ENTRYPOINT ["java", "-jar", "/usr/src/Server-0.0.1-SNAPSHOT.jar"]
