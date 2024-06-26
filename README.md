# android_codespace_test
Testing codespace configurations and resources to create a Android Developer

## Executing
Sequence of cmd-line commands:
```shell
gradlew installDebug
adb logcat AppTest:I *:S -v color;breif -d
```