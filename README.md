# SOFTENG 206 - EscAIpe Room
Project for SOFTENG 206 (Software Engineering Design 1) in Part II of our Software Engineering degree @ The University of Auckland.

# Project Video
https://github.com/tonylxm/escAIpe-room-game-potioncraft/assets/126369686/1ddb7d3c-7d89-45e7-be2a-f0fe0ace8ab5

# Developers:
- Adam Bodicoat
- Tony Lim
- Andy Zhang

### Built With
- Java
- JavaFX
- CSS

## Project Requirements
- Design your own escape room and riddles to solve
- Riddles and interactions must be generated programmatically by GPT
- Presence of an intelligent 'Game Master' utilising OpenAI's API
- Incorporate text-to-speech for accessibility
- Application menu with difficulty levels and time limits
- Inclusion of randomness in game design for replayability

## To setup OpenAI's API

- add in the root of the project (i.e., the same level where `pom.xml` is located) a file named `apiproxy.config`
- put inside the credentials that you received from no-reply@digitaledu.ac.nz (put the quotes "")

  ```
  email: "upi123@aucklanduni.ac.nz"
  apiKey: "YOUR_KEY"
  ```
  these are your credentials to invoke the OpenAI GPT APIs

## To setup codestyle's API

- add in the root of the project (i.e., the same level where `pom.xml` is located) a file named `codestyle.config`
- put inside the credentials that you received from gradestyle@digitaledu.ac.nz (put the quotes "")

  ```
  email: "upi123@aucklanduni.ac.nz"
  accessToken: "YOUR_KEY"
  ```

 these are your credentials to invoke GradeStyle

## To run the game

`./mvnw clean javafx:run`

## To debug the game

`./mvnw clean javafx:run@debug` then in VS Code "Run & Debug", then run "Debug JavaFX"

## To run codestyle

`./mvnw clean compile exec:java@style`
