package com.ajn.mybatis.generator.model;

public class OutputPath {

	private String modelPackage;
	private String modelProject;

	public OutputPath() {
		super();
	}

	public OutputPath(String modelPackage, String modelProject) {
		super();
		this.modelPackage = modelPackage;
		this.modelProject = modelProject;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getModelProject() {
		return modelProject;
	}

	public void setModelProject(String modelProject) {
		this.modelProject = modelProject;
	}

}
