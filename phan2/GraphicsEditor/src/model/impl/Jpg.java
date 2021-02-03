package model.impl;

import model.IFile;

public class Jpg implements IFile {
  public static final String EXTENSION = "jpg";
  private String fileOpended;

  @Override
  public void openFile(String fileName) {
    fileOpended = fileName;
    System.out.println(EXTENSION + ": open " + fileName);
  }

  @Override
  public String getFileOpended() {
    return fileOpended;
  }

  @Override
  public void parseFile() {
    System.out.println(EXTENSION + ": parse");
  }

  @Override
  public void saveFile() {
    if (fileOpended != null) {
      System.out.println(EXTENSION + ": save");
    } else {
      System.out.println("Nothing to save");
    }
  }
}
