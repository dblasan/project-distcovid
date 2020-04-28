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
    stage('Test the code') {
      steps {
        // Compile the app and its dependencies
        echo 'Simple Test process'
        sh './gradlew test -x'
      }
    }
    
    stage('Compile Project') {
      steps {
        // Compile the app and its dependencies
        echo 'Build the program'
        sh './gradlew build --stacktrace'
      }
    } 
  }

}
