package com.artgallery.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//use FeignClient to make the call to the Met collectionapi

import com.artgallery.model.ArtObjectList;

@FeignClient(name="museum-service", url  = "https://collectionapi.metmuseum.org/public/collection/v1/objects")
public interface ArtGalleryFeign {
	@GetMapping( produces = "application/json")
	ArtObjectList artObjectList(@RequestParam Integer departmentIds);

}
