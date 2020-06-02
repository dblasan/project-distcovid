pipeline {
    agent any
    stages {
        stage('Clean project') {
            steps {
                echo 'Starting ...'
                bat 'gradle clean --warning-mode all --stacktrace'
            }
        }
        stage('Build  project') {
            steps {
                echo 'Starting...'
                bat 'gradlew build --warning-mode all --stacktrace'
            }
        }
    }
}