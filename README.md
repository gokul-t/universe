Sure! Here's the provided text converted to Markdown format:

# Universe

Universe is a collection of planetary bodies.

## REST API Assignment
Assignment Details
1. Create a PlanetaryBody model with the following fields:
   - name (string)
   - mass (float)
   - radius (float)
   - numberOfMoons (int)
2. Create a REST API endpoint for the Planetary Body model that allows for the following operations:
   - POST /planets - Create a new planet
     - Data Validations:
       - name cannot be empty
       - mass cannot be negative
       - radius cannot be negative
       - numberOfMoons cannot be negative
     - Return bad request on validation error
     - Return 201 response code with the product id as the response on success
3. Enable Swagger for API documentation
4. Write a Dockerfile to containerize your microservice.
5. Provide the Helm charts to deploy the container in Kubernetes.
6. Write a README that can be used to evaluate your submission.
7. Push the code to a private GitHub repo and add the username <> as collaborator for evaluating your code.

Technology Stack:
- Java 11+
- Spring Boot
- Postgres
- Docker
- Kubernetes