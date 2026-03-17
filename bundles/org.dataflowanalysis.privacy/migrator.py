import os
from pathlib import Path

# Script for migrating DFDs made before the information of Label and LabelType was moved to an abstract superclass
def bulk_replace_in_files(directory_path, file_extension, replacement_map):
    # Ensure the extension starts with a dot
    if not file_extension.startswith('.'):
        file_extension = f'.{file_extension}'

    folder_path = Path(directory_path)

    if not folder_path.is_dir():
        print(f"Error: The directory '{directory_path}' does not exist.")
        return

    files_modified = 0

    # Change to .glob() to disable searching in subdirectories
    for file_path in folder_path.rglob(f'*{file_extension}'):
        if file_path.is_file():
            try:
                with open(file_path, 'r', encoding='utf-8') as file:
                    content = file.read()

                new_content = content
                for old_text, new_text in replacement_map.items():
                    new_content = new_content.replace(old_text, new_text)

                # Only save if changes were made
                if new_content != content:
                    with open(file_path, 'w', encoding='utf-8') as file:
                        file.write(new_content)
                    print(f"Updated: {file_path.name}")
                    files_modified += 1

            except UnicodeDecodeError:
                print(f"Skipped {file_path.name}: Not a standard UTF-8 text file.")
            except Exception as e:
                print(f"Error processing {file_path.name}: {e}")

    print(f"\nFinished. Updated {files_modified} file(s).")


if __name__ == "__main__":
    TARGET_DIRECTORY = '.'

    TARGET_EXTENSION = '.dataflowdiagram'

    REPLACEMENTS = {
        "<properties h": "<properties xsi:type=\"datadictionary:Label\" h",
        "<dataflowdiagram:DataFlowDiagram xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"": "<dataflowdiagram:DataFlowDiagram xmlns:datadictionary=\"http://dataflowanalysis.org/dfd/datadictionary\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"",
    }

    bulk_replace_in_files(TARGET_DIRECTORY, TARGET_EXTENSION, REPLACEMENTS)
