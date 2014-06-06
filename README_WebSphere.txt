======================
Setup WebSphere 7.0.27
======================

1) Configure the DataSource
1.1) Copy the file hsqldb-2.2.9.jar to <WAS_PROFILE>/lib/ext (restart the WAS after that)
1.2) Create a JDBC Provider
	- Name: HSQLDB
	- Implementation Class Name: org.hsqldb.jdbc.pool.JDBCPooledDataSource
1.3) Create a DataSource
	- Name: DefaultDS
	- JNDI Name: jdbc/DefaultDS
	- DataStore Helper: com.ibm.websphere.rsadapter.GenericDataStoreHelper
	- Custom properties
		- user: sa
		- url: jdbc:hsqldb:hsql://localhost/omdb 

2) Create a Queue ConnectionFactory and a Queue
2.1) ConnectionFactory
	- Name: ConnectionFactory
	- JNDI: ConnectionFactory
2.2) Queue
	- Name: ProductPriceUpdateQueue
	- JNDI: queue/ProductPriceUpdateQueue
	
OBS.: You must create a BUS and other JMS settings as default in WebSphere. 

3) Start the HSQLDB Server

java -cp hsqldb-2.2.9.jar org.hsqldb.server.Server --database.0 file:omdb --dbname.0 omdb

4) Configure the WAS port (remote.port) in the file /ordermanager/src/main/resources/META-INF/config/config.properties. 

5) Run the maven clean and package tasks to prepare the WAR

6) Deploy
6.1) Deploy the WAR using the WAS Console
6.2) Configure the attribute "Class loader order" to "parent last" in the EAR and in the WAR

7) Access the application: http://localhost:7001/ordermanager/
