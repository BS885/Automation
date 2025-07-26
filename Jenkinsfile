pipeline {
    agent any

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/user/repo.git', description: 'Git repository URL')
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch name')
    }

    environment {
        TARGET_BRANCH = "${params.BRANCH_NAME}"
    }

    triggers {
        cron('30 5 * * 1-5')
        cron('0 14 * * *')
    }

    stages {

        stage('Checkout Code') {
            options {
                timeout(time: 5, unit: 'MINUTES')
            }
            steps {
                echo "Starting checkout from ${params.REPO_URL}, branch ${params.BRANCH_NAME}"

                git branch: "${params.BRANCH_NAME}", url: "${params.REPO_URL}"

                echo "Code checkout completed successfully"
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