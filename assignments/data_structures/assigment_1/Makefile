# Compile all java files
compile_src: src/*.java
	javac -d bin src/*.java

compile_binary: src/binary/*.java
	javac -d bin src/binary/*.java

compile_files: src/files/*.java
	javac -d bin src/files/*.java

compile_list: src/list/*.java
	javac -d bin src/list/*.java

compile_all: compile_src compile_binary compile_files compile_list

run_binary: compile_all
	java -cp bin src/binary/MainBinary

run_list: compile_all
	java -cp bin src/list/MainList