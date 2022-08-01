pipeline {
   agent any

   tools {
       maven 'Maven 3.8.5'
       jdk 'JDK 17'
   }

   environment {
     SERVICE_NAME = "fleetman-webapp"
     REPOSITORY_TAG="${YOUR_DOCKERHUB_USERNAME}/${ORGANIZATION_NAME}-${SERVICE_NAME}:${BUILD_ID}"
   }

   stages {
      stage('Build') {
         steps {
            sh 'mvn clean install'
         }
      }

      stage('Build and Push Image') {
         steps {
           sh 'eval $(minikube -p minikube docker-env)'
           sh 'eval $(minikube -p minikube docker-env) && docker images'
           sh 'eval $(minikube -p minikube docker-env) && docker build . -t theilig/simple-web-service'
           sh 'docker images'
         }
      }

      stage('Deploy to Cluster') {
          steps {
            sh 'kubectl apply -f deployment_service_ingress.yml'
          }
      }
   }
}