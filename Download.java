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

        Desc: Shows the logging of a command run
        Inputs: Process running the command
        Outputs: Log of command

    */

    public static void showCommandLog(Process run) {

        try {

            BufferedReader read = new BufferedReader(new InputStreamReader(run.getInputStream()));
            String line;
            while ((line = read.readLine()) != null) {

                System.out.println(line);

            }

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    /*

        Desc: Shows all formats available for youtube video
        Inputs: Video link
        Outputs: formats available

    */

    public static void showVideoFormats(String URL) {

        try {

            String command = "youtube-dl -F " + URL;
            System.out.println("Running: " + command);
            Process run = Runtime.getRuntime().exec(command);
            showCommandLog(run);

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    /*

        Desc: Download the webm from youtube link
        Inputs: Video link, mp3 file name, and video format
        Outputs: Name of webm file

    */

    public static String downloadVideo(String URL, String mp3Name, String videoFormat) {

        try {

            String command = "youtube-dl -f " + videoFormat + " " + URL + " -o " + mp3Name + ".webm";
            System.out.println("Running: " + command);
            Process run = Runtime.getRuntime().exec(command);
            showCommandLog(run);

        } catch (Exception e) {

            System.out.println(e);

        }

        return mp3Name + ".webm";

    }

    /*

        Desc: Converts webm to mp3 and deletes webm
        Inputs: webm file name, mp3 name
        Outputs: MP3 files

    */

    public static void convertVideo(String webmName, String mp3Name) {

        try {

            String command = "ffmpeg -vn -i " + webmName + " Music/" + mp3Name + ".mp3";
            System.out.println("Running: " + command);
            Process run = Runtime.getRuntime().exec(command);
            showCommandLog(run);

            command = "rm " + webmName;
            System.out.println("Running: " + command);
            run = Runtime.getRuntime().exec(command);
            showCommandLog(run);

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public static void main(String[] args) {
        
        if (args.length < 2) {

            System.out.println("Usage: java Download [URL] [MP3 Name]");
            return;

        } else if (args.length == 2) {

            showVideoFormats(args[0]);
            String webm = downloadVideo(args[0], args[1], "250");
            convertVideo(webm, args[1]);

        } else {

            showVideoFormats(args[1]);
            String webm = downloadVideo(args[1], args[2], args[0]);
            convertVideo(webm, args[2]);

        }

    }

}
