pipeline {
  agent any
 
  options {
    // Stop the build early in case of compile or test failures
    skipStagesAfterUnstable()
  }
  stages {
    stage('Clean Project') {
      steps {
        // clean the project
        echo 'Clean the project'
        sh './gradlew clean'
      }
    }
    stage('Build project') {
      steps {
        // Compile the app and its dependencies
        echo 'Start build'
        sh './gradlew assembleDebug'
      }
    }
  }

}
