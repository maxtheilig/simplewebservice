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
           sh 'docker build . -t theilig/simple-web-service'
         }
      }

//       stage('Deploy to Cluster') {
//           steps {
//             sh 'envsubst < ${WORKSPACE}/deploy.yaml | kubectl apply -f -'
//           }
//       }
   }
}