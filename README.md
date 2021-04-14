TO RUN DEX:

1)  Log into MySQL server
2)  Set data source to an (empty) local database of your choice (in "application.properties")
  _-If you don't have an empty database ready, this app will auto-generate a database which will contain tables "catalogue", "collection", "item", and "users" as defined in Entity package
  - All join tables are also defined (users_catalogue, catalogue_collection, collection_item)
3) Update application.properties with your custom database link, and local username and password you used to log into your server
4) Run AppLauncher and enjoy

! If you get errors starting up/initializing, it probably has to do with dependency importing issues
  -Try to copy and paste all files into new project as Spring Boot application and add framework support for:
    -MySQL support
    -Spring Web
    -Spring JDBC
    -Spring JPA
    -Spring Security
  -Can also try to build from 'pom.xml' configuration file
