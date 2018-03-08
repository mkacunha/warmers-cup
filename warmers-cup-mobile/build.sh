echo "   *** PULL ***"
git pull origin master
echo "   *** NPM INSTALL ***"
npm install
echo "  *** NG BUILD ***"
ng build --prod
echo "   *** BUILD AND RUN DOCKER CONTAINER ***"
docker stop warmersmobile
docker rm warmersmobile
docker rmi db1/warmersmobile
docker build -t db1/warmersmobile .
docker run -d -p 8086:80 --name warmersmobile db1/warmersmobile
echo "   ***  FINISHED  ***"
