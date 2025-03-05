#!/bin/bash

current_date_time="`date +%Y%m%d%H%M%S`";
echo $current_date_time;

mkdir -p /results/$current_date_time/
mv /results/exp1 /results/$current_date_time/
mv /results/exp2 /results/$current_date_time/