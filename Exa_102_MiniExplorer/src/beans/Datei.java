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
}