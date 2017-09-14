#!groovy​

stage 'Build'
node {

}

stage 'Unit Tests'
node {

}

stage 'Integration Tests'
node {

}

stage 'Static Analysis'
node {

}

stage 'Artifact Upload'
node {
// stash it
}

stage 'Approval'
timeout(time:3, unit:'DAYS') {
    input 'Do I have your approval for deployment?'
}

stage 'Deploy'
node {

}