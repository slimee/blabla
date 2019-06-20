# Description #
blabla is a repo containing ann app that mow lawns.

It's based on spring boot.


# Docker Hub #
A docker image is available here:

https://cloud.docker.com/u/blueforest/repository/docker/blueforest/blabla


# How to test ? #

## With docker ##
With docker, go fast

  * Get a file with content like in [sample.world](https://github.com/slimee/blabla/blob/master/simple.world)
  * Run the following after replacement of "*/path/to*" by your sample.world file path
  
```
docker run -v /path/to/sample.world:/sample.world blueforest/blabla:1 --file=/sample.world
```

## Building from sources with maven ##
From sources, go fast too with jdk and maven :)

```
git clone https://github.com/slimee/blabla.git 
cd blabla
mvn install
java -jar target/blablamower-0.0.1.jar --file=sample.world
```

BlablaMowerApplication will start (it's a spring boot one) check the file you pass and log the result.
