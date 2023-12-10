package internal.service;

import java.util.HashSet;

public class Set {
  public HashSet<String> verbSet;
  public HashSet<String> nounsSet;

  public Set() {
    verbSet = new HashSet<>();
    nounsSet = new HashSet<>();

    verbSet.add("check");
    verbSet.add("move");
    verbSet.add("fight");
    verbSet.add("apply");

    nounsSet.add("inventory");
    nounsSet.add("health");
  }
}
