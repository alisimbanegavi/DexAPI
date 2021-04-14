TO RUN DEX:

Set data source to an (empty) local database of your choice (in "application.properties")
If you don't have an empty database ready:
This app will auto-generate a database called "db"
Database will contain tables "catalogue", "collection", "item", and "users" as defined in Entity package
All join tables are also defined (users_catalogue, catalogue_collection, collection_item)
Can run script 'create-user-database.sql' for test database to create itself!
Update application.properties with your custom database link, local username, and password
Run AppLauncher and enjoy
If you get errors starting up/initializing, it probably has to do with dependency importing issues

Try to copy and paste all files into new project as Spring Boot application and add framework support for:

Spring Web
SQL support
Spring JDBC
Spring JPA
Can also try to build from 'pom.xml' configuration file

JSON DATA TEMPLATES CONTAINED IN EACH CONTROLLER FILE FOR METHODS THAT TAKE A REQUEST BODY AS INPUT*