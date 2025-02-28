# Experiment

## Prerequisites

### Requestly

The browser extension [Requestly](https://chromewebstore.google.com/detail/requestly-free-api-testin/mdnleldcmiljblolnjhpnblkcekpdkpa?hl=en) should be installed, and two Header-modification rules should be added.

- Remove response header "content-security-policy"
- Remove response header "x-frame-options"

This is necessary for the iframes to work.
