PROJECT="$1"

if  [ "$PROJECT" != "" ] && [ "$PROJECT" != "common" -a "$PROJECT" != "message" -a "$PROJECT" != "web" ] ;
then
	echo "error parameters : $PROJECT" 
	exit ;
fi


cd coder-common
mvn clean install -Dmaven.test.skip=true
cd ../coder-message
mvn clean install -Dmaven.test.skip=true

if [ $PROJECT != "" ] ; then
	cd ../coder-$PROJECT
	mvn clean package -Dmaven.test.skip=true
else	
	cd ../coder-web;
	mvn clean package -Dmaven.test.skip=true
fi




