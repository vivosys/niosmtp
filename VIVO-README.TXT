vivosys repository: git://github.com/vivosys/niosmtp.git
URL https://github.com/vivosys/niosmtp

1. Add upstream repository

    git add upstream git@github.com:normanmaurer/niosmtp

2. On MacOSX the tests may hang.  Skip the tests on the Mac while deploying

    REPO_ID=vivosys-repo
    REPO_URL=https://tools.vivosys.com/artifactory/ext-release-local
    mvn \
      -Dgpg.skip -DskipTests=true \
      -DaltDeploymentRepository=$REPO_ID::default::$REPO_URL \
       source:jar javadoc:jar install deploy
