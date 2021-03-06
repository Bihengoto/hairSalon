# Barber Salon

It is a spark application that allows salon owners to manage stylists and clients.
Users can add, update, delete and assign clients to stylists. 
Additionally, they can add, update and delete client information.

## List Of Contributors

Isaac Bihengoto

## Setup/Installation Requirements

Follow the following setup instructions to run the program.:

1.Open your terminal

2.Install the java software development kit (sdk), java and gradle respectively

3.Git clone https://github.com/Bihengoto/hairSalon.git

4.cd into the cloned directory and open with preferred java text editor

5.To run the program in the terminal you can use 'gradle run' command

## Dependencies

1. Java

2. Gradle

3. Postgres

## Technologies used

1.JDK

2.Junit testing framework

3.Java

4.SDK

5. HTML

6. CSS

7. Postgres(psql)


## Database

```
In PSQL:

     CREATE DATABASE hair_salon;
     CREATE TABLE stylists(id int,name varchar,gender varchar,age int,email varchar);
     CREATE TABLE clients(id int,name varchar,gender varchar,phone varchar,email varchar,stylistid int);
```

## Known Bugs
NO known bugs as at the moment please reach to us if you see any.


## Support and Contact Details

For more information on the application or if you may come across any issues you can contact me via email at isaacbihengoto@gmail.com

### License
*Hero Squad was released under [MIT](LICENSE)