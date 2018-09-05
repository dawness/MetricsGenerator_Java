package com.metric;
	
	


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



	public class Metrics {

	    private String path;
	    private Map<String,Long> payloadMap = new HashMap<>();
	    private String metricType;
	    private String payload;
	    private String values;

	    public String getValues() {
	        return values;
	    }

	    public void setValues(String values) {
	        this.values = values;
	    }

	    public String getPath() {
	        return path;
	    }

	    public void setPath(String path) {
	        this.path = path;
	    }

	    public String getMetricType() {
	        return metricType;
	    }

	    public void setMetricType(String metricType) {
	        this.metricType = metricType;
	    }

	    public String getPayload() {
	        return payload;
	    }

	    public void setPayloadMap(String payload) {
	        this.payload = payload;
	    }


	    public Map<String,Long> getPayloadMap() {
	        return payloadMap;
	    }

	    public void setPayloadMap(Map<String,Long> payloadMap) {
	        this.payloadMap = payloadMap;
	    }
	    @Override
	    public String toString()
	    {
	        return  " Path :" + path + " \n" +
	                " Payload : " + payload + "\n" +
	                " metricType : " + metricType ;
	    }

	    
	    public static void main(String[] args) {
	    	
	    	String str="news";
	    	str=str.substring(0,3);
	    	System.out.println(str);
	    	
	    }
	    
	 /*   	String payLoad= "\"FailureRateDeviceAssetClass.STB-XG2V2.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass.STB-Xg1.Linear.gauge.xuaMediaOpened\": 0";, 	   
	    List<String> list =new ArrayList<>();
	    		Collections.addAll( list, payLoad.split(","));
	    		
	    Map<String,String> map = new HashMap<>();
	   map = list.stream().map(a-> a.split(":")).collect(Collectors.toMap(e->e[0],e->e[1]));
	  map.entrySet().stream().forEach(a-> System.out.println(a.getKey()+ "    "+ a.getValue()  ));
	   
	    		
	  //  		list.stream().forEach(System.out::println);
	    	
//	    	List<String> list = new inputArrayList<>();
//	    	Collections.addAll(list, payLoad.split(","));
//	    	
//	    	Map <String,String> map =list.stream().map(a-> a.split(":")).collect(Collectors.toMap(e->e[0], e->e[1]));
//	    	map.entrySet().stream().forEach(a->System.out.println(a.getKey() + "   " + a.getValue()));  
	 


	    }

	    
	 
	}
	
	



