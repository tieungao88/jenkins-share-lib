#!/usr/bin/env groovy
def call(String imagename) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t tieungao1988/${imagename} ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push tieungao1988/${imagename}"
    }
}
