pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
    }
    options {
          timeout(time: 5, unit: 'MINUTES')
      }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/kemalmahmud/sonarqube-and-jenkins-demo']])
                bat 'mvn clean install'
                echo 'Git Checkout Completed'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn clean package'
                    bat ''' mvn clean verify sonar:sonar -Dsonar.projectKey=sonarqubeAndJenkinsDemo -Dsonar.projectName='sonarqubeAndJenkinsDemo' -Dsonar.host.url=http://localhost:9000 '''
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
//         stage("Quality Gate") {
//             steps {
//                 waitForQualityGate abortPipeline: true
//                 echo 'Quality Gate Completed'
//             }
//         }

        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t kemalmahmud/sonarqube-and-jenkins-demo .'
                    echo 'Build Docker Image Completed'
                }
            }
        }

        stage('Docker Push') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhub-password')]) {
                        bat ''' docker login -u kemalbarca -p "%dockerhub-password%" '''
                    }
                    bat 'docker push kemalbarca/sonarqubeandjenkinsdemo'
                }
            }
        }

//         stage ('Docker Run') {
//             steps {
//                 script {
//                     bat 'docker run -d --name sonarqubeAndJenkinsDemo -p 8099:8080 kemalbarca/sonarqubeAndJenkinsDemo'
//                     echo 'Docker Run Completed'
//                 }
//             }
//         }

    }
    post {
        always {
            bat 'docker logout'
        }
    }
}