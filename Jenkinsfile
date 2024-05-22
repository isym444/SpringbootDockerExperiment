pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'docker build -t my-app:latest .'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker run -d -p 9090:8080 my-app:latest'
            }
        }
    }
}
