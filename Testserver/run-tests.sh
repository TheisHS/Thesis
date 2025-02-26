#!/bin/bash

rm -rf /testing/task/*
cp /config/workspace/* /testing/task

javac /testing/task/*.java
javac /testing/tests/*.java
java /testing/task/Main