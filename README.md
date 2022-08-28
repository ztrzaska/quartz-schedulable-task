# Quartz schedulable engine with jobs parameterized from database

### Getting Started

Implementation of quartz scheduler by retrieving cron descriptions from database. End customer can simple change cron's parameters by changing field in database.

At startup few jobs are created with data from initialization sql script. The mechanism is conditional on property. It can be enabled/disabled if needed.

### Conditional enabling schedulable jobs
```
@ConditionalOnProperty(name = "quartz.enabled")
```

### Initializing jobs from database

```
INSERT INTO BATCH_PROCESS(ID, TYPE, CRONE) values (1, 'READ_CUSTOMERS', '0/5 * * * * ?');
INSERT INTO BATCH_PROCESS(ID, TYPE, CRONE) values (2, 'READ_PRODUCTS', '0/11 * * * * ?');
INSERT INTO BATCH_PROCESS(ID, TYPE, CRONE) values (3, 'CREATE_FEES', '0 45 10 * * ?');
INSERT INTO BATCH_PROCESS(ID, TYPE, CRONE) values (4, 'CREATE_CONTRIBUTIONS', '0 0 11 * * ?');
```



### Reference Documentation
For further reference, please consider the following sections:

* [Quartz documentation](http://www.quartz-scheduler.org/documentation/)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)

