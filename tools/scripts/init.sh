#!/usr/bin/env bash

#printf %"$(tput cols)"s |tr " " "-"
#echo "Please enter your First name :"
#read firstName

#printf %"$(tput cols)"s |tr " " "-"
#echo "Please enter your Surname :"
#read surName

#printf %"$(tput cols)"s |tr " " "-"
#echo "Please enter your Key Password :"
#read keyPass

firstName=ahmed
surName=rizawan
keyPass=thunder.32

getFirstChar=$(echo "${firstName}" | head -c1)
submissNSurname=$getFirstChar$surName

mkdir -p /app/configs

keytool -genkey -noprompt \
 -alias submiss_$submissNSurname \
 -keyalg RSA \
 -keysize 2048 \
 -dname "CN=localhost, OU=ID, O=IBM, L=Hursley, S=Hants, C=GB" \
 -keystore /app/configs/keystore.jks \
 -storepass $keyPass \
 -keypass $keyPass

echo "Key Generated"

keytool -noprompt -storepass $keyPass -keypass $keyPass  -export -keystore /app/configs/keystore.jks -alias submiss_$submissNSurname -file /app/configs/submiss_$submissNSurname.cer

echo "Cert Generated"

echo "org.apache.ws.security.crypto.merlin.keystore.type=jks" > /app/configs/submiss-sp.properties
echo "org.apache.ws.security.crypto.merlin.keystore.password=$keyPass" >> /app/configs/submiss-sp.properties
echo "org.apache.ws.security.crypto.merlin.keystore.alias=submiss_$submissNSurname" >> /app/configs/submiss-sp.properties
echo "org.apache.ws.security.crypto.merlin.keystore.file=/app/configs/keystore.jks" >> /app/configs/submiss-sp.properties