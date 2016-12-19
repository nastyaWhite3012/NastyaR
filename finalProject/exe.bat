#!/bin/bash
echo "Starting VM."
vagrant up
echo "VM is up."
vagrant ssh -c 'sudo sh /vagrant/finalProject.sh; /bin/bash'--wait-exit
echo "Test"
cd
cd .\finalProject
mvn test