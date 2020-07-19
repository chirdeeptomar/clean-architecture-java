# Hexagonal Architecture
Sample project for hexagonal architecture in Java

Technologies Used: 
1) Java 11+
2) Spring Boot
3) Spring Data JPA
4) Lombok

Setup: 
1) Run data.sql to load data into party table

How to run: 
1) Run ./gradlew trade-driver-adapter:clean build
2) java -jar trade-driver-adapter/build/libs/trade-driver-adapter-0.0.1-SNAPSHOT.jar

##### Sample Request: 

###### POST REQUEST

`curl -X POST \
  http://localhost:8081/v1/api/trades \
  -H 'Accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
	"quantity": 100,
	"currencyCode": "JPY",
	"stock": "GOOG",
	"buyer": "c1a8b9bc-36c0-4a4f-8323-ec71f92b8d21",
	"seller": "126a4cbf-dc40-4bfe-bbfe-d547b63d6cd4",
	"rate": 150.00 
}
`

###### GET REQUEST

`curl --location --request GET 'localhost:8081/v1/api/stocks/GOOG'`