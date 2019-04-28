# rmi-server-client-basics


To run in console (Windows 10 64 bit, JDK11)
1. Run 2 command prompt consoles in client and server //src/ folders
2. Execute cmd prompt commands:
SET PATH=%PATH%D:\Program Files\Java\jdk-11.0.2\bin

javac RMIServer.java
javac RMIClient.java

java -Djava.security.policy=srv.policy RMIServer //172.0.0.1/rmi1
java -Djava.security.policy=srv.policy RMIServer //172.0.0.1/rmi2
java -Djava.security.policy=srv.policy RMIServer //172.0.0.1/rmi3

java RMIClient //127.0.0.1/rmi1 //127.0.0.1/rmi2 //127.0.0.1/rmi3
