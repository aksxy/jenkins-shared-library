#!/usr/bin/env groovy

def call() {
    echo "building the application for $BRANCH"
    sh 'mvn package'
}
