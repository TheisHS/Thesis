#!/bin/bash

mkdir -p /config/results/exp$1/task
cp /config/workspace/* /config/results/exp$1/task
rm -rf /config/workspace/*

rm -rf /testing/task/*
rm -rf /testing/tests/*