@ECHO off
SET basedir=%~dp0

%basedir%translate\translate.exe "%1" "%2" 
%basedir%bin\preprocess.exe <output.sas
%basedir%bin\dos2unix output
%basedir%search\downward-seq-sat-fdss-1 unit downward-1