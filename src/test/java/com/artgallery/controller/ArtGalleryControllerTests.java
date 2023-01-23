package com.artgallery.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.artgallery.model.ArtObjectList;
import com.artgallery.service.ArtGalleryService;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ArtGalleryControllerTests {
	
	private ArtGalleryService artGalleryService;
	private ObjectMapper mapper = new ObjectMapper();
	
	private MockMvc mockMvc;
	
	ArtGalleryController controller;
	
	@BeforeEach
	public void setup() {
		artGalleryService = Mockito.mock(ArtGalleryService.class);
		controller = new ArtGalleryController(artGalleryService);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}
	//a test for a department number that has images
	@Test
	public void getAllDeptObjectIdsTest() throws Exception {
		ArtObjectList artObjectList = new ArtObjectList();
		artObjectList.setTotal(13612);
		int [] arr = {1,2};
		artObjectList.setObjectIDs(arr);
	
		when(artGalleryService.getAllObjectIds(4)).thenReturn(artObjectList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/art-gallery").param("departmentID", "4");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		ArtObjectList artObjectListResponse = mapper.readValue(result.getResponse().getContentAsString(), ArtObjectList.class);
		
		assertThat(artObjectListResponse).isNotNull();
		assertEquals(artObjectListResponse.getTotal(),13612);
		assertEquals(artObjectListResponse.getObjectIDs()[0], arr[0]);
		assertEquals(artObjectListResponse.getObjectIDs()[1], arr[1]);
		
		
		
	}
	// at test for a department number that doesn't have images
	@Test
	public void getEmptyResponseTest() throws Exception {
		ArtObjectList artObjectList = new ArtObjectList();
		artObjectList.setTotal(0);
		int [] arr = {};
		artObjectList.setObjectIDs(arr);
	
		when(artGalleryService.getAllObjectIds(0)).thenReturn(artObjectList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/art-gallery").param("departmentID", "0");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		ArtObjectList artObjectListResponse = mapper.readValue(result.getResponse().getContentAsString(), ArtObjectList.class);
		
		assertThat(artObjectListResponse).isNotNull();
		assertEquals(artObjectListResponse.getTotal(),0);
		assertThat(artObjectListResponse.getObjectIDs()).isEmpty();
		
		
		
		
	}

	

}
