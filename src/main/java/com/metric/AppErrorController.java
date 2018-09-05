package com.metric;




import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController{
	



	    private final static String ERROR_PATH = "/error";

	    @RequestMapping(value = ERROR_PATH)
	    @ResponseBody
	    public ResponseEntity<?> error(HttpServletRequest request) {

	        return new ResponseEntity<String>(" Hello there Welcome to MetricsGenerator </H>", HttpStatus.OK);
	    }



	    @Override
	    public String getErrorPath() {
	        return ERROR_PATH;
	    }
	}



