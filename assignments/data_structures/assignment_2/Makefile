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

#! Generate javadocs
# Javadocs for main
doc_main_main:
	javadoc -d docs/main/main_docs -cp bin src/main/Main.java

docs_main_experiment:
	javadoc -d docs/main/experiment_docs -cp bin src/main/MainExperiment.java

docs_main: doc_main_main docs_main_experiment

# Javadocs for performance
doc_performance:
	javadoc -d docs/performance/performance_doc -cp bin src/performance/Performance.java

# Javadocs for lib
doc_lib_data_type:
	javadoc -d docs/lib/data_type_doc -cp bin src/lib/DataType.java

doc_lib_binary_tree_node:
	javadoc -d docs/lib/binary_tree_node_doc -cp bin src/lib/BinaryTreeNode.java

doc_lib_btqueue_node:
	javadoc -d docs/lib/btqueue_node_doc -cp bin src/lib/BTQueueNode.java

doc_lib_btqueue:
	javadoc -d docs/lib/btqueue_doc -cp bin src/lib/BTQueue.java

doc_lib_binary_tree:
	javadoc -d docs/lib/binary_tree_doc -cp bin src/lib/BinaryTree.java

doc_lib_avl_tree:
	javadoc -d docs/lib/avl_tree_doc -cp bin src/lib/AVLTree.java

doc_lib: doc_lib_data_type doc_lib_binary_tree_node doc_lib_btqueue_node doc_lib_btqueue doc_lib_binary_tree doc_lib_avl_tree

# Javadocs for files
doc_files_path:
	javadoc -d docs/files/path_doc -cp bin src/files/FilePath.java

doc_files_genericskb:
	javadoc -d docs/files/genericskb_doc -cp bin src/files/GenericsKbAVLApp.java

doc_files_get_file_content:
	javadoc -d docs/files/get_file_content_doc -cp bin src/files/GetFileContent.java

doc_files_content:
	javadoc -d docs/files/content_doc -cp bin src/files/FileContent.java

doc_files: doc_files_path doc_files_genericskb doc_files_get_file_content doc_files_content

# Generate all javadocs
generate_all_docs: docs_main doc_performance doc_lib doc_files

# Run main file
run_main: cp_main
	java -cp bin main/Main

run_experiment: cp_main
	java -cp bin main/MainExperiment