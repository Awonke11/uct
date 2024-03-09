# Compile all java files
compile_src: src/*.java
	javac -d bin src/*.java

compile_binary: src/binary/*.java
	javac -d bin src/binary/*.java

compile_files: src/files/*.java
	javac -d bin src/files/*.java

compile_list: src/list/*.java
	javac -d bin src/list/*.java

compile_all_files: compile_src compile_binary compile_files compile_list #! Compile all java files

# Run the main classes
run_binary: compile_all
	java -cp bin src/binary/MainBinary

run_list: compile_all
	java -cp bin src/list/MainList

# Generate javadoc for each file in src
file_list_doc: src/fileList.java
	javadoc -d doc/src/fileList src/fileList.java

field_doc: src/Field.java
	javadoc -d doc/src/field src/Field.java

src_doc: file_list_doc field_doc #! Generate all src javadoc

binary_search_tree_doc: src/binary/BinarySearchTree.java
	javadoc -d doc/src/binary/binarySearchTree src/binary/BinarySearchTree.java

main_binary_doc: src/binary/MainBinary.java
	javadoc -d doc/src/binary/mainBinary src/binary/MainBinary.java

binary_doc: binary_search_tree_doc main_binary_doc #! Generate all src/binary javadoc

extract_file_doc: src/files/ExtractFile.java
	javadoc -d doc/src/files/extractFile src/files/ExtractFile.java

files_doc: extract_file_doc #! Generate all src/files javadoc

list_array_doc: src/list/ListArray.java
	javadoc -d doc/src/list/listArray src/list/ListArray.java

main_list_doc: src/list/MainList.java
	javadoc -d doc/src/list/mainList src/list/MainList.java

list_doc: list_array_doc main_list_doc #! Generate all src/list javadoc

# Generate javadoc
generate_all_javadocs: src_doc binary_doc list_doc files_doc