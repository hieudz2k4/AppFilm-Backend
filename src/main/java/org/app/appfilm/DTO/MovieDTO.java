package org.app.appfilm.DTO;

import java.io.Serializable;
import java.util.Date;

public class MovieDTO implements Serializable {
  private String movieEngName;
  private String movieVNName;
  private int duration;
  private Date releaseDate;
  private String summary;
  private int numOfLike;
  private int numOfShare;
}
