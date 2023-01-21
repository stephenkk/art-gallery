package com.artgallery.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
	
	@Test
	public void getAllDeptObjectIdsTest() throws Exception {
		ArtObjectList artObjectList = new ArtObjectList();
		when(artGalleryService.getAllObjectIds(4)).thenReturn(artObjectList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/art-gallery").param("departmentID", "4");
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		ArtObjectList artObjectListResponse = mapper.readValue(result.getResponse().getContentAsString(), ArtObjectList.class);
		
		assertThat(artObjectListResponse).isNotNull();
		
		
	}

}
