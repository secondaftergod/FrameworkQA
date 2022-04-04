
**Generate Allure reports**

`mvn clean test allure:report`


**Run Allure server**

`mvn allure:serve`

**Jenkins**

`/opt/homebrew/opt/openjdk@11/bin/java -Dmail.smtp.starttls.enable=true -jar /opt/homebrew/opt/jenkins-lts/libexec/jenkins.war --httpListenAddress=127.0.0.1 --httpPort=8080`

***Sample commands***:

*Install the latest LTS version:* 
`brew install jenkins-lts`

*Install a specific LTS version:* 
`brew install jenkins-lts@YOUR_VERSION`

*Start the Jenkins service:* 
`brew services start jenkins-lts`

*Restart the Jenkins service:* 
`brew services restart jenkins-lts`

*Update the Jenkins version:* 
`brew upgrade jenkins-lts`