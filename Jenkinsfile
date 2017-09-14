#!groovy​
def gitUrl = 'https://github.com/ricardozanini/soccer-stats.git'
def mavenEnv = "PATH+MAVEN=${tool 'm3'}/bin"

stage 'Build'
node {
    git gitUrl
    withEnv([mavenEnv]) {
        sh "mvn -B -Dmaven.test.skip=true clean install"
        stash name: "artifact", includes: "target/soccer-stats-*.jar"
        stash name: "source", includes: "**", excludes: "target/"
    }
}

stage 'Unit Tests'
node {
    unstash 'source'
    withEnv([mavenEnv]) {
        sh "mvn -B clean test"
    }
}

stage 'Integration Tests'
node {
    unstash 'source'
    withEnv([mavenEnv]) {
        sh "mvn -B clean test"
    }
}

stage 'Static Analysis'
node {
    unstash 'source'
    withEnv([mavenEnv]) {
        sh "mvn sonar:sonar"
    }
}

stage 'Artifact Upload'
node {
    unstash 'artifact'
}

stage 'Approval'
timeout(time:3, unit:'DAYS') {
    input 'Do I have your approval for deployment?'
}

stage 'Deploy'
node {

}