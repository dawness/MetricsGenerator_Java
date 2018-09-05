package com.metric;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.*;
	import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	import com.fasterxml.jackson.databind.ObjectMapper;

	import javax.annotation.PostConstruct;

	@RestController
	@RequestMapping("/metricsgen")
	public class MetricsGenerator {

	    private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();
	    private Map<String,Metrics> metricsMap = new HashMap<>();
	    private static int maximum_opened = 2000;
	    private static int maximum_failed = 500;
	    private static Random randomNumber = new Random();

	    /**
	     * Generate a map of <string,Map<string,Long>>.
	     * The inner map contains the payload.metrics as keys and 0 as values ( parsed from config.file)
	     * The outer map contains path as key.
	     * @throws IOException
	     */
	    @PostConstruct
	    public void init() throws IOException {
	        ObjectMapper jsonMapper = new ObjectMapper();
	        
	        List<Metrics> objList = jsonMapper.readValue( new FileInputStream(System.getProperty("config.file")), new TypeReference<List<Metrics>>() {});
	    //    List<String> pathList=objList.stream().map(a->a.getPath()).collect(Collectors.toList());
	        
	        
	        for(Metrics met : objList) {
	        	
	        	String payLoad= met.getPayload();
	        	List<String > payLoadList = new ArrayList<>();
	        	Collections.addAll(payLoadList, payLoad.split(","));
	        	Map<String,Long> payLoadMap = new HashMap<>();
	        	payLoadMap=payLoadList.stream().map(a->a.split(":")).collect(Collectors.toMap(e->e[0], e->Long.parseLong(e[1].trim())));
	        	met.setPayloadMap(payLoadMap);
	        	metricsMap.put(met.getPath(), met);
	        	
	        }
	/*        Iterator mItr = objList.iterator()
	        while(mItr.hasNext()) {
	            Metrics metrics = (Metrics) mItr.next();
	            Map<String, Long> mMap = new HashMap<>();
	            String[] payloads = metrics.getPayload().split(",");
	            for (int i = 0; i < payloads.length; i++) {
	                String[] payload = payloads[i].split(":");
	                String key = payload[0].trim().replaceAll("\"", "");
	                Long value = Long.parseLong(payload[1].trim());
	                mMap.put(key, value);
	            }
	            metrics.setPayloadMap(mMap);
	            metricsMap.put(metrics.getPath(),metrics);
	        }*/
	        
	        
	        
	         
	    }

	    @RequestMapping("/{metricsName}")
	    public ResponseEntity<?> metricsGen(@PathVariable("metricsName") String metricsName) {

	        if(metricsMap.get(metricsName) == null)
	        {
	            String outStr = "/" + metricsName +" REST end point is not implemented, call received at " + new Date();
	            System.out.println( outStr );
	            return new ResponseEntity<String>( outStr , HttpStatus.OK);

	        }

	        Metrics metrics = metricsMap.get(metricsName);
	        Map<String,Long> mMap = metrics.getPayloadMap();
	        String jsonString = null;
	        try {
	            updateMetricsMap(mMap,metrics.getMetricType(),metrics.getValues());
	            jsonString = new ObjectMapper().writeValueAsString(mMap);
	        }catch(Exception ex)
	        {
	            System.out.println(" exception at converting map to jsonString is : " + ex.getMessage());
	            
	            throw new Error ();
	        }

	        return new ResponseEntity<String>( jsonString , HttpStatus.OK);
	    }

	    private  void updateMetricsMap(Map<String,Long> mMap,String metricsType,String valueType)
	    {
	        Iterator keys = mMap.keySet().iterator();

	        while(keys.hasNext())
	        {
	            String key = (String)keys.next();
	            Long value = mMap.get(key).longValue();
	            Long newValue = generateNewValue(key,valueType);
	            if(metricsType.equalsIgnoreCase("gauge"))
	                mMap.replace(key,newValue);
	            if(metricsType.equalsIgnoreCase("counter"))
	                mMap.replace(key,value+newValue);
	            else
	                mMap.replace(key,newValue);
	        }

	    }

	    private Long generateNewValue(String key,String valueType)
	    {
	        Long tempvalue=0L ;
	        if(valueType.contains("constant"))
	        {
	           tempvalue = Long.parseLong(valueType.trim().split(" ")[1]);
	        }
	        if(valueType.contains("random"))
	        {
	            if(key.contains("MediaOpened"))
	                tempvalue = randomNumber.longs(maximum_failed, maximum_opened).findFirst().getAsLong();
	            else
	                tempvalue =  randomNumber.longs(0,maximum_failed).findFirst().getAsLong();
	        }
	        return tempvalue;
	    }
	}



