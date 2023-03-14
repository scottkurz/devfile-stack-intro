<!-- PROJECT LOGO -->

<p align="center">
  <a href="https://openliberty.io/">
    <img src="https://openliberty.io/img/spaceship.svg" alt="Logo">
  </a>
</p>
<p align="center">
  <a href="https://openliberty.io/">
    <img src="https://github.com/OpenLiberty/open-liberty/blob/master/logos/logo_horizontal_light_navy.png" alt="title" width="400">
  </a>
</p>
<br />

[![License](https://img.shields.io/badge/License-ASL%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)

# devfile-stack-intro

This app is a simple but complete JAX-RS sample for use with the Open Liberty application stack. It includes a basic REST API, integration tests, and the MicroProfile Config, Health, and Metrics features.

### Getting Started

> It's recommended to use the latest version of OpenShift Do (odo). You can install odo using [these instructions](https://odo.dev/docs/getting-started/installation)

1. Perform an `oc login` to your cluster.

1. Clone the devfile-stack-intro repository

    ```shell
    git clone git@github.com:OpenLiberty/devfile-stack-intro.git
    cd devfile-stack-intro
    ```


1. Create your odo component

    ```shell
    odo create java-openliberty my-component
    ```

1. Push the sample application to OpenShift

    ```shell
    odo push
    ```
1. Wait for tests to complete

    ```shell
    odo log -f
    ```

For more details on using the Open Liberty devfile stack, check out https://github.com/OpenLiberty/devfile-stack

For more details on using odo, check out https://odo.dev
