if [ $(ps aux | grep 'selenium-server-standalone-2.24.1.jar -role hub' | grep -v grep | wc -l | tr -s "\n") -eq 0 ];
then . ~/projects/olly-selenium/functional-tests/scripts/term.sh -x java -jar ~/projects/olly-selenium/functional-tests/selenium-server-standalone-2.24.1.jar -role hub;
sleep 5s;
fi

if [ $(ps aux | grep 'selenium-server-standalone-2.24.1.jar -role node' | grep -v grep | wc -l | tr -s "\n") -eq 0 ];
then . ~/projects/olly-selenium/functional-tests/scripts/term.sh -x java -jar ~/projects/olly-selenium/functional-tests/selenium-server-standalone-2.24.1.jar -role node -Dwebdriver.chrome.driver="src/test/resources/chromedriver" -hub http://localhost:4444/grid/register -browser browserName=firefox,maxInstances=5,platform=MAC -browser browserName=chrome,maxInstances=5,platform=MAC;
sleep 10s;
fi