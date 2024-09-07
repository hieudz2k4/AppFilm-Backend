package org.app.appfilm.Utils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class InfoObject {

  public static StringBuilder getInfo(Object o) {
    Field[] fields = o.getClass().getDeclaredFields();
    StringBuilder res = new StringBuilder();
    Arrays.stream(fields).forEach(field -> {
      try {
        field.setAccessible(true);
        String fieldName = field.getName();
        String fieldValue = (field.get(o) != null? field.get(o).toString(): "null");
        String fieldInfo = fieldName + ": " + fieldValue + "\n";
        res.append(fieldInfo);
      } catch (IllegalAccessException e) {
        res.append("Lỗi Access tại Info.java");
      }
    });

    return res;
  }
}
