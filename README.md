# Schoolproject
--------------------------------------------------------------------------
--------------------------------------------------------------------------
# Endpoints:
  
 * resource: student:
 {
 "firstName":"String",
 "lastName":"String", 
 "email":"String"
 }
  
  * base url: localhost:8080/school/students

  
  * # method: GET
  * path: /
  * description: list all students
  * produces: JSON
  * responsecodes: 200
  
  * # method: GET
  * path: /
  * Path param: email
  * description: retrieve student by email
  * produces: JSON
  * responsecodes: 200, 404
  
  * # method: POST
  * path: /
  * description: create a student from request body
  * body: student
  * consumes: JSON
  * produces: JSON
  * responsecodes: 201, 400
  
  
  * # method: DELETE
  * path: /
  * path param: email
  * description: delete a student by email
  * produces: JSON
  * responsecodes: 204, 404
  
  * # method: PUT
  * path: /
  * description: update student from request body
  * body: student
  * consumes: JSON
  * produces: JSON
  * responsecodes: 200, 400, 404

  
  example curl: 
  curl --request POST \
  --url http://localhost:8080/school/students \
  --header 'content-type: application/json' \
  --data '{	
	"firstName":"1",
	"lastName":"1",
	"email":"1@gmail.com"
}	'


# changes:

  * '/student' endpoint changed to '/students'.
  * '/add' endpoint replaced with POST method on '/students'.
  * forename, lastname changed to firstName, lastName.
  * updateStudent() takes requestBody as input and not path params.
  
--------------------------------------------------------------------------
--------------------------------------------------------------------------
Small project for teaching purposes.

* Wildfly
* JEE 8 
* Java 11
* Git
* Maven
* MySQL

## Wildfly configuration

Install any Wildfly release you want. I use 18.

Add a user, and place the school.cli script under the bin folder.<br>
Create database school. The script will need a mysql connector under `C:\Users`
to work. 

The script is predefined for `mysql.connector-java-8.0.12.jar`. Change location and version for your own liking.

Start Wildfly, and once running, open a new prompt, and go to the bin folder.<br>
Write `jboss-cli -c --file=school.cli`

It should say outcome success. Write `jboss-cli -c --command=:reload` to restart the server.



 
