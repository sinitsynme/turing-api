# turing-api
API for Turing Machine

Simple API for Turing Machine with 2 preloaded algorythms: Unary Addition and Unary GCD.

Steps to launch: 
--

With Docker compose
1) Build project with **mvn package**
2) Build image for your project
3) Run **docker compose up -d**
4) The application is started at port 8100!

With local run:
1) Install MongoDB on your PC
2) Configure connection
3) Run app with -dev- profile, ensuring that you have proper configs (check credentials and mongo url)
4) The application is started at port 8080!

API docs can be found at `http://localhost:{port}/swagger`

Frontend implementation:
--
done by [B0gda](https://github.com/B0gda)

Link to the repository: https://github.com/B0gda/TuringMachine
