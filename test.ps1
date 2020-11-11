echo "GENERATE NEW PROJECT"
mvn clean integration-test
echo "PACKAGE THE OUTPUT"
Invoke-Expression "./target/test-classes/projects/basic/project/projectx/package.ps1"
