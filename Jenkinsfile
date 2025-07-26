pipeline {
    agent any

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
            options {
                timeout(time: 5, unit: 'MINUTES')
            }
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
                sh '''
                    if ! command -v mvn &> /dev/null; then
                        echo "Maven is NOT installed on this agent."
                        exit 1
                    else
                        mvn -version
                    fi
                '''
            }
        }

        stage('Compile') {
            options {
                timeout(time: 5, unit: 'MINUTES')
            }
            steps {
                echo "Starting compilation stage"
                sh 'mvn compile'
                echo "Compilation stage completed successfully"
            }
        }

        stage('Test') {
            options {
                timeout(time: 5, unit: 'MINUTES')
            }
            steps {
                echo "Starting test stage"
                sh 'mvn test'
                echo "Test stage completed successfully"
            }
        }

        stage('Build Docker Image') {
            when {
                expression { fileExists('Dockerfile') }
            }
            steps {
                echo 'Building Docker image...'
                sh '''
                    docker build -t my-app:${BUILD_NUMBER} .
                '''
                echo 'Docker image built successfully.'
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully!"
        }
        failure {
            echo "Pipeline failed."
        }
    }
}