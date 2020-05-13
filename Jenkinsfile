pipeline {
  agent any
  
  stages {
    stage('Clean') {
      steps {
        bat "gradle -v"
	      echo 'Clean project'
        bat "gradlew clean -g ${workspace}\\build-caches --stacktrace"
      }
    }

    stage('Build') {
      steps {
	      echo 'Build project'
        bat "gradlew assembleDebug -g ${workspace}\\build-caches --stacktrace"
      }
    }

  }

}
