@ECHO off
SET basedir=%~dp0
call :getargc argc %*


SET translate=%basedir%translate\translate.exe
SET preprocess=%basedir%bin\preprocess.exe
SET search=%basedir%search\downward-seq-sat-fdss-1


echo 1. Running translator
%translate%  %1 %2
echo.

IF %ERRORLEVEL% == 0 (
echo 2. Running preprocessor
%preprocess% <output.sas
echo.
) ELSE (
echo Error!
GOTO:EOF
)



rem throw the first parameter away
shift
shift
set params=%1
:loop
shift
if [%1]==[] goto afterloop
set params=%params% %1
goto loop
:afterloop



IF %ERRORLEVEL% == 0 (
echo 3. Running search
%search% unit downward-1
echo.
) ELSE (
echo Error!
)



echo.&goto:eof

:usage
echo usage: %~fp0 [DOMAIN_FILE] PROBLEM_FILE SEARCH_OPTION ...
GOTO:EOF

:getargc
    set getargc_v0=%1
    set /a "%getargc_v0% = 0"
:getargc_l0
    if not x%2x==xx (
        shift
        set /a "%getargc_v0% = %getargc_v0% + 1"
        goto :getargc_l0
    )
    set getargc_v0=
    goto :eof