FROM ubuntu:20.04

RUN apt-get update && apt-get install -y \
    curl \
    git \
    && rm -rf /var/lib/apt/lists/*

# Install code-server
RUN curl -fsSL https://code-server.dev/install.sh | sh

EXPOSE 8080

CMD ["code-server", "--bind-addr", "0.0.0.0:8080"]