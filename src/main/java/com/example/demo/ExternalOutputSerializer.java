package com.example.demo;

import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


public class ExternalOutputSerializer  extends StdSerializer<OutputData>{
	public ExternalOutputSerializer() {
        this(null);
    }
	 
	public ExternalOutputSerializer(Class<OutputData> out_dat) {
	        super(out_dat);
	    }
	
	@Override
    public void serialize(
      OutputData value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
	  	ArrayList<OutputHolder> outHold = new ArrayList<OutputHolder>();
		ArrayList<CategoryData> catDat= value.getFinalOutput();
		//jgen.writeStartObject();
		
		for(CategoryData dat: catDat) {
			ArrayList<Result> results = dat.getResults();
		    ArrayList<ResultFormat> formatItems = new ArrayList<ResultFormat>();
		    //jgen.writeStartObject();
		    //jgen.writeStringField("category", results.get(0).getCategory());
		    OutputHolder outA = new OutputHolder();
		    outA.setCategory(results.get(0).getCategory());
		    for(Result result: results) {
		    	ResultFormat resultFormat = new ResultFormat();
		    	resultFormat.setType(result.getType());
		    	resultFormat.setDifficulty(result.getDifficulty());
		    	resultFormat.setQuestion(result.getQuestion());
		    	resultFormat.setAllAnswers(result.getIncorrectAnswers());
		    	resultFormat.setCorrectAnswer(result.getCorrectAnswer());
		    	formatItems.add(resultFormat);
		    }
		    outA.setResults(formatItems);
		    outHold.add(outA);
		   // AllResultFormat arf = new AllResultFormat();
		   // arf.setAllFormat(formatItems);
		   // jgen.writeObjectField("results", formatItems);
		}
		jgen.writeStartObject();
		jgen.writeObjectField("quiz", outHold);
        jgen.writeEndObject(); 
        
    }
	
}
