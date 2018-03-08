echo "   *** PULL ***"
git pull origin master
echo "   *** NPM INSTALL ***"
npm install
echo "  *** NG BUILD ***"
ng build --prod
echo "   *** BUILD AND RUN DOCKER CONTAINER ***"
docker stop warmersng
docker rm warmersng
docker rmi db1/warmersng
docker build -t db1/warmersng .
docker run -d -p 8085:80 --name warmersng db1/warmersng
echo "   ***  FINISHED  ***"
