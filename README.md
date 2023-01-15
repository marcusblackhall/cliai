# Ai Search Runner

This project uses picocli to create a command that allows execution of an OpenAi request. 
OpenAi requires you to register and obtain an Api key. To run a request using this app you will need to set a system variable AI_API_KEY to the value
you have in your OpenAi account.

## Usage
To display help on how to run the app type the following in a command line

```shell
java -jar target/aicli.jar -h 
```

## Example usage 
```shell 
java -jar target/aicli.jar -p "Suggest the best snooker players of all time"
```
## Create an executable
To create a windows executable using GraalVm execute

```shell
mvn package -Pnative
```

## Screen recording of usage

[![asciicast](https://asciinema.org/a/551799.svg)](https://asciinema.org/a/551799)
