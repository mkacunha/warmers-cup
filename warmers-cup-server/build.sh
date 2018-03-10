echo "   *** PULL ***"
git pull origin master
echo "   *** BUILD AND RUN DOCKER CONTAINER ***"
docker login
docker rmi mkacunha/warmersserver
docker build -t mkacunha/warmersserver .
docker push mkacunha/warmersserver
echo "   ***  FINISHED  ***"
