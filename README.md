# Progessive Twitch Goals
A simple way to display your goals in OBS

Progressive Twitch Goals is a simple application that allows you to dynamically modify a text file used as a source in OBS (Open Broadcaster Software). This project was designed for streamers who want to display live goals and easily update them during their broadcast.

## Features
- Dynamic update of text file
- Easy OBS integration via a text source
- Goals customization via a csv file

## Installation
- Make sure JRE 8 is installed on your computer
- Download the latest release
- Download goals-params.properties file
- Open a terminal in the folder where the jar file was downloaded and use
'''
progressiveGoals.jar path_to_properties
'''
- If properties are in the same folder as the Jar file, you can just execute it

## Configuration
- Open OBS and add a text source (Type: "Text (GDI+)").
- Point the text source to the file generated/modified by the application.
- Launch the application and start updating your goals from the interface

## Actual release : 0.1.0
- Key controls disabled in main Window
- Key controls disabled in Set Up window

## License
This project is licensed under the MIT License. See the LICENSE file for more information. 



