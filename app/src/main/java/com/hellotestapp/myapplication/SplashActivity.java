package com.hellotestapp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {
//    https://github.com/adrianburcin/ContactsListView
    public static int width = 0;
    public static int height = 0;
    public static int totalPixels = 0;
    public static int totalBytes = 0;
    public static int[] rgbValues;
    public static int shift = 0;
    public static int buff = 0;
    public static int count = 0;
    public static int limit = -12;
    public static int pixel;
    public static int componentsPerPixel = 3;
    public static String data = "";
    ShapeableImageView image;





    //////////////check intenet permission
    //////////////check variavle not nulll
    /////https://github.com/tutorialwing/retrofit

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        image = findViewById(R.id.image);


        Bitmap finalimage = Hide( "{\n" +
                "  \"payload\": {\n" +
                "    \"app_setting\": [\n" +
                "      {\n" +
                "        \"key\": \"new_app_link\",\n" +
                "        \"value\": \"https://shorturl.at/vFOSV\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"preload_inter\",\n" +
                "        \"value\": \"true\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"qureka_id\",\n" +
                "        \"value\": \"https://www.qureka.com/\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"url\",\n" +
                "        \"value\": \"https://d1ex46a0eaqlz9.cloudfront.net/\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"id\",\n" +
                "        \"value\": \"touchvpn\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"country\",\n" +
                "        \"value\": \"us\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"startscreen\",\n" +
                "        \"value\": \"2\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"ad_networks\": [\n" +
                "      {\n" +
                "        \"ad_network\": \"Google\",\n" +
                "        \"enabled\": true,\n" +
                "        \"priority\": 1,\n" +
                "        \"api_key\": \"\",\n" +
                "        \"banner_ads\": [\n" +
                "          {\n" +
                "            \"enabled\": true,\n" +
                "            \"ad_network\": \"Google\",\n" +
                "            \"ad_unit_id\": \"/6499/example/banner\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"interstitial_ads\": [\n" +
                "          {\n" +
                "            \"enabled\": true,\n" +
                "            \"ad_network\": \"Google\",\n" +
                "            \"ad_unit_id\": \"/6499/example/interstitial\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"native_ads\": [\n" +
                "          {\n" +
                "            \"enabled\": true,\n" +
                "            \"ad_network\": \"Google\",\n" +
                "            \"ad_unit_id\": \"/6499/example/native\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"app_open_ads\": [\n" +
                "          {\n" +
                "            \"enabled\": true,\n" +
                "            \"ad_network\": \"Google\",\n" +
                "            \"ad_unit_id\": \"/6499/example/app-open\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"ad_network\": \"StartApp\",\n" +
                "        \"enabled\": true,\n" +
                "        \"priority\": 3,\n" +
                "        \"api_key\": \"0000000\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}", SplashActivity.this);
        image.setImageBitmap(finalimage);


      /*  OutputStream outputStream ;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)
        {
            ContentResolver resolver = getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME,"Image_"+".jpg");
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE,"image/jpeg");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + File.separator+"TestFolder");
            Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues);
            try {
                outputStream =  resolver.openOutputStream(Objects.requireNonNull(imageUri) );
                finalimage.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                Objects.requireNonNull(outputStream);
                Toast.makeText(SplashActivity.this, "Image Saved", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(SplashActivity.this, "Image Not Not  Saved: \n "+e, Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

        }
*/


        Bitmap bitmap = finalimage;
        FileOutputStream outStream = null;
        File imageFile = new File(Environment.getExternalStorageDirectory(), "image.png");
        try {
            outStream = new FileOutputStream(imageFile);
        } catch (FileNotFoundException e) {
            Log.e("TAG", "onCreategetMessage: " + e.getMessage());
            e.printStackTrace();
        }

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
        try {
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaScannerConnection.scanFile(
                SplashActivity.this,
                new String[]{imageFile.getAbsolutePath()},
                null,
                null
        );


       // Bitmap bitmapp = drawableToBitmap(getResources().getDrawable(R.drawable.butter));
        data = reveal(bitmap);

        Log.e("TAG", "reverse: " + data);

    }

    public static String reveal(Bitmap bitmap) {

        width = 0;
        height = 0;
        totalPixels = 0;
        totalBytes = 0;
        rgbValues = new int[]{};

        shift = 0;
        buff = 0;
        count = 0;
        limit = -12;
        pixel = 0;
        componentsPerPixel = 3;
        ArrayList<String> bitab = new ArrayList<>();
        String combineString = "";
        data = "";


        width = bitmap.getWidth();
        height = bitmap.getHeight();
        totalPixels = width * height;
        totalBytes = totalPixels * componentsPerPixel;
        rgbValues = new int[totalBytes];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (shift != 0) {
                    shift -= 1;
                    continue;
                }
                pixel = bitmap.getPixel(col, row);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                rgbValues[0] = (int) red;
                rgbValues[1] = (int) green;
                rgbValues[2] = (int) blue;
                int[] rgblist = new int[]{red, green, blue};
                for (int color = 0; color < rgblist.length; color++) {
                    int color1 = rgblist[color] & 1;
                    int count1 = 7 - count;
                    buff += color1 << count1;
                    count += 1;
                    if (count == 8) {
                        bitab.add(Character.toString((char) buff));


                        buff = 0;
                        count = 0;

                        for (int i = 0; i < bitab.size(); i++) {
                        }

                        if (bitab.get(bitab.size() - 1).equalsIgnoreCase(":") && limit == -12) {
                            for (int i = 0; i < bitab.size() - 1; i++) {
                                combineString = combineString.concat(bitab.get(i));
                            }
                            limit = Integer.parseInt(combineString);
                        }
                    }
                }


                if (bitab.size() - String.valueOf(limit).length() - 4 == limit) {

                    String ans = "";
                    for (int i = String.valueOf(limit).length(); i < bitab.size(); i++) {
                        ans = ans.concat(bitab.get(i));

                    }

                    //  String removeByte = ans.substring(5);
                    // String s = BString(ans);
                    return ans;
                }
            }
        }
        return null;
    }


    public Bitmap Hide(String mainstr, Activity activity)
    {
        Bitmap input_image = drawableToBitmap(activity.getResources().getDrawable(R.drawable.butterfly));
        String str = mainstr;
        int encoding = 8;
        int shift = 0;
        Boolean auto_convert_rgb = false;
        String message;
        Bitmap encoded;
        String message_bits;
        int index = 0;
        int npixels;
        int len_message_bits;
        int a;
        int r;
        int g;
        int b;

        String mainstrbyte = "b'" + mainstr + "'";


      //  Log.e("TAG", "Hidemainstrbyte: " + mainstrbyte);

        int message_length = mainstr.length();
        if (message_length == 0) {
            Toast.makeText(activity, "message length is zero", Toast.LENGTH_SHORT).show();
            //return input_image;
            return null;
        }

        //  encoded = Bitmap.createBitmap(width, height, input_image.getConfig());

        encoded = input_image.copy(Bitmap.Config.ARGB_8888, true);
        int width = encoded.getWidth();
        int height = encoded.getHeight();


        message = message_length + ":" + mainstrbyte.toString();


        message_bits = stringToBinary(message);

        int ans = (((3 - message_bits.length() % 3)) % 3);
        for (int i = 0; i < ans; i++) {
            message_bits = message_bits.concat("0");
        }

        npixels = width * height;
        len_message_bits = message_bits.length();

        if (len_message_bits > (npixels * 3)) {
            Toast.makeText(activity, " The message you want to hide is too long", Toast.LENGTH_SHORT).show();
            return null;
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (shift != 0) {
                    shift -= 1;
                    continue;
                }

                if ((index + 3) <= len_message_bits) {
                    pixel = encoded.getPixel(col, row);
                    a = Color.alpha(pixel);
                    r = Color.red(pixel);
                    g = Color.green(pixel);
                    b = Color.blue(pixel);

                    r = setLsb(r, String.valueOf(message_bits.charAt(index)));
                    g = setLsb(g, String.valueOf(message_bits.charAt(index + 1)));
                    b = setLsb(b, String.valueOf(message_bits.charAt(index + 2)));

                //    Log.e("TAG", "Hidehide: " + message_bits.charAt(index) + "///////" + message_bits.charAt(index + 1) + "/////" + message_bits.charAt(index + 2));

                    int newColor = Color.argb(a, r, g, b);

                    encoded.setPixel(col, row, newColor);
                    index += 3;

                } else {
                    return encoded;
                }
            }
        }


        return encoded;
    }


    public static int setLsb(int component, String bit) {
        return (component & ~1) | Integer.parseInt(bit);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        int width = drawable.getIntrinsicWidth();
        width = width > 0 ? width : 1;
        int height = drawable.getIntrinsicHeight();
        height = height > 0 ? height : 1;

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static String stringToBinary(String str) {
        StringBuilder binary = new StringBuilder();
        for (char c : str.toCharArray()) {
            String binaryChar = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            binary.append(binaryChar);
        }
        return binary.toString().trim();
    }

    public static String BString(String str) {
        try {
            return new String(Base64.decode(str, Base64.DEFAULT), "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            return "This is not valid data";
        }
    }

}