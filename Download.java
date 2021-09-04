import java.io.*;

/*

Name: Download
Desc: Download music from youtube link
Usage: java Download [URL] [MP3 Name]
Inputs: Youtube link and mp3 file name
Outputs: MP3 file

*/

public class Download {
 
    /*

        Desc: Download the webm from youtube link
        Inputs: Video link and mp3 file name
        Outputs: Name of webm file

    */

    public static String downloadVideo(String URL, String mp3Name) {

        try {

            String command = "youtube-dl -f 250 " + URL + " -o " + mp3Name + ".webm";
            Process run = Runtime.getRuntime().exec(command);

        } catch (Exception e) {}

        return mp3Name + ".webm";

    }

    public static void main(String[] args) {
        
        if (args.length < 2) {

            System.out.println("Usage: java Download [URL] [MP3 Name]");
            return;

        }

        downloadVideo(args[0], args[1]);

    }

}
