pipeline {

   agent any

    environment {
         IMAGE = readMavenPom().getArtifactId()
         VERSION = readMavenPom().getVersion()
    }
    stages {

        stage('Build maven') {
            steps {
                sh 'mvn -B -U -DskipTests clean package' 
            }
        }

        stage("Deploy - Producao"){
            when {
                 expression { VERSION ==~  /[0-9]+\.[0-9]+\.[0-9]+/ }
            }
            steps {
                script {
                    sh("eval \$(aws ecr get-login --no-include-email --region us-east-1)")
                    docker.build('${IMAGE}-ms:${VERSION}','--build-arg JAR_FILE=${IMAGE}-ms-${VERSION}.jar .' )
                    docker.withRegistry('https://893634147751.dkr.ecr.us-east-1.amazonaws.com') {
                        docker.image('${IMAGE}-ms:${VERSION}').push('${VERSION}')
                    }
                }
                    sh "sh /home/infotera/kubernetes/ecr-login-google.sh"
                    sh "kubectl set image deployment.v1.apps/tboholiday-deployment tboholiday=893634147751.dkr.ecr.us-east-1.amazonaws.com/${IMAGE}-ms:${VERSION}"
            }
        }

        stage("Deploy - Homologacao"){
            when {
                expression { readMavenPom().getVersion().endsWith("SNAPSHOT") }
            }
            steps {
                sh "docker build --build-arg AMBIENTE=H --build-arg JAR_FILE=${IMAGE}-ms-${VERSION}.jar . -t 127.0.0.1:32000/${IMAGE}-ms:${VERSION}"
                sh "docker push 127.0.0.1:32000/${IMAGE}-ms:${VERSION}" 
                sh "microk8s.kubectl set image deployment.v1.apps/tboholiday-deployment tboholiday=127.0.0.1:32000/${IMAGE}-ms:${VERSION}"
            }

        }

    }
}
