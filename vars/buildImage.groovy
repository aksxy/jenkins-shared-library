#!/usr/bin/env groovy

//def call() {
// def call(String imageName) {
//     echo "building the docker image..."
//     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//        // sh 'docker build -t aksxy/java-maven-app:jma-2.1 .' 
//         sh "docker build -t $imageName ." //using $imageName as pasameter passing value from Jenkins file
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh "docker push $imageName"
//      }
// }

import com.example.Docker

def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
}
