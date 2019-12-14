# clean-architecture-java
Sample project for hexagonal architecture in Java

1) Run ./gradlew trade-driver-adapter:clean build
2) java -jar trade-driver-adapter/build/libs/trade-driver-adapter.jar

Sample Request: 
curl -X POST \
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
