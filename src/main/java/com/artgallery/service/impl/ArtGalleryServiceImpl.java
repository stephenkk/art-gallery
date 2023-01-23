package com.artgallery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artgallery.exception.ArtGalleryException;
import com.artgallery.model.ArtObjectList;
import com.artgallery.service.ArtGalleryFeign;
import com.artgallery.service.ArtGalleryService;

@Service
public class ArtGalleryServiceImpl implements ArtGalleryService {
	// feign object will get created at earlier spring application startup process,
	@Autowired // autowire will simply assign already created object of feign to the
				// variable below
	ArtGalleryFeign artGalleryFeign;

	// define getAllAbjectIds() method with artGalleryFeign.artObjectList()
	@Override
	public ArtObjectList getAllObjectIds(Integer departmentId) {
		try {
			ArtObjectList artObjectList = artGalleryFeign.artObjectList(departmentId);
			return artObjectList;
		} catch (Exception e) {
			throw new ArtGalleryException(
					"Exception occured for the department ID " + departmentId + " " + e.getMessage());
		}

	}

}

