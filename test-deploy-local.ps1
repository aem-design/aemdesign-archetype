echo "GENERATE NEW PROJECT"
mvn clean integration-test

cd ./target/test-classes/projects/basic/project/aglenergy

echo "INIT GIT"
git init
git add .
git commit -m init
git tag -a 0.1 -m init

echo "DEPLOYING PACKAGE THE LOCAL"
./deploy-local.ps1

echo "DONE"
cd -
