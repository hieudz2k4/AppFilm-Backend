package org.app.appfilm.Constant;

public enum RoleConstant {
  REGULAR_USER(4),
  VIP_USER(3),
  ADMIN(2),
  MANAGER(1);

  private int value;
  RoleConstant(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static void main(String[] args) {
    RoleConstant roleConstant = RoleConstant.MANAGER;

    System.out.println(roleConstant);
  }
}
