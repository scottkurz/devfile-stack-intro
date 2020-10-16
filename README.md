![](https://github.com/OpenLiberty/open-liberty/blob/master/logos/logo_horizontal_light_navy.png)

# application-stack-intro

This app is a simple but complete JAX-RS sample for use with the Open Liberty application stack. It includes a basic REST API, integration tests, and the MicroProfile Config, Health, and Metrics features.

### Getting Started

1. Clone the application-stack-intro repository

    ```shell
    git clone git@github.com:OpenLiberty/application-stack-intro.git
    cd application-stack-intro
    ```

1. Initialize the project with the java-openliberty stack

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

For more details on using the Open Liberty application-stack, check out https://github.com/OpenLiberty/application-stack

For more details on using odo, check out https://odo.dev
