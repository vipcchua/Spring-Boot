package com.ssm.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {
	  private final String tagName;

	    @JsonCreator
	    public Tag(@JsonProperty("tagName") String tagName) {
	        this.tagName = tagName;
	    }

	    public String getTagName() {
	        return tagName;
	    }

	    @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("Tag{");
	        sb.append("tagName='").append(tagName).append('\'');
	        sb.append('}');
	        return sb.toString();
	    }
}
