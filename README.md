# Movies rental
 A movie rental shop manages information about movies and clients.
* perform CRUD operations on movies and clients
## Project structure:
* A core module containing services, repositories, model classes
* A web module containing :
  * controllers exposed as RESTful Web Services
  * a client module (/webapp) containing Angular that accesses the RESTful Web Services using RestTemplate.

## How to use
 In order to run this project you need:
* Tomcat server
* java JDK 11 
* database connection (web module -> src -> main-> resources -> local-> db.properties) 

#### > Run Tomcat server ( HTTP port:8090 )
#### > npm install @angular/cli   
#### > ng serve  --open @angular/cli  
 
