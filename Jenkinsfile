pipeline {
   agent any

   environment {
     SERVICE_NAME = "fleetman-webapp"
     REPOSITORY_TAG="${YOUR_DOCKERHUB_USERNAME}/${ORGANIZATION_NAME}-${SERVICE_NAME}:${BUILD_ID}"
   }

   stages {
      stage('Preparation') {
         steps {
            cleanWs()
            git credentialsId: 'GitHub', url: "https://github.com/${ORGANIZATION_NAME}/simplewebservice"
         }
      }
      stage('Build') {
         steps {
            sh 'echo No build required for Webapp.'
         }
      }

//       stage('Build and Push Image') {
//          steps {
//            sh 'docker build . -t theilig/simple-web-service'
//          }
//       }

//       stage('Deploy to Cluster') {
//           steps {
//             sh 'envsubst < ${WORKSPACE}/deploy.yaml | kubectl apply -f -'
//           }
//       }
   }
}