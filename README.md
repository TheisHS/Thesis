# Experiment

## How to run

1. Install the requirements with

   ```sh
   pip install -r lsl-server/requirements.txt
   ```

2. Set the environment variables for the oTree image in `docker-compose.yml`.

   - `PID`: The participant ID number. This defines the order of the tasks and AI-assistance.
   - `DEBUG`: Toggles the debug mode. This defines whether continue buttons are available in the user interface.

3. Run the `lsl-server` and docker containers

   ```sh
   python lsl-server/server.py
   docker compose up --build
   ```

## Components

- `code-server`

  This is the server for self-hosting VS Code inside a Docker container. By doing this, we are able to remove the headers that disallows us from embedding it in an iframe. It also allows us to pre-install the redhat.java extension and a JDK.

- `exp-server`

  This is a Python flask server, which acts as an endpoint, responsible for the behind-the-scenes actions for the experiment, such as running tests, setting the experiements up, and sending requests to the OpenAI API.

- `java-src`

  This directory contains the Java tasks for the experiment, including the UML diagrams and tests for the tasks.

- `lsl-server`

  This is a Python flash server, which handles the collection and streaming of Lab-Streaming-Layer (LSL) events. This must be run locally on the host machine for LabRecorder to capture the stream.

- `otree`

  This is the client, which manages the user interface that the experiment.

- nginx

  We use nginx as a reverse proxy to remove the headers for the `code-server` and to redirect requests within the docker network to the `lsl-server`, which runs on the host machine.

## Prerequisites

### Python and Docker

This experiment requires Python>=v3 and Docker.

### Requestly

The browser extension [Requestly](https://chromewebstore.google.com/detail/requestly-free-api-testin/mdnleldcmiljblolnjhpnblkcekpdkpa?hl=en) should be installed, and two Header-modification rules should be added.

- Remove response header "content-security-policy"
- Remove response header "x-frame-options"

This is necessary for the iframes to work.

### OpenAI API Key

The system running this should have a .env file in the root folder with an environment variable like this: `OPENAI_API_KEY=<key here>`.
