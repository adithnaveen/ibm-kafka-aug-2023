# System Requirement

## System with 8 GB
- Hypervisor Support to test with docker
- abount 50 GB free space
- Operating System Mac / Windows / Linux
- Open internet access

-------
## Step 1

Download and install jdk 11 for your respective OS(Mac/Win/Linux) - https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html


## Step 2

Download Kafka from - https://downloads.apache.org/kafka/3.4.1/kafka_2.12-3.4.1.tgz Extract with softwares like 7 zip / win zip etc

- Note Windows Users: install wsl2 first - https://docs.microsoft.com/en-us/windows/wsl/install

- To install wsl
- wsl --install


## Step 3

Add Kafka to system path - kafka_2.13-3.1.0/bin
Additional Softwares

- Docker - https://www.docker.com/products/docker-desktop/
- Eclipse JEE - https://www.eclipse.org/downloads/packages/
- install MySQL - https://dev.mysql.com/downloads/installer/



# Day 1 

## introcution 

- Debalaya Bohdhak -  I'm a very new in it also. I got to know about kalfka, and as I am in testing and want to expand my knowledge and expertise in the field.

- Deepak Kamde - working with oracle project, join iBM as fresher from 2017, OUTA for automation, to learn more, and see how it is useful, Automation Test enginerr 

- Deepak Lalu - 13 years exp, UFT, SELENIUM, Soap UI, want to learn kafka, the project is in microservices, doing contract testing. 

- Fathima  Shifana- joined IBM - 2 years, working as performance testing, new to kafka, in there project currently kafkaa is beeing used 

- Gauresh Kumar - 10 years exp worked on middleware, cucumber, soap ui, want to learn kafka test + add skills to resume 

- Lingaraj Reddy - 15 + Yrs Exp. Working as Test Lead . Want to know the More about Kafka Tool & Kafka Testing .

- Madhurima Saha - with ibm 10+, manual and automation, with selenium currently with fedility to know how kakfa is working as ESB, specflow, working with kafka for first time, to know the way how kafka can help in testing, and enhance the way how it is done .

- Mandala Snehitha - 6.5 year exp, with ibm 1 year, nasco, API Tester (tosca), new to kafka, to know how kafka can be used in testing 

- Prashanth Sahoo - 14 years with IBM, expertise with telco, banking etc have worked with automation and testing, to work for microservices for the project, looking for insight on how kafka can help in project 

- Radha siddheshwar - 10+ years in automation UFT, Selenium etc API testing, on bench, interested in learning kafka 

- Sanjeet das - 12 years exp, new to kafka, know the ESB, now more middle ware testing, work with use cases / common use cases 

- Somnath ghost - 13 years with ibm, specialist in API testing, worked with kafka, soap arch (soA), postman, after 2013 did not use, trying to refreshing 

- Sruthi s - 10 years in testing, api testing, jmeter, soap ui, rest assured etc, want to work with ESB + explore more 

- Vani Pratyusha - 16 years exp, with  IBM 8 year, test management, have working with manual + automation, selenium, soap ui, want to learn messaging system 






### 

- Verticle Scaling (Monolithic)
    - DAO 
        - login system 
        - stock 
        - accounts 
        - purchases 
        - discounts 
        - vouchers 
        - audit 
        - ..... 
- Horizaontal Scaling 
    - microservices 
        - they keep ther services in different locations 


- ESB (Enterprise Service Bus)
    - Tibco 
    - open mq 
    - rabbit mq 
    - mulesoft 
    - kafka 
        - does not belive - producer - consumer - it has the confirmation of the message is taken or not 
        - instead publisher - subscriber - it does not have the confirmation of the message is taken or not 



###  where kafka is used in MS Arch 
    - discovery service + api
    - in between MS 
    - 


## working with kafka 

### - start zookeeper 


```
 ./zookeeper-server-start.sh ../config/zookeeper.properties 

```

### start kafka 
```
 ./kafka-server-start.sh ../config/server.properties 
```
### list kafka topics 
```
  kafka-topics.sh --bootstrap-server localhost:9092 --list
```
### create a topic

 ```
- kafka-topics.sh --bootstrap-server localhost:9092 --topic first-topic --create

- kafka-topics.sh --bootstrap-server localhost:9092 --topic second-topic --create
```

### create a producer 

```
 kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first-topic
```
- you can type messages 

### create a consumer

```
- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic 

- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic --from-beginning

```
### describe the topic 
```
 kafka-topics.sh --bootstrap-server localhost:9092 --topic partition-topic-1 --describe 
```

### create topic with partition 

```
 kafka-topics.sh --bootstrap-server localhost:9092 --topic partition-topic-1 --create --partitions 3 
```

## to create replica factor of 2 (but note this will not work since we have single broker)

```
- kafka-topics.sh --bootstrap-server localhost:9092 --topic topic-with-partition-repl --create --partitions 3 --replication-factor 2 
```
###  you can have defaultly 2 partition 
- goto server.properties edit num.partitions=1 -> num.partitions=2 
(note: please stop kafka broker and start again)



###  Segment size 
- 50 for 3 chars it takes 

- Hi - 1 segment  
- bye - 1 segment 
- Deb ala ya -  3 segments 



- Best Fit  - hi (0.66) of the segment - which is very difficult 
- First Fit - any body who wants the data just block multiples of segment (5) - preferred -> scala -> java 
- Worst Fit - find multiple chunks of segment blocks and hop (bye) (0.45 and 0.55)



