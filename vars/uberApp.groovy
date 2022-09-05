def call(String repoUrl){
pipeline {
       agent any
       tools {
           maven 'maven'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh 'mvn --version'
                   sh 'java -version'
               }
           }
           stage('demo-newapp'){
            steps{
                sh 'cat /etc/passwd'
                echo "jenkins is a powerful tool"
            }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage("to-test-maven") {
               steps {
                   sh 'mvn -v'
               }
           }
       }
}
}