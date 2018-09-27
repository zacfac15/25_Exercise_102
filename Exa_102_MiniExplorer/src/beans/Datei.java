package beans;

import java.io.File;
import java.text.SimpleDateFormat;

public class Datei extends File
{

  private static final SimpleDateFormat SDF = new SimpleDateFormat("dd.MM.yyyy hh:mm");
  private String displayName;

  public Datei(String pathname)
  {
    super(pathname);
    displayName = getName();
  }

  @Override
  public String toString()
  {
    if (isDirectory())
    {
      return String.format("%s", displayName);
    }
    else
    {
      String indicator = "";
      if (canRead())
      {
        indicator += "R";
      }
      if (canWrite())
      {
        indicator += "W";
      }
      if (isHidden())
      {
        indicator += "H";
      }
      if (canExecute())
      {
        indicator += "X";
      }
      if (getDisplayName().equals("..."))
      {
        return String.format("%-25s", displayName);
      }

      return String.format("%-35s %10s %5s %5s", displayName, (length()) / 1000 + "KB", SDF.format(this.lastModified()), indicator);
    }
  }

  public String getDisplayName()
  {
    return displayName;
  }

  public String getReturnPathName()
  {
    String absolutePath = getAbsolutePath();
    String replace = absolutePath.substring(absolutePath.lastIndexOf(File.separator) + 1, absolutePath.length());
    return absolutePath.replace(replace, "");
  }
}
