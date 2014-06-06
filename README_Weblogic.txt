=====================
Setup WebLogic 10.3.6
=====================

1) Enable JPA in WebLogic
- Include the following definition in commEnv.sh

export PRE_CLASSPATH=/home/user/Oracle/Middleware/modules/javax.persistence_1.1.0.0_2-0.jar:/home/user/Oracle/Middleware/modules/com.oracle.jpa2support_1.0.0.0_2-1.jar

Reference: http://docs.oracle.com/cd/E23943_01/web.1111/e13720/using_toplink.htm#EJBAD1311 


2) Configure the DataSource

2.1) Copy the file hsqldb-2.2.9.jar to <WL_DOMAIN>/lib  (restart the server after that)
2.2) Create the file <WL_DOMAIN>/config/jdbc/DefaultDS-jdbc.xml with the following content

<?xml version='1.0' encoding='UTF-8'?>
<jdbc-data-source xmlns="http://xmlns.oracle.com/weblogic/jdbc-data-source" xmlns:sec="http://xmlns.oracle.com/weblogic/security" xmlns:wls="http://xmlns.oracle.com/weblogic/security/wls" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.oracle.com/weblogic/jdbc-data-source http://xmlns.oracle.com/weblogic/jdbc-data-source/1.2/jdbc-data-source.xsd">
  <name>DefaultDS</name>
  <jdbc-driver-params>
    <url>jdbc:hsqldb:hsql://localhost/omdb</url>
    <driver-name>org.hsqldb.jdbcDriver</driver-name>
  </jdbc-driver-params>
  <jdbc-data-source-params>
    <jndi-name>jdbc/DefaultDS</jndi-name>
    <global-transactions-protocol>OnePhaseCommit</global-transactions-protocol>
  </jdbc-data-source-params>
</jdbc-data-source>

2.3) Change the file <WL_DOMAIN>/config/config.xml to include a reference to the DataSource and disable that WebLogic 
enforce the revalidation of credentials in basic-auth

<domain>
  <security-configuration>
	...

    <enforce-valid-basic-auth-credentials>false</enforce-valid-basic-auth-credentials>
  </security-configuration>

  ...
  <jdbc-system-resource>
    <name>DefaultDS</name>
    <target>AdminServer</target>
    <descriptor-file-name>jdbc/DefaultDS-jdbc.xml</descriptor-file-name>
  </jdbc-system-resource>
</domain>

3) Create a Queue ConnectionFactory and a Queue
3.1) ConnectionFactory
	- Name: ConnectionFactory
	- JNDI: ConnectionFactory
3.2) Queue
	- Name: ProductPriceUpdateQueue
	- JNDI: queue/ProductPriceUpdateQueue
	
OBS.: You must create a BUS and other JMS settings as default in WebSphere. 

4) Start the HSQLDB Server

java -cp hsqldb-2.2.9.jar org.hsqldb.server.Server --database.0 file:omdb --dbname.0 omdb

5) Configure the WAS port (remote.port) in the file /ordermanager/src/main/resources/META-INF/config/config.properties. 

6) Run the maven clean and package tasks to prepare the WAR

7) Deploy the WAR using the Console

8) Access the application: http://localhost:7001/ordermanager/

