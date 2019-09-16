Prerequisite :
1. JDK 1.8
2. Maven 3.5 <=

Installation :
1. Create jar :
   mvn clean compile package

2. For create response time statistics run this command :
   cd ~/dkatalis.assessment.storeload/target
   java -cp dependency-jars/spf4j-core-8.6.10.jar:dependency-jars/args4j-2.33.jar:dependency-jars/slf4j-api-1.7.21.jar:dependency-jars/trove4j-3.0.3.jar:dependency-jars/guava-27.1-jre.jar:dependency-jars/avro-1.9.0.10p.jar:dkatalis.assessment.storeload.jar org.spf4j.stackmonitor.Monitor -df /Users/anovandri/Documents/Me/DKatalis/coding-assessment/dkatalis.assessment.storeload/target/ -dp spf4j-performance-monitoring -ss -si 100 -main  com.dkatalis.assessment.storeload.App

3. Open spf4j tools monitoring
   cd ~/dkatalis.assessment.storeload/target
   java -cp dependency-jars/spf4j-ui-8.6.10.jar:dependency-jars/slf4j-api-1.7.21.jar org.spf4j.ui.Explorer

4. Open file ~/dkatalis.assessment.storeload/target/*.tsdb2 for time statistics
   Open file ~/dkatalis.assessment.storeload/target/*.ssdump2 for thread related
