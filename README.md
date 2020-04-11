# Archetype Project

[![build_status](https://github.com/aem-design/aemdesign-archetype/workflows/ci/badge.svg)](https://github.com/aem-design/aemdesign-archetype/actions?workflow=ci)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=design.aem%3Aaemdesign-archetype&metric=alert_status)](https://sonarcloud.io/dashboard?id=design.aem%3Aaemdesign-archetype)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/design.aem/aemdesign-archetype/badge.svg?magic)](https://maven-badges.herokuapp.com/maven-central/design.aem/aemdesign-archetype)
[![github license](https://img.shields.io/github/license/aem-design/aemdesign-archetype)](https://github.com/aem-design/aemdesign-archetype) 
[![github issues](https://img.shields.io/github/issues/aem-design/aemdesign-archetype)](https://github.com/aem-design/aemdesign-archetype) 
[![github last commit](https://img.shields.io/github/last-commit/aem-design/aemdesign-archetype)](https://github.com/aem-design/aemdesign-archetype) 
[![github repo size](https://img.shields.io/github/repo-size/aem-design/aemdesign-archetype)](https://github.com/aem-design/aemdesign-archetype) 
[![github repo size](https://img.shields.io/github/languages/code-size/aem-design/aemdesign-archetype)](https://github.com/aem-design/aemdesign-archetype) 
[![github release](https://img.shields.io/github/release/aem-design/aemdesign-archetype)](https://github.com/aem-design/aemdesign-archetype)


This project is used to create a new aem-design project base

This base can be updated by generating an archetype from existing project and copying relevant parts to this project.


## To use
To create a new project base framework from scratch follow these steps:


* Install the archetype to your local .m2 repo. Ensure you are in this `aemdesign-archetype` directory.
```
cd aemdesign-archetype
mvn install
```
* Use this archetype to generate a new project framework. Ensure you are in this `aemdesign-archetype` directory.
Edit `groupId`, `package` and `artifactId` to be specific to your project. 
```aidl
mkdir test-structure
cd test-structure
mvn archetype:generate \
  -DarchetypeGroupId=aemdesign \
  -DarchetypeArtifactId=aemdesign-archetype \
  -DarchetypeVersion=0 \
  -DgroupId=design.aem \
  -Dpackage=aemdesign-aem \
  -DartifactId=aemdesign-parent
```

You should now have a base maven project within `test-structure` that can be used as a starting point for your new aemdesign project.

```
cd aemdesign-parent
chmod +x deploy-local
```

Below `deploy-local` command builds and deploys, created aemdesign-parent project to local AEM author instance. Make sure you have local AEM Instance upon running.

```
./deploy-local
```

This should build and deploy, your project successfully to local AEM Instance.

**NOTE: We need Yarn to be installed for `compose` submodule build.
      Check if Yarn v1.7.0 is installed** 
      
```
yarn -version
```

If `yarn` is not installed, run the below command.

```
brew install yarn
```

### Full Process

Following is the process of how to use this archetype to create a new project and run post creation tasks.

This process will create a new base project for you, rename it to parent convention, init git and update all scripts to be executable.

1. Create base project

```bash
mvn archetype:generate \
    -DarchetypeGroupId=design.aem \
    -DarchetypeArtifactId=aemdesign-archetype \
    -DarchetypeVersion=1.0.22 \
    -DgroupId=au.com.projectx.aem \
    -DgroupTitle="ProjectX AEM" \
    -DartifactId=projectx \
    -DartifactTitle="ProjectX AEM" \
    -DparentArtifactId=projectx-parent \
    -DparentArtifactName="ProjectX :: AEM :: parent" \
    -Dpackage=projectx \
    -DpackageGroup=projectx \
    -Dversion=0.1 \
    -DcomponentGroupTitle=ProjectX \
    -DappsFolderName=projectx \
    -DcontentFolderName=projectx \
    -DconfFolderName=projectx \
    -DclientLibsFolderName=projectx \
    -DclassNamespace=au.com.projectx.aem \
    -DappsParent=aemdesign
```

2. Rename generated project folder to parent

```bash
mv projectx projectx-parent
cd projectx-parent
```

3. Init git with initial content and create first Tag to allow automated project versioning to work.

```bash
git init
git add .
git commit -m init
git tag -a 0.1 -m init
```

4. Update script permissions

```bash
find . -type f  -name "deploy" -exec chmod +x {} \;
find . -type f  -name "deploy-*" -exec chmod +x {} \;
find . -type f  -name "test-spec*" -exec chmod +x {} \;
find . -type f  -name "install" -exec chmod +x {} \;
find . -type f  -name "package" -exec chmod +x {} \;
find . -type f  -name "pull" -exec chmod +x {} \;
find . -type f  -name "stats" -exec chmod +x {} \;
find . -type f  -name "seleniumhub-*" -exec chmod +x {} \;
```

5. Package project to test everything

```bash
./package
```



## Generate Archetype from existing project
To generate an updated archetype based on existing maven project run the following command from the parent repo

```bash
mvn archetype:create-from-project
```

This will generate new archetype content in target directory. This process can be done ongoing or at the end of the project copying across relevant and optimal things that are good as a starting point for a project.


    
### Available properties

groupId                 | Maven GroupId                 | Type                          | Example                       | Default     |
------------------------|-------------------------------|-------------------------------|-------------------------------|-------------|
groupId                 | Base Maven groupId            | namespace                     | au.com.aemdesign              | design.aem  |
groupTitle              | group title                   |                               |                               | AEM.Design  |
artifactId              | ArtifactId prefix             | simple name                   | aemdesign                     | aemdesign   |
artifactTitle           | artifact title                | title                         |                               | ${artifactId} |
parentArtifactId        | parent artifact id            | simple name                   | aemdesign                     | ${artifactId}-parent |
parentArtifactName      | parent artifact name          | simple name                   | aemdesign                     | ${groupId} :: ${artifactId} :: parent |
package                 | Java Source Package           | simple name                   | aemdesign                     | ${artifactId} |
packageGroup            | Content Package Group name    | simple name                   |                               | ${groupTitle} |
version                 | Version                       | version                       | 0.1-SNAPSHOT                  | 0.1-SNAPSHOT |
componentGroupTitle     | componentGroup for component  | title                         | AEM Design                    | ${groupTitle} |
appsParent              | /apps folder for inherited components    | simple name                   | aemdesign          | aemdesign   |
appsFolderName          | /apps folder name             | simple name                   | aemdesign                     | ${artifactId} |
contentFolderName       | /content folder name          | simple name                   | aemdesign                     | ${artifactId} |
confFolderName          | /conf folder name             | simple name                   |                               | ${artifactId} |
clientLibsFolderName    | /etc/clientlibs folder name   | simple name                   |                               | ${artifactId} |
classNamespace          | namespace for classes         | namespace                     |                               | ${artifactId} |


# Post Generate Task

After you have generated your new project run the following command to set execute permissions for scripts

```bash
find . -maxdepth 2 -type f  -name deploy -o -name deploy-* -o -name install -o -name build -o -name package -o -name serve -o -name pull -o -name stats -o -name watch | xargs -I{} chmod +x {}
```

# Versioning

## Git Describe

To test git versioning run

`git describe`

this will show you generated version message with latest tag and how many commits since tag.

If you get an error:

`fatal: No annotated tags can describe`

create or overwrite an existing tag with a message:

`git tag 1.0 1.0^{} -f -m "initial tag"`

## Version Convention
Version numbers should follow semver format:

 * MAJOR version when you make incompatible API changes,
 * MINOR version when you add functionality in a backwards-compatible manner, and
 * PATCH version when you make backwards-compatible bug fixes.

Please use MAJOR and MINOR version in Tags, PATCH version will be automatically added as a commit count since the last tag using the git describe.

## Version Meaning
Version `1.0.3-SNAPSHOT` means that current checkout has uncommitted changes
Version `1.0.3` means that current checkout does not have uncommitted changes and is 3 commits ahead of the tag `1.0`

## Version Number Commits
You do not need to commit POM files with venison numbers as they will be generated.

## Minimal core artifacts required for providing overridable AEM components.

Supporting content for AEMDesign development and maintenance.

## To build
To ensure the project builds correctly locally run:

`mvn -Dvault.useProxy=false -DskipTests -e -U clean package`

## To deploy
To build and deploy the project to your local aem instance (default localhost:4502), in the project root run:

`./deploy-local`


## To create a release
Releases are managed via the maven plugins `versions-maven-plugin` and `maven-scm-plugin`

Version numbers should follow the [SemVer](https://semver.org/) convention.

### The release process
#### Prepare release branch
In preparation for a release, create a new git release branch from the current master snapshot branch:
 1. Create a new release branch.
    * `mvn scm:branch -Dbranch=release/<version> -Dmessage="creating release branch <version>"`
 2. Ensure you are on the new release branch.
    * `git checkout release/<version>`
 3. Update the maven `version` parameter.
    * `mvn versions:set -DnewVersion=<version>`
 4. Check the version number was correctly applied and confirm.
    * `mvn versions:commit -Pdeploymentpackage`
 5. Commit the updated version numbers to the release branch.
    * `mvn scm:checkin -Dmessage="updating version numbers"`

#### Release new version
Once the testing cycle has been completed and all code fixes have been applied to the remote release branch, we create a git tag of our version and deploy the maven `aemdesign-aem-core` artifact to the remote maven repository and merge our release to master branch.
 1. Ensure we are on the release branch for [aemdesign-aem-core](https://github.com/aem-design/aemdesign-aem-core).
 2. Raise a Gitlab Merge Request from the relase branch to master branch, adding the necessary reviewers.
 3. Create the git tag.
    * `mvn scm:tag -Dtag="<version>"`
 4. Deploy the maven release artifacts to the remote maven repository
    * `<ToDo>`
 5. Accept the [aemdesign-aem-core](https://github.com/aem-design/aemdesign-aem-core) Merge Request and delete the release branch.
 6. Update the `Release history` section in this readme with details of the new release.


## Release history
| Version   | Release Date  | Features                      |
|: ---------|:-------------:| :----------------------------:|
| 1.0       | 12/09/2018    | Initial release after refactor|
|           |               |                               |
|           |               |                               |
|           |               |                               |
