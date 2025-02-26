FROM ubuntu:20.04

RUN apt-get update && apt-get install -y \
    curl \
    git \
    && rm -rf /var/lib/apt/lists/*

COPY ./code-server/redhat-java.vsix /redhat-java.vsix

# Install code-server
RUN curl -fsSL https://code-server.dev/install.sh | sh
RUN code-server --install-extension /redhat-java.vsix

EXPOSE 8080

CMD ["code-server", "--bind-addr", "0.0.0.0:8080"]