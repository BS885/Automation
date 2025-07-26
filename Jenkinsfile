pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            args '-v /root/.m2:/root/.m2'
        }
    }

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/BS885/Automation', description: 'Git repository URL')
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch name')
    }

    environment {
        TARGET_BRANCH = "${params.BRANCH_NAME}"
    }

    triggers {
        cron('30 5 * * 1-5')
    }

    stages {
        stage('Checkout Code') {
            options { timeout(time: 5, unit: 'MINUTES') }
            steps {
                echo "Starting checkout from ${params.REPO_URL}, branch ${params.BRANCH_NAME}"
                git branch: "${params.BRANCH_NAME}",
                    credentialsId: 'd955d1c6-5900-4805-931a-29ab45b85965',
                    url: "${params.REPO_URL}"
                echo "Code checkout completed successfully"
            }
        }

        stage('Check Maven Installation') {
            steps {
                echo "Checking if Maven is installed..."
                sh 'mvn -version || echo "Maven is NOT installed on this agent."'
            }
        }

        stage('Compile') {
            options { timeout(time: 5, unit: 'MINUTES') }
            steps {
                echo "Starting compilation stage"
                sh 'mvn compile'
                echo "Compilation stage completed successfully"
            }
        }

        stage('Test') {
            options { timeout(time: 5, unit: 'MINUTES') }
            steps {
                echo "Starting test stage"
                sh 'mvn test'
                echo "Test stage completed successfully"
            }
        }
    }

    post {
        success { echo "Pipeline completed successfully!" }
        failure { echo "Pipeline failed." }
    }
}