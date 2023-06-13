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
