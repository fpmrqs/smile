package com.fran.smile.smile;

import javax.persistence.*;

@Entity
public class Smile {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private boolean isCrying;
  private boolean isLaughing;

  public Smile() {
  }

  public Smile(boolean isCrying, boolean isLaughing) {
    this.isCrying = isCrying;
    this.isLaughing = isLaughing;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean getIsCrying() {
    return this.isCrying;
  }

  public void setIsCrying(boolean isCrying) {
    this.isCrying = isCrying;
  }

  public boolean getIsLaughing() {
    return this.isLaughing;
  }

  public void setIsLaughing(boolean isLaughing) {
    this.isLaughing = isLaughing;
  }

}
