Adding Continuous Testing to Maven
==================================

This fork of maven-scala-plugin adds continuous testing; like SBT's "~ test" or "~ test-only *FooTest" goals.

To use it do a local build, make sure your project depends on the latest snapshot of maven-scala-plugin then you can do the following...

Using Continuous Testing
------------------------

To run all tests in a project whenever the code changes just do the following...

    mvn scala:cctest

if you want to run only certain tests whenever the code changes try

    mvn scala:cctest -Dtest=MyTest

which would run all tests containing MyTest in the name in any package


Notes
-----

To get useful output when tests fail (like SBT does by default) please make sure you have configured the surefire plugin
to set **useFile** to false then you get a reasonable report on the console of failures.

e.g.


      <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
          <forkMode>once</forkMode>
          <useFile>false</useFile>
        </configuration>
      </plugin>