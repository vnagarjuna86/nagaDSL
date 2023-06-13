pipeline {
  agent any

  stages {
    stage('Load Groovy Files') {
      steps {
        script {
          def fwdJobOwnerGroup = load 'FwdJobOwnerGroup.groovy'
          def failureEmailToMonitoring = load 'failureEmailToMonitoring.groovy'

          // Use the loaded Groovy files as needed in your pipeline script
          // ...
        }
      }
    }

    stage('Test') {
      steps {
        script {
          failureEmailToMonitoring.call("Test details", fwdJobOwnerGroup.FwdJobOwner.NETWORK_TEAM)
        }
      }
    }
  }

  post {
    failure {
      steps {
        script {
          failureEmailToMonitoring.call("Failure details", fwdJobOwnerGroup.FwdJobOwner.NETWORK_TEAM, fwdJobOwnerGroup.FwdJobOwner.PERF_JOB_OWNERS)
        }
      }
    }
  }
}
