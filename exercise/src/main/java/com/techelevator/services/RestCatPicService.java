package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {
	private static final String API_BASE_URL = "https://cat-data.netlify.app/api/pictures/random/";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatPic getPic() {
		// TODO Auto-generated method stub
		CatPic catPic = null;

		try {
			catPic = restTemplate.getForObject(API_BASE_URL + catPic.getFile(), CatPic.class);
		} catch (RestClientResponseException | ResourceAccessException e) {
			e.getMessage();
		}
		return catPic;
	}


}	
