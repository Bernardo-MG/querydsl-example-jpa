# Usage

The project includes tests showcasing how to query with Querydsl.

## Database support

Three databases are used to test the queries:

- h2
- Mysql
- Postgres

These, except for h2, should be started before running the tests. Which can be done with Docker:

```
docker-compose -f docker/docker-compose.yml --project-name querydsl-example-jpa up
```

## Running the queries

There is a profile for each database:

- h2
- mysql
- postgres

Just run the tests with the profile desired:

```
mvn clean verify -Pmysql
```
