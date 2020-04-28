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
        sh './gradlew clean'
      }
    }
    
    stage('Compile Project') {
      steps {
        // Compile the app and its dependencies
        sh './gradlew compileDebugSources'
      }
    } 
  }

}
