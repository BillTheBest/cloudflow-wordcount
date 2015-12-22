# Cloudflow Wordcount

This is a minimal and ready-to-run application which can be used to start your own Cloudflow pipelines.

More about Cloudflow: https://github.com/genepi/cloudflow

Happy Coding!

## Getting Started

You can clone our example project to test cloudflow:

```shell
git clone https://github.com/genepi/cloudflow-wordcount
```

Next, you have to import the project into Eclipse or you can execute maven to build the jar file:

```shell
cd cloudflow-wordcount
mvn package
```

Maven creates the jar `target/cloudflow-wordcount-hadoop/cloudflow-0.6.0-wordcount.jar`, which includes all dependencies. The job can be execute with the following command:

### Running on MapReduce

```shell
hadoop jar, cloudflow-wordcount.jar mapreduce <hdfs_input> <hdfs_output>
```

### Running on Spark

```shell
/usr/bin/spark-submit --class genepi.cloudflow.examples.WordCount --master yarn cloudflow-wordcount.jar spark <hdfs_input> <hdfs_output>
```

More examples can be found here: https://github.com/seppinho/cloudflow/tree/master/cloudflow/src/cloudflow/examples
