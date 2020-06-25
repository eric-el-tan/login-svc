#!/bin/bash --login
#
# build login-svc
#mvn clean package -Dmaven.test.skip=true
mvn clean package

# remove the container
docker rm -f login-svc
echo "docker container removed."

# build the image
docker build -f DockerFile -t android/login-svc .
echo "docker image built."

# run the image as container
docker run -d -it --name login-svc -p 8080:8080 android/login-svc
echo "docker container executed."

# health check
sleep 10
docker logs login-svc --tail 1000
sleep 5
curl -o out.json http://localhost:8080/login/hello
echo $(cat out.json)
#rm out.json
#sleep 5
#curl -o out.json http://localhost:8080/swagger-ui.html#/login
#cat out.json
rm out.json
echo "docker health checked."
