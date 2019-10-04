#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
${artifactTitle} AEM Base Content
=================================

This package contains all of the initial content that is deployed to new AEM instances.


Deploying
---------

Use the deploy scripts or use the following command

```bash
mvn -Dvault.useProxy=false -DskipTests verify -P turnoffdamworkflow -Dcrx.host=localhost
mvn -Dvault.useProxy=false -DskipTests clean install -P autoInstallPackage -Dcrx.host=localhost
mvn -Dvault.useProxy=false -DskipTests verify -P turnondamworkflow -Dcrx.host=localhost
```

Content Cleaning
---------

Please clean your content when checking it into codebase, use Regex search and replace in the IDE to replace all mathing lines with empty stirg.

You will need to do this couple of time. At very least please remove Account and Unique ID info.


# Replace all identifier attributes these with ""

```
^.+(cq|jcr)\:(createdBy|lastReplicatedBy|lastModifiedBy|lastReplicated|lastReplicationAction|uuid)\=\".+\"\n
^.+(cq|jcr)\:(createdBy|lastReplicatedBy|lastModifiedBy|lastReplicated|lastReplicationAction|uuid)\=\".+\"\>
```

# Remove all system generated attributes

```
^.+(cq|jcr)\:(created|lastReplicated|lastModified|lastReplicationAction|uuid)\=\".+\"\n
^.+(cq|jcr)\:(created|lastReplicated|lastModified|lastReplicationAction|uuid)\=\".+\"\>
```

# Remove all `componentId` instances

```
^.+(componentId)\=\".+\"\n
^.+(componentId)\=\".+\"\>
```
