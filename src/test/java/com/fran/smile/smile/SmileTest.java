package com.fran.smile.smile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SmileTest {

  @Test
  // smile isLaughing
  public void testConstructionOfSmileWithIsLaughing() {
    Smile subject = new Smile(false, true);
    assertEquals(false, subject.getIsCrying());
    assertEquals(true, subject.getIsLaughing());
    assertEquals(null, subject.getId());
  }

  @Test
  // smile isCrying
  public void testConstructionOfSmileWithIsCrying() {
    Smile subject = new Smile(true, false);
    assertEquals(true, subject.getIsCrying());
    assertEquals(false, subject.getIsLaughing());
    assertEquals(null, subject.getId());
  }

}