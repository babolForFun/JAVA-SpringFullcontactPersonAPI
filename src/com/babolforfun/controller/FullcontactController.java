package com.babolforfun.controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.codehaus.jackson.map.ObjectMapper;

import com.babolforfun.models.ContactInfo;
import com.babolforfun.models.Organization;
import com.babolforfun.models.Photo;
import com.babolforfun.models.SocialProfile;
import com.babolforfun.utils.EmailValidator;

@Controller
@RequestMapping("/getfullcontact")
public class FullcontactController {

	private String FCP_URL_REQ = "https://api.fullcontact.com/v2/person.json?email=";
	private String FCP_API_KEY = "[YOUR_FULL_CONTACT_PERSON_API_KEY]";
	
	/**
	 * Call FCP_API with email as input
	 * @param requestIn request
	 * @param res response
	 * @return
	 * @throws IOException
	 */
     @RequestMapping(value = "/by_email", method = RequestMethod.POST)  
     public ModelAndView getfullcontact( @RequestParam(value="email") String email_in) throws IOException {  
    	
    	// Variables
    	ModelAndView RESULT_PAGE_MODELVIEW = new ModelAndView();
    	
    	EmailValidator EMAIL_VALIDATOR = new EmailValidator();
    	if(EMAIL_VALIDATOR.validate(email_in)){
	    	
	    	// HTTP Variables
	    	URL HTTP_URL 						= new URL(FCP_URL_REQ.concat(email_in.trim()));
	        HttpURLConnection HTTP_CONNECTION   = createHTTPConnection(HTTP_URL);
	 	
	        // Header
	        setHeaderRequest(generateHeaderRequest(),HTTP_CONNECTION);
	        int HTTP_CONNECTION_CODE = HTTP_CONNECTION.getResponseCode();
	        
	        if("200".equals(String.valueOf(HTTP_CONNECTION_CODE))){
		        // Buffer response
		        StringBuilder JSON_RESPONSE = getResponse(new DataInputStream(HTTP_CONNECTION.getInputStream()));
			        
		        // Info arrays
		        List<Photo> 		INFO_PHOTOS_ARRAY 		= getInfoPhotos(JSON_RESPONSE.toString());
		        List<ContactInfo> 	INFO_CONTACT_ARRAY 		= getInfoContact(JSON_RESPONSE.toString());
		        List<SocialProfile> INFO_SOCIAL_ARRAY		= getInfoSocialProfile(JSON_RESPONSE.toString());
		        List<Organization> 	INFO_ORGANIZATION_ARRAY = getInfoOrganizations(JSON_RESPONSE.toString());
		        
				// Create model
		        RESULT_PAGE_MODELVIEW.setViewName("resultpage");
		        RESULT_PAGE_MODELVIEW.addObject("EMAIL_IN",email_in);
		        RESULT_PAGE_MODELVIEW.addObject("INFO_PHOTOS_ARRAY",		INFO_PHOTOS_ARRAY );
		        RESULT_PAGE_MODELVIEW.addObject("INFO_CONTACT_ARRAY",		INFO_CONTACT_ARRAY );
		        RESULT_PAGE_MODELVIEW.addObject("INFO_ORGANIZATION_ARRAY",	INFO_ORGANIZATION_ARRAY );
		        RESULT_PAGE_MODELVIEW.addObject("INFO_SOCIAL_ARRAY",		INFO_SOCIAL_ARRAY);
	        }
    	}else{
    		RESULT_PAGE_MODELVIEW.setViewName("error");
    	}
	    // return model
        return RESULT_PAGE_MODELVIEW;  
    }  
    
    /**
	 * Create Arraylist<SocialProfile>
	 * @param JSON_STRING response
	 * @return
	 */
     public List<SocialProfile> getInfoSocialProfile(String JSON_STRING){
     	
     	// List and Mapper
     	List<SocialProfile> SOCIAL_INFO_MAP = new ArrayList<SocialProfile>();
     	ObjectMapper MAPPER_JSON_TO_SOCIAL = new ObjectMapper();
     	
     	// JSON manipulation
     	JSONObject JSON_INPUT = new JSONObject(JSON_STRING);
     	JSONArray  JSON_ARRAY = JSON_INPUT.getJSONArray("socialProfiles");
     	
     	try{
 	    	for(Object JSON_SINGLE_SOCIAL: JSON_ARRAY)
 	    		SOCIAL_INFO_MAP.add(MAPPER_JSON_TO_SOCIAL.readValue(JSON_SINGLE_SOCIAL.toString(), SocialProfile.class));
     	}catch(Exception e){
     		System.out.println(e.getMessage());
     	}

     	return SOCIAL_INFO_MAP;
     }
        
