#!/bin/sh

javac -cp $(find ./lib -name "*.jar" | tr "\n" ":") -d ./classes $(find ./src -name "*.java" | tr "\n" " ")
