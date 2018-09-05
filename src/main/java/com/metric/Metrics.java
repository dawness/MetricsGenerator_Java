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
	    
	 /*   	String payLoad= "\"FailureRateDeviceAssetClass_comcast.STB-XG2V2.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Android.VOD.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XG2V2.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XI5.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-IOS.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-RNG150.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XG2V2.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XID.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XG1V4.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-IOS.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Desktop.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XID.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XG1V4.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-IOS.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Android.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XG1V4.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Desktop.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1v3.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XID.cDVR.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XI5.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XI5.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Android.cDVR.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XI6.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xi3.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xi3.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-IOS.VOD.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-IOS.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Desktop.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XID.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XI5.VOD.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1v3.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1v3.cDVR.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XG1V4.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Android.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XID.Linear.gauge.xuaMediaFailed\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XI5.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1v3.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-Xg1v3.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Desktop.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-RNG150.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-XG2V2.VOD.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.STB-RNG150.cDVR.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Android.Linear.gauge.xuaMediaOpened\": 0, \"FailureRateDeviceAssetClass_comcast.cDVR-X2-Android.Linear.gauge.xuaMediaFailed\": 0";
	   
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
	    	int[] inputArray = {1,4,6,10,2};
	    int a=	avoidObstacles(inputArray);
	    	System.out.println(a);
	    	
	    	questionCorrectionBot(" ahis isn't a relevant question , is it ");



	    }

	    
	    public static int avoidObstacles(int[] inputArray) {
	    	
	    	
	    	Arrays.sort(inputArray);
	    	int jump=inputArray[inputArray.length-1] +1 ,pos=0;
	    	boolean flag= false;
	    	
	    	while(pos!= inputArray.length)
	    	{
	    	for(int i=pos + 1;i<inputArray.length;i++) {
	    		if((inputArray[i] - inputArray[i-1]) !=1) {
	    		jump = inputArray[i-1] + 1;	
	    		pos= i +1;
	    		break;
	    		}
	    		
	    	}
	    	for(int i=pos;i<inputArray.length;i++) {
	    			flag=true;
	    	if(inputArray[i] % jump ==0) {
	    		flag =false;
	    	
	    		break;
	    	}
	    	
	    	}
	    	if(flag==true)
	    		break;
	    	}
	    	
	    return (jump);
	    }
	
	
	
	   static  String  questionCorrectionBot(String question) {
	    	
	   
	 String str;
	 str= question.replaceAll("\\s+", " ");
	  str= str.replaceAll("\\s+,", ", ");
	  
	  str= str.replaceAll("\\?+", "?");
	  str= str.trim();
	   int c= str.charAt(0);
	   if(c >=97)
		str =str.substring(0,1).toUpperCase() + str.substring(1);
	   int ind= str.length()-1;
	   if(str.charAt(ind)!='?')
		 str=  str.concat("?");
	   System.out.print(str);
	    	
	    	
	    	
	    	return null;
	    }

	*/
	}
	
	



