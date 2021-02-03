import model.IFile;
import model.impl.Bmp;
import model.impl.Gif;
import model.impl.Jpg;
import model.impl.Png;

public class GraphicsEditor {
  private IFile bmp = new Bmp();
  private IFile gif = new Gif();
  private IFile png = new Png();
  private IFile jpg = new Jpg();

  public void getFile(String fileName) throws Exception {
    String ext = fileName.substring(fileName.length() - 3);
    switch (ext) {
      case "bmp":
        bmp.openFile(fileName);
        bmp.parseFile();
        bmp.saveFile();
        break;
      case "gif":
        gif.openFile(fileName);
        break;
      case "png":
        png.openFile(fileName);
        break;
      case "jpg":
        jpg.openFile(fileName);
        break;
      default:
        throw (new Exception("Unknown file type"));
    }
  }

  public static void main(String[] args) {
    GraphicsEditor graphicsEditor = new GraphicsEditor();

    try {
      graphicsEditor.getFile("jpg");
      graphicsEditor.getFile("png");
      graphicsEditor.getFile("bmp");
      graphicsEditor.getFile("gif");
    } catch (Exception e) {
      e.toString();
    }
  }
}
