enum FwdJobOwner {
    NETWORK_TEAM('peymankazemian, yuefengliu'),
    JOBDSL_OWNER('pavanreddymaley'),
    FORWARD_LOHIKA_SERVICES_OWNERS('pavanreddymaley, manuelcorona, infra'),
    CLIENT_OWNERS('deepdesai, sivasankar'),
    LOHIKA_BUILD_OWNERS('yasserganjisaffar'),
    PERF_JOB_OWNERS('sivasankar, deepdesai'),
    STAGING_INFRA_OWNERS('deepdesai, pavanreddymaley, manuelcorona')
 
    String recipients
 
    FwdJobOwner(String recipients) {
        this.recipients = recipients
    }
 
    List<String> getRecipients() {
        return recipients.split(',').collect { it.trim() }
    }
}
