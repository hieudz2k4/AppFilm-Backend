package org.app.appfilm.DTO;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrResDTO extends ResponseDTO implements Serializable {

  @Builder
  public ErrResDTO(int statusCode, String path, String msg, StringBuilder msgDetail) {
    super(statusCode, path, msg, msgDetail);
  }
}
