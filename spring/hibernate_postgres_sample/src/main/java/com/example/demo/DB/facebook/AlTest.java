package com.example.demo.DB.facebook;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alma on 2019/10/15.
 */
@Entity
@Table(name = "al_test",schema="public")
public class AlTest implements Serializable {
  @Column(name = "aa")
  private Integer aa;

  @Id
  @Column(name = "bb")
  private String[] bb;

  public int getAa() {
    return aa;
  }

  public void setAa(Integer aa) {
    this.aa = aa;
  }

  public AlTest(Integer aa) {
    this.aa = aa;
  }
  public AlTest(){}
}
