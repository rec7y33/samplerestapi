# Sample rest api server project
a simple rest api server built with spring boot

## Dependancies used in this project:
1. Spring web
    - for setting up a http rest server
3. Logbook
    - for loggin all incoming and outgoing requests into log files
5. Spring JPA
    - for db access

## Controller classes
### Student Controller
1. enroll (POST)
    - add a student into the system
2. update (POST)
    - update the student's name and address by ic
3. list (GET)
    - list all students by pagination
  
### User Controller
1. add (POST)
    - add a user by calling to another service
  
## Postman scripts
- can be found in the folder "Postman Scripts"
