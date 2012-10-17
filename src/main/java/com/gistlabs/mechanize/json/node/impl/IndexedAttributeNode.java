package com.gistlabs.mechanize.json.node.impl;

import org.json.JSONArray;
import org.json.JSONException;

import com.gistlabs.mechanize.json.exceptions.JsonException;
import com.gistlabs.mechanize.json.node.JsonNode;

public class IndexedAttributeNode extends AttributeNode {
	
	private final int index;
	private JSONArray array;

	public IndexedAttributeNode(JsonNode parent, String name, JSONArray array, int index) {
		super(parent, name);
		this.array = array;
		this.index = index;
	}

	@Override
	public String getValue() {
		try {
			return this.array.getString(this.index);
		} catch (JSONException e) {
			throw new JsonException(e);
		}
	}

	@Override
	public void setValue(String value) {
		try {
			this.array.put(this.index, value);
		} catch (JSONException e) {
			throw new JsonException(e);
		}
	}
}