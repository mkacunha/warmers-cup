echo "   *** PULL ***"
git pull origin master
echo "   *** NPM INSTALL ***"
npm install
echo "  *** NG BUILD ***"
ng build --prod
echo "   *** BUILD AND RUN DOCKER CONTAINER ***"
docker stop warmersmobile
docker rm warmersserver
docker rmi db1/warmersserver
docker build -t db1/warmersserver .
docker run -d -p 8789:8080 --name warmersserver db1/warmersserver
echo "   ***  FINISHED  ***"
