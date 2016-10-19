import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

/**
 * Find size of the folder and folders' and
 * files' date creation
 */
public class SizeDirAndDate {
  /**
   * find folder's size and all
   * files' and folders' size in
   * current folder
   *
   * @param fList - current directory's array
   * @param p     - folder's path
   * @return folder's size
   * @throws IOException
   */
  public long sizeDir(File[] fList, String p) throws IOException {
    long sum = 0;
    File dir = new File(p);
    File[] dArray = dir.listFiles();
    for (File f : dArray) {
      if (f.isDirectory()) {
        sum += sizeDir(dArray, f.getCanonicalPath());
      }
      if (f.isFile()) {
        sum += f.length();
      }
    }
    return sum;
  }

  /**
   * Find folders' and files'
   * date creation
   *
   * @param path - current directory's and file's path
   * @return file's and directory's data creation
   * @throws IOException
   */
  public String getDate(Path path) throws IOException {
    BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
    FileTime dateTime = attr.creationTime();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    String date = dateFormat.format(dateTime.toMillis());
    return date;
  }

  /**
   * Count folder's size in Kb
   *
   * @param sum - folder's size in bytes
   * @return 0, if folder is empty,
   * 1, if size in bytes less 1
   * otherwise return folder's size in Kb
   */
  public long convertToKb(long sum) {
    if (sum == 0) {
      return 0;
    }
    if (sum < 1024) {
      return 1;
    }
    return sum / 1024;
  }
}
