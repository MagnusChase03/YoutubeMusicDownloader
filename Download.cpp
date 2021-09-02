/*

Author: Zachary Ness
Desc: A script that downloads music from youtube
Inputs: Youtube URL, format number, and name of mp3 file
Outputs: None

*/

#include <iostream>
#include <cstdlib>
#include <string>
#include <sstream>

using namespace std;

void downloadVideo(string videoURL, string videoFormat);
void convertVideo(string mp3Name);

int main(int argc, char** argv) {

    if (argc < 4) {

        cout << "Usage: ./Download [URL] [Format] [MP3 Name]" << endl;
        return 1;

    }

    downloadVideo(argv[1], argv[2]);
    convertVideo(argv[3]);

    return 0;

}

/*

Desc: Download webm from url either 249, 250 or 251
Inputs: Video url and format number
Outputs: None

*/

void downloadVideo(string videoURL, string videoFormat) {

    stringstream command;
    command << "youtube-dl -f " << videoFormat << " " << videoURL;
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

    system("rm *.webm");

}
