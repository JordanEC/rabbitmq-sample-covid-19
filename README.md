#Sample covid-19 updates broadcaster

Simple broadcaster of updates of covid-19 stats by country/continent using RabbitMq and Spring AMQP. 
There are 2 spring boot applications, the sender broadcasts updates and there could be N number of consumers
subscribed to those updates based on the continent or country that are listening.

In the sender application, there's a controller to publish updates.
Set country (Alpha-3) and continent (Alpha-2) names using these codes: https://www.iban.com/country-codes and https://datahub.io/core/continent-codes/r/0.html

[POST] http://localhost:8080/samplecovid19/update/create
Body: 
{
    "continent": "CR",
    "countryName": "CRI",
    "cases": 435,
    "deaths": 2,
    "recovered": 13
}

Updates will be printed on receivers console

#How to run

+ Run docker dependencies: docker-compose up -d
+ Run the sender application: ./gradlew sender:bootrun
+ Run receivers setting different ports, continents and countries parameters:<br/>
    Listen updates of Central America <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8081,--topic.continent=CA
    
    Listen updates of Costa Rica <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8082,--topic.continent=CA,--topic.country=CRC
    
    Listen updates of North America <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8083,--topic.continent=NA
    
    Listen updates of United States <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8084,--topic.continent=NA,--topic.country=USA
    
    Listen updates of South America <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8085,--topic.continent=SA
    
    Listen updates of Brazil <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8086,--topic.continent=SA,--topic.country=BRA
    
    Listen updates of Europe <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8087,--topic.continent=EU
    
    Listen updates of Germany <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8088,--topic.continent=EU,--topic.country=DEU
    
    Listen updates of Italy <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8089,--topic.continent=EU,--topic.country=ITA
    
    Listen updates of Spain <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8090,--topic.continent=EU,--topic.country=ESP
    
    Listen updates of Asia <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8091,--topic.continent=AS
    
    Listen updates of China <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8092,--topic.continent=AS,--topic.country=CHN
    
    Listen updates of South Korea <br/>
    ./gradlew receiver:bootrun -Pargs=--server.port=8093,--topic.continent=AS,--topic.country=KOR