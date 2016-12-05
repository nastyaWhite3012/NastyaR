#!/bin/bash
echo "Starting VM."
vagrant up
echo "VM is up."
vagrant ssh -c 'sudo sh /vagrant/finalProject.sh; /bin/bash'--wait-exit

echo "Test"
cd
cd C:\Users\HP\vagrant-lamp-wordpress\finalProject
mvn test
