pipeline {
  agent any
  
  stages {
    stage('Clean') {
      steps {
        echo "${env.BRANCH_NAME}"
	      echo 'Clean project'
        bat "gradlew clean --stacktrace"
      }
    }

    stage('Build') {
      steps {
	      echo 'Build project'
        bat "gradlew assembleDebug --stacktrace"
      }
    }

    stage('Integration test'){
      steps{
        echo 'Jacoco Report'
        bat 'gradlew jacocoTestReport --stacktrace'
      }
    }

    stage('SonarQube analysis') {
      steps {
	      echo 'Starting analysis'
        bat "gradlew sonarqube -X --stacktrace"
      }
    }
    /*stage('SonarQube analysis') {
    steps {
      //withSonarQubeEnv() { // Will pick the global server connection you have configured
      bat 'gradlew sonarqube -X --info'//-Dsonar.projectKey=distcovid-bitbucket-key -Dsonar.junit.reportPaths=./build/test-results/test -Dsonar.binaries=./build/classes -Dsonar.coverage.jacoco.xmlReportPaths=./build/reports/jacoco/test/html/index.html''
    //}
    }
  }*/

  }

}
