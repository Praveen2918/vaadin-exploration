# Vaadin Upload

This is project to make hands dirty in Vaadin Upload component.Also allow upload component to capture photos for uploading.

## Running the application

- `git clone https://github.com/Praveen2918/vaadin-upload.git`
- From Terminal - mvn spring-boot:run
- In browser open url `http://localhost:9090/zio-dm/`

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different 
IDEs](https://vaadin.com/docs/latest/flow/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `mvn clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/myapp-1.0-SNAPSHOT.jar`

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/components/vaadin-app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Useful links

- Vaadin upload component - `https://vaadin.com/docs/latest/ds/components/upload/`
- `https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/capture`
- `https://caniuse.com/html-media-capture`
- `https://vaadin.com/docs/latest/flow/production/production-build`