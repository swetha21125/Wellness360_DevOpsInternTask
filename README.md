# Spring Boot Application with CI/CD Pipeline

This repository contains a Spring Boot application containerized using Docker and deployed to AWS ECS using GitHub Actions.

---

## Project Overview

The project includes:

- A basic Spring Boot application.
- A `Dockerfile` to containerize the application.
- A CI/CD pipeline using GitHub Actions for automation.
- Deployment to AWS ECS.

---

## Dockerfile

```dockerfile
# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file
COPY target/<your-application-name>.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## CI/CD Pipeline (GitHub Actions)

The pipeline automates the following tasks:

1. **Checkout Code**: Clones the repository.
2. **Set Up Java**: Installs Java 11.
3. **Build and Test**:
   - Executes `mvn clean install` to build the application.
   - Runs unit and integration tests.
4. **Dockerize**:
   - Builds a Docker image for the application.
   - Pushes the Docker image to AWS ECR.
5. **Deploy to ECS**:
   - Deploys the Docker container from ECR to ECS.

---

## Key AWS Services Used

1. **Elastic Container Registry (ECR)**: Used to store Docker images.
2. **Elastic Container Service (ECS)**: Manages Docker container deployment.
3. **IAM Role**: Provides permissions for ECR and ECS operations.

---

## Commands Used

### Maven Commands
```bash
# Build the application
mvn clean install
```

### Docker Commands
```bash
# Build Docker image
docker build -t <your-ecr-registry-uri>:<image-tag> .

# Run Docker container locally
docker run -p 8080:8080 <your-ecr-registry-uri>:<image-tag>

# Tag Docker image
docker tag <image-id> <your-ecr-registry-uri>:<image-tag>

# Push Docker image to ECR
docker push <your-ecr-registry-uri>:<image-tag>
```

### AWS CLI Commands
```bash
# Login to ECR
aws ecr get-login-password --region <your-region> | docker login --username AWS --password-stdin <your-ecr-registry-uri>
```

---

## Local Testing

1. Build the application using Maven:
   ```bash
   mvn clean install
   ```

2. Build the Docker image:
   ```bash
   docker build -t springboot-app:latest .
   ```

3. Run the Docker container:
   ```bash
   docker run -p 8080:8080 springboot-app:latest
   ```

4. Open the application in your browser:
   - URL: `http://localhost:8080`

---

## Deployment to ECS

1. Push the Docker image to ECR:
   ```bash
   docker push <your-ecr-registry-uri>:<image-tag>
   ```

2. Create an ECS cluster and task definition.
3. Configure the ECS service to use the ECR image and deploy it.

---

## Troubleshooting

### Common Issues and Solutions

1. **Error: Permission Denied When Pushing to ECR**
   - Ensure AWS CLI is configured with the correct permissions:
     ```bash
     aws configure
     ```
   - Add an IAM role with ECR permissions.

2. **Pipeline Fails During Build or Test**
   - Check GitHub Actions logs.
   - Ensure the `mvn clean install` command runs successfully locally.

3. **ECS Deployment Fails**
   - Verify ECS service and task definition configuration.
   - Confirm the correct ECR image URI is used in the task definition.

---


