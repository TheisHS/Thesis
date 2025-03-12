#!/bin/bash

rm -rf /testing/task/*
cp /config/workspace/* /testing/task

cd /testing/task
for f in *.java ; 
do sed -i '1ipackage task;' $f ; 
done

cd /testing
javac /testing/task/*.java
javac /testing/tests/*.java
java tests.Main