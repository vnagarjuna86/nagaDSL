def call(details = "", FwdJobOwner... teams) {
    def recipients = teams.collect { it.getRecipients() }.flatten().join(',')
    recipients = recipients ?: ['infra']
     
    def emailRecipients = recipients.collect { "${it}@forwardnetworks.com" }    
    def emailBody = "Build URL: " + env.Build_URL + '\n\n'
    emailBody += details
 
    mail(to: emailRecipients,
         subject: "Build failed in Jenkins: ${currentBuild.projectName} ${currentBuild.fullDisplayName}",
         body: emailBody)
}
