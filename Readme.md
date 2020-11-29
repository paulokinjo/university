
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

# References
https://start.spring.io