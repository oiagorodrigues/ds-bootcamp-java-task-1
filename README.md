# DS Client API

Simple Client REST API made as the first task of the DevSuperior Spring React Bootcamp, using Spring Boot and persiting in a memory database using Spring Data JPA.

## How to install

Clone this repo
```bash
git clone https://github.com/oiagorodrigues/dsbootcamp-java-first-task.git

or 

git clone git@github.com:oiagorodrigues/dsbootcamp-java-first-task.git
```

Open it in your favorite IDE. 
Recommended using [Intellij](https://www.jetbrains.com/pt-br/idea/), [STS](https://spring.io/tools) or [VSCode](https://code.visualstudio.com/).

## Conceptual model

<img src="https://raw.githubusercontent.com/oiagorodrigues/dsbootcamp-java-first-task/main/conceptual_model.jpg" width="300">

## Technologies

- Java 11
- Spring Boot 2.4.6
- Spring Data JPA
- H2 Database

## Endpoints

### Client [[Postman docs]](https://documenter.getpostman.com/view/6767905/TzXzEcpC#cf7c6d12-e9b6-4ec5-8a8a-80e51297d65b)

#### Add a client

> POST - /clients

Example Request

```json
{
    "name": "Maria Silva",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
}
```

Example Response

```json
// 201 CREATED
// Location: /clients/11

{
  "id": 11,
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

#### Fetch Clients (Pageable)

> GET - /clients

Params

- **page** - Gets a list specified by the page number. Default = 0

- **linesPerPage** - Gets the size of the list specified. Default = 12

- **direction** - Gets the list sorted by a direction. [ASC, DESC] Default = DESC

- **orderBy** - Gets the list ordered by the fields of the Client. Default = id.
```

Example Response

```json
// 200 OK

 {
    "content": [
    {
      "id": 10,
      "name": "Iago Samuel Drumond",
      "cpf": "58298663900",
      "income": 20000,
      "birthDate": "1968-08-02T20:50:07Z",
      "children": 2
    },
    {
      "id": 8,
      "name": "Ian Nicolas Isaac Gonçalves",
      "cpf": "38294706221",
      "income": 3000,
      "birthDate": "1953-11-09T20:50:07Z",
      "children": 1
    },
    {
      "id": 5,
      "name": "Luana Bárbara da Rosa",
      "cpf": "58093464565",
      "income": 11000,
      "birthDate": "1982-06-14T20:50:07Z",
      "children": 5
    },
    {
      "id": 6,
      "name": "Lucas Elias Carvalho",
      "cpf": "54636645529",
      "income": 1000,
      "birthDate": "1949-09-07T20:50:07Z",
      "children": 1
    },
    {
      "id": 2,
      "name": "Patrícia Regina Araújo",
      "cpf": "74665963398",
      "income": 1070,
      "birthDate": "1963-07-13T20:50:07Z",
      "children": 1
    },
    {
      "id": 9,
      "name": "Rodrigo Cláudio Caldeira",
      "cpf": "81025624122",
      "income": 3200,
      "birthDate": "1989-03-22T20:50:07Z",
      "children": 4
    }
  ],
    "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "pageSize": 6,
    "pageNumber": 0,
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalPages": 2,
  "totalElements": 10,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "first": true,
  "numberOfElements": 6,
  "size": 6,
  "number": 0,
  "empty": false
 }
```

#### Fetch Client by Id

> GET - /clients/{id}

Example Response

```json
// 200 OK

{
  "id": 10,
  "name": "Iago Samuel Drumond",
  "cpf": "58298663900",
  "income": 20000,
  "birthDate": "1968-08-02T20:50:07Z",
  "children": 2
}
```

#### Update Client

> PUT - /clients/{id}

Example Request

```json
{
    "name": "Maria Silvaaa",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
}
```

Example Response

```json
// 200 OK

{
  "id": 1,
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

#### Delete Client

> DELETE - /clients/{id}

Example Response

```json
// 201 NO CONTENT
```
