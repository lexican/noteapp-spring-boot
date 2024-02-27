# Note App

This Note App is built with Spring Boot and demostrates how CRUD APIs work

<br>

## Features

- Implement create note
- Implement update note by note Id
- Implement edit note by Id
- Imlement delete note by Id
- Used Lombok to make model classes more robust
- Used spring boot starter validation to handle validation

Note : I did not use any database to persist the notes for simplicity.

## ✨ Requirements

- Any Operating System (ie. MacOS X, Linux, Windows)
- Any IDE with Java SDK installed (ie IntelliJ, Eclipse, Spring Suite Tool etc)
- A little knowledge of Java and Spring Boot


## Run Locally

```bash
  git clone https://github.com/lexican/noteapp-spring-boot.git
  cd noteapp-spring-boot
  mvn clean spring-boot:run
```

## Endpoints URls

- Get all notes

Make a GET request to http://localhost:8080/api/notes to retrieve all notes.

- Get a single note

To get a single note, make a GET request to http://localhost:8080/api/notes/{noteId} and replace noteId with the actual note Id

- Create a new note

To create a note, make a POST request to http://localhost:8080/api/notes and pass the note title, description.

- Update a single note

To update a note, make a PATCH request to http://localhost:8080/api/notes and pass the note title, description and most importantly the nodeId in the request body.

- Delete a single note

To delete a mote by Id, make a DELETE request to http://localhost:8080/api/notes/{noteId} and replace noteId with the actual note Id.

