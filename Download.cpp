/*

Author: Zachary Ness
Desc: A script that downloads mp3 or mp4 from youtube
Inputs: Youtube URL, output file, and what you want to download (mp4/mp3)
Outputs: None

*/

#include <iostream>
#include <cstdlib>
#include <string>
#include <sstream>

using namespace std;

string displayVideoFormats(string videoURL);
void downloadVideo(string videoURL, string videoFormat);
void downloadVideo(string videoURL, string videoFormat, string mp4Name);
void convertVideo(string mp3Name);

int main(int argc, char** argv) {

    if (argc < 4) {

        cout << "Usage: ./Download [v(ideo)/a(udio)] [URL] [Output File]" << endl;
        return 1;

    }

    string videoFormat = displayVideoFormats(argv[2]);

    string option = argv[1];
    if (option == "a") {

        downloadVideo(argv[2], videoFormat);
        convertVideo(argv[3]);

    } else if (option == "v") {

        downloadVideo(argv[2], videoFormat, argv[3]);

    }

    return 0;

}

/*

Desc: Displays the available formats to download video
Inputs: Video url
Outputs: Video format

*/

string displayVideoFormats(string videoURL) {

    stringstream command;
    command << "youtube-dl -F " << videoURL;
    system(command.str().c_str());

    cout << "Format > ";
    string videoFormat;
    getline(cin, videoFormat);
    return videoFormat;

}


/*

Desc: Download webm from url
Inputs: Video url and format number
Outputs: None

*/

void downloadVideo(string videoURL, string videoFormat) {

    stringstream command;
    command << "youtube-dl -f " << videoFormat << " " << videoURL;
    system(command.str().c_str());

}

/*

Desc: Download mp4 from url
Inputs: Video url, format number, and name of mp4
Outputs: None

*/

void downloadVideo(string videoURL, string videoFormat, string mp4Name) {

    stringstream command;
    command << "youtube-dl -f " << videoFormat << " " << videoURL << " -o " << mp4Name << ".mp4";
    system(command.str().c_str());

}


/*

Desc: Converts webm to mp3 file and deletes webm
Inputs: Name of mp3 file
Outputs: none

*/

void convertVideo(string mp3Name) {

    stringstream command;
    command << "ffmpeg -vn -i *.webm " << mp3Name << ".mp3";
    system(command.str().c_str());

    system("rm -rf *.webm");

}
