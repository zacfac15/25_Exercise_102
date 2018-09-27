package beans;

import java.util.Comparator;

public class Sort implements Comparator<Datei>
{

  @Override
  public int compare(Datei o1, Datei o2)
  {

    if (o2.isFile() && o1.isDirectory())
    {
      return -1;
    }
    else if ((o1.isDirectory() && o2.isDirectory()) || (o1.isFile() && o2.isFile()))
    {
      return o1.getName().compareTo(o2.getName());
    }
    else
    {
      return 1;
    }
  }
}