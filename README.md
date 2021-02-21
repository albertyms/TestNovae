With Docker:
        1.1. Create root folder and clone both web services (NovaeTest and ClientNovae). Example:
            ├── ...
            ├── rootFolder              # root folder
            │   ├── NovaeTest           # Web services for a backend 
            │   ├── ClientNovae         # Web services client
            │   └── docker-compose.yml  # File to create containers with docker
            └── ...
        1.2. Compiler both web services with maven, run the command: mvn clean install -Dmaven.test.skip=true
        1.3. Run the command: docker-compose up --build on the file docker-compose.yml that is in the root of the folders (Docker must be installed).
        1.4. Run the postman collections

With Springboot/Maven:
    NOTE: To run with this option it is necessary to have a PostgreSQL database with a database called "testnovae"
          and change the connection string to the database in the application.properties file so that the scripts 
          can be executed table creation.
        For project NovaeTest:
        Uncommet:
          spring.datasource.url=jdbc:postgresql://localhost:5432/testnovae
        Comment:
          #spring.datasource.url=jdbc:postgresql://dbpostgresql:5432/testnovae
    2.1. Move to the root folder of the project: cd C:\Users\user\NovaeTest\target on command line
    2.2. Compile the project with the command: mvn clean install -Dmaven.test.skip=true
    2.3. Run the following command: mvn spring-boot:run
    2.4. Repeat steps 2.1 to 2.4 for client web services ClientNovae
    
For NovaeTest:

    Enpoint to consume service:
    
    Type: POST
    localhost:localhost:8081/api/creditCard
    Create credit card    

    Request example:
    {
        "cardHolderName": "Albert Medina",
        "cardNumber": "5280000100020005",
        "billingAddress": "Carrea 15",
        "expireDate": "12/2021",
        "cvv": "124",
        "maskNumber": "5280000100020005"
    }
    
    Response:
    {
        "id": 1,
        "cardHolderName": "Albert Medina",
        "cardNumber": "KhufY1JO/W4bf1WeGQqkOk6uVfHi1xZJ4Wfw4fNp2Gg=",
        "billingAddress": "Carrea 15",
        "expireDate": "12/2021",
        "cvv": "a38JxA8Pstf9VJ8UckLebA==",
        "maskNumber": "************0005",
        "creationDate": "2021-02-21T09:59:55.498-05:00"
    }
    
    Type: GET
    localhost:8081/api/creditCard/1
    Get credit card for id    

    Response:
    {
        "id": 1,
        "cardHolderName": "Albert Medina",
        "cardNumber": "KhufY1JO/W4bf1WeGQqkOk6uVfHi1xZJ4Wfw4fNp2Gg=",
        "billingAddress": "Carrea 15",
        "expireDate": "12/2021",
        "cvv": "a38JxA8Pstf9VJ8UckLebA==",
        "maskNumber": "************0005",
        "creationDate": "2021-02-20T17:33:29.248-05:00"
    }

    Type: GET
    localhost:8081/api/creditCard
    Get a list of all credit cards

    Response:
    [
        {
            "id": 1,
            "cardHolderName": "Albert Medina",
            "cardNumber": "KhufY1JO/W4bf1WeGQqkOk6uVfHi1xZJ4Wfw4fNp2Gg=",
            "billingAddress": "Carrea 15",
            "expireDate": "12/2021",
            "cvv": "a38JxA8Pstf9VJ8UckLebA==",
            "maskNumber": "************0005",
            "creationDate": "2021-02-20T17:33:29.248-05:00"
        },
        {
            "id": 2,
            "cardHolderName": "Albert Medina",
            "cardNumber": "KhufY1JO/W4bf1WeGQqkOk6uVfHi1xZJ4Wfw4fNp2Gg=",
            "billingAddress": "Carrea 15",
            "expireDate": "12/2021",
            "cvv": "a38JxA8Pstf9VJ8UckLebA==",
            "maskNumber": "************0005",
            "creationDate": "2021-02-21T09:59:55.498-05:00"
        }
    ]

    Type: PUT
    localhost:localhost:8081/api/creditCard/update/1
    Update credit card    

    Request example:
    {
        "id": 1,
        "cardHolderName": "Albert2 Medina2",
        "cardNumber": "5280000100020005",
        "billingAddress": "Carrea 15",
        "expireDate": "12/2021",
        "cvv": "124",
        "maskNumber": "5280000100020005"
    }
    
    Response:
    {
       "id": 1,
        "cardHolderName": "Albert2 Medina2",
        "cardNumber": "KhufY1JO/W4bf1WeGQqkOk6uVfHi1xZJ4Wfw4fNp2Gg=",
        "billingAddress": "Carrea 15",
        "expireDate": "12/2021",
        "cvv": "a38JxA8Pstf9VJ8UckLebA==",
        "maskNumber": "************0005",
        "creationDate": "2021-02-20T17:33:29.248-05:00"
    }

    Type: GET
    localhost:8081/api/creditCard/delete/1
    Delete credit card for id    

    Response:
    Http status 200
    
    Type: GET
    localhost:8081/api/creditCard/getCard/5280000100020005
    Get credit card for number    

    Response:
    {
        "id": 2,
        "cardHolderName": "Albert Medina",
        "cardNumber": "KhufY1JO/W4bf1WeGQqkOk6uVfHi1xZJ4Wfw4fNp2Gg=",
        "billingAddress": "Carrea 15",
        "expireDate": "12/2021",
        "cvv": "a38JxA8Pstf9VJ8UckLebA==",
        "maskNumber": "************0005",
        "creationDate": "2021-02-21T09:59:55.498-05:00"
    }

    


    

