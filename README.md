# Experiment

## Prerequisites

### Requestly

The browser extension [Requestly](https://chromewebstore.google.com/detail/requestly-free-api-testin/mdnleldcmiljblolnjhpnblkcekpdkpa?hl=en) should be installed, and two Header-modification rules should be added.

- Remove response header "content-security-policy"
- Remove response header "x-frame-options"

This is necessary for the iframes to work.

### OpenAI API Key

The system running this should have a .env file in the root folder with an environment variable like this: `OPENAI_API_KEY=<key here>`.
