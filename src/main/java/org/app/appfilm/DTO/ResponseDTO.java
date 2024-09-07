package org.app.appfilm.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ResponseDTO implements Serializable {
  private int statusCode;
  private String path;
  private String msg;
  private StringBuilder msgDetail;
}
