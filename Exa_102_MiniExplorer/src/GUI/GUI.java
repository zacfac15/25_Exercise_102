package GUI;

import beans.Datei;
import beans.DateiModell;
import beans.FileListRenderer;

public class GUI extends javax.swing.JFrame
{

  private final DateiModell model = new DateiModell();
  private static String PATH_NAME = System.getProperty("user.dir");

  public GUI()
  {
    initComponents();
    this.setSize(500, 250);
    this.setTitle(PATH_NAME);
    list.setModel(model);
    //list.setCellRenderer(new FileListRenderer());      
    model.getFileList(new Datei(PATH_NAME));
    model.sort();
    list.setCellRenderer(new FileListRenderer());

  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jScrollPane1 = new javax.swing.JScrollPane();
    list = new javax.swing.JList<>();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new java.awt.GridLayout(1, 0));

    list.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
    list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    list.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        onChangeDir(evt);
      }
    });
    jScrollPane1.setViewportView(list);

    getContentPane().add(jScrollPane1);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void onChangeDir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onChangeDir
      if (evt.getClickCount() == 2)
      {
        //Doppelklick
        if (model.getDatei(list.getSelectedIndex()).getDisplayName().equals("..."))
        {

          model.getFileList(new Datei(model.getReturnPathName()));
          model.sort();
          this.setTitle(model.getReturnPathName());
        }
        else
        {

          try
          {
            model.getFileList(model.getDatei(list.getSelectedIndex()));
            model.sort();
            this.setTitle(model.getDatei(0).getReturnPathName());

          }
          catch (NullPointerException e)
          {
            System.out.println("Nix funktionieren");
          }
        }

      }
    }//GEN-LAST:event_onChangeDir

  public static void main(String args[])
  {

    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new GUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList<Datei> list;
  // End of variables declaration//GEN-END:variables
}
