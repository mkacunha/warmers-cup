echo "   *** PULL ***"
git pull origin master
echo "   *** NPM INSTALL ***"
npm install
echo "  *** NG BUILD ***"
ng build --prod
echo "   *** BUILD AND PUSH DOCKER CONTAINER ***"
docker login
docker rmi mkacunha/warmersmobile
docker build -t mkacunha/warmersmobile .
docker push mkacunha/warmersmobile
