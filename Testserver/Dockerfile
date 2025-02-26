# Testserver/Dockerfile
FROM ubuntu:20.04

WORKDIR /app

COPY . .
RUN apt-get update && apt-get install -y python3 python3-pip && rm -rf /var/lib/apt/lists/*
ARG DEBIAN_FRONTEND=noninteractive
RUN pip install flask 
RUN apt-get update && apt-get install -y openjdk-11-jdk && rm -rf /var/lib/apt/lists/*

EXPOSE 5000

CMD ["python3", "testserver.py"]