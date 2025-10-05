# API End points

## User APIs

* Create User - ```http://localhost:8080/api/users```
* Fetch all user - ```http://localhost:8080/api/users```
* Fetch single user by Id - ```http://localhost:8080/api/users/{id}```
* Delete User - ```http://localhost:8080/api/users/{userid}/delete```

## Todo API

* Create a Todo - ```http://localhost:8080/api/users/{userid}/todo```
* Fetch all todos - ```http://localhost:8080/api/users/{userid}/todo/todos```
* Fetch single todo by Id - ```http://localhost:8080/api/users/4/todo/todos/{todoid}```
* Update a todo - ```http://localhost:8080/api/users/4/todo/todos/{todoid}/update```
* Delete a Todo - ```http://localhost:8080/api/users/4/todo/todos/{todoid}/delete```