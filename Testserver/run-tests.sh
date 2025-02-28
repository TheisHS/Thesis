#!/bin/bash

rm -rf /testing/task/*
cp /config/workspace/* /testing/task

cd /testing
javac /testing/task/*.java
javac /testing/tests/*.java
java task.Main