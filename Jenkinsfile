pipeline {
  agent any
  
  stages {
    stage('Clean') {
      steps {
        echo "${env.BRANCH_NAME}"
	      echo 'Clean project'
        bat "gradlew clean -g ${workspace}\\build-caches --stacktrace"
      }
    }

    /*stage('Build') {
      steps {
	      echo 'Build project'
        bat "gradlew assembleDebug -g ${workspace}\\build-caches --stacktrace"
      }
    }

    stage('Integration test'){
      steps{
        echo 'Jacoco Report'
        bat 'gradlew jacocoTestReport -g ${workspace}\\build-caches --stacktrace'
      }
    }

    stage('SonarQube analysis') {
      steps {
	      echo 'Starting analysis'
        bat "gradlew sonarqube -g ${workspace}\\build-caches --stacktrace"
      }
    }*/

    stage('Deploy') {
    steps {
        echo "${env.ANDROID_HOME}"
        bat 'env'
    }
  }

  }

}
