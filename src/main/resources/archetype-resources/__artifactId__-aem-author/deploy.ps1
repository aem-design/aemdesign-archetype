$SCRIPT_URI = "https://github.com/aem-design/aemdesign-docker/releases/latest/download/project-deploy.ps1"

. ([Scriptblock]::Create((([System.Text.Encoding]::ASCII).getString((Invoke-WebRequest -Uri "${SCRIPT_URI}").Content))))
