package com.github.tstock.jsonxml;

import org.json.JSONObject;
import org.json.XML;

public class JsonXmlTransformer {

  public String transformToJson(String xml) {
    return XML.toJSONObject(xml).toString();
  }

  public String transformToXml(String json) {
    JSONObject object = new JSONObject(json);
    return XML.toString(object);
  }
}
