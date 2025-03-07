#!/bin/bash

rm -rf /results/exp$1

mkdir -p /testing/task
mkdir -p /testing/tests
mkdir -p /config/workspace

cp /templates/exp$1/task/* /config/workspace
cp /templates/exp$1/tests/* /testing/tests

cd /config/workspace

for f in *.java ; 
do tail -n +2 "$f" > "$f.tmp" && mv "$f.tmp" "$f" ; 
done