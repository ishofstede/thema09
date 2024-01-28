# Introduction to Machine Learning (Java Wrapper)

Hanzehogeschool Groningen: Bioinformatics Project Year 3, Period 9

Creating a Java Wrapper around a machine learning model to classify birds based on bone measurements.

This application was created to make classifying instances with a created machine learning model easier. The final result is a standalone Java Archiver (.jar) application that can be used from the command line.

# Data 
The data consists of bone measurement of differnt bird types and was taken from Kaggle; Bird bones and habitats: Kaggle bird dataset, "Birds bones and Living Habitats" data set, Retrieved from
https://www.kaggle.com/datasets/zhangjuefei/birds-bones-and-living-habits 

# Repository File Structure

```bash
├───.gradle
├───.idea
├───build
└───src
    ├───main
    │   ├───java
    │   │   └───nl
    │   │       └───bioinf
    │   │           └───ishofstede
    │   │               └───thema09
    │   └───resources
    └───test
        ├───java
        └───resources
```
## .gradle files
These files create the structure of the project, they are used by Gradle to include and use the correct dependencies and build the final .jar.

## src/main/
This branch contains the main classes for the build. 

## resources
This directory contains models and datasets that are required for the project to function. 

# Usage 
To run the program you need to build a jar and shadowJar file by in the right corner Gradle/build/jar or Gradle/build/shadowJar. The program needs two arguments which are two .csv files and are provided in the data folder. clean_bird.csv and unknown.csv.

Run the following on the commandline:
java -jar ./build/libs/wrapper-1.0-SNAPSHOT-all.jar -f ./build/resources/main/clean_bird.csv -u ./build/resources/main/unknown.csv

If one of the arguments is missing it gives you the next outcome:
Parsing failed! As a result of an error: No csv file is provided with unknown instances

usage: java -jar .build/libs/wrapper/JavaWrapper-1.0-SNAPSHOT-all.jar [options]
* -f,--file The input file with the known classes of the instances
* -h,--help Displays the help for the command line arguments
* -u,--unknown The input file of the unknown classes of the instances
* inputFile: ./build/resources/main/unknown.csv
* unknownInputFile = null

# rebuilding the jar
When a working IntelliJ project has been created with Gradle structure a vertical Gradle button should be on the right side of the application.
Then with Tasks > shadow > shadowJar a jar can be created that has all the dependencies included in it, enabling for standalone use.

# contact
Isabella Hofstede
ishofstede@st.hanze.nl 
