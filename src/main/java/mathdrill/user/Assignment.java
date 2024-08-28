package mathdrill.user;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Assignment {
  private String assignmentName;
  private String worksheetData;
  public Assignment() {
  }
  public String getAssignmentName(){return assignmentName;}
  public void setAssignmentName (String newValue){ assignmentName=newValue;}
  public String getWorksheetData(){return worksheetData;}
  public void setWorksheetData (String newValue){ worksheetData=newValue;}

}