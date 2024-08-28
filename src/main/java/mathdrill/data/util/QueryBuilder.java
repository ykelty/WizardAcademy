package mathdrill.data.util;


public class QueryBuilder
{
  private StringBuffer queryString;
  public QueryBuilder(String query)
  {
    queryString = new StringBuffer(query);
  }
  public String getQueryString(){
    return queryString.toString();
  }
  public void AddStringParameter (String s){
    if (s ==null){
      s="";
    }
    String newString = " '"+s+"' ";
    AddParameter(newString);
  }

  public void AddParameter(String param){
    String query = queryString.toString();
    int index= query.indexOf("?");
    if (index>0){
      queryString.replace(index,index+1,param);
    }
    else {
      System.out.println(">>>> Error: need to add exception handling later. QueryBuilder.AddParameter");
    }
  }

}