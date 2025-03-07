#!/bin/bash

mkdir -p /results/exp$1
cp /config/workspace/* /results/exp$1
rm -rf /config/workspace/*

rm -rf /testing/task/*
rm -rf /testing/tests/*