package model;

public interface IFile {
  void openFile(String fileName);

  void parseFile();

  void saveFile();

  String getFileOpended();
}
