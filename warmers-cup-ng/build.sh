echo "   *** PULL ***"
git pull origin master
echo "   *** NPM INSTALL ***"
npm install
echo "  *** NG BUILD ***"
ng build --prod
echo "   *** BUILD AND PUSH DOCKER CONTAINER ***"
docker login
docker rmi mkacunha/warmersng
docker build -t mkacunha/warmersng .
docker push mkacunha/warmersng
echo "   ***  FINISHED  ***"
