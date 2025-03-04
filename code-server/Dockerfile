# code-server/Dockerfile
FROM lscr.io/linuxserver/code-server:latest

RUN apt-get update && apt-get install -y \
    openjdk-11-jdk

RUN chmod 777 -R /config

EXPOSE 8443