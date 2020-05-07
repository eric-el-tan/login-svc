#!/bin/bash --login
#
# deploying login-svc

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
docker logs login-svc --tail 1000
curl -o out.json http://localhost:8080/login/hello
cat out.json
#rm out.json
curl -o out.json http://localhost:8080/swagger-ui.html#/login
cat out.json
echo "docker health checked."
rm out.json