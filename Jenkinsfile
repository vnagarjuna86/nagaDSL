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
pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                script {
                    failureEmailToMonitoring("Test details", FwdJobOwner.NETWORK_TEAM)
                }
            }
        }
    }

    post {
        failure {
            script {
                failureEmailToMonitoring("Failure details", FwdJobOwner.NETWORK_TEAM, FwdJobOwner.PERF_JOB_OWNERS)
            }
        }
    }
}
