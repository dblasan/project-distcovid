pipeline {
  agent any
  environment{
		GRADLE_HOME = "C:\Gradle\gradle-6.3"
		env.PATH = "${GRADLE_HOME};${GRADLE_HOME}\bin;${env.PATH}"
		//SONARQUBE_HOME = "C:\sonarqube-8.2"
		//JAVA_HOME = "C:\Program Files\Java\jdk-11.0.7"
	}
  stages {
    stage('Env variables') {
	
      steps {
	  echo 'print gradle version'
        bat 'gradle -v'
      }
    }
  }

}
