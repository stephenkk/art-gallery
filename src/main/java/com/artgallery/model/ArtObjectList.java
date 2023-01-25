package com.artgallery.model;
//test comment for feature branch push
public class ArtObjectList {
	//The Met collectionapi returns an integer (the total number of art objects) and an integer array (a list of art object ids)
	//Each art object is associated with a unique art object id. We can build a query string to filter these results by department:
	//https://collectionapi.metmuseum.org/public/collection/v1/objects?departmentIds=1 will return the total and a list
	//of object ids for department 1.

	private int total;
	private int [] objectIDs;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int[] getObjectIDs() {
		return objectIDs;
	}
	public void setObjectIDs(int[] objectIDs) {
		this.objectIDs = objectIDs;
	}
	
	
	
}
