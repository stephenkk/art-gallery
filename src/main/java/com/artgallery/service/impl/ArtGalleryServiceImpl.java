package com.artgallery.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artgallery.model.ArtObjectList;
import com.artgallery.service.ArtGalleryFeign;
import com.artgallery.service.ArtGalleryService;

@Service
public class ArtGalleryServiceImpl implements ArtGalleryService{
	
	@Autowired
	ArtGalleryFeign artGalleryFeign;



	@Override
	public ArtObjectList getAllObjectIds() {
		ArtObjectList artObjectList = artGalleryFeign.artObjectList();
		
		return artObjectList;
	}


}
