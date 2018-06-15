# EnergyBot-Challenge

Create an application that which loads the following weather recordings file from NOAA and provides an API(REST) to lookup data at a station using station id.

You can develop the application using Java / JavaScript / Kotlin or Golang. Please feel free to use a polyglot approach.
 
ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/by_year/2017.csv.gz
ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/readme.txt

How to run

1. Please download the file ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/by_year/2017.csv.gz and place in \src\main\resources path
2. Install Mysql 5.6 and create a database Weather2017 using:

create database Weather2017;
3. Modify application.properties file in \src\main\resources:

update the Mysql connection string for your local system
4. run the project as spring boot application.
5. got to localhost:8080/welcome 
6. the Application will keep streaming the data for 2017 into the mysql database in the background which will take some time, as the time goes the data will keep increasing in the database, it takes almost 3 hours to stream 30 million records into mysql database.

How to deploy on docker container

1. Make sure docker engine is running in your system.
2. use below comand to download a mysql database image.

docker pull mysql
3. run the image using below command:
docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=Admin123 -e MYSQL_DATABASE=Weather2017 -e MYSQL_USER=uday -e MYSQL_PASSWORD=Admin123 -d: mysql:5.6
4. Modify application.properties file in \src\main\resources:

update the Mysql connection string for your docker, replace hostname with mysql-standalone
