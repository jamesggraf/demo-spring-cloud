stage 'Test and Package'
node {
  checkout scm
  sh "mvn -B clean test package"
  archive 'application/rest/target/template-rest-*'
}

stage 'approve'
input message: 'Do you want to deploy?'

stage 'input'
input message: 'Where should this be deployed?', parameters: [[$class: 'StringParameterDefinition', defaultValue: '', description: '', name: 'HOSTNAME'], [$class: 'StringParameterDefinition', defaultValue: '', description: '', name: 'PORT_NUMBER'], [$class: 'CredentialsParameterDefinition', credentialType: 'com.cloudbees.plugins.credentials.common.StandardCredentials', defaultValue: '', description: '', name: 'CREDENTIALS', required: false]]

stage 'deploy'
node {
  sh "echo 'Deploying to ${env.HOSTNAME}:${PORT_NUMBER} using ID: ${CREDENTIALS}'"
  sh "ls -alh"
  sh "ls -alh application"
}
