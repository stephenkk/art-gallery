package com.artgallery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artgallery.model.ArtObjectList;
import com.artgallery.service.ArtGalleryService;

@RestController
//url = http://<server-address>/api/v1/art-gallery?departmentID=1,2,
public class ArtGalleryController {

	private ArtGalleryService artGalleryService; // at this point it is null

	// constructor injection
	public ArtGalleryController(ArtGalleryService artGalleryService) {
		super();
		this.artGalleryService = artGalleryService;
	}

	@GetMapping("/api/v1/art-gallery")
	public ArtObjectList getAllDeptObjectIds(@RequestParam Integer departmentID) {
		ArtObjectList artObjectList = artGalleryService.getAllObjectIds(departmentID);
		return artObjectList;

	}

}
