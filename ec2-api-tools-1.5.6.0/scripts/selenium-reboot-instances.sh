export EC2_SCRIPTS_HOME="$HOME/projects/olly-selenium/ec2-api-tools-1.5.6.0/scripts"

source $EC2_SCRIPTS_HOME/ci-instances.sh

export EC2_HOME="$HOME/projects/olly-selenium/ec2-api-tools-1.5.6.0"
DEV_EC2_PRIVATE_KEY="$HOME/projects/olly-selenium/ec2-api-tools-1.5.6.0/keys/pk-DWK4K3PULDLH4BHUNRDCV5YIAAAP3KEN.pem"
DEV_EC2_CERT="$HOME/projects/olly-selenium/ec2-api-tools-1.5.6.0/keys/cert-DWK4K3PULDLH4BHUNRDCV5YIAAAP3KEN.pem"

function wait-for-instance-to-stop {
  while ! $EC2_HOME/bin/ec2-describe-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $1 | grep -q stopped; do
    echo "Waiting for $2 instance to stop..."
    sleep 5
  done
  echo "Instance $2 stopped"
}

$EC2_HOME/bin/ec2-stop-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_HUB_INSTANCE_ID $SELENIUM_RC_1_INSTANCE_ID $SELENIUM_RC_2_INSTANCE_ID $SELENIUM_RC_3_INSTANCE_ID $SELENIUM_RC_4_INSTANCE_ID $SELENIUM_RC_5_INSTANCE_ID

wait-for-instance-to-stop $SELENIUM_HUB_INSTANCE_ID "Selenium Hub"
wait-for-instance-to-stop $SELENIUM_RC_1_INSTANCE_ID "Selenium Webdriver 1"
wait-for-instance-to-stop $SELENIUM_RC_2_INSTANCE_ID "Selenium Webdriver 2"
wait-for-instance-to-stop $SELENIUM_RC_3_INSTANCE_ID "Selenium Webdriver 3"
wait-for-instance-to-stop $SELENIUM_RC_4_INSTANCE_ID "Selenium Webdriver 4"
wait-for-instance-to-stop $SELENIUM_RC_5_INSTANCE_ID "Selenium Webdriver 5"

$EC2_HOME/bin/ec2-start-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_HUB_INSTANCE_ID
$EC2_HOME/bin/ec2-associate-address -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_HUB_ELASTIC_IP -i $SELENIUM_HUB_INSTANCE_ID

$EC2_HOME/bin/ec2-start-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_1_INSTANCE_ID
$EC2_HOME/bin/ec2-associate-address -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_1_ELASTIC_IP -i $SELENIUM_RC_1_INSTANCE_ID

$EC2_HOME/bin/ec2-start-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_2_INSTANCE_ID
$EC2_HOME/bin/ec2-associate-address -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_2_ELASTIC_IP -i $SELENIUM_RC_2_INSTANCE_ID

$EC2_HOME/bin/ec2-start-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_3_INSTANCE_ID
$EC2_HOME/bin/ec2-associate-address -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_3_ELASTIC_IP -i $SELENIUM_RC_3_INSTANCE_ID

$EC2_HOME/bin/ec2-start-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_4_INSTANCE_ID
$EC2_HOME/bin/ec2-associate-address -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_4_ELASTIC_IP -i $SELENIUM_RC_4_INSTANCE_ID

$EC2_HOME/bin/ec2-start-instances -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_5_INSTANCE_ID
$EC2_HOME/bin/ec2-associate-address -K $DEV_EC2_PRIVATE_KEY -C $DEV_EC2_CERT $SELENIUM_RC_5_ELASTIC_IP -i $SELENIUM_RC_5_INSTANCE_ID
~                                                                                                                                         
