package club.pagocel.allinn.pagocel;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by Gsus on 07/01/2016.
 */
public class Conection {

    public void updateCoord(Double lat, Double log, String placa, String sts) throws UnsupportedEncodingException {
        String url = "http://www.pagocel.club/Patrullas/archivos/update.php";
        String codigo = URLEncoder.encode("usuario", "UTF-8")+"="+ URLEncoder.encode(placa , "UTF-8")+"&"+
                URLEncoder.encode("status", "UTF-8")+"="+ URLEncoder.encode(sts , "UTF-8")+"&"+
                URLEncoder.encode("latitud", "UTF-8")+"="+ URLEncoder.encode(""+lat, "UTF-8")+"&"+
                URLEncoder.encode("longitud", "UTF-8")+"="+ URLEncoder.encode("" + log, "UTF-8");
        executar(codigo,url );
    }

    public String executar(String encode, String url) throws UnsupportedEncodingException {

        try {
            URL liga = new URL(url);
            HttpURLConnection httpsURLConnection = (HttpURLConnection)liga.openConnection();
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(encode);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line;
            while ((line = bufferedReader.readLine())!= null){
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpsURLConnection.disconnect();
            return result;

        } catch (MalformedURLException e) {
            Log.e("DatosEntrada A", e.toString());
        } catch (IOException e) {
            Log.e("DatosEntrada B", e.toString());
        }
        return "FALSE";
    }
}

