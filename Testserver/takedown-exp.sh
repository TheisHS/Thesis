#!/bin/bash

mkdir -p /config/results/exp$1/task
cp /config/workspace/* /config/results/exp$1/task
rm -rf /config/workspace/*

mkdir -p /testing/task/*
mkdir -p /testing/tests/*