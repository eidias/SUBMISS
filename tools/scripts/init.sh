#!/usr/bin/env bash

printf %"$(tput cols)"s |tr " " "-"
echo "Please enter your First name :"
read firstName

printf %"$(tput cols)"s |tr " " "-"
echo "Please enter your Surname :"
read surName

printf %"$(tput cols)"s |tr " " "-"
echo "Please enter your Key Password :"
read keyPass

getFirstChar=$(echo "${firstName}" | head -c1)
submissNSurname=$getFirstChar$surName

keytool -genkey -noprompt \
 -alias submiss_$submissNSurname \
 -keyalg RSA \
 -keysize 2048 \
 -dname "CN=localhost, OU=ID, O=IBM, L=Hursley, S=Hants, C=GB" \
 -keystore keystore.jks \
 -storepass $keyPass \
 -keypass $keyPass

echo "Key Generated"

keytool -noprompt -storepass $keyPass -keypass $keyPass  -export -keystore keystore.jks -alias submiss_$submissNSurname -file submiss_$submissNSurname.cer

echo "Cert Generated"

echo "org.apache.ws.security.crypto.merlin.keystore.type=jks" > ../configs/submiss-sp.properties
echo "org.apache.ws.security.crypto.merlin.keystore.password=$keyPass" >> ../configs/submiss-sp.properties
echo "org.apache.ws.security.crypto.merlin.keystore.alias=submiss_$submissNSurname" >> ../configs/submiss-sp.properties
echo "org.apache.ws.security.crypto.merlin.keystore.file=$(pwd)/keystore.jks" >> ../configs/submiss-sp.properties