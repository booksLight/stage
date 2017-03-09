package org.nurture.estore.util;

import java.util.Calendar;

public class CallenderUtil
{
  public CallenderUtil() {}
  
  public static java.sql.Timestamp convertDateJavaToSqlTimestamp(java.util.Date utilDate)
  {
    if (utilDate == null)
    {

      utilDate = new java.util.Date();
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(utilDate);
    cal.set(14, 0);
    
    return new java.sql.Timestamp(utilDate.getTime());
  }
  
  public static java.util.Date convertSqlTimestampToDateJava(java.sql.Timestamp sqlTimeStamp)
  {
    Calendar calander = Calendar.getInstance();
    calander.setTimeInMillis(sqlTimeStamp.getTime());
    return calander.getTime();
  }
}