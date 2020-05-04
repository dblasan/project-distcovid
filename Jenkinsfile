pipeline {
  agent any
 
  /*options {
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
    }*/
    stage('Build project') {
      steps {
        // Compile the app and its dependencies
        echo 'Start build...'
        if(isUnix()){
          sh './gradlew build'
        }else{
          bat 'gradlew.bat build'
        }
      }
    }
  }

}
