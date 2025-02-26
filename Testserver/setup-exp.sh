#!/bin/bash

rm -rf /config/results/exp$1

mkdir -p /testing/task
mkdir -p /testing/tests

cp /templates/exp$1/task/* /config/workspace
cp /templates/exp$1/tests/* /testing/tests
