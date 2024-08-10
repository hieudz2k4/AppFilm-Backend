package org.app.appfilm.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {
  private int statusCode;
  private String path;
  private String errMsg;
  private List<String> errDetail;
}
