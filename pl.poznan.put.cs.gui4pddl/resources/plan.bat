@ECHO off
SET basedir=%~dp0
call :getargc argc %*

IF %argc% LSS 2 goto usage

SET translate=%basedir%translate\translate.exe
SET preprocess=%basedir%bin\preprocess.exe
SET search=%basedir%search\downward-seq-sat-fdss-1
SET dosunix=%basedir%bin\dos2unix


echo 1. Running translator
%translate%  %1 %2
echo.

IF %ERRORLEVEL% == 0 (
echo 2. Running preprocessor
%preprocess% <output.sas
%dosunix% output
echo.
) ELSE (
echo Error!
GOTO:EOF
)

IF %ERRORLEVEL% == 0 (
echo 3. Running search
%search% unit downward-1
echo.
) ELSE (
echo Error!
)


echo.&goto:eof

:usage
echo usage: %~fp0 DOMAIN_FILE PROBLEM_FILE
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