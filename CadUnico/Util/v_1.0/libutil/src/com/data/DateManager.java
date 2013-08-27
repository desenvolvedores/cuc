/*
 * Classe pertencente a API de utilidades "libutil".
 */
package com.data;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class DateManager {

    public DateManager() {
        formatDate = new java.text.SimpleDateFormat("dd/MM/yyyy");
    }

    public String getCurrentDate() {
        String today = "";
        if ((calendar.get(java.util.GregorianCalendar.MONTH) + 1) < 10)
            today = calendar.get(java.util.GregorianCalendar.DATE) + "/0" +
                    (calendar.get(java.util.GregorianCalendar.MONTH) + 1) + "/" +
                    calendar.get(java.util.GregorianCalendar.YEAR);
        else
            today = calendar.get(java.util.GregorianCalendar.DATE) + "/" +
                    (calendar.get(java.util.GregorianCalendar.MONTH) + 1) + "/" +
                    calendar.get(java.util.GregorianCalendar.YEAR);
        return today;
    }

    public String getCurrentDateSQL() {
        String today = "";
        String date = calendar.get(java.util.GregorianCalendar.YEAR) + "-" +
                (calendar.get(java.util.GregorianCalendar.MONTH) + 1) + "-" +
                calendar.get(java.util.GregorianCalendar.DATE);
        try {
            today = new java.sql.Date(formatDate.parse(date).getTime()).toString();
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        return today;
    }

    public String parseDate(String date) {
        return date.substring(8, 10) + "/" + date.substring(5, 7) + "/" + date.substring(0, 4);
    }
    
    public java.util.Date parseDate(java.sql.Date date) {
        java.util.Date d = new java.util.Date();
        d.setYear(date.getYear());
        d.setMonth(date.getMonth());
        d.setDate(date.getDate());
        return d;
    }
    
    public java.util.Date parseStringDate(String date) {
        java.util.Date d = new java.util.Date();
        d.setYear(Integer.parseInt(date.substring(8, 10)));
        d.setMonth(Integer.parseInt(date.substring(3, 5)));
        d.setDate(Integer.parseInt(date.substring(0, 2)));
        return d;
    }

    public String parseDateToSQL(String date) {
        return date.substring(6, 10) + "-" + date.substring(3, 5) + "-" + date.substring(0, 2);
    }
    
    public java.sql.Date parseDateToSQL(java.util.Date date) {
        return new java.sql.Date(date.getYear(), date.getMonth(), date.getDate());
    }

    public boolean isValidDate(String date) {
        try {
            boolean valid = false;
            int year = Integer.parseInt(date.substring(8, 10));
            int month = Integer.parseInt(date.substring(3, 5));
            int day = Integer.parseInt(date.substring(0, 2));
            if (month >= 1 && month <= 12) {
                switch (month) {
                    case 1: if (day >= 1 && day <= 31)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 2: if (isLeapYear(date.substring(8, 10))) {
                                if (day >= 1 && day <= 29)
                                    valid = true;
                                else
                                    valid = false;
                            } else {
                                if (day >= 1 && day <= 28)
                                    valid = true;
                                else
                                    valid = false;
                            }
                        break;
                    case 3: if (day >= 1 && day <= 31)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 4: if (day >= 1 && day <= 30)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 5: if (day >= 1 && day <= 31)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 6: if (day >= 1 && day <= 30)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 7: if (day >= 1 && day <= 31)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 8: if (day >= 1 && day <= 31)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 9: if (day >= 1 && day <= 30)
                                valid = true;
                            else
                                valid = false;
                        break;
                    case 10: if (day >= 1 && day <= 31)
                                 valid = true;
                             else
                                 valid = false;
                        break;
                    case 11: if (day >= 1 && day <= 30)
                                 valid = true;
                             else
                                 valid = false;
                        break;
                    case 12: if (day >= 1 && day <= 31)
                                 valid = true;
                             else
                                 valid = false;
                        break;
                }
                return valid;
            } else
                return false;
        } catch (java.lang.NumberFormatException ex) {
            return false;
        }
    }

    public boolean isLeapYear(String year) {
        try {
            int value = Integer.parseInt(year);
            return value % 4 == 0 ? true : false;
        } catch (java.lang.NumberFormatException ex) {
            return false;
        }
    }

    public long howDays(String date1, String date2) {
        long d1 = java.sql.Date.UTC(Integer.parseInt(date1.substring(6, 10)), Integer.parseInt(date1.substring(3, 5)), Integer.parseInt(date1.substring(0, 2)), 0, 0, 0);
        long d2 = java.sql.Date.UTC(Integer.parseInt(date2.substring(6, 10)), Integer.parseInt(date2.substring(3, 5)), Integer.parseInt(date2.substring(0, 2)), 0, 0, 0);
        long result = d2 - d1;
        result = result / 1000;
        result = result / 60;
        result = result / 60;
        return result / 24;
    }
    
    public long howYears(String date1, String date2) {
        long d1 = java.sql.Date.UTC(Integer.parseInt(date1.substring(6, 10)), Integer.parseInt(date1.substring(3, 5)), Integer.parseInt(date1.substring(0, 2)), 0, 0, 0);
        long d2 = java.sql.Date.UTC(Integer.parseInt(date2.substring(6, 10)), Integer.parseInt(date2.substring(3, 5)), Integer.parseInt(date2.substring(0, 2)), 0, 0, 0);
        long result = d2 - d1;
        result = result / 1000;
        result = result / 60;
        result = result / 60;
        result = result / 24;
        return result / 365;
    }
    
    public String changeDateFormat(String date) {
        return date.replaceAll("/", "-");
    }

    private java.text.SimpleDateFormat formatDate;
    private java.util.GregorianCalendar calendar = (java.util.GregorianCalendar) java.util.GregorianCalendar.getInstance();

}
