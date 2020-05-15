pipeline {
  agent any

  environment {
    echo 'loading Android environment variable'

    ANDROID_HOME = "$ANDROID_HOME"
    ANDROID_EMULATOR = '%ANDROID_HOME%\\emulator'
    ANDROID_ADB = '%ANDROID_HOME%\\cmdline-tools\latest\\bin'

    echo '------------- EMULATOR (S) ---------------'
    echo 'List available devices'
    bat '%ANDROID_EMULATOR%\\emulator -list-avds'

    echo '------------- ADB VERSION ----------------'
    bat '%ANDROID_ADB%\\adb version'
  }
  stages {
    /*stage('Clean') {
      steps {
        echo "${env.BRANCH_NAME}"
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
        echo 'List available devices'
        bat '%ANDROID_EMULATOR%\\emulator -list-avds'
        echo '(re)-start emulator'
        timeout(time: 20, unit: 'SECONDS') {
            bat '%ANDROID_EMULATOR%\\emulator -avd Nexus_5X_API_29_x86'
        }
        //bat 'env'
    }
  }

  }

  post{
    failure {
        echo 'try to kill adb server'
        bat '%ANDROID_ADB%\\adb kill-server'
    }
  }

}
