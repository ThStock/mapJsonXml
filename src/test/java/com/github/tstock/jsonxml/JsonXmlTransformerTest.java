package com.github.tstock.jsonxml;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JsonXmlTransformerTest {

  private JsonXmlTransformer testee;

  @Before
  public void before() {
    testee = new JsonXmlTransformer();

  }

  @Test
  public void testTransform_xml_to_json() {
    // GIVEN
    String xml = "<a>b</a>";

    // WHEN
    String json = testee.transformToJson(xml);

    // THEN
    assertEquals("{\"a\":\"b\"}", json);
  }

  @Test
  public void testTransform_xml_to_json_with_attr() {
    // GIVEN
    String xml = "<a k=\"c\">b</a>";

    // WHEN
    String json = testee.transformToJson(xml);

    // THEN
    assertEquals("{\"a\":{\"content\":\"b\",\"k\":\"c\"}}", json);
  }

  @Test
  @Ignore
  public void testTransform_json_to_xml_with_attr() {
    // GIVEN
    String xml = "{\"a\":{\"content\":\"b\",\"k\":\"c\"}}";

    // WHEN
    String json = testee.transformToXml(xml);

    // THEN
    assertEquals("<a k=\"c\">b</a>", json);
  }

  @Test
  public void testTransform_xml_to_json_level1() {
    // GIVEN
    String xml = "<a><b>c</b></a>";

    // WHEN
    String json = testee.transformToJson(xml);

    // THEN
    assertEquals("{\"a\":{\"b\":\"c\"}}", json);
  }

  @Test
  public void testTransform_xml_to_json_level1_array() {
    // GIVEN
    String xml = "<a><b>c</b><b>c</b></a>";

    // WHEN
    String json = testee.transformToJson(xml);

    // THEN
    assertEquals("{\"a\":{\"b\":[\"c\",\"c\"]}}", json);
  }

  @Test
  public void testTransform_xml_to_json_level2() {
    // GIVEN
    String xml = "<a><b><c>d</c></b></a>";

    // WHEN
    String json = testee.transformToJson(xml);

    // THEN
    assertEquals("{\"a\":{\"b\":{\"c\":\"d\"}}}", json);
  }

  @Test
  public void testTransform_xml_to_json_level3() {
    // GIVEN
    String xml = "<a><b><c><d>e</d></c></b></a>";

    // WHEN
    String json = testee.transformToJson(xml);

    // THEN
    assertEquals("{\"a\":{\"b\":{\"c\":{\"d\":\"e\"}}}}", json);
  }

  @Test
  public void testTransform_json_to_xml() {
    // GIVEN
    String json = "{ \"a\": \"b\" }";

    // WHEN
    String xml = testee.transformToXml(json);

    // THEN
    assertEquals("<a>b</a>", xml);
  }

  @Test
  public void testTransform_json_to_xml_level1() {
    // GIVEN
    String json = "{ \"b\": {\"c\": \"d\"} }";

    // WHEN
    String xml = testee.transformToXml(json);

    // THEN
    assertEquals("<b><c>d</c></b>", xml);
  }

  @Test
  public void testTransform_json_to_xml_level1_array() {
    // GIVEN
    String json = "{\"b\":{\"b\":[\"b\",\"b\"]}}";

    // WHEN
    String xml = testee.transformToXml(json);

    // THEN
    assertEquals("<b><b>b</b><b>b</b></b>", xml);
  }

}
