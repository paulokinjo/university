
# Docker
```
$ docker run --restart=always -d --name couchbase -p 8091-8094:8091-8094 -p 11210:11210 couchbase:community-6.0.0
```

# Couchbase
## _design/student
- all
```
Map
function (doc, meta) {
  if(doc._class == 'com.uni.university.model.student.Student') { 
  	emit(meta.id, null);
  }
}
```

- byFullName 
```
Map
function (doc, meta) {
  if(doc._class == "com.uni.university.model.student.Student") {
  	emit(doc.fullName, null);
  }
}
```

- countByFullName
```
Map
function (doc, meta) {
  if(doc._class == "com.uni.university.model.student.Student") {
  	emit(doc.fullName, null);
  }
}

Reduce (built in: _count, _sum, _stats)
function(keys, values, reduce) {
  return values.length;
}
```

-



# Couchbase -> SpringBoot
- CouchbaseClusterConnector
- CouchbaseEnvironmentConfigurer
- CouchbaseBucketConfig

## Troubleshooting
```
org.springframework.data.couchbase.core.CouchbaseQueryExecutionException: Unable to execute query due to the following n1ql errors: 
{"msg":"No index available on keyspace university that matches your query. Use CREATE INDEX or CREATE PRIMARY INDEX to create an index, or check that your expected index is online.","code":4000}
```

Solution:
```
CREATE PRIMARY INDEX `university-primary-index` ON `university` USING GSI;
```

# References
https://start.spring.io