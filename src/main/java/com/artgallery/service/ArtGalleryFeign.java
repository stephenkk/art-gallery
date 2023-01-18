package com.artgallery.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artgallery.model.ArtObjectList;

@FeignClient(name="museum-service", url  = "https://collectionapi.metmuseum.org/public/collection/v1/objects?departmentIds=3")
public interface ArtGalleryFeign {
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	ArtObjectList artObjectList();

}
