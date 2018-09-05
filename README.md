"# MyProjects" 


# MetricsGenerator
Metrics generator 

## Overview
 This tool generates  metrics values based on the provided configuration file and expose them as a REST service. 

## How to use it

  The tool can be customized using two configuration files
  
* -- application.properties : defines the runtime configurations like server.port and server.address
  * -- server.port=8082
  * -- server.address=localhost
  
* -- metrics.config  : defines the behavior of the application. This file contains an array of json elements, each entry 
 contains the following 4 elements
   * -- path : the REST endpoint for this set of metrics
   * -- payload : the metrics name and value( default to 0). This a json string and can contain n number of metrics.
   * -- metricType : the metric type to be used ( currently supports counter and gauge). 
       * The counter gives a cumulative sum of the values on each invocation
       * The gauge returns a new value each time.
   * -- values : the values to be populated, 
       * random - a random value will be generated on each invocation
           * If the metricType is counter, increment by the random number on each invocation.
           * If the metricType is gauge,return the random number on each invocation.
       * constant <#Number#> - a constant value will be generated on each invocation.
           * If the metricType is counter, increment by the constant number on each invocation.
           * If the metricType is gauge,return the constant number on each invocation.
       
 
