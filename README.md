# CodeValidationPipeline

A starter Java 17 + Maven project with a Jenkins Declarative Pipeline.

## Pipeline stages
1. **Checkout** — checks out the configured source repository.
2. **Validate** — checks the Maven project configuration.
3. **Compile** — compiles the Java source.
4. **Test** — runs JUnit tests and publishes test results in Jenkins.
5. **Package** — creates the JAR.
6. **Post actions** — archives the JAR on success and reports the outcome.

## Prerequisites
- Jenkins with Pipeline and JUnit plugins installed.
- A build agent with a POSIX shell, Java 17, and Maven available.
- Jenkins tools configured with the exact names `JDK17` and `Maven3`
  under **Manage Jenkins → Tools**.
- This project committed to a Git repository if using `checkout scm`.

## Create the Jenkins job
1. Push this folder to a Git repository.
2. In Jenkins, select **New Item**.
3. Enter `CodeValidationPipeline`.
4. Select **Pipeline**, then click **OK**.
5. Under **Pipeline**, choose **Pipeline script from SCM**.
6. Select **Git**, enter your repository URL and credentials if required.
7. Set **Branch Specifier** (for example, `*/main`) and **Script Path** to `Jenkinsfile`.
8. Save and click **Build Now**.

## Run locally
From the project directory, run:

```bash
mvn clean test package
```

If your Jenkins agent is Windows, replace the `sh` steps in the Jenkinsfile with
the equivalent `bat` commands.
