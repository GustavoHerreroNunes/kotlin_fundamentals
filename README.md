# android_codespace_test
Testing codespace configurations and resources to create a Android Developer

## Executing
Sequence of cmd-line commands:
```shell
gradlew installDebug
adb logcat MainActivity:I AddTaskActivity:I AddUserActivity:I ConsultUserActivity:I *:F -v color;breif -d
```