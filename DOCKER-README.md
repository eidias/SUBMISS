### Building docker images

* Edit settings on folder SUBMISS/tools/karaf_etc
* Update firstname/surname/keypass SUBMISS/tools/scripts/init.sh

Build image

```sh
$ docker build -t SUBMISS .
```

Or if you want to run the database and the app :

* Login to your gitlab docker repo by using your user name and gitlab personal access token [https://docs.github.com/en/github/authenticating-to-github/creating-a-personal-access-token] :

```sh
$ docker login https://docker.pkg.github.com -u YOUR_USERNAME 
```

After login, run below command to start the submiss server.

```sh

$ docker-compose up -d
```