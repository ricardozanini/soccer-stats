#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

${DIR}/example-application/gradlew --build-file ${DIR}/example-application/build.gradle build

pushd ${DIR}/kitchen

bundle exec kitchen test

popd 