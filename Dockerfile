FROM openjdk:8u212-jre
MAINTAINER ocollado@mimp.gob.pe
COPY "./target/ms-gobierno-backend-1.0.jar" "app.jar"
EXPOSE 7165
#ADD target/ms-gobierno-backend-1.0 ms-gobierno-backend-1.0
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Duser.timezone=America/Lima", "-Xms128m", "-XX:ParallelGCThreads=2", "-XX:CICompilerCount=2", "-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=1", "-jar","app.jar"]