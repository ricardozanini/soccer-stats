def pom

pipeline {
    agent none
    
    options {
        // set a timeout of 20 minutes for this pipeline
        timeout(time: 20, unit: 'MINUTES')
    }
    
    stages {
         stage('Build') {
            agent { label 'maven' }
            steps {
                git url: 'https://github.com/ricardozanini/soccer-stats.git'
                script {
                    pom = readMavenPom file: 'pom.xml'
                    sh "mvn -B versions:set -DnewVersion=${pom.version}-${BUILD_NUMBER}"
                    sh "mvn -B -Dmaven.test.skip=true clean package"
                }
                stash name: "artifact", includes: "target/*.war"
            }
        }
        stage('Unit Tests') {  
            agent { label 'maven' }
            steps {
                script {
                    sh "mvn -B test"
                }
                stash name: "unit_tests", includes: "target/surefire-reports/**, target/jacoco*.exec"
            } 
        }

        stage('Integration Tests') {
            agent { label 'maven' }
            steps {
                script {
                    sh "mvn -B verify -Dsurefire.skip=true"
                }
                stash name: 'it_tests', includes: 'target/failsafe-reports/**, target/jacoco*.exec'
            }
        }
        stage('Build Image') {
            agent { label 'maven' }
            steps {
                unstash name:"artifact"
                script {
                    pom = readMavenPom file: "pom.xml"
                    def repoPath =  "${pom.groupId}".replace(".", "/") + 
                                    "/${pom.artifactId}"
    
                    def version = pom.version
                    sh "cp target/${pom.artifactId}-${version}.war target/${pom.artifactId}.war"
                    sh "oc start-build soccer-stats --from-file=target/${pom.artifactId}.war --follow"
                }
            }
        }
        stage('Approval') {
            agent none
            steps {
                timeout(time:3, unit:'DAYS') {
                    input 'Do I have your approval for deployment?'
                }
            }
        }

        stage('Deploy') {
            agent { label 'maven' }
            steps {
                openshiftDeploy depCfg: 'soccer-stats', waitTime: '10', waitUnit: 'min'
                openshiftVerifyDeployment depCfg: 'soccer-stats', replicaCount: '1', verifyReplicaCount: 'true'
                //slackSend color: 'good', message: "A new version (${pom.version}) of soccer-stats app is ready to use!"
            }
        }
    
    }
}


