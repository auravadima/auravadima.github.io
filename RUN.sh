if [[ "$OSTYPE" == "win32" ]]; then
        java -classpath bin;libs/commons-cli-1.4.jar main.Main $1
else
        java -classpath bin:libs/commons-cli-1.4.jar main.Main $1
fi