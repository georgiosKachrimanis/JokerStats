package teamergasia3;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modal.DrawOpapJoker;
import static teamergasia3.R3.ProvoliStatistikon2.jLabel5;

/**
 * @author Georgios Kachrimanis
 * @author Nikolas Psyllou
 * @author Skliris Dionysis
 */
public class DrawsFunctions {

//  Set Date Format
    private DateFormat apiDateFormat = new SimpleDateFormat("YYYY-MM-dd");
//  Create ArrayList for the all the draws
    private ArrayList<DrawOpapJoker> drawsList = new ArrayList<>();

//  Return drawList
    public ArrayList<DrawOpapJoker> getDrawsList() {
        return drawsList;
    }

//  Get Draw from API
    public DrawOpapJoker getDataJokerById(int drawId, int gameId) throws ParseException, IOException {
//      Set the URL API with gameId and drawId
        String urlWithGameId = "https://api.opap.gr/draws/v3.0/" + gameId + "/" + String.valueOf(drawId);
//      Request from OpapAPI
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlWithGameId).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseString = response.body().string();
//              Convert to JSONParser
                JSONParser jsonparser = new JSONParser();
//              Convert to Object
                Object mainObj = jsonparser.parse(responseString);
                JSONObject mainJSONObj = (JSONObject) mainObj;
//              Create Winning numbers as Object
                JSONObject winningNumbersObj = (JSONObject) mainJSONObj.get("winningNumbers");
//              Get Drawtime
                Long drawTime = (Long) mainJSONObj.get("drawTime");
//              Create List numbers as Array
                JSONArray winningNumbersArray = (JSONArray) winningNumbersObj.get("list");
//              Create BonusNumber as Array
                JSONArray bonusArray = (JSONArray) winningNumbersObj.get("bonus");
//              Save Bonus array as Long  
                Long bonusNumberLong = (Long) bonusArray.get(0);
//              Convert bonusNumber to integer
                int bonusNumber = bonusNumberLong.intValue();
//              Add winning numbers as string for the DB
                String winningNumbersString = "";
                for (Object winningNumber : winningNumbersArray) {
                    winningNumbersString += winningNumber + ",";
                }
//              Delete last comma
                winningNumbersString = winningNumbersString.substring(0, winningNumbersString.length() - 1);

//              Create prize Categories as Object
                JSONArray prizeCategories = (JSONArray) mainJSONObj.get("prizeCategories");
//              Create prizeCategories as Array

//              Convert winnerString, distributedString, dividentString, jackpotString as String for the DB
                String winnerString = "";
                String distributedString = "";
                String dividentString = "";
                String jackpotString = "";
                for (Object object : prizeCategories) {
                    JSONObject jsonObject = (JSONObject) object;
                    //Long id = (Long) jsonObject.get("id");
                    Long winners = (Long) jsonObject.get("winners");
                    Double distributed = (Double) jsonObject.get("distributed");
                    Double divident = (Double) jsonObject.get("divident");
                    Double jackpot = (Double) jsonObject.get("jackpot");

                    winnerString += winners.toString() + ",";
                    distributedString += distributed.toString() + ",";
                    dividentString += divident.toString() + ",";
                    jackpotString += jackpot.toString() + ",";
                }
//              Delete last comma
                winnerString = winnerString.substring(0, winnerString.length() - 1);
                distributedString = distributedString.substring(0, distributedString.length() - 1);
                dividentString = dividentString.substring(0, dividentString.length() - 1);
                jackpotString = jackpotString.substring(0, jackpotString.length() - 1);
//              Convert drawTime to Date
                Date startDate = new Date(drawTime);
//              Add data to POJO Class
                DrawOpapJoker outputDraw = new DrawOpapJoker(null, gameId, drawId, startDate,
                        winningNumbersString, bonusNumber, winnerString,
                        dividentString, distributedString, jackpotString
                );
//              Return data
                return outputDraw;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//  Save Draw to Database
    public boolean saveDrawToDB(DrawOpapJoker drawId) {
//        Connect DB
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeanErgasia3PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//      Check if the draw exists to DB
        if (!findDrawToDB(drawId.getDrawid(), em)) {
            em.persist(drawId);
            em.getTransaction().commit();
        } else {
            return false;
        }
//      Close DB
        em.close();
        emf.close();
        return true;
    }

//  Chech if the draw exists to Database
    public boolean findDrawToDB(int drawId, EntityManager em) {
//      Find Draw with drawId
        Query q = em.createNamedQuery("DrawOpapJoker.findByDrawid", DrawOpapJoker.class);
        q.setParameter("drawid", drawId);
        try {
            DrawOpapJoker result = (DrawOpapJoker) q.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//  Delete Draw From Database
    public boolean deleteDrawWithIdFromDB(int drawId) {
        //        Connect Database
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeanErgasia3PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Delete Draw with drawId
        Query q = em.createNamedQuery("DrawOpapJoker.findByDrawid", DrawOpapJoker.class);
        q.setParameter("drawid", drawId);
        try {
            DrawOpapJoker result = (DrawOpapJoker) q.getSingleResult();
            em.remove(result);
//          Commit and close DB
            em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println("Draw id: " + drawId + " has deleted");
            return true;
        } catch (Exception e) {
            System.out.println("No records to Delete!  " + e);
            return false;
        }
    }

//  Divide Start Date and End Date by Three Months
    public void dataJokerByDates(String from, String until, int gameId) throws ParseException {
//      Convert from String(from, until) to Date(startDate, endDate) 
        Date startDate = java.sql.Date.valueOf(from);
        Date endDate = java.sql.Date.valueOf(until);
//      Create middle date for the three months
        Calendar middleDate = Calendar.getInstance();
        middleDate.setTime(startDate);
        middleDate.add(Calendar.MONTH, +3);
//      While loop to call dataJokerByThreeMonths method until middleDate is bigger from endDate
        while (middleDate.getTimeInMillis() <= endDate.getTime()) {
            dataJokerByThreeMonths(apiDateFormat.format(startDate), apiDateFormat.format(middleDate.getTime()), gameId);
            startDate = middleDate.getTime();
            middleDate.add(Calendar.MONTH, +3);
        }
//      Call last time dataJokerByThreeMonths method and end of the function 
        dataJokerByThreeMonths(apiDateFormat.format(startDate), apiDateFormat.format(endDate), gameId);
    }

//  Get Draws data by three months
    private void dataJokerByThreeMonths(String from, String until, int gameId) throws ParseException {
        //      Set the URL API with gameId,Start Date and End Date
        String urlWithGameId = "https://api.opap.gr/draws/v3.0/" + gameId + "/draw-date/" + from + "/" + until + "?limit=180";

        //      Request Api
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlWithGameId).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
//              Save the response  
                String responseString = response.body().string();
//              Convert to JSONParser
                JSONParser jsonparser = new JSONParser();
//              Convert to Object
                Object mainObj = jsonparser.parse(responseString);
//              Convert to JSON Object 
                JSONObject allDraws = (JSONObject) mainObj;
//              Get the content as JSON Array
                JSONArray draws = (JSONArray) allDraws.get("content");
//              For each loop for every draw
                for (Object draw : draws) {
//                  Convert draw to JSON Object to get the data
                    JSONObject d = (JSONObject) draw;
//                  Get drawId
                    Long drawIdLong = (long) d.get("drawId");
//                  Convert drawId to integer
                    int drawId = drawIdLong.intValue();
//                  Create Winning numbers as Object
                    JSONObject winningNumbersObj = (JSONObject) d.get("winningNumbers");
//                  Get Drawtime
                    Long drawTime = (Long) d.get("drawTime");
//                  Create List numbers as Array
                    JSONArray winningNumbersArray = (JSONArray) winningNumbersObj.get("list");
//                  Create BonusNumber as Array
                    JSONArray bonusArray = (JSONArray) winningNumbersObj.get("bonus");
//                  Save Bonus array as Long  
                    Long bonusNumberLong = (Long) bonusArray.get(0);
//                  Convert bonusNumber to integer
                    int bonusNumber = bonusNumberLong.intValue();
//                  Add winning numbers as string for the DB
                    String winningNumbersString = "";
                    for (Object winningNumber : winningNumbersArray) {
                        winningNumbersString += winningNumber + ",";
                    }
//                  Delete last comma
                    winningNumbersString = winningNumbersString.substring(0, winningNumbersString.length() - 1);

//                  Create prizeCategories as Array
                    JSONArray prizeCategories = (JSONArray) d.get("prizeCategories");

//                  Convert winnerString, distributedString, dividentString, jackpotString as String for the DB
                    String winnerString = "";
                    String distributedString = "";
                    String dividentString = "";
                    String jackpotString = "";
                    for (Object object : prizeCategories) {
                        JSONObject jsonObject = (JSONObject) object;
                        //Long id = (Long) jsonObject.get("id");
                        Long winners = (Long) jsonObject.get("winners");
                        Double distributed = (Double) jsonObject.get("distributed");
                        Double divident = (Double) jsonObject.get("divident");
                        Double jackpot = (Double) jsonObject.get("jackpot");

                        winnerString += winners.toString() + ",";
                        distributedString += distributed.toString() + ",";
                        dividentString += divident.toString() + ",";
                        jackpotString += jackpot.toString() + ",";
                    }
//                  Delete last comma
                    winnerString = winnerString.substring(0, winnerString.length() - 1);
                    distributedString = distributedString.substring(0, distributedString.length() - 1);
                    dividentString = dividentString.substring(0, dividentString.length() - 1);
                    jackpotString = jackpotString.substring(0, jackpotString.length() - 1);
//                  Convert drawTime to Date
                    Date startDate = new Date(drawTime);
//                  Add data to POJO Class
                    DrawOpapJoker outputDraw = new DrawOpapJoker(null, gameId, drawId, startDate,
                            winningNumbersString, bonusNumber, winnerString,
                            dividentString, distributedString, jackpotString
                    );
                    drawsList.add(outputDraw);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //  Chech if the draws exists to Database
    public boolean findDrawsToDB(String startDate, String endDate) {

//      Convert Dates
        java.sql.Date d1 = java.sql.Date.valueOf(startDate);
        java.sql.Date d2 = java.sql.Date.valueOf(endDate);
//        Connect DB
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeanErgasia3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//      Find Draws with Dates Range
        Query q = em.createNamedQuery("DrawOpapJoker.findByDrawtimeWithRange", DrawOpapJoker.class);
        q.setParameter("start", d1);
        q.setParameter("end", d2);
        try {

            List<DrawOpapJoker> result;
            result = (List<DrawOpapJoker>) q.getResultList();
//          Close Database
            em.close();
            emf.close();
//          Check if we have Draws and return True
            if (result.size() > 0) {
                return true; // Database have these draws
            }
        } catch (NumberFormatException e) {
//          Database does not have these draws
            return false;
        }
        return false;
    }

}
