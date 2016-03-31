package com.mangiafico.qb;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;

public class Observation {

	static final String uri = DataCube.uri + "Observation";
	
	private final Resource resource;
	
	Observation(Model model, String name) {
		resource = model.createResource(model.ns + name);
		resource.addProperty(RDF.type, ResourceFactory.createResource(uri));
	}
	
	public Observation setDimension(Dimension dimension, String value) {
		Property property = ResourceFactory.createProperty(dimension.getURI());
		resource.addProperty(property, value);
		return this;
	}
	public Observation setDimension(Dimension dimension, int value) {
		Property property = ResourceFactory.createProperty(dimension.getURI());
		resource.addProperty(property, Integer.toString(value), XSDDatatype.XSDinteger);
		return this;
	}

	public Observation setMeasure(Measure measure, int value) {
		Property property = ResourceFactory.createProperty(measure.getURI());
		resource.addProperty(property, Integer.toString(value), XSDDatatype.XSDinteger);
		return this;
	}

}
