#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    // def buildDockerImage(String imageName)  {
    //     script.echo "building the docker image..."
    //     script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    //         script.sh "docker build -t $imageName ."
    //         script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
    //         script.sh "docker push $imageName"
    //     }
    // }

    //Create functions for each work

    //Build image
    def buildDockerImage(String imageName)  {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName ."
    }

    //Login
    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
             script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    //push image
    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }
        
}
