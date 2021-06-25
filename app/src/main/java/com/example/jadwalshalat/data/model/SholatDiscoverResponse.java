package com.example.jadwalshalat.data.model;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class SholatDiscoverResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private ArrayList<DataResponse> data;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(ArrayList<DataResponse> data){
		this.data = data;
	}

	public ArrayList<DataResponse> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"SholatDiscoverResponse{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}