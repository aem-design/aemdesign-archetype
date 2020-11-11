
 Start-Process mvn -NoNewWindow -Wait -ArgumentList "-Dvault.useProxy=false", "-DskipTests", "-e", "-U", "clean", "package"
