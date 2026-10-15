pipeline {
    agent any

    tools {
        // Configure this tool in Jenkins: Manage Jenkins > Tools.
        jdk 'JDK17'
        maven 'Maven3'
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Validate') {
            steps {
                sh 'mvn -B validate'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
            post {
                always {
                    junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -B package -DskipTests'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, allowEmptyArchive: true
            echo 'CodeValidationPipeline completed successfully.'
        }
        failure {
            echo 'CodeValidationPipeline failed. Review the stage logs and test reports.'
        }
        always {
            echo 'Pipeline run finished.'
        }
    }
}
