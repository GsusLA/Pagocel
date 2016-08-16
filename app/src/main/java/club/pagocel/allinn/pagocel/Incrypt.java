package club.pagocel.allinn.pagocel;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Jesus on 02/08/2016.
 */
public class Incrypt {
    public static String codifPago(String data){
        return toMd2(data);
    }
    private static String toMd2(String pass){
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(pass.getBytes());
            byte messageDigest[] = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for(int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            String convert = "";
            String test = hexString.toString();
            for(int i = 0; i<test.length();i++)
            {
                convert =convert+test.codePointAt(i);
            }
            return convert;
        }catch(NoSuchAlgorithmException ex){
            Log.e("NoSuchAlgorithmExcept", ex.toString());
            return ex.toString();
        }
    }


    public static String getCdata(String message, String algorithm){

        byte[] digest = null;

        byte[] buffer = message.getBytes();

        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            messageDigest.reset();

            messageDigest.update(buffer);

            digest = messageDigest.digest();

        } catch (NoSuchAlgorithmException ex) {

            System.out.println("Error creando Digest");

        }

        return toHexadecimal(digest);

    }

    private static String toHexadecimal(byte[] digest){

        String hash = "";

        for(byte aux : digest) {

            int b = aux & 0xff;

            if (Integer.toHexString(b).length() == 1) hash += "0";

            hash += Integer.toHexString(b);

        }

        return hash;

    }
}
