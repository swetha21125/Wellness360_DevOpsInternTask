How to Run the Project
Prerequisites
AWS account: Ensure you have an AWS account with permissions to use ECR.
Docker: Install Docker on your local machine for testing Docker commands.
GitHub repository: Set up a GitHub repository for using GitHub Actions.
Setting Up the Project Locally
Clone the repository:
bash
git clone https://github.com/swetha21125/Wellness360_DevOpsInternTask.git
Build the project: Use Maven to build the project:
bash
mvn clean install
Build the Docker Image: Once Docker is installed, you can build the Docker image locally:
bash
docker build -t <your-ecr-registry-uri>:<image-tag> .
Push to AWS ECR: After building the image, tag it and push it to your ECR repository:
bash
docker tag <image> <your-ecr-registry-uri>:<image-tag>
docker push <your-ecr-registry-uri>:<image-tag>
Conclusion
This project demonstrates how to integrate CI/CD pipelines using GitHub Actions, Docker, and AWS ECR. The workflows created automate the process of building, testing, and deploying the application, improving both development speed and reliability.
