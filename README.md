# BlablaDocs #
*Please Visit*
  * Sources: https://github.com/slimee/blabla
  * Javadoc: [http://blabladoc.github.io/apidocs/index.html](https://slimee.github.io/blabladoc.github.io/apidocs)
  * test Javadoc: [http://blabladoc.github.io/testapidocs/index.html](https://slimee.github.io/blabladoc.github.io/testapidocs)
  * Project infos: [http://blabladoc.github.io](https://slimee.github.io/blabladoc.github.io/)
  * Docker hub: [blabla docker hub](https://cloud.docker.com/u/blueforest/repository/docker/blueforest/blabla)

# Description #
blabla is a repo containing java sources for a monolith app that mow lawns with:
  * domains to model the business
  * factories to create beans
  * commands to run the worlds
  * controllers to orchestrate commands

  * You MUST provide a --file argument with the path of [the file you want to use](https://github.com/slimee/blabla/blob/master/simple.world).
  * The file MUST be well formatted with the WorldMowerFormat.

It's based on spring boot, it contains some integration and unit tests.

# How to test ?! #
When BlablaMowerApplication is a spring boot app that will read the file pass and log the Mow result.

## With docker ##
With docker, go fast

  * Get a file with content like in [sample.world](https://github.com/slimee/blabla/blob/master/simple.world)
  * Run the following after replacement of "*/path/to*" by your sample.world file path
  
```
docker run -v /path/to/sample.world:/sample.world blueforest/blabla:1 --file=/sample.world
```

## From sources ##
From sources, go fast too with jdk and maven :)

```
git clone https://github.com/slimee/blabla.git 
cd blabla
mvn install
java -jar target/blablamower-0.0.1.jar --file=sample.world
```
