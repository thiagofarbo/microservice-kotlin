# About this application. 
> On this application was used Maven to manage the dependencies of the project, Java 8 to build api restful services. This application does not need to install any server to do run, the application is deployed in an embedded server (Tomcat).

# How to access your database 
> To access your database, go to http://localhost:8080/h2

# How to run the application 
> By default the SpringBoot run on port 8080 so make sure you do not have any server running on port 8080. Go to root folder of your application and type on your terminal the command mvn spring-boot:run

# Access to Swagger 
> http://localhost:8080/swagger-ui.html

# How to execute requests of API RESTful 
- POST: to create a card: http://localhost:8080/api/cards 
> JSON { 
	"name": "John Summer",
	"amout": 2.000,
	"expirationDate": "2020/02/05",
	"status": "ACTIVE"
> }
- GET: List cards: http://localhost:8080/api/cards
- GET: Get a card by id: http://localhost:8080/api/cards/31
- PUT: Update a card by id: http://localhost:8080/api/cards/31
> JSON { 
	"name": "John Summer",
	"amout": 2.000,
	"expirationDate": "2020/02/05",
	"status": "ACTIVE"
> }
- DELETE: Delete card: http://localhost:8080/api/cards/35