    /**
     * Create Arraylist<ContactInfo>
     * @param JSON_STRING response
     * @return
     */
     public List<Organization> getInfoOrganizations(String JSON_STRING){
     	
     	// List and Mapper
     	List<Organization> ORGANIZSTION_INFO_MAP = new ArrayList<Organization>();
     	ObjectMapper MAPPER_JSON_TO_ORGANIZATION = new ObjectMapper();
     	
     	// JSON manipulation
     	JSONObject JSON_INPUT = new JSONObject(JSON_STRING);
     	if(JSON_INPUT.has("organizations")){
     	JSONArray  JSON_ARRAY = JSON_INPUT.getJSONArray("organizations");
		 	try{
		    	for(Object JSON_SINGLE_ORGANIZATION: JSON_ARRAY)
		    		ORGANIZSTION_INFO_MAP.add(MAPPER_JSON_TO_ORGANIZATION.readValue(JSON_SINGLE_ORGANIZATION.toString(), Organization.class));
		 	}catch(Exception e){
		 		System.out.println(e.getMessage());
		 	}
     	}
     	return ORGANIZSTION_INFO_MAP;
     }
     
    /**
     * Create Arraylist<ContactInfo>
     * @param JSON_STRING response
     * @return
     */
     public List<ContactInfo> getInfoContact(String JSON_STRING){
    	
    	// List and Mapper
    	List<ContactInfo> CONTACT_INFO_MAP  = new ArrayList<ContactInfo>();
    	ObjectMapper MAPPER_JSON_TO_CONTACT = new ObjectMapper();
    	
    	// JSON manipulation
    	JSONObject JSON_INPUT = new JSONObject(JSON_STRING);
    	JSONObject JSON_CHATS = JSON_INPUT.getJSONObject("contactInfo");
    	if (JSON_CHATS.has("chats")){
			JSONArray  JSON_ARRAY = JSON_CHATS.getJSONArray("chats");
			
			try{
		    	for(Object JSON_SINGLE_CONTACT : JSON_ARRAY)
		    		CONTACT_INFO_MAP.add(MAPPER_JSON_TO_CONTACT.readValue(JSON_SINGLE_CONTACT.toString(), ContactInfo.class));
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
    	}
    	
    	return CONTACT_INFO_MAP;
    }
    
    /**
     * Create Arraylist<Photo>
     * @param JSON_STRING Json response
     * @return
     */
     public List<Photo> getInfoPhotos(String JSON_STRING){
    	
    	// List and Mapper
    	List<Photo> PHOTOS_MAP = new ArrayList<Photo>();
    	ObjectMapper MAPPER_JSON_TO_PHOTO = new ObjectMapper();
    	
    	// JSON manipulation
    	JSONObject JSON_INPUT = new JSONObject(JSON_STRING);
    	if(JSON_INPUT.has("photos")){
    		JSONArray JSON_ARRAY = JSON_INPUT.getJSONArray("photos");
	    	try{
		    	for(Object JSON_SINGLE_PHOTO : JSON_ARRAY)
		    		PHOTOS_MAP.add(MAPPER_JSON_TO_PHOTO.readValue(JSON_SINGLE_PHOTO.toString(), Photo.class));
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    	}
    	
    	return PHOTOS_MAP;
    }
    
    /**
     * Build String response from input stream
     * @param INPUT_STREAM input stream
     * @return response
     * @throws IOException
     */
     public StringBuilder getResponse(DataInputStream INPUT_STREAM) throws IOException{
    	
    	int BUFFER_INDEX = 0;
    	StringBuilder RESPONSE_BUILDER = new StringBuilder();;
    	while ( (BUFFER_INDEX = INPUT_STREAM.read()) != -1) 
    		RESPONSE_BUILDER.append((char) BUFFER_INDEX);
    	INPUT_STREAM.close();
    	return RESPONSE_BUILDER;
    }
    
    /**
     * Create HTTPConnection
     * @param HTTP_URL
     * @return
     * @throws IOException
     */
     public HttpURLConnection createHTTPConnection(URL HTTP_URL) throws IOException{
    	
    	HttpURLConnection HTTP_CONNECTION   = (HttpURLConnection) HTTP_URL.openConnection();
        
    	HTTP_CONNECTION.setRequestMethod("POST");
        HTTP_CONNECTION.setInstanceFollowRedirects(true);
        HTTP_CONNECTION.setDoOutput(true);
        HTTP_CONNECTION.setDoInput(true);
 	
		return HTTP_CONNECTION;
    }

    /**
     * Generate key-value in Map<String,String>
     * @return
     */
     public Map<String,String> generateHeaderRequest(){
    	Map<String,String> HEADERS = new HashMap<>();
        HEADERS.put("X-FullContact-APIKey",FCP_API_KEY);
        return HEADERS;
    }
    
    /**
     * Set header in HTTP request
     * @param HTTP_MAP_HEADER header parameters
     * @param HTTP_CONNECTION connection to add 
     */
     public void setHeaderRequest(Map<String,String> HTTP_MAP_HEADER,HttpURLConnection HTTP_CONNECTION){
    	for (Entry<String, String> HTTP_SINGLE_HEADER : HTTP_MAP_HEADER.entrySet())
            HTTP_CONNECTION.setRequestProperty(HTTP_SINGLE_HEADER.getKey(),HTTP_SINGLE_HEADER.getValue());
    }
    
    
}
