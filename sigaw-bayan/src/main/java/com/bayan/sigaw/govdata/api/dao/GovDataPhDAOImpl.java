package com.bayan.sigaw.govdata.api.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.bayan.sigaw.govdata.model.ProjectDetail;
import com.bayan.sigaw.govdata.model.ProjectDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GovDataPhDAOImpl implements GovDataPhDAO{

	
	private static final String OPENDATA_URL = "http://api.kabantayngbayan.ph/saro";
	private static final String OPENDATA_GENERIC_URL = "http://api.kabantayngbayan.ph/";
	private static final String APP_ID = "527a5d935e13db265fc2598d";
	private int limit = 500;
	
	
	/**
	 * calls the kabantayan api to get first 1000 projects
	 */
	
	@Override
	public List<ProjectDetail> getAllProjects() {
		DefaultHttpClient client = new DefaultHttpClient();
		ProjectDetails projectDetails = null;
		List<ProjectDetail> returnProjectDetails = new ArrayList<ProjectDetail>(); 
		try {
			
			int skip = 0;
			int counter = 0;
			do
			{
				counter++;
				System.out.println("ctr: " + counter);
				HttpGet getRequest = new HttpGet(OPENDATA_URL + "?app_id=" + APP_ID 
							+ "&limit=" + limit + "&skip=" + skip);
				
				getRequest.addHeader("accept", "application/json");				
			
				HttpResponse response = client.execute(getRequest);		
					
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response.getStatusLine().getStatusCode());
				}
			
				BufferedReader br = new BufferedReader(
	                    new InputStreamReader((response.getEntity().getContent())));
				
				StringBuffer responseBuffer = new StringBuffer(); 
				String output = null;
				while ((output = br.readLine()) != null) {
					responseBuffer.append(output);
				}
				
				
				if(!StringUtils.isEmpty(responseBuffer.toString())) {
					Gson gson = new GsonBuilder().create();
					projectDetails = gson.fromJson(responseBuffer.toString(), ProjectDetails.class);
					returnProjectDetails.addAll(projectDetails.getData());
					skip = projectDetails.getData().size();
				} else {
					throw new RuntimeException("No data retrieve!!!!");
				}
				
			} while (skip == limit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		client.getConnectionManager().shutdown();
		System.out.println("projectDetails.getProjectDetails(): " + projectDetails.getData());
		return projectDetails.getData();
	}


	@Override
	public String callGenericGovDataApi(String requestUri) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(OPENDATA_GENERIC_URL + requestUri);
		StringBuffer responseBuffer = new StringBuffer();
		try {
			HttpResponse response = client.execute(getRequest);		
			
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}
		
			BufferedReader br = new BufferedReader(
	                new InputStreamReader((response.getEntity().getContent())));
			
			 
			String output = null;
			while ((output = br.readLine()) != null) {
				responseBuffer.append(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseBuffer.toString();
	}


	@Override
	public List<ProjectDetail> getAllProjects(String limit) {
		DefaultHttpClient client = new DefaultHttpClient();
		ProjectDetails projectDetails = null;
		List<ProjectDetail> returnProjectDetails = new ArrayList<ProjectDetail>(); 
		try {

			HttpGet getRequest = new HttpGet(OPENDATA_URL + "?app_id=" + APP_ID 
					+ "&limit=" + limit);

			getRequest.addHeader("accept", "application/json");				

			HttpResponse response = client.execute(getRequest);		

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));

			StringBuffer responseBuffer = new StringBuffer(); 
			String output = null;
			while ((output = br.readLine()) != null) {
				responseBuffer.append(output);
			}


			if(!StringUtils.isEmpty(responseBuffer.toString())) {
				Gson gson = new GsonBuilder().create();
				projectDetails = gson.fromJson(responseBuffer.toString(), ProjectDetails.class);
				returnProjectDetails.addAll(projectDetails.getData());
			} else {
				throw new RuntimeException("No data retrieve!!!!");
			}



		} catch (Exception e) {
			e.printStackTrace();
		}
		
		client.getConnectionManager().shutdown();
		System.out.println("projectDetails.getProjectDetails(): " + projectDetails.getData());
		return projectDetails.getData();
	}


	@Override
	public List<ProjectDetail> getFewProjectsPerRegion() {
		ArrayList<String> regions = new ArrayList<String>();
					
		regions.add("1");
		regions.add("2");
		regions.add("3");
		regions.add("4");
		regions.add("5");
		regions.add("6");
		regions.add("7");
		regions.add("8");
		regions.add("9");
		regions.add("10");
		regions.add("11");
		regions.add("12");
		regions.add("NCR");
		regions.add("CAR");
		
		DefaultHttpClient client = new DefaultHttpClient();
		ProjectDetails projectDetails = null;
		List<ProjectDetail> returnProjectDetails = new ArrayList<ProjectDetail>();
		
		try 
		{
			for (String region: regions) {
				HttpGet getRequest = new HttpGet(OPENDATA_URL + "?app_id=" + APP_ID 
						+ "&limit=" + 5 + "&region=" + region);

				//getRequest.addHeader("accept", "application/json");				

				HttpResponse response = client.execute(getRequest);		

				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatusLine().getStatusCode());
				}

				BufferedReader br = new BufferedReader(
						new InputStreamReader((response.getEntity().getContent())));

				StringBuffer responseBuffer = new StringBuffer(); 
				String output = null;
				while ((output = br.readLine()) != null) {
					responseBuffer.append(output);
				}

				if(!StringUtils.isEmpty(responseBuffer.toString())) {
					Gson gson = new GsonBuilder().create();
					projectDetails = gson.fromJson(responseBuffer.toString(), ProjectDetails.class);
					returnProjectDetails.addAll(projectDetails.getData());
				} else {
					throw new RuntimeException("No data retrieve!!!!");
				}
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnProjectDetails;
	}


	@Override
	public List<ProjectDetail> getAllProjectsInRegion(String region) {
		DefaultHttpClient client = new DefaultHttpClient();
		ProjectDetails projectDetails = null;
		List<ProjectDetail> returnProjectDetails = new ArrayList<ProjectDetail>();

		try 
		{

			HttpGet getRequest = new HttpGet(OPENDATA_URL + "?app_id=" + APP_ID 
					+ "&limit=" + 5 + "&region=" + region);

			HttpResponse response = client.execute(getRequest);		

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));

			StringBuffer responseBuffer = new StringBuffer(); 
			String output = null;
			while ((output = br.readLine()) != null) {
				responseBuffer.append(output);
			}

			if(!StringUtils.isEmpty(responseBuffer.toString())) {
				Gson gson = new GsonBuilder().create();
				projectDetails = gson.fromJson(responseBuffer.toString(), ProjectDetails.class);
				returnProjectDetails.addAll(projectDetails.getData());
			} else {
				throw new RuntimeException("No data retrieve!!!!");
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnProjectDetails;
	}
	
	
	
	
}
