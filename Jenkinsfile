stage 'Test and Package'
node {
  checkout scm
  sh "mvn -B clean test package"
}

stage 'approve'
input message: 'Do you want to deploy?'

stage 'deploy'
node {
  sh "echo 'Deploying'"
  sh "ls -alh"
  sh "ls -alh application"
}