# Day 2 


## topics for the day 

- map (key / value )
    - hi (producer) -> hi (consumer) 
    - key,value -> key and value 

```
 -- to start producer with key/value pair  and seperator 
    > kafka-console-producer.sh --bootstrap-server localhost:9092 --topic first-topic --property parse.key=true --property key.separ
ator=:
```

```
    greet: hi 
    null:hi
```

 - in java 
    ```
        int n; 
        String s; 
        Integer nn; 
    ```

```
    - to use formatter in the consumer 

    >  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic --formatter  kafka.tools.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true

      >  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first-topic --formatter  kafka.tools.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true --from-beginning 
```

- Consumer groups 
    - by default kafka-console-consumer is single consumer it is possible for you to have group of consumer and call it as consumer groups 
    - pls ensure to have more than 2 partitions for the benefit of the consumer groups 
    - code section 

```
        > kafka-topics.sh --bootstrap-server localhost:9092  --topic topic-partition-3 --create --partitions 3
        ```
        --  
```

```
        > kafka-topics.sh --bootstrap-server localhost:9092 --topic topic-partition-3 --describe
```

        > kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-partition-3 --group second-application


- Reset offsets 



```
        - to reset the offset to earliest dry run 
   
        > kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --to-earliest --dry-run --topic topic-partition-3

```

        - to reset the offset to earliest execute

        > kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --to-earliest --execute --topic topic-partition-3
```
- code snippet output 

-  kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --to-earliest --dry-run --topic topic-partition-3

GROUP                          TOPIC                          PARTITION  NEW-OFFSET     
first-application              topic-partition-3              0          0              
first-application              topic-partition-3              1          0              
first-application              topic-partition-3              2          0              
$ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --to-earliest --execute --topic topic-partition-3

GROUP                          TOPIC                          PARTITION  NEW-OFFSET     
first-application              topic-partition-3              0          0              
first-application              topic-partition-3              1          0              
first-application              topic-partition-3              2          0              
$ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --describe                                                       

Consumer group 'first-application' has no active members.

GROUP             TOPIC             PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
first-application topic-partition-3 0          0               17              17              -               -               -
first-application topic-partition-3 1          0               10              10              -               -               -
first-application topic-partition-3 2          0               15              15              -               -               -
 



- reset by -5 and +2 
 $ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --shift-by -5 --execute --topic topic-partition-3 

GROUP                          TOPIC                          PARTITION  NEW-OFFSET     
first-application              topic-partition-3              0          12             
first-application              topic-partition-3              1          5              
first-application              topic-partition-3              2          10             
$ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --describe                                                       

Consumer group 'first-application' has no active members.

GROUP             TOPIC             PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
first-application topic-partition-3 0          12              17              5               -               -               -
first-application topic-partition-3 1          5               10              5               -               -               -
first-application topic-partition-3 2          10              15              5               -               -               -
$ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --reset-offsets --shift-by 2 --execute --topic topic-partition-3

GROUP                          TOPIC                          PARTITION  NEW-OFFSET     
first-application              topic-partition-3              0          14             
first-application              topic-partition-3              1          7              
first-application              topic-partition-3              2          12             
$ kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group first-application --describe                                                      

Consumer group 'first-application' has no active members.

GROUP             TOPIC             PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG             CONSUMER-ID     HOST            CLIENT-ID
first-application topic-partition-3 0          14              17              3               -               -               -
first-application topic-partition-3 1          7               10              3               -               -               -
first-application topic-partition-3 2          12              15              3               -               -               -

    ```
```

## to read from partituclar partition 
```
    > kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-partition-3 --partition 0 

```




- using  Kafka with Java (Programming language)
    - in java project pom.xml -> project object model 
    - all the artefacts for project will be kept inside ~/. -> home directory of user 



# Day 3 


- grafana / ELK 
- case study (wiki...)
    - java program 
- single zookeeper multi cluster 

    ```
        - Steps for setting up multi cluster broker 

        - Step 1 : Start Zookeeper - 2181 
        - Step 2 : make a copy of server.properties to server1.properties, server2.properties
        - Step 3 : Open file server.properites, port - 9092, broker.id=0, log.dirs=/tmp/kafka-logs-ibm-aug-2023-1
        - Step 4 : Open file server1.properites, port - 9093, broker.id=1, log.dirs=/tmp/kafka-logs-ibm-aug-2023-2
        - Step 5 : Open file server2.properites, port - 9094, broker.id=2, log.dirs=/tmp/kafka-logs-ibm-aug-2023-3
        - Step 6 : Start kafka cluster with server.properties >  ./kafka-server-start.sh ../config/server.properties 
        - Step 7 : Start kafka cluster with server1.properties >  ./kafka-server-start.sh ../config/server1.properties 
        - Step 8 : Start kafka cluster with server2.properties >  ./kafka-server-start.sh ../config/server2.properties 
        - Step 9 : create a topic for with partitions and replica 

            > kafka-topics.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic topic-with-partition-repl --create --partitions 3 --replication-factor 3

            > kafka-topics.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic topic-with-partition-repl --describe 

        - Step 10 : Create a producer 
            > kafka-console-producer.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic topic-with-partition-repl

        - Step 11 : Create a consumer 
            > kafka-console-consumer.sh --bootstrap-server localhost:9092,localhost:9093,localhost:9094 --topic topic-with-partition-repl --from-beginning 
    ```

- Kafka with KRaft 
- Case study driven - DB (Mysql), Selenium - POM, Kafka 

