# Compile performance
cp_performance: 
	javac -cp bin -d bin src/performance/*.java

# compile lib folder
cp_lib_dataType:
	javac -cp bin -d bin src/lib/DataType.java

cp_lib_binary_tree_node:
	javac -cp bin -d bin src/lib/BinaryTreeNode.java

cp_lib_btqueue_node:
	javac -cp bin -d bin src/lib/BTQueueNode.java

cp_lib_btqueue:
	javac -cp bin -d bin src/lib/BTQueue.java

cp_lib_binary_tree:
	javac -cp bin -d bin src/lib/BinaryTree.java

cp_lib_avl_tree:
	javac -cp bin -d bin src/lib/AVLTree.java

cp_lib: cp_lib_dataType cp_lib_binary_tree_node cp_lib_btqueue_node cp_lib_btqueue cp_lib_binary_tree cp_lib_avl_tree

# Compile files
cp_files_path:
	javac -cp bin -d bin src/files/FilePath.java

cp_files_genericskb:
	javac -cp bin -d bin src/files/GenericsKbAVLApp.java

cp_files_get_file_content:
	javac -cp bin -d bin src/files/GetFileContent.java

cp_files_content:
	javac -cp bin -d bin src/files/FileContent.java

cp_files: cp_files_path cp_files_genericskb cp_files_get_file_content cp_files_content

# Compile main folder
cp_main: cp_performance cp_lib cp_files
	javac -cp bin -d bin src/main/*.java

# Run main file
run_main: cp_main
	java -cp bin main/Main

run_experiment: cp_main
	java -cp bin main/MainExperiment